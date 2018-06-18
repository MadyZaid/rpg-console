package in.ramakant.rpg.ui.menu.item;

import in.ramakant.rpg.common.utils.ToStringBuilder;

public enum ExplorationMenuItem {
    UP("W", "Go North"),
    DOWN("S", "Go South"),
    LEFT("A", "Go West"),
    RIGHT("D", "Go East"),
    COMMANDS("1", "Show this menu"),
    MAP("2", "Show map"),
    LEGEND("3", "Show legend"),
    PLAYER("4", "Show player info"),
    STATS("5", "Show statistics"),
    SAVE("9", "Save the service"),
    EXIT("0", "Exit to main menu");

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
