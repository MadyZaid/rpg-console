package in.ramakant.rpg.ui.menu;

import in.ramakant.rpg.persistence.dto.RealmConfiguration;

import java.util.List;

public interface WorldConfigurationMenu {
    RealmConfiguration chooseConfiguration(String realmQuestion, List<RealmConfiguration> realmConfigs);

    void confirmRealmConfiguration(String realmConfirmationMessage);
}
