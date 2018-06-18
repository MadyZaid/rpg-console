package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.common.utils.ToStringBuilder;

import java.io.Serializable;

public class MedicConfiguration implements Serializable {
    private static final long serialVersionUID = 1841775729168516828L;

    private final String name;
    private final String description;
    private final String greeting;
    private final int healthSupply;

    public MedicConfiguration(String name, String description, String greeting, int healthSupply) {
        this.name = name;
        this.description = description;
        this.greeting = greeting;
        this.healthSupply = healthSupply;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGreeting() {
        return greeting;
    }

    public int getHealthSupply() {
        return healthSupply;
    }

    @Override
    public String toString() {
        return ToStringBuilder.defaultBuilder(this)
                .append("name", name)
                .append("description", description)
                .append("greeting", greeting)
                .append("healthSupply", healthSupply)
                .build();
    }
}
