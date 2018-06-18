package in.ramakant.rpg.domain.builder;

import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;

abstract class GameInfoBuilder<T extends GameInfoBuilder<T>> extends OutputBuilderBase {
    protected World world;
    protected Player player;

    public T withWorld(World world) {
        this.world = world;
        return that();
    }

    public T withPlayer(Player player) {
        this.player = player;
        return that();
    }

    protected abstract T that();

    public String build() {
        if (world == null) {
            return errorOccurred();
        }

        return buildInner();
    }

    protected String errorOccurred() {
        return "Cannot build request information, an error occurred";
    }

    //TODO: rename it to something meaningful
    protected abstract String buildInner();
}
