package in.ramakant.rpg.common.utils;

import in.ramakant.rpg.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class StringUtilsTest {
    @Test
    public void StringUtils_IsBlank_ReturnTrueIfStringIsNull(){
        boolean result = StringUtils.isBlank(null);
        assertThat(result).isTrue();
    }

    @Test
    public void StringUtils_IsBlank_ReturnTrueIfStringIsEmpty(){
        boolean result = StringUtils.isBlank("");
        assertThat(result).isTrue();
    }

    @Test
    public void StringUtils_IsBlank_ReturnTrueIfStringIsEmptyWithWhitespaces(){
        boolean result = StringUtils.isBlank("        ");
        assertThat(result).isTrue();
    }

    @Test
    public void StringUtils_IsBlank_ReturnFalseIfStringIsNotBlank(){
        boolean result = StringUtils.isBlank("  ramakant      ");
        assertThat(result).isFalse();
    }
}
