package in.ramakant.rpg.domain.world;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.common.context.DependencyContainer;
import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.domain.exception.ExplorationException;
import in.ramakant.rpg.domain.world.location.Coordinates;
import in.ramakant.rpg.domain.world.location.Location;
import in.ramakant.rpg.persistence.RealmConfigurationProvider;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.catchThrowable;

@Category(UnitTest.class)
public class WorldTest {
    private World world;

    @Before
    public void dataSetup() throws ConfigurationException {
        List<RealmConfiguration> realms = DependencyContainer.resolve(RealmConfigurationProvider.class).load();
        world = new World(realms.get(0));
    }

    @Test
    public void World_randomCoordinatesWithoutAnyone() {
        Coordinates coordinates = world.randomCoordinatesWithoutAnyone();
        assertThat(coordinates).isNotNull();
        assertThat(coordinates.getX()).isBetween(0, world.getMap().length);
        assertThat(coordinates.getY()).isBetween(0, world.getMap().length);
    }

    @Test
    public void World_getLocation() throws ExplorationException {
        Location location = world.getLocation(world.randomCoordinatesWithoutAnyone());
        assertThat(location).isNotNull();
    }

    @Test
    public void World_getLocation_ThrowExplorationException() throws ExplorationException {
        Throwable thrown = catchThrowable(() ->
                world.getLocation(new Coordinates(50, 50))
        );
        assertThat(thrown).isInstanceOf(ExplorationException.class);
    }

    @Test
    public void World_setLocation() {
        world.setLocation(world.randomCoordinatesWithoutAnyone(), new Location(world.randomCoordinatesWithoutAnyone()));
    }

    @Test
    public void World_areAllEnemiesDead() {
        assertThat(world.areAllEnemiesDead()).isFalse();
    }

    @Test
    public void World_aliveEnemiesLeft() {
        assertThat(world.aliveEnemiesCount()).isGreaterThan(0);
    }

    @Test
    public void World_getName() {
        assertThat(world.getName()).isEqualTo("Game Of Thrones");
    }

    @Test
    public void World_getMap() {
        assertThat(world.getMap()).isNotNull();
    }

    @Test
    public void World_getEnemies() {
        assertThat(world.getEnemies().size()).isGreaterThan(0);
    }

    @Test
    public void World_toString() {
        assertThat(world.toString()).isEqualTo("[name=Game Of Thrones,mapSize=9]");
    }
}