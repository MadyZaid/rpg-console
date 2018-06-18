package in.ramakant.rpg.common.utils;

import in.ramakant.rpg.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class RandomIntegerUtilsTest {
    @Test
    public void RandomIntegerUtils_getRandomIntInclusive_ReturnsIntLessThanOrEqualToGivenNumber(){
        int result = RandomIntegerUtils.getRandomIntInclusive(5);
        assertThat(result).isBetween(0, 5);
    }

    @Test
    public void RandomIntegerUtils_getRandomIntInclusive_ReturnsIntBetweenGivenNumbers(){
        int result = RandomIntegerUtils.getRandomIntInclusive(5, 10);
        assertThat(result).isBetween(5, 10);
    }

    @Test
    public void RandomIntegerUtils_getRandomIntExclusive_ReturnsIntLessThanGivenNumber(){
        int result = RandomIntegerUtils.getRandomIntExclusive(5);
        assertThat(result).isBetween(0, 4);
    }

    @Test
    public void RandomIntegerUtils_getRandomIntExclusive_ReturnsIntBetweenGivenNumbers(){
        int result = RandomIntegerUtils.getRandomIntInclusive(5, 10);
        assertThat(result).isBetween(5, 9);
    }
}
