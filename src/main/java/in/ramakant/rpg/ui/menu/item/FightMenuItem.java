package in.ramakant.rpg.ui.menu.item;

import in.ramakant.rpg.common.constants.ConfigurationConstants;

import static in.ramakant.rpg.common.utils.ColorFormatter.red;
import static in.ramakant.rpg.common.utils.ColorFormatter.yellow;

public enum FightMenuItem {
    ATTACK(red("Attack") + " the enemy"),
    FLEE(yellow("Flee from here if you feel like.") + " This will save your life, but reduce health by " + ConfigurationConstants.FIGHT_FLEEING_HP_REDUCTION);

    private final String description;

    FightMenuItem(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
