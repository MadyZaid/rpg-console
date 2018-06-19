package in.ramakant.rpg;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import org.junit.Test;

import java.io.IOException;

public class ApplicationTest {

    private ApplicationRunner applicationRunner = new ApplicationRunner();

    public ApplicationTest() throws IOException {
    }

    @Test
    public void applicationAsksForUserMoveAndThenMakesOwnMove() throws InterruptedException, ConfigurationException {
        applicationRunner.startGame();
        applicationRunner.hasDisplayed("\u001B[1m\u001B[35m\n" +
                "Welcome to the Dungeons!\u001B[0m\u001B[0m\n" +
                "\n" +
                "Select an option below:\n" +
                "\t1: Start the game\n" +
                "\t2: Load last saved game\n" +
                "\t3: Leave the game\n");
    }
}