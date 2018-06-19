package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class RealmConfigurationTest {

    private RealmConfiguration realmConfiguration;

    @Before
    public void dataSetup() {
        realmConfiguration = new RealmConfiguration("test", 5, new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void RealmConfiguration_getName() {
        assertThat(realmConfiguration.getName()).isEqualTo("test");
    }

    @Test
    public void RealmConfiguration_getRealmSize() {
        assertThat(realmConfiguration.getRealmSize()).isEqualTo(5);
    }

    @Test
    public void RealmConfiguration_getEnemies() {
        assertThat(realmConfiguration.getEnemies()).isEmpty();
    }

    @Test
    public void RealmConfiguration_getMedics() {
        assertThat(realmConfiguration.getMedics()).isEmpty();
    }

    @Test
    public void RealmConfiguration_toString() {
        assertThat(realmConfiguration.toString()).isEqualTo("test");
    }

    @Test
    public void RealmConfiguration_detailedToString() {
        assertThat(realmConfiguration.detailedToString()).isEqualTo("RealmConfiguration[name=test,realmSize=5,enemies=no enemies defined,medics=no medics defined]");
    }

    @Test
    public void RealmConfiguration_shortDescription() {
        assertThat(realmConfiguration.shortDesc()).isEqualTo("test this is the map");
    }
}