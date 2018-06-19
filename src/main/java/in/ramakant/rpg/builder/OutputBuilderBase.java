package in.ramakant.rpg.builder;

abstract class OutputBuilderBase {
    protected String formatDigit(int digit) {
        return commonFormat(digit, "d");
    }

    protected String formatString(String string) {
        return commonFormat(string, "s");
    }

    protected String commonFormat(Object value, String valueType) {
        return String.format("%-4" + valueType, value);
    }

    protected String formatLocationMark(String mark) {
        return mark + "   ";
    }
}
