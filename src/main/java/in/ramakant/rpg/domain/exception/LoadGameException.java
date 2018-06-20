package in.ramakant.rpg.domain.exception;

import in.ramakant.rpg.common.exceptions.ConfigurationException;

import static in.ramakant.rpg.common.utils.ColorFormatter.bold;
import static in.ramakant.rpg.common.utils.ColorFormatter.red;

public class LoadGameException extends ConfigurationException {
    private static final long serialVersionUID = -6138854057620055792L;

    public LoadGameException(Throwable cause) {
        super(bold(red("Failed to load game, please start a new one")), cause);
    }
}