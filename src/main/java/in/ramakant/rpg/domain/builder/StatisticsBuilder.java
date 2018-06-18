package in.ramakant.rpg.domain.builder;

import in.ramakant.rpg.common.utils.ToStringBuilder;
import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;

public class StatisticsBuilder extends GameInfoBuilder<StatisticsBuilder> {
    public static String buildStatistics(World world, Player player) {
        return statistics().withWorld(world).withPlayer(player).build();
    }

    public static StatisticsBuilder statistics() {
        return new StatisticsBuilder();
    }

    @Override
    protected StatisticsBuilder that() {
        return this;
    }

    @Override
    protected String buildInner() {
        return ToStringBuilder.fieldsWithNewlinesAndTabs(this)
                .append("enemies left", world.aliveEnemiesLeft() + "/" + world.getEnemies().size())
                .append("", player.toStringWithColors())
                .build();
    }
}
