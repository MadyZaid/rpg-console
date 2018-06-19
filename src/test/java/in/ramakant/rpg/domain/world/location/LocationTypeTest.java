package in.ramakant.rpg.domain.world.location;

import in.ramakant.rpg.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static in.ramakant.rpg.common.utils.ColorFormatter.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class LocationTypeTest {
    @Test
    public void getDescription() {
        assertThat(LocationType.ENEMY.getDescription()).isEqualTo("An Enemy");
        assertThat(LocationType.MEDIC.getDescription()).isEqualTo("A medic who can give you some health");
        assertThat(LocationType.NPC_DEAD.getDescription()).isEqualTo("Someone died here");
        assertThat(LocationType.PLAYER.getDescription()).isEqualTo("The Player");
        assertThat(LocationType.EMPTY.getDescription()).isEqualTo("No one is here");
    }

    @Test
    public void getMapMark() {
        assertThat(LocationType.ENEMY.getMapMark()).isEqualTo(red("E"));
        assertThat(LocationType.MEDIC.getMapMark()).isEqualTo(green("M"));
        assertThat(LocationType.NPC_DEAD.getMapMark()).isEqualTo(boldMagenta("X"));
        assertThat(LocationType.PLAYER.getMapMark()).isEqualTo(underlinedBlue("P"));
        assertThat(LocationType.EMPTY.getMapMark()).isEqualTo(" ");
    }

    @Test
    public void LocationType_toString() {
        assertThat(LocationType.ENEMY.toString()).isEqualTo("[name=ENEMY,mapMark=\u001B[31mE\u001B[0m,description=An Enemy]");
        assertThat(LocationType.MEDIC.toString()).isEqualTo("[name=MEDIC,mapMark=\u001B[32mM\u001B[0m,description=A medic who can give you some health]");
        assertThat(LocationType.EMPTY.toString()).isEqualTo("[name=EMPTY,mapMark= ,description=No one is here]");
        assertThat(LocationType.PLAYER.toString()).isEqualTo("[name=PLAYER,mapMark=\u001B[4m\u001B[34mP\u001B[0m\u001B[0m,description=The Player]");
        assertThat(LocationType.NPC_DEAD.toString()).isEqualTo("[name=NPC_DEAD,mapMark=\u001B[1m\u001B[35mX\u001B[0m\u001B[0m,description=Someone died here]");

    }
}