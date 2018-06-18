package in.ramakant.rpg.ui.menu.item;

import static in.ramakant.rpg.common.utils.ColorFormatter.blue;
import static in.ramakant.rpg.common.utils.ColorFormatter.red;

public enum BeforeFightMenuItem {
    ATTACK(red("Attack!!!")),
    FALL_BACK(blue("Fall back from this fight."));
    private final String description;

    BeforeFightMenuItem(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
