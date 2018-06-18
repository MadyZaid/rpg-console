package in.ramakant.rpg.ui;

import in.ramakant.rpg.ui.menu.item.ExplorationMenuItem;

public class ExplorationMenuToStringFormatter extends MenuToStringFormatter<ExplorationMenuItem> {
    public ExplorationMenuToStringFormatter() {
    }

    public String format(ExplorationMenuItem item, int itemNumberInList) {
        return format(item.getDescription(), item.getKeyBinding());
    }
}
