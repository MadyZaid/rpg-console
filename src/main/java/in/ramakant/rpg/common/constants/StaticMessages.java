package in.ramakant.rpg.common.constants;

import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;
import in.ramakant.rpg.ui.QuestionsToPlayer;

import static in.ramakant.rpg.common.utils.ColorFormatter.*;
import static in.ramakant.rpg.domain.builder.LegendBuilder.buildLegend;
import static in.ramakant.rpg.domain.builder.WorldViewBuilder.buildWorldView;

//TODO: Move all these messages into messages.properties for localization support
public interface StaticMessages {
    String ENEMY_DEFEATED = "Defeating this enemy gave you %d experience points. ";
    String LEVEL_UP = "You earned enough experience points to " + boldMagenta("level up") + " your player! ";

    String REALM_QUESTION = "In which realm would you like to begin your journey?";

    String REALM_CONFIRMATION_MESSAGE = boldMagenta("%s") + ". \n Get ready for the action! Best of luck!";

    String INTRODUCTION = "Hello, player.\n" +
            "Welcome to the game " +
            "Please tell me something about you.";

    String NAME_QUESTION = "What is your name?";
    String DESC_QUESTION = "Why are you here?";
    String BONUS_STATS_DESC = "\nSelect your skills - \n" +
            "You may distribute " + yellow(ConfigurationConstants.MAX_BONUS_POINTS + " skill points") + " to 3 attributes: bonus health, bonus damage and bonus damage variation\n" +
            "Base statistics are: " + yellow("100 health and 10-1" + ConfigurationConstants.FIGHT_DAMAGE_VARIATION_MULTIPLIER + " damage")
            + " (10 base damage and 1 damage variation. every variation point gives 0-" + ConfigurationConstants.FIGHT_DAMAGE_VARIATION_MULTIPLIER + " damage)";
    String BONUS_STATS_HP_QUESTION = "How much would you like to keep for " + yellow("bonus health") + "? (base = " + ConfigurationConstants.BASE_HEALTH + ")";
    String BONUS_STATS_DMG_QUESTION = "How much would you like to keep for " + yellow("bonus damage") + "? (base = " + ConfigurationConstants.BASE_DAMAGE + ")";
    String BONUS_STATS_DMG_VAR_QUESTION = "How much would you like to keep for " + yellow("bonus damage variation") + "? (base = " + ConfigurationConstants.BASE_DAMAGE_VARIATION + ")";

    String GREETING = boldMagenta("Wow, %s") + ", you have some amazing origin story.\n" +
            "%s\n" +
            "You will fit perfectly in the world of " + boldMagenta("%s") +
            "\n\n" +
            "Here, have a " + blue("map") + ". You'll be able to use it whenever you feel lost!\n" +
            "%s\n" +
            "%s";

    String TRAVEL_INFO = "You just traveled and you find that... ";
    String GET_AWAY_FROM_THE_FIGHT = "See you again!";

    String VICTORY = bold(green(("Congratulations, %s, you WON! Forces of evil perished and %s realm is safe again.")));
    String DEFEAT = bold(red("You died! Try harder next time!"));

    String GAME_SAVED = "Game successfully saved!";
    String GAME_LOADING_FAILED = "Could not load service state";
    String GAME_LOADED = "Welcome again! Here, let me remind you where you were";

    static QuestionsToPlayer questionsToPlayer() {
        return QuestionsToPlayer.builder()
                .withMaxBonusPoints(ConfigurationConstants.MAX_BONUS_POINTS)
                .withNameQuestion(NAME_QUESTION)
                .withDescQuestion(DESC_QUESTION)
                .withBonusStatsDescription(BONUS_STATS_DESC)
                .withBonusStatsBonusHpQuestion(BONUS_STATS_HP_QUESTION)
                .withBonusStatsBonusDamageQuestion(BONUS_STATS_DMG_QUESTION)
                .withBonusStatsBonusDamageVariationQuestion(BONUS_STATS_DMG_VAR_QUESTION)
                .build();
    }

    static String greeting(Player player, World world) {
        return String.format(GREETING, player.getName(), player.toStringWithColors(), world.getName(), buildWorldView(world, player), buildLegend());
    }

    static String realmConfigDone(World world) {
        return String.format(REALM_CONFIRMATION_MESSAGE, world.getName());
    }
}
