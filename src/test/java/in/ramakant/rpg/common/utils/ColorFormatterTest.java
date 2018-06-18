package in.ramakant.rpg.common.utils;

import in.ramakant.rpg.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class ColorFormatterTest {
    @Test
    public void ColorFormatter_AssertAllFormats(){
        assertThat(ColorFormatter.red("ramakant")).isEqualTo("\u001B[31mramakant\u001B[0m");
        assertThat(ColorFormatter.blue("ramakant")).isEqualTo("\u001B[34mramakant\u001B[0m");
        assertThat(ColorFormatter.green("ramakant")).isEqualTo("\u001B[32mramakant\u001B[0m");
        assertThat(ColorFormatter.yellow("ramakant")).isEqualTo("\u001B[33mramakant\u001B[0m");
        assertThat(ColorFormatter.cyan("ramakant")).isEqualTo("\u001B[36mramakant\u001B[0m");
        assertThat(ColorFormatter.bold("ramakant")).isEqualTo("\u001B[1mramakant\u001B[0m");
        assertThat(ColorFormatter.boldMagenta("ramakant")).isEqualTo("\u001B[1m\u001B[35mramakant\u001B[0m\u001B[0m");
        assertThat(ColorFormatter.underlinedBlue("ramakant")).isEqualTo("\u001B[4m\u001B[34mramakant\u001B[0m\u001B[0m");
    }
}