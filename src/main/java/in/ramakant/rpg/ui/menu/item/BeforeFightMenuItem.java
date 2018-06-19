package in.ramakant.rpg.ui.menu.item;

import in.ramakant.rpg.common.constants.MenuConstants;

import static in.ramakant.rpg.common.utils.ColorFormatter.blue;
import static in.ramakant.rpg.common.utils.ColorFormatter.red;

public enum BeforeFightMenuItem {
    ATTACK(red(MenuConstants.ATTACK)),
    FALL_BACK(blue(MenuConstants.FALL_BACK));
    private final String description;

    BeforeFightMenuItem(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
