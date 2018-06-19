package in.ramakant.rpg.domain.model;

import in.ramakant.rpg.common.utils.Color;
import in.ramakant.rpg.domain.world.location.LocationType;
import in.ramakant.rpg.persistence.dto.MedicConfiguration;

import java.io.Serializable;

public class Medic extends NPC implements Serializable {
    private static final long serialVersionUID = 8584663183441712027L;

    public Medic(MedicConfiguration medicConfiguration) {
        super(medicConfiguration.getName(), medicConfiguration.getDescription(), medicConfiguration.getGreeting(), medicConfiguration.getHealthSupply(), 0, 0);
    }

    @Override
    protected Color greetingColor() {
        return Color.GREEN;
    }

    @Override
    protected LocationType locationTypeSpecificForNpc() {
        return LocationType.MEDIC;
    }
}
