package in.ramakant.rpg.domain.character;

import static in.ramakant.rpg.common.constants.StaticMessages.ENEMY_DEFEATED;
import static in.ramakant.rpg.common.constants.StaticMessages.LEVEL_UP;

public enum ExperienceStatus {
    DIDNT_LEVEL_UP(ENEMY_DEFEATED),
    LEVELED_UP(ENEMY_DEFEATED + LEVEL_UP),
    DOUBLE_LEVELED_UP(ENEMY_DEFEATED + LEVEL_UP + "Twice!"),
    TRIPLE_LEVELED_UP(ENEMY_DEFEATED + LEVEL_UP + "Thrice!!");

    private final String desc;

    ExperienceStatus(String desc) {
        this.desc = desc;
    }

    public static ExperienceStatus fromLevelDiff(int levelDiff) {
        for (ExperienceStatus experienceStatus : ExperienceStatus.values()) {
            if (levelDiff == experienceStatus.ordinal()) {
                return experienceStatus;
            }
        }

        return DIDNT_LEVEL_UP;
    }

    @Override
    public String toString() {
        return desc;
    }
}
