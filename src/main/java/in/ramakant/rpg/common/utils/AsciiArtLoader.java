package in.ramakant.rpg.common.utils;

public class AsciiArtLoader {
    public static final String ASCII_ART_FOLDER = "ascii_art";

    private AsciiArtLoader() {
    }

    public static String loadIfPossible(String characterName) {
        try {
            return InternalIO.readAsString(ASCII_ART_FOLDER, characterName);
        } catch (NullPointerException e) {
            return "";
        }
    }
}
