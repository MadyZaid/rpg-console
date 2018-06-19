package in.ramakant.rpg;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import org.junit.Test;

import java.io.IOException;

public class ApplicationTest {

    private ApplicationRunner application = new ApplicationRunner();

    public ApplicationTest() throws IOException {
    }

    @Test
    public void applicationAsksForUserMoveAndThenMakesOwnMove() throws InterruptedException, ConfigurationException
    {
        application.startGame();
        application.hasDisplayed("\u001B[1m\u001B[35m\n" +
                "Welcome to my simple role play game\u001B[0m\u001B[0m\n" +
                "\n" +
                "Please choose one of those options:\n" +
                "\t1: Start the game\n" +
                "\t2: Load last saved game\n" +
                "\t3: Leave the game\n");
    }
}