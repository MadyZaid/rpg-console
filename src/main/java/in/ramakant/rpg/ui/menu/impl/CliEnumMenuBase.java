package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;

import java.util.Arrays;

public class CliEnumMenuBase<T extends Enum> extends CliMenuBase<T> {
    protected CliEnumMenuBase(InputParser inputParser, OutputWriter outputWriter, T[] menuItems) {
        super(inputParser, outputWriter, Arrays.asList(menuItems));
    }
}
