package in.ramakant.rpg.domain.exception;

import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;

import static in.ramakant.rpg.common.constants.StaticMessages.VICTORY;

public class Victory extends GameException {
    private static final long serialVersionUID = -2863330948749332350L;

    public Victory(String worldName, String playerName) {
        super(String.format(VICTORY, playerName, worldName));
    }

    public static void victory(World world, Player player) {
        throw new Victory(world.getName(), player.getName());
    }
}
