package in.ramakant.rpg.common.utils;

import java.io.PrintStream;

public class OutputWriter {
    private final PrintStream out;

    public OutputWriter(PrintStream out) {
        this.out = out;
    }

    public void showMessageWithSpace(String msg) {
        out.println();
        showMessage(msg);
    }

    public void showMessage(String msg) {
        out.println(msg);
    }
}
