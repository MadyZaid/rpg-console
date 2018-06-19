package in.ramakant.rpg.ui.menu.item;

import in.ramakant.rpg.common.constants.MenuConstants;

public enum MainMenuItem {
    START(MenuConstants.START_THE_GAME),
    LOAD(MenuConstants.LOAD_LAST_GAME),
    EXIT(MenuConstants.LEAVE_GAME);

    private final String description;

    MainMenuItem(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
