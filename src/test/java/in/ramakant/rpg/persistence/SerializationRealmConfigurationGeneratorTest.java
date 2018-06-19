package in.ramakant.rpg.persistence;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class SerializationRealmConfigurationGeneratorTest {

    @Test
    public void SerializationRealmConfigurationGenerator_main() throws ConfigurationException {
        SerializationRealmConfigurationGenerator.main(new String[]{});
    }

    @Test
    public void SerializationRealmConfigurationGenerator_generateRealms() throws ConfigurationException{
        SerializationRealmConfigurationGenerator.generateRealms();
    }

    @Test
    public void realms() {
        List<RealmConfiguration> realms = SerializationRealmConfigurationGenerator.realms();
        assertThat(realms.size()).isGreaterThan(0);
    }

    @Test
    public void dungeonsRealm() {
    }

    @Test
    public void gotRealm() {
    }

    @Test
    public void buildMedic() {
    }

    @Test
    public void buildEnemy() {
    }

    @Test
    public void buildEnemy1() {
    }

    @Test
    public void buildEnemy2() {
    }

    @Test
    public void buildRealmConfiguration() {
    }
}