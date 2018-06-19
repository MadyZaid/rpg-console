package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class EnemyConfigurationTest {

    private EnemyConfiguration enemyConfiguration;

    @Before
    public void dataSetup() {
        enemyConfiguration = new EnemyConfiguration("test", "test", "test", 100, 5, 2);
    }

    @Test
    public void EnemyConfiguration_getName() {
        assertThat(enemyConfiguration.getName()).isEqualTo("test");
    }

    @Test
    public void EnemyConfiguration_getDescription() {
        assertThat(enemyConfiguration.getDescription()).isEqualTo("test");
    }

    @Test
    public void EnemyConfiguration_getGreeting() {
        assertThat(enemyConfiguration.getGreeting()).isEqualTo("test");
    }

    @Test
    public void EnemyConfiguration_getDamage() {
        assertThat(enemyConfiguration.getDamage()).isEqualTo(5);
    }

    @Test
    public void EnemyConfiguration_getMaxHealth() {
        assertThat(enemyConfiguration.getMaxHealth()).isEqualTo(100);
    }

    @Test
    public void EnemyConfiguration_getDamageVariation() {
        assertThat(enemyConfiguration.getDamageVariation()).isEqualTo(2);
    }

    @Test
    public void EnemyConfiguration_toString() {
        assertThat(enemyConfiguration.toString()).isEqualTo("[name=test,description=test,greeting=test,maxHp=100,damage=5,damageVariation=2]");
    }
}