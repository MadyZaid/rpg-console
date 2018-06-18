package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;

import java.io.Serializable;

public class GameState implements Serializable {
    private static final long serialVersionUID = 5346203254032368981L;

    private final World world;
    private final Player player;

    public GameState(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
    }
}
