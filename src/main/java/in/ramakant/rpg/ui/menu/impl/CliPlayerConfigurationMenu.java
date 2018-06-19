package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.domain.exception.PlayerValidationException;
import in.ramakant.rpg.persistence.dto.PlayerConfiguration;
import in.ramakant.rpg.ui.QuestionsToPlayer;
import in.ramakant.rpg.ui.menu.PlayerConfigurationMenu;

public class CliPlayerConfigurationMenu extends CliMenuBase<String> implements PlayerConfigurationMenu {

    public CliPlayerConfigurationMenu(InputParser inputParser, OutputWriter outputWriter) {
        super(inputParser, outputWriter);
    }

    @Override
    public PlayerConfiguration askForPlayerConfig(QuestionsToPlayer questions) {
        PlayerConfiguration playerConfiguration = null;

        PlayerConfiguration.PlayerConfigurationBuilder playerConfigurationBuilder = PlayerConfiguration.builder(questions.getMaxBonusPoints());
        playerConfigurationBuilder.withName(inputParser.readUserInputAsString(questions.getNameQuestion()));
        playerConfigurationBuilder.withDescription(inputParser.readUserInputAsString(questions.getDescQuestion()));

        do {
            try {
                showMessage(questions.getBonusStatsDescription());
                playerConfigurationBuilder.withHealthBonus(inputParser.tryReadingInputAsInt(questions.getBonusStatsBonusHpQuestion()));
                playerConfigurationBuilder.withDamageBonus(inputParser.tryReadingInputAsInt(questions.getBonusStatsBonusDanageQuestion()));
                playerConfigurationBuilder.withDamageVariationBonus(inputParser.tryReadingInputAsInt(questions.getBonusStatsBonusDanageVariationQuestion()));

                playerConfiguration = playerConfigurationBuilder.build();
            } catch (PlayerValidationException e) {
                showMessage(e.getMessage());
            }
        } while (playerConfiguration == null);

        return playerConfiguration;
    }

    @Override
    public void showIntroduction(String introduction) {
        outputWriter.showMessageWithSpace(introduction);
    }

    @Override
    public void greetPlayer(String greetingMessage) {
        outputWriter.showMessageWithSpace(greetingMessage);
    }
}
