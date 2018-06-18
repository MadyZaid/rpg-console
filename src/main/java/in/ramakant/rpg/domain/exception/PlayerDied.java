package in.ramakant.rpg.domain.exception;

import static in.ramakant.rpg.common.constants.StaticMessages.DEFEAT;

public class PlayerDied extends GameException {
    private static final long serialVersionUID = 2128051029469994583L;

    public PlayerDied() {
        super(DEFEAT);
    }
}
