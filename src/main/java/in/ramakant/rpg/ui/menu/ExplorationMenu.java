package in.ramakant.rpg.ui.menu;

import in.ramakant.rpg.ui.menu.item.ExplorationMenuItem;

public interface ExplorationMenu extends BaseMenu<ExplorationMenuItem> {
    void showMap(String map);

    void showStatistics(String statistics);
}
