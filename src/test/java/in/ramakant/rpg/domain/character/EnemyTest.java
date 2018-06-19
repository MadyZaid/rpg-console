package in.ramakant.rpg.domain.character;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.common.utils.Color;
import in.ramakant.rpg.domain.character.Enemy;
import in.ramakant.rpg.domain.character.Player;
import in.ramakant.rpg.domain.world.location.LocationType;
import in.ramakant.rpg.persistence.dto.EnemyConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class EnemyTest {

    Enemy enemy;

    @Before
    public void dataSetup(){
        enemy = new Enemy("test", "test", "test", 100, 15, 2);
    }

    @Test
    public void Enemy_fromEnemyConfiguration(){
        Enemy enemyFromConfiguration = new Enemy(Mockito.mock(EnemyConfiguration.class));
        assertThat(enemyFromConfiguration).isNotNull();
    }

    @Test
    public void Enemy_getName(){
        assertThat(enemy.getName()).isEqualTo("test");
    }

    @Test
    public void Enemy_getDescription(){
        assertThat(enemy.getDescription()).isEqualTo("test");
    }

    @Test
    public void Enemy_getMaxHealth(){
        assertThat(enemy.getMaxHealth()).isEqualTo(100);
    }

    @Test
    public void Enemy_getDamage(){
        assertThat(enemy.getDamage()).isEqualTo(15);
    }

    @Test
    public void Enemy_getCurrentHealth(){
        assertThat(enemy.getCurrentHealth()).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void Enemy_getDamageVariation(){
        assertThat(enemy.getDamageVariation()).isEqualTo(2);
    }

    @Test
    public void Enemy_greeting(){
        assertThat(enemy.greeting()).isEqualTo("\u001B[31mtest\u001B[0m");
    }

    @Test
    public void Enemy_locationType(){
        assertThat(enemy.locationType()).isEqualTo(LocationType.ENEMY);
    }

    @Test
    public void Enemy_getExpReward(){
        assertThat(enemy.getExpReward()).isEqualTo(100);
    }

    @Test
    public void Enemy_attack(){
        assertThat(enemy.attack(Mockito.mock(Player.class))).isGreaterThanOrEqualTo(15);
    }

    @Test
    public void Enemy_isAlive(){
        assertThat(enemy.isAlive()).isTrue();
    }

    @Test
    public void Enemy_isEnemy(){
        assertThat(enemy.isEnemy()).isTrue();
    }

    @Test
    public void Enemy_isMedic(){
        assertThat(enemy.isMedic()).isFalse();
    }

    @Test
    public void Enemy_currentStatus(){
        assertThat(enemy.currentStatus()).isEqualTo("\n" +
                "Enemy current status is: \n" +
                "\tname: \u001B[33mtest\u001B[0m\n" +
                "\tdescription: \u001B[0mtest\u001B[0m\n" +
                "\thealth: \u001B[32m100/100\u001B[0m\n" +
                "\tdamage: \u001B[31m15-19\u001B[0m\n");
    }

    @Test
    public void Enemy_isDead(){
        assertThat(enemy.isDead()).isFalse();
    }

    @Test
    public void Enemy_toString(){
        assertThat(enemy.toString()).isEqualTo("\tname: test\n" +
                "\tdescription: test\n" +
                "\thealth: 100/100\n" +
                "\tdamage: 15-19\n");
    }

    @Test
    public void Enemy_toStringWithColors(){
        assertThat(enemy.toStringWithColors()).isEqualTo("\tname: \u001B[33mtest\u001B[0m\n" +
                "\tdescription: \u001B[0mtest\u001B[0m\n" +
                "\thealth: \u001B[32m100/100\u001B[0m\n" +
                "\tdamage: \u001B[31m15-19\u001B[0m\n");
    }

    @Test
    public void Enemy_locationTypeSpecificForNpc() {
        assertThat(enemy.locationType()).isEqualTo(LocationType.ENEMY);
    }

    @Test
    public void Enemy_greetingColor() {
        assertThat(enemy.greetingColor()).isEqualTo(Color.RED);
    }
}