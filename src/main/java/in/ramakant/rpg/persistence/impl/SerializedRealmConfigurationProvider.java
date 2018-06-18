package in.ramakant.rpg.persistence.impl;

import in.ramakant.rpg.persistence.RealmConfigurationProvider;
import in.ramakant.rpg.persistence.SerializationRealmConfigurationGenerator;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;

import java.util.List;

import static in.ramakant.rpg.common.utils.ExternalIO.resourcesPath;

public class SerializedRealmConfigurationProvider extends SerializedResourceProvider<RealmConfiguration> implements RealmConfigurationProvider {
    public static final String FILENAME = "realm_configuration.ser";

    @Override
    protected String getFilename() {
        return FILENAME;
    }

    @Override
    protected String basePath() {
        return resourcesPath() + configPath();
    }

    @Override
    protected boolean isLoadExternal() {
        return false;
    }

    @Override
    protected List<RealmConfiguration> handleException(Exception e) {
        return rollbackToBuiltInDefault();
    }

    private List<RealmConfiguration> rollbackToBuiltInDefault() {
        return SerializationRealmConfigurationGenerator.realms();
    }
}
