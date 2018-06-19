package in.ramakant.rpg.domain.character;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.common.utils.Color;
import in.ramakant.rpg.domain.character.Medic;
import in.ramakant.rpg.domain.world.location.LocationType;
import in.ramakant.rpg.persistence.dto.MedicConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class MedicTest {

    private Medic medic;

    @Before
    public void dataSetup(){
        medic = new Medic(Mockito.mock(MedicConfiguration.class));
    }

    @Test
    public void greetingColor() {
        assertThat(medic.greetingColor()).isEqualTo(Color.GREEN);
    }

    @Test
    public void locationTypeSpecificForNpc() {
        assertThat(medic.locationType()).isEqualTo(LocationType.MEDIC);
    }
}