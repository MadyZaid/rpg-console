package in.ramakant.rpg.domain.character;

import in.ramakant.rpg.UnitTest;
import in.ramakant.rpg.domain.character.Enemy;
import in.ramakant.rpg.domain.world.location.LocationType;
import in.ramakant.rpg.persistence.dto.EnemyConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import static org.assertj.core.api.Java6Assertions.assertThat;


@Category(UnitTest.class)
public class NPCTest {

    private Enemy enemy;

    @Before
    public void dataSetup(){
        enemy = new Enemy(Mockito.mock(EnemyConfiguration.class));
    }

    @Test
    public void NPC_locationType_When_isDead() {
        enemy.die();
        assertThat(enemy.locationType()).isEqualTo(LocationType.NPC_DEAD);
    }
}