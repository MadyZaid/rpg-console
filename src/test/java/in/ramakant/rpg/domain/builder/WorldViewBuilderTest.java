package in.ramakant.rpg.domain.builder;

import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;
import in.ramakant.rpg.domain.world.location.Coordinates;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WorldViewBuilderTest extends WorldViewBuilder {

    @Test
    public void WorldViewBuilder_builder_ReturnWorldViewBuilder() {
        WorldViewBuilder builder = WorldViewBuilder.builder();
        assertThat(builder).isNotNull();
    }

    @Test
    public void WorldViewBuilder_buildWorldView_WithOnlyWorld_ReturnsString() {
        String result = WorldViewBuilder.buildWorldView(new World(new RealmConfiguration("test", 4, new ArrayList<>(), new ArrayList<>())));
        assertThat(result).isNotBlank();
    }

    @Test
    public void WorldViewBuilder_buildWorldView_WithWorldAndPlayer_ReturnString() {
        String result = WorldViewBuilder.buildWorldView(
                new World(new RealmConfiguration("test", 4, new ArrayList<>(), new ArrayList<>())),
                new Player("test", "test player", 100, 10, 5, new Coordinates(1, 1)));
        assertThat(result).isNotBlank();
    }

    @Test
    public void WorldViewBuilder_that_ReturnThis() {
        WorldViewBuilder worldViewBuilder = new WorldViewBuilder();
        assertThat(worldViewBuilder.that()).isEqualTo(worldViewBuilder);
    }

    @Test
    public void WorldViewBuilder_buildInner_ReturnsMapView() {
        WorldViewBuilder worldViewBuilder = new WorldViewBuilder();
        assertThat(worldViewBuilder.that()).isEqualTo(worldViewBuilder);
    }
}