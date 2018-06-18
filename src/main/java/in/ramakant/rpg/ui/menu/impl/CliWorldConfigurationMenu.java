package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;
import in.ramakant.rpg.ui.menu.WorldConfigurationMenu;

import java.util.List;

public class CliWorldConfigurationMenu extends CliMenuBase<RealmConfiguration> implements WorldConfigurationMenu {

    public CliWorldConfigurationMenu(InputParser inputParser, OutputWriter outputWriter) {
        super(inputParser, outputWriter);
    }

    @Override
    public RealmConfiguration chooseConfiguration(String realmQuestion, List<RealmConfiguration> realmConfigs) {
        setMenuItems(realmConfigs);

        printAllOptions(realmQuestion);
        return selectOption();
    }

    @Override
    public void confirmRealmConfiguration(String realmConfirmationMessage) {
        outputWriter.showMessageWithSpace(realmConfirmationMessage);
    }
}
