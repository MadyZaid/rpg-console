package in.ramakant.rpg.ui;

import in.ramakant.rpg.common.constants.StaticMessages;
import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.controller.GameController;
import in.ramakant.rpg.domain.exception.ShouldNeverHappen;
import in.ramakant.rpg.persistence.GameStateProvider;
import in.ramakant.rpg.persistence.RealmConfigurationProvider;
import in.ramakant.rpg.ui.menu.MainMenu;
import in.ramakant.rpg.ui.menu.item.MainMenuItem;

import static in.ramakant.rpg.common.utils.ColorFormatter.boldMagenta;
import static in.ramakant.rpg.ui.menu.item.MainMenuItem.EXIT;

public class MainMenuManager {
    private final RealmConfigurationProvider configurationProvider;
    private final GameStateProvider gameStateProvider;
    private final AllMenus allMenus;
    private final MainMenu mainMenu;

    public MainMenuManager(RealmConfigurationProvider configurationProvider, AllMenus allMenus, GameStateProvider gameStateProvider) {
        this.allMenus = allMenus;
        this.mainMenu = allMenus.mainMenu();
        this.configurationProvider = configurationProvider;
        this.gameStateProvider = gameStateProvider;
    }

    public void showMenu() throws ConfigurationException {
        MainMenuItem choice;
        do {
            mainMenu.showMessage(boldMagenta(StaticMessages.WELCOME));
            choice = mainMenu.showMenu();

            switch (choice) {
                case START:
                    GameController.newGame(gameStateProvider, allMenus, configurationProvider.load());
                    break;
                case LOAD:
                    GameController.loadGame(gameStateProvider, allMenus);
                    break;
                case EXIT:
                    mainMenu.showMessage(StaticMessages.COME_BACK);
                    break;
                default:
                    throw new ShouldNeverHappen();
            }
        } while (choice != EXIT);
    }
}
