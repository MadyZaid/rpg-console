package in.ramakant.rpg.persistence;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.persistence.dto.GameState;

public interface GameStateProvider extends Repository<GameState> {
    default GameState loadGame() throws ConfigurationException {
        return loadOne();
    }

    default void saveGame(GameState gameState) throws ConfigurationException {
        saveOne(gameState);
    }
}
