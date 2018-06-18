package in.ramakant.rpg.ui.menu.item;

public enum MainMenuItem {
    START("Start the game"),
    LOAD("Load last saved game"),
    EXIT("Leave the game");

    private final String description;

    MainMenuItem(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
