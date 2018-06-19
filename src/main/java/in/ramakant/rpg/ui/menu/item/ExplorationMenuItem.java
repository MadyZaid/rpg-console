package in.ramakant.rpg.ui.menu.item;

import in.ramakant.rpg.common.constants.MenuConstants;
import in.ramakant.rpg.common.utils.ToStringBuilder;

public enum ExplorationMenuItem {
    UP("W", MenuConstants.GO_NORTH),
    DOWN("S", MenuConstants.GO_SOUTH),
    LEFT("A", MenuConstants.GO_WEST),
    RIGHT("D", MenuConstants.GO_EAST),
    COMMANDS("1", MenuConstants.SHOW_THIS_MENU),
    MAP("2", MenuConstants.SHOW_MAP),
    LEGEND("3", MenuConstants.SHOW_LEGEND),
    PLAYER("4", MenuConstants.SHOW_PLAYER_INFO),
    STATS("5", MenuConstants.SHOW_STATISTICS),
    SAVE("9", MenuConstants.SAVE_THE_GAME),
    EXIT("0", MenuConstants.EXIT);

    private final String keyBinding;
    private final String description;

    ExplorationMenuItem(String keyBinding, String description) {
        this.keyBinding = keyBinding;
        this.description = description;
    }

    public static ExplorationMenuItem fromString(String input) {
        if (input == null) {
            return null;
        }

        for (ExplorationMenuItem item : ExplorationMenuItem.values()) {
            if (item.keyBinding.equalsIgnoreCase(input)) {
                return item;
            }
        }

        return null;
    }

    public String getKeyBinding() {
        return keyBinding;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.defaultBuilder(this)
                .append("keyBinding", keyBinding)
                .append("description", description)
                .build();
    }
}
