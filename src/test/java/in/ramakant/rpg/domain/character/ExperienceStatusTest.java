package in.ramakant.rpg.domain.character;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.domain.character.ExperienceStatus;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class ExperienceStatusTest {

    @Test
    public void ExperienceStatus_assertAll(){
        assertThat(ExperienceStatus.DIDNT_LEVEL_UP.toString()).isEqualTo("Defeating this enemy gave you %d experience points. ");
        assertThat(ExperienceStatus.LEVELED_UP.toString()).isEqualTo("Defeating this enemy gave you %d experience points. You earned enough experience points to \u001B[1m\u001B[35mlevel up\u001B[0m\u001B[0m your player! ");
        assertThat(ExperienceStatus.DOUBLE_LEVELED_UP.toString()).isEqualTo("Defeating this enemy gave you %d experience points. You earned enough experience points to \u001B[1m\u001B[35mlevel up\u001B[0m\u001B[0m your player! Twice!");
        assertThat(ExperienceStatus.TRIPLE_LEVELED_UP.toString()).isEqualTo("Defeating this enemy gave you %d experience points. You earned enough experience points to \u001B[1m\u001B[35mlevel up\u001B[0m\u001B[0m your player! Thrice!!");
    }

    @Test
    public void ExperienceStatus_fromLevelDiff() {
        assertThat(ExperienceStatus.fromLevelDiff(2).toString()).isEqualTo("Defeating this enemy gave you %d experience points. You earned enough experience points to \u001B[1m\u001B[35mlevel up\u001B[0m\u001B[0m your player! Twice!");
    }

    @Test
    public void ExperienceStatus_fromLevelDiff_DidNotLevelUp() {
        assertThat(ExperienceStatus.fromLevelDiff(7).toString()).isEqualTo("Defeating this enemy gave you %d experience points. ");
    }

    @Test
    public void ExperienceStatus_toString() {
        assertThat(ExperienceStatus.LEVELED_UP.toString()).isEqualTo("Defeating this enemy gave you %d experience points. You earned enough experience points to \u001B[1m\u001B[35mlevel up\u001B[0m\u001B[0m your player! ");
    }
}