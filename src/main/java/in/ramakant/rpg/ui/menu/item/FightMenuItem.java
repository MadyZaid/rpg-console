package in.ramakant.rpg.ui.menu.item;

import in.ramakant.rpg.common.constants.MenuConstants;

public enum FightMenuItem {
    ATTACK(MenuConstants.ATTACK_THE_ENEMY),
    FLEE(MenuConstants.FLEE);

    private final String description;

    FightMenuItem(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
