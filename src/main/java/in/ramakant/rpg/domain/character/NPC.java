package in.ramakant.rpg.domain.character;

import in.ramakant.rpg.common.utils.Color;
import in.ramakant.rpg.domain.world.location.LocationType;

/**
 * NPC = Non Player Character
 */
public abstract class NPC extends Character {
    private static final long serialVersionUID = 2466275918667512445L;

    private final String greeting;
    private final int expReward;

    public NPC(String name, String description, String greeting, int maxHealth, int damage, int damageVariation) {
        super(name, description, maxHealth, damage, damageVariation);
        this.greeting = greeting;
        this.expReward = maxHealth; //This player rewards its maxHealth when gets defeated by the player
    }

    public int getExpReward() {
        return expReward;
    }

    public boolean isEnemy() {
        return this instanceof Enemy;
    }

    public boolean isMedic() {
        return this instanceof Medic;
    }

    public String greeting() {
        return greetingColor().format(greeting);
    }

    protected abstract Color greetingColor();

    public LocationType locationType() {
        if (!isAlive) {
            return LocationType.NPC_DEAD;
        } else {
            return locationTypeSpecificForNpc();
        }
    }

    protected abstract LocationType locationTypeSpecificForNpc();
}
