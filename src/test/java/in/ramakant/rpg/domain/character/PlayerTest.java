package in.ramakant.rpg.domain.character;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.domain.exception.PlayerDied;
import in.ramakant.rpg.domain.world.location.Coordinates;
import in.ramakant.rpg.persistence.dto.MedicConfiguration;
import in.ramakant.rpg.persistence.dto.PlayerConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class PlayerTest {

    private Player player;

    @Before
    public void dataSetup() {
        player = new Player("test", "test", 1, 2, 2, new Coordinates(5, 5));
    }

    @Test
    public void Player_fromConfiguration() {
        Player playerFromConf = new Player(Mockito.mock(PlayerConfiguration.class), new Coordinates(1, 1));
        assertThat(playerFromConf).isNotNull();
    }

    @Test
    public void Player_up() {
        Coordinates newCoordinates = player.up();
        assertThat(newCoordinates.getY()).isEqualTo(4);
    }

    @Test
    public void Player_down() {
        Coordinates newCoordinates = player.down();
        assertThat(newCoordinates.getY()).isEqualTo(6);
    }

    @Test
    public void Player_left() {
        Coordinates newCoordinates = player.left();
        assertThat(newCoordinates.getX()).isEqualTo(4);
    }

    @Test
    public void Player_right() {
        Coordinates newCoordinates = player.right();
        assertThat(newCoordinates.getX()).isEqualTo(6);
    }

    @Test
    public void Player_killed_DidNotLevelUp() {
        Enemy enemy = new Enemy("test", "test", "test", 50, 5, 5);
        String result = player.killed(enemy);
        assertThat(result).isEqualTo("Defeating this enemy gave you 50 experience points. ");
    }

    @Test
    public void Player_killed_SingleLevelUp() {
        Enemy enemy = new Enemy("test", "test", "test", 100, 5, 5);
        String result = player.killed(enemy);
        assertThat(result).isEqualTo("Defeating this enemy gave you 100 experience points. You earned enough experience points to [1m[35mlevel up[0m[0m your player! ");
    }

    @Test
    public void Player_killed_DoubleLevelUp() {
        Enemy enemy1 = new Enemy("test", "test", "test", 50, 5, 1);
        String result1 = player.killed(enemy1);

        MedicConfiguration medicConfiguration = new MedicConfiguration("test", "test", "test", 300);
        Medic medic = new Medic(medicConfiguration);
        player.getMedicHelp(medic);

        Enemy enemy2 = new Enemy("test", "test", "test", 300, 5, 1);
        String result2 = player.killed(enemy2);

        assertThat(result1).isEqualTo("Defeating this enemy gave you 50 experience points. ");
        assertThat(result2).isEqualTo("Defeating this enemy gave you 300 experience points. You earned enough experience points to \u001B[1m\u001B[35mlevel up\u001B[0m\u001B[0m your player! Twice!");
    }

    @Test
    public void Player_getMedicHelp() {
        MedicConfiguration medicConfiguration = new MedicConfiguration("test", "test", "test", 100);
        Medic medic = new Medic(medicConfiguration);
        int currentMaxHealth = player.getMaxHealth();
        player.getMedicHelp(medic);
        assertThat(player.getMaxHealth()).isEqualTo(currentMaxHealth + medic.getMaxHealth());
        assertThat(medic.isAlive()).isFalse();
    }

    @Test
    public void Player_flee() {
        String result = player.flee();
        assertThat(result).isEqualTo("You lost some health while retreating from battle field");
    }

    @Test
    public void Player_die() {
        Throwable thrown = catchThrowable(() ->
                player.die()
        );
        assertThat(thrown).isInstanceOf(PlayerDied.class);
        assertThat(player.isAlive()).isFalse();
        assertThat(player.isDead()).isTrue();
    }

    @Test
    public void Player_getCoordinates() {
        assertThat(player.getCoordinates().getX()).isEqualTo(5);
        assertThat(player.getCoordinates().getY()).isEqualTo(5);
    }

    @Test
    public void Player_setCoordinates() {
        player.setCoordinates(new Coordinates(3, 3));
        assertThat(player.getCoordinates().getX()).isEqualTo(3);
        assertThat(player.getCoordinates().getY()).isEqualTo(3);
    }

    @Test
    public void Player_getExperience() {
        Experience experience = player.getExperience();
        assertThat(experience).isNotNull();
    }

    @Test
    public void Player_toString() {
        assertThat(player.toString()).isEqualTo("\tname: test\n" +
                "\tdescription: test\n" +
                "\thealth: 101/101\n" +
                "\tdamage: 12-18\n" +
                "\tcoordinates: [x=5,y=5]\n" +
                "\texperience: level=1, currentExp=0/100\n");
    }

    @Test
    public void Player_toStringWithColors() {
        assertThat(player.toStringWithColors()).isEqualTo("\tname: \u001B[33mtest\u001B[0m\n" +
                "\tdescription: \u001B[0mtest\u001B[0m\n" +
                "\thealth: \u001B[32m101/101\u001B[0m\n" +
                "\tdamage: \u001B[31m12-18\u001B[0m\n" +
                "\tcoordinates: \u001B[0m[x=5,y=5]\u001B[0m\n" +
                "\texperience: \u001B[0mlevel=1, currentExp=0/100\u001B[0m\n");
    }
}