package in.ramakant.rpg.common.constants;

import static in.ramakant.rpg.common.utils.ColorFormatter.red;
import static in.ramakant.rpg.common.utils.ColorFormatter.yellow;

public interface MenuConstants {
    String ATTACK = "Attack!!!";
    String FALL_BACK = "Fall back from this fight.";

    String GO_NORTH = "Go North";
    String GO_SOUTH = "Go South";
    String GO_WEST = "Go West";
    String GO_EAST = "Go East";
    String SHOW_THIS_MENU = "Show this menu";
    String SHOW_MAP = "Show map";
    String SHOW_LEGEND = "Show legend";
    String SHOW_PLAYER_INFO = "Show player info";
    String SHOW_STATISTICS = "Show statistics";
    String SAVE_THE_GAME = "Save the game";
    String EXIT = "Exit to main menu";

    String ATTACK_THE_ENEMY = red("Attack") + " the enemy";
    String FLEE = yellow("Flee from here if you feel like.") + " This will save your life, but reduce health by " + ConfigurationConstants.FIGHT_FLEEING_HP_REDUCTION;

    String START_THE_GAME = "Start the game";
    String LOAD_LAST_GAME = "Load last saved game";
    String LEAVE_GAME = "Leave the game";


}
