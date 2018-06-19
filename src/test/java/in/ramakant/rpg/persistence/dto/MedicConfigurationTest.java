package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class MedicConfigurationTest {

    private MedicConfiguration medicConfiguration;

    @Before
    public void dataSetup(){
        medicConfiguration = new MedicConfiguration("test", "test", "test", 100);
    }

    @Test
    public void MedicConfiguration_getName() {
        assertThat(medicConfiguration.getName()).isEqualTo("test");
    }

    @Test
    public void MedicConfiguration_getDescription() {
        assertThat(medicConfiguration.getDescription()).isEqualTo("test");
    }

    @Test
    public void MedicConfiguration_getGreeting() {
        assertThat(medicConfiguration.getGreeting()).isEqualTo("test");
    }

    @Test
    public void MedicConfiguration_getHealthSupply() {
        assertThat(medicConfiguration.getHealthSupply()).isEqualTo(100);
    }

    @Test
    public void MedicConfiguration_toString() {
        assertThat(medicConfiguration.toString()).isEqualTo("[name=test,description=test,greeting=test,healthSupply=100]");

    }
}