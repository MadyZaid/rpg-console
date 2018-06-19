package in.ramakant.rpg;

import in.ramakant.rpg.common.constants.StaticMessages;
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
                String msg = StaticMessages.CONFIG_ERROR;
                shutdown(msg, e);
            }
        } catch (Throwable t) {
            String msg = StaticMessages.UNEXPECTED_ERROR;
            shutdown(msg, t);
        }
    }

    private void shutdown(String msg, Throwable e) {
        System.out.println(msg);
        System.exit(1);
    }
}
