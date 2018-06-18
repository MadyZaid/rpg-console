package in.ramakant.rpg.common.utils;

public enum Color {
    CLEAR_ALL_FORMATTING(0),

    BOLD(1),
    ITALIC(3),
    UNDERLINE(4),

    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36);

    private final int colorNumber;

    Color(int colorNumber) {
        this.colorNumber = colorNumber;
    }

    public int number() {
        return colorNumber;
    }

    public String format(String input) {
        return (char) 27 + "[" + number() + "m" + input + (char) 27 + "[" + CLEAR_ALL_FORMATTING.number() + "m";
    }

    @Override
    public String toString() {
        return name() + "(" + colorNumber + ")";
    }
}