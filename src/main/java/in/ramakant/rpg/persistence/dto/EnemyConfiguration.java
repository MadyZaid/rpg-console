package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.common.utils.ToStringBuilder;

import java.io.Serializable;

public class EnemyConfiguration implements Serializable {
    private static final long serialVersionUID = -4145543816835307342L;
    private final String name;
    private final String description;
    private final String greeting;
    private final int maxHealth;
    private final int damage;
    private final int damageVariation;

    public EnemyConfiguration(String name, String description, String greeting, int maxHealth, int damage, int damageVariation) {
        this.name = name;
        this.description = description;
        this.greeting = greeting;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.damageVariation = damageVariation;
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

    public int getDamage() {
        return damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDamageVariation() {
        return damageVariation;
    }

    @Override
    public String toString() {
        return ToStringBuilder.defaultBuilder(this)
                .append("name", name)
                .append("description", description)
                .append("greeting", greeting)
                .append("maxHp", maxHealth)
                .append("damage", damage)
                .append("damageVariation", damageVariation)
                .build();
    }
}
