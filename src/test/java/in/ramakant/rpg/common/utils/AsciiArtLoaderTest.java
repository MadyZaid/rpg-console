package in.ramakant.rpg.common.utils;

import in.ramakant.rpg.UnitTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class AsciiArtLoaderTest {
    @Test
    public void AsciiArtLoader_ReturnEmptyString_IfAsciiNotPresent() {
        String ascii = AsciiArtLoader.loadIfPossible("ramakant");
        assertThat(ascii).isEqualTo("");
    }

    @Test
    public void AsciiArtLoader_ReturnAscii_IfAsciiIsPresent() {
        String ascii = AsciiArtLoader.loadIfPossible("Elmo");
        assertThat(ascii).isNotBlank();
    }
}
