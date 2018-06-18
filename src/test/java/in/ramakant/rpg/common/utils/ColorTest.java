package in.ramakant.rpg.common.utils;

import in.ramakant.rpg.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class ColorTest {
    @Test
    public void Font_AssertAll(){
        assertThat(Color.CLEAR_ALL_FORMATTING.number()).isEqualTo(0);

        assertThat(Color.BOLD.number()).isEqualTo(1);
        assertThat(Color.ITALIC.number()).isEqualTo(3);
        assertThat(Color.UNDERLINE.number()).isEqualTo(4);

        assertThat(Color.RED.number()).isEqualTo(31);
        assertThat(Color.GREEN.number()).isEqualTo(32);
        assertThat(Color.YELLOW.number()).isEqualTo(33);
        assertThat(Color.BLUE.number()).isEqualTo(34);
        assertThat(Color.MAGENTA.number()).isEqualTo(35);
        assertThat(Color.CYAN.number()).isEqualTo(36);
    }
}
