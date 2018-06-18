package in.ramakant.rpg.common.utils;

import static in.ramakant.rpg.common.utils.Color.*;

public class ColorFormatter {
    public static String red(String input) {
        return RED.format(input);
    }

    public static String blue(String input) {
        return BLUE.format(input);
    }

    public static String green(String input) {
        return GREEN.format(input);
    }

    public static String yellow(String input) {
        return YELLOW.format(input);
    }

    public static String cyan(String input) {
        return CYAN.format(input);
    }

    public static String bold(String input) {
        return BOLD.format(input);
    }

    public static String boldMagenta(String input) {
        return bold(MAGENTA.format(input));
    }

    public static String underlinedBlue(String input) {
        return UNDERLINE.format(BLUE.format(input));
    }
}
