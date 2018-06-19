package in.ramakant.rpg.domain.world.location;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.domain.character.Enemy;
import in.ramakant.rpg.domain.character.Medic;
import in.ramakant.rpg.persistence.dto.MedicConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static in.ramakant.rpg.common.utils.ColorFormatter.green;
import static in.ramakant.rpg.common.utils.ColorFormatter.red;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class LocationTest {

    private Location enemyLocation;
    private Location medicLocation;
    private Location emptyLocation;
    private Enemy enemy;
    private Medic medic;

    @Before
    public void dataSetup() {
        enemy = new Enemy("test", "test", "test", 100, 5, 2);
        MedicConfiguration medicConfiguration = new MedicConfiguration("test", "test", "test", 100);
        medic = new Medic(medicConfiguration);
        enemyLocation = new Location(new Coordinates(5, 5), enemy);
        medicLocation = new Location(new Coordinates(1, 1), medic);
        emptyLocation = new Location(new Coordinates(2,2));
    }

    @Test
    public void Location_getCoordinates_Enemy() {
        assertThat(enemyLocation.getCoordinates().getX()).isEqualTo(5);
        assertThat(enemyLocation.getCoordinates().getY()).isEqualTo(5);
    }

    @Test
    public void Location_getCoordinates_Medic() {
        assertThat(medicLocation.getCoordinates().getX()).isEqualTo(1);
        assertThat(medicLocation.getCoordinates().getY()).isEqualTo(1);
    }

    @Test
    public void Location_isAnyoneThere_Enemy() {
        assertThat(enemyLocation.isAnyoneThere()).isTrue();
    }

    @Test
    public void Location_isAnyoneThere_Medic() {
        assertThat(medicLocation.isAnyoneThere()).isTrue();
    }

    @Test
    public void Location_getType_Enemy() {
        assertThat(enemyLocation.getType()).isEqualTo(LocationType.ENEMY);
    }

    @Test
    public void Location_getType_Medic() {
        assertThat(medicLocation.getType()).isEqualTo(LocationType.MEDIC);
    }

    @Test
    public void Location_getType_Empty() {
        assertThat(emptyLocation.getType()).isEqualTo(LocationType.EMPTY);
    }

    @Test
    public void Location_mapMark_Enemy() {
        assertThat(enemyLocation.mapMark()).isEqualTo(red("E"));
    }

    @Test
    public void Location_mapMark_Medic() {
        assertThat(medicLocation.mapMark()).isEqualTo(green("M"));
    }

    @Test
    public void Location_desc_Enemy() {
        assertThat(enemyLocation.desc()).isEqualTo("An Enemy");
    }

    @Test
    public void Location_desc_Medic() {
        assertThat(medicLocation.desc()).isEqualTo("A medic who can give you some health");
    }

    @Test
    public void Location_getNpc_Enemy() {
        assertThat((Enemy) enemyLocation.getNpc()).isEqualTo(enemy);
    }

    @Test
    public void Location_getNpc_Medic() {
        assertThat((Medic) medicLocation.getNpc()).isEqualTo(medic);
    }

    @Test
    public void Location_toString_Enemy() {
        assertThat(enemyLocation.toString()).isEqualTo("[coordinates=[x=5,y=5],type=ENEMY,mapMark=\u001B[31mE\u001B[0m]");
    }

    @Test
    public void Location_toString_Medic() {
        assertThat(medicLocation.toString()).isEqualTo("[coordinates=[x=1,y=1],type=MEDIC,mapMark=\u001B[32mM\u001B[0m]");
    }
}