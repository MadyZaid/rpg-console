package in.ramakant.rpg.common.constants;

import in.ramakant.rpg.common.context.PropertyProvider;

public interface ConfigurationConstants {
    int MAX_BONUS_POINTS = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.MAX_BONUS_POINTS));
    int FIGHT_FLEEING_HP_REDUCTION = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.FIGHT_FLEEING_HP_REDUCTION));
    int LEVEL_UP_BONUS = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.LEVEL_UP_BONUS));
    int FIGHT_DAMAGE_VARIATION_MULTIPLIER = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.FIGHT_DAMAGE_VARIATION_MULTIPLIER));
    int EXP_TO_FIRST_LEVEL_UP = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.EXP_TO_FIRST_LEVEL_UP));
    float NEXT_LEVEL_EXP_MULTIPLIER = Float.parseFloat(PropertyProvider.getPropertyValue(PropertyKeyConstants.NEXT_LEVEL_EXP_MULTIPLIER));
    int BASE_HEALTH = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.BASE_HEALTH));
    int BASE_DAMAGE = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.BASE_DAMAGE));
    int BASE_DAMAGE_VARIATION = Integer.parseInt(PropertyProvider.getPropertyValue(PropertyKeyConstants.BASE_DAMAGE_VARIATION));
}
