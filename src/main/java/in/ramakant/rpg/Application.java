package in.ramakant.rpg;

import in.ramakant.rpg.common.context.DependencyContainer;
import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.common.exceptions.UserInputParseException;
import in.ramakant.rpg.ui.MainMenuManager;

public class Application {
    private MainMenuManager mainMenuManager = DependencyContainer.resolve(MainMenuManager.class);

    public void startGame() {
        try {
            mainMenuManager.showMenu();
        } catch (UserInputParseException e) {
            shutdown(e.getMessage(), e);
        } catch (ConfigurationException e) {
            if (e.getMessage() != null) {
                shutdown(e.getMessage(), e);
            } else {
                String msg = "There was a problem with the configuration. Please check the configurations.";
                shutdown(msg, e);
            }
        } catch (Throwable t) {
            String msg = "There was a unexpected problem. Please try again.";
            shutdown(msg, t);
        }
    }

    private void shutdown(String msg, Throwable e) {
        System.out.println(msg);
        System.exit(1);
    }
}
