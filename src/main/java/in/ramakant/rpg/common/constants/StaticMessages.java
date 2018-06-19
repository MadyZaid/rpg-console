package in.ramakant.rpg.common.constants;

import in.ramakant.rpg.domain.character.Player;
import in.ramakant.rpg.domain.world.World;
import in.ramakant.rpg.ui.QuestionsToPlayer;

import static in.ramakant.rpg.builder.LegendBuilder.buildLegend;
import static in.ramakant.rpg.builder.WorldViewBuilder.buildWorldView;
import static in.ramakant.rpg.common.utils.ColorFormatter.*;

//TODO: Move all these messages into messages.properties for localization support. May be in a json file
public interface StaticMessages {
    String WELCOME = "\nWelcome to the Dungeons!";
    String COME_BACK = "Come back soon! :)";
    String CHOOSE_OPTION = "Select an option below:";
    String BAD_MENU = "Bad menu! Shutting down...";
    String ENEMY_DEFEATED = "Defeating this enemy gave you %d experience points. ";
    String LEVEL_UP = "You earned enough experience points to " + boldMagenta("level up") + " your player! ";

    String REALM_QUESTION = "In which realm would you like to begin your journey?";

    String REALM_CONFIRMATION_MESSAGE = "Welcome to the world of " + boldMagenta("%s") + ". \n Get ready for the action!";

    String INTRODUCTION = "Please tell me something about you!";

    String NAME_QUESTION = "What is your name?";
    String DESC_QUESTION = "Why are you here?";
    String BONUS_STATS_DESC = "\nSelect your skills - \n" +
            "You may distribute " + yellow(ConfigurationConstants.MAX_BONUS_POINTS + " skill points") + " to 3 attributes: bonus health, bonus damage and bonus damage variation\n" +
            "Base statistics are: " + yellow("100 health and 10-1" + ConfigurationConstants.FIGHT_DAMAGE_VARIATION_MULTIPLIER + " damage")
            + " (10 base damage and 1 damage variation. every variation point gives 0-" + ConfigurationConstants.FIGHT_DAMAGE_VARIATION_MULTIPLIER + " damage)";
    String BONUS_STATS_HP_QUESTION = "How much would you like to keep for " + yellow("bonus health") + "? (base = " + ConfigurationConstants.BASE_HEALTH + ")";
    String BONUS_STATS_DMG_QUESTION = "How much would you like to keep for " + yellow("bonus damage") + "? (base = " + ConfigurationConstants.BASE_DAMAGE + ")";
    String BONUS_STATS_DMG_VAR_QUESTION = "How much would you like to keep for " + yellow("bonus damage variation") + "? (base = " + ConfigurationConstants.BASE_DAMAGE_VARIATION + ")";

    String GREETING = "Below is your current status " +
            "%s\n" +
            "Use your skills carefully to defeat all enemies in the world of " + boldMagenta("%s\n") +
            "Go to a " + green("medic") + " if you need to take some health.\n" +
            "Here, have a " + blue("map") + ". You'll be able to use it whenever you feel lost!\n" +
            "%s\n" +
            "%s";

    String GET_AWAY_FROM_THE_FIGHT = "See you again!";

    String VICTORY = bold(green("Congratulations, %s, you WON!") + yellow(" %s ") + green("realm is safe again."));
    String DEFEAT = bold(red("You died! Try harder next time!"));

    String GAME_SAVED = "Game successfully saved!";
    String GAME_LOADING_FAILED = "Could not load service state";
    String GAME_LOADED = "Welcome again! Here, let me remind you where you were";

    String CONFIG_ERROR = "There was a problem with the configuration. Please check the configurations.";
    String UNEXPECTED_ERROR = "There was a unexpected problem. Please try again.";
    String WRONG_OPTION = "You have chosen a wrong option, please try again";

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
