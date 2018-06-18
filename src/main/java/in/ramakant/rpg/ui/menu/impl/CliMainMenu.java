package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.ui.menu.MainMenu;
import in.ramakant.rpg.ui.menu.item.MainMenuItem;

public class CliMainMenu extends CliEnumMenuBase<MainMenuItem> implements MainMenu {

    public CliMainMenu(InputParser inputParser, OutputWriter outputWriter) {
        super(inputParser, outputWriter, MainMenuItem.values());
    }

    @Override
    public MainMenuItem showMenu() {
        printAllOptions();
        return selectOption();
    }
}
