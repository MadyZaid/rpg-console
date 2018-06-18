package in.ramakant.rpg.domain.model;

import in.ramakant.rpg.common.utils.Color;
import in.ramakant.rpg.domain.world.location.LocationType;
import in.ramakant.rpg.persistence.dto.EnemyConfiguration;

public class Enemy extends NPC {
    private static final long serialVersionUID = 4251180469538630063L;

    public Enemy(String name, String description, String greeting, int maxHealth, int damage, int damageVariation) {
        super(name, description, greeting, maxHealth, damage, damageVariation);
    }

    public Enemy(EnemyConfiguration conf) {
        this(conf.getName(), conf.getDescription(), conf.getGreeting(), conf.getMaxHealth(), conf.getDamage(), conf.getDamageVariation());
    }

    @Override
    protected LocationType locationTypeSpecificForNpc() {
        return LocationType.ENEMY;
    }

    @Override
    protected Color greetingColor() {
        return Color.RED;
    }
}
