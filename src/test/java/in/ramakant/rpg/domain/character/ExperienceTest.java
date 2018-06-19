package in.ramakant.rpg.domain.character;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.domain.character.Experience;
import in.ramakant.rpg.domain.character.ExperienceStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class ExperienceTest {

    private Experience experience;

    @Before
    public void dataSetup(){
        experience = new Experience();
    }

    @Test
    public void Experience_getCurrentExp() {
        assertThat(experience.getCurrentExp()).isEqualTo(0);
    }

    @Test
    public void Experience_getLevel() {
        assertThat(experience.getLevel()).isEqualTo(1);
    }

    @Test
    public void Experience_addKillReward() {
        assertThat(experience.addKillReward(200)).isEqualTo(ExperienceStatus.LEVELED_UP);
    }

    @Test
    public void Experience_toString() {
        assertThat(experience.toString()).isEqualTo("level=1, currentExp=0/100");
    }
}