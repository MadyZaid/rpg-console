package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.constants.StaticMessages;
import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.domain.exception.GameException;
import in.ramakant.rpg.ui.MenuToStringFormatter;
import in.ramakant.rpg.ui.menu.BaseMenu;

import java.util.List;

public abstract class CliMenuBase<T> implements BaseMenu<T> {

    protected final InputParser inputParser;
    protected final OutputWriter outputWriter;
    protected final MenuToStringFormatter<T> menuFormatter;
    protected List<T> menuItems;

    protected CliMenuBase(InputParser inputParser, OutputWriter outputWriter) {
        this(inputParser, outputWriter, null);
    }

    protected CliMenuBase(InputParser inputParser, OutputWriter outputWriter, List<T> menuItems) {
        this.inputParser = inputParser;
        this.outputWriter = outputWriter;
        this.menuItems = menuItems;
        this.menuFormatter = menuFormatter();
    }

    protected MenuToStringFormatter<T> menuFormatter() {
        return new MenuToStringFormatter<>();
    }

    public void setMenuItems(List<T> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public void showMessage(String message) {
        outputWriter.showMessage(message);
    }

    public T showMenu() {
        printAllOptions();
        return selectOption();
    }

    public void printAllOptions(String message) {
        outputWriter.showMessageWithSpace(message);
        printAllOptions();
    }

    public void printAllOptions() {
        if (menuItems == null) {
            throw new GameException(StaticMessages.BAD_MENU);
        }

        outputWriter.showMessageWithSpace(StaticMessages.CHOOSE_OPTION);
        for (int i = 0; i < menuItems.size(); i++) {
            outputWriter.showMessage(formatMessage(menuItems.get(i), i));
        }
    }

    private String formatMessage(T item, int i) {
        return menuFormatter.format(item, i);
    }

    public T selectOption() {
        T menuItem = readUserChoice();
        return menuItem;
    }

    protected T readUserChoice() {
        return menuItems.get(inputParser.tryReadingMenuChoice(menuItems.size()));
    }
}
