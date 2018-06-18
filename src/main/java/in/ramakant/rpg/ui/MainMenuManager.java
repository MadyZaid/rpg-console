package in.ramakant.rpg.ui;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.domain.exception.ShouldNeverHappen;
import in.ramakant.rpg.domain.service.GameService;
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
            mainMenu.showMessage(boldMagenta("\nWelcome to my simple role play game"));
            choice = mainMenu.showMenu();

            switch (choice) {
                case START:
                    GameService.newGame(gameStateProvider, allMenus, configurationProvider.load());
                    break;
                case LOAD:
                    GameService.loadGame(gameStateProvider, allMenus);
                    break;
                case EXIT:
                    mainMenu.showMessage("Come back soon! :)");
                    break;
                default:
                    throw new ShouldNeverHappen();
            }
        } while (choice != EXIT);
    }
}
