package in.ramakant.rpg.domain.model;

import in.ramakant.rpg.common.constants.ConfigurationConstants;
import in.ramakant.rpg.common.utils.RandomIntegerUtils;
import in.ramakant.rpg.common.utils.ToStringBuilder;

import java.io.Serializable;

import static in.ramakant.rpg.common.utils.Color.*;

public abstract class Character implements Serializable {
    private static final long serialVersionUID = -1547755448238755247L;

    protected final String name;
    protected final String description;

    protected int maxHealth;
    protected int currentHealth;
    protected int damage;
    protected int damageVariation;

    protected boolean isAlive;

    public Character(String name, String description, int maxHealth, int damage, int damageVariation) {
        this.name = name;
        this.description = description;

        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.damage = damage;
        this.damageVariation = damageVariation;

        this.isAlive = true;
    }

    public int attack(Character otherCharacter) {
        return otherCharacter.receiveDamage(calculateDamageToDeal());
    }

    private int receiveDamage(int damage) {
        currentHealth = currentHealth - damage;
        if (currentHealth <= 0) {
            die();
        }

        return damage;
    }

    protected int calculateDamageToDeal() {
        return RandomIntegerUtils.getRandomIntInclusive(damage, damage + damageVariation * ConfigurationConstants.FIGHT_DAMAGE_VARIATION_MULTIPLIER);
    }

    public void die() {
        isAlive = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public int getDamageVariation() {
        return damageVariation;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isDead() {
        return !isAlive;
    }

    public String currentStatus() {
        return "\n" + getClass().getSimpleName() + " current status is: \n" + toStringWithColors();
    }

    @Override
    public String toString() {
        return toStringCommon().build();
    }

    public String toStringWithColors() {
        return toStringCommon().build(true);
    }

    private ToStringBuilder toStringCommon() {
        return ToStringBuilder.fieldsWithNewlinesAndTabs(this)
                .append("name", name, YELLOW)
                .append("description", description)
                .append("health", currentHealth + "/" + maxHealth, GREEN)
                .append("damage", damage + "-" + (damage + damageVariation * ConfigurationConstants.FIGHT_DAMAGE_VARIATION_MULTIPLIER), RED);
    }
}
