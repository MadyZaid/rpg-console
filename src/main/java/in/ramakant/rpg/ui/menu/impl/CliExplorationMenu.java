package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.ui.ExplorationMenuToStringFormatter;
import in.ramakant.rpg.ui.MenuToStringFormatter;
import in.ramakant.rpg.ui.menu.ExplorationMenu;
import in.ramakant.rpg.ui.menu.item.ExplorationMenuItem;

public class CliExplorationMenu extends CliEnumMenuBase<ExplorationMenuItem> implements ExplorationMenu {
    public CliExplorationMenu(InputParser inputParser, OutputWriter outputWriter) {
        super(inputParser, outputWriter, ExplorationMenuItem.values());
    }

    @Override
    public void showMap(String map) {
        outputWriter.showMessageWithSpace(map);
    }

    @Override
    public void showStatistics(String statistics) {
        outputWriter.showMessageWithSpace(statistics);
    }

    @Override
    protected MenuToStringFormatter<ExplorationMenuItem> menuFormatter() {
        return new ExplorationMenuToStringFormatter();
    }

    @Override
    protected ExplorationMenuItem readUserChoice() {
        ExplorationMenuItem choice = ExplorationMenuItem.fromString(inputParser.readUserInputAsString());
        if (choice == null) {
            showMessage("You have chosen a wrong option, please try again");
            return ExplorationMenuItem.COMMANDS;
        }

        return choice;
    }

}
