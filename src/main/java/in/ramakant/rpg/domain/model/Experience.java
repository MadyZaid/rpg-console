package in.ramakant.rpg.domain.model;

import in.ramakant.rpg.common.constants.ConfigurationConstants;
import in.ramakant.rpg.common.utils.ToStringBuilder;

import java.io.Serializable;

public class Experience implements Serializable {
    private static final long serialVersionUID = 8485389176310336892L;

    private int level;
    private int currentExp;
    private int lastLevelUpExp;

    public Experience() {
        this.currentExp = 0;
        this.level = 1;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public int getLevel() {
        return level;
    }

    public ExperienceStatus addKillReward(int expReward) {
        currentExp += expReward;
        int startingLevel = level;
        while (currentExp >= getExpRequiredToLevelUp()) {
            levelUp();
        }

        return ExperienceStatus.fromLevelDiff(level - startingLevel);
    }

    private int getExpRequiredToLevelUp() {
        if (level == 1) {
            return ConfigurationConstants.EXP_TO_FIRST_LEVEL_UP;
        } else {
            return (int) (lastLevelUpExp + lastLevelUpExp * ConfigurationConstants.NEXT_LEVEL_EXP_MULTIPLIER);
        }
    }

    private void levelUp() {
        lastLevelUpExp = getExpRequiredToLevelUp();
        level++;
    }

    @Override
    public String toString() {
        return ToStringBuilder.defaultBuilderWithoutBrackets(this)
                .append("level", level)
                .append("currentExp", currentExp + "/" + getExpRequiredToLevelUp())
                .build();
    }
}
