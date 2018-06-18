package in.ramakant.rpg.persistence.impl;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.domain.exception.LoadGameException;
import in.ramakant.rpg.persistence.GameStateProvider;
import in.ramakant.rpg.persistence.dto.GameState;

import java.util.List;

import static in.ramakant.rpg.common.constants.StaticMessages.GAME_LOADING_FAILED;

public class SerializedGameStateProvider extends SerializedResourceProvider<GameState> implements GameStateProvider {

    private static final String DEFAULT_SAVE_FILENAME = "save.ser";

    @Override
    public List<GameState> load() throws ConfigurationException {
        try {
            return super.load();
        } catch (ConfigurationException e) {
            throw new LoadGameException(e);
        }
    }

    @Override
    protected List<GameState> handleException(Exception e) throws ConfigurationException {
        throw new ConfigurationException(GAME_LOADING_FAILED, e);
    }

    @Override
    protected String getFilename() {
        return DEFAULT_SAVE_FILENAME;
    }

    @Override
    protected String basePath() {
        return savePath();
    }

    @Override
    protected boolean isLoadExternal() {
        return true;
    }
}
