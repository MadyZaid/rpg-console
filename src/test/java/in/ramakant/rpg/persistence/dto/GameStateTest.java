package in.ramakant.rpg.persistence.dto;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.domain.character.Player;
import in.ramakant.rpg.domain.world.World;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import static org.assertj.core.api.Java6Assertions.assertThat;

@Category(UnitTest.class)
public class GameStateTest {

    GameState gameState;
    World world;
    Player player;

    @Before
    public void dataSetup() {
        world = Mockito.mock(World.class);
        player = Mockito.mock(Player.class);
        gameState = new GameState(world, player);
    }

    @Test
    public void getWorld() {
        assertThat(gameState.getWorld()).isEqualTo(world);
    }

    @Test
    public void getPlayer() {
        assertThat(gameState.getPlayer()).isEqualTo(player);
    }
}