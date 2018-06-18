package in.ramakant.rpg.domain.world.location;

import in.ramakant.rpg.common.utils.ToStringBuilder;

import static in.ramakant.rpg.common.utils.ColorFormatter.*;

public enum LocationType {
    EMPTY("Nothing is here", " "),
    MEDIC("A medic who can give you some health", green("M")),
    ENEMY("An Enemy", red("E")),
    PLAYER("The Player", underlinedBlue("P")),
    NPC_DEAD("Someone died here", boldMagenta("X"));

    private final String description;
    private final String mapMark;

    LocationType(String description, String mapMark) {
        this.description = description;
        this.mapMark = mapMark;
    }

    public String getDescription() {
        return description;
    }

    public String getMapMark() {
        return mapMark;
    }

    @Override
    public String toString() {
        return ToStringBuilder.defaultBuilder(this)
                .append("name", name())
                .append("mapMark", mapMark)
                .append("description", description)
                .build();
    }
}
