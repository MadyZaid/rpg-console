package in.ramakant.rpg.domain.world.location;

import in.ramakant.rpg.common.utils.ToStringBuilder;
import in.ramakant.rpg.domain.model.NPC;

import java.io.Serializable;

public class Location implements Serializable {
    private static final long serialVersionUID = -6870466936186552113L;
    private final Coordinates coordinates;
    private LocationType type;
    private NPC npc;

    public Location(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.type = LocationType.EMPTY;
    }

    public Location(Coordinates coordinates, NPC npc) {
        this.coordinates = coordinates;
        this.type = npc.locationType();
        this.npc = npc;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean isAnyoneThere() {
        return npc != null && npc.isAlive();
    }

    public LocationType getType() {
        return relevantLocationType();
    }

    public String mapMark() {
        return type.getMapMark();
    }

    public String desc() {
        return type.getDescription();
    }

    public NPC getNpc() {
        return npc;
    }

    private LocationType relevantLocationType() {
        if (npc != null) {
            return npc.locationType();
        }

        return type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.defaultBuilder(this)
                .append("coordinates", coordinates.toString())
                .append("type", type.name())
                .append("mapMark", mapMark())
                .build();
    }
}
