package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.domain.exception.PlayerValidationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class PlayerConfigurationTest {

    private PlayerConfiguration playerConfiguration;

    @Before
    public void dataSetup() throws PlayerValidationException {
        playerConfiguration = PlayerConfiguration.builder(5)
                .withName("test")
                .withDescription("test")
                .withHealthBonus(1)
                .withDamageBonus(2)
                .withDamageVariationBonus(2)
                .build();
    }

    @Test
    public void getName() {
        assertThat(playerConfiguration.getName()).isEqualTo("test");
    }

    @Test
    public void getDescription() {
        assertThat(playerConfiguration.getDesc()).isEqualTo("test");
    }

    @Test
    public void getHealthBonus() {
        assertThat(playerConfiguration.getHealthBonus()).isEqualTo(1);
    }

    @Test
    public void getDamageBonus() {
        assertThat(playerConfiguration.getDamageBonus()).isEqualTo(2);
    }

    @Test
    public void getDamageVariationBonus() {
        assertThat(playerConfiguration.getDamageVariationBonus()).isEqualTo(2);
    }
}