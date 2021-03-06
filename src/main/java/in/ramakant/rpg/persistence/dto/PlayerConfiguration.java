package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.common.utils.StringUtils;
import in.ramakant.rpg.domain.exception.PlayerValidationException;

import static in.ramakant.rpg.common.utils.ColorFormatter.bold;
import static in.ramakant.rpg.common.utils.ColorFormatter.red;

public class PlayerConfiguration {
    private final String name;
    private final String desc;
    private final int healthBonus;
    private final int damageBonus;
    private final int damageVariationBonus;

    private PlayerConfiguration(String name, String desc, int hpBonus, int damageBonus, int damageVariationBonus) {
        this.name = name;
        this.desc = desc;
        this.healthBonus = hpBonus;
        this.damageBonus = damageBonus;
        this.damageVariationBonus = damageVariationBonus;
    }

    public static PlayerConfigurationBuilder builder(int maxBonusStats) {
        return new PlayerConfigurationBuilder(maxBonusStats);
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public int getDamageVariationBonus() {
        return damageVariationBonus;
    }

    public static final class PlayerConfigurationBuilder {
        private final int maxBonusStats;

        private String name;
        private String desc;
        private int hpBonus;
        private int damageBonus;
        private int damageVariationBonus;

        private PlayerConfigurationBuilder(int maxBonusStats) {
            this.maxBonusStats = maxBonusStats;
        }

        public PlayerConfigurationBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PlayerConfigurationBuilder withDescription(String desc) {
            this.desc = desc;
            return this;
        }

        public PlayerConfigurationBuilder withHealthBonus(int hpBonus) {
            this.hpBonus = hpBonus;
            return this;
        }

        public PlayerConfigurationBuilder withDamageBonus(int damageBonus) {
            this.damageBonus = damageBonus;
            return this;
        }

        public PlayerConfigurationBuilder withDamageVariationBonus(int damageVariationBonus) {
            this.damageVariationBonus = damageVariationBonus;
            return this;
        }

        public PlayerConfiguration build() throws PlayerValidationException {
            validate();
            return new PlayerConfiguration(name, desc, hpBonus, damageBonus, damageVariationBonus);
        }

        private void validate() throws PlayerValidationException {
            if (StringUtils.isBlank(name)) {
                throw new PlayerValidationException("Name cannot be empty");
            }

            defaultEmptyDescIfNotSet();

            if (statBonusesOutsideLimit(maxBonusStats)) {
                throw new PlayerValidationException(bold(red("Too many bonus stats, the limit is " + maxBonusStats)));
            }
        }

        private void defaultEmptyDescIfNotSet() {
            if (desc == null) {
                desc = "";
            }
        }

        private boolean statBonusesOutsideLimit(int maxBonusStats) {
            int statSum = hpBonus + damageBonus + damageVariationBonus;
            return statSum > maxBonusStats || statSum < 0;
        }
    }
}
