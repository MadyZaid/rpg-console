package in.ramakant.rpg.ui.menu;

import in.ramakant.rpg.persistence.dto.PlayerConfiguration;
import in.ramakant.rpg.ui.QuestionsToPlayer;

public interface PlayerConfigurationMenu {

    PlayerConfiguration askForPlayerConfig(QuestionsToPlayer questionsToPlayer);

    void showIntroduction(String introduction);

    void greetPlayer(String greetingMessage);
}
