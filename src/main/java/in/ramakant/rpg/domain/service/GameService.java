package in.ramakant.rpg.domain.service;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.domain.exception.LoadGameException;
import in.ramakant.rpg.domain.exception.PlayerDied;
import in.ramakant.rpg.domain.exception.Victory;
import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;
import in.ramakant.rpg.persistence.GameStateProvider;
import in.ramakant.rpg.persistence.dto.GameState;
import in.ramakant.rpg.persistence.dto.PlayerConfiguration;
import in.ramakant.rpg.persistence.dto.RealmConfiguration;
import in.ramakant.rpg.ui.AllMenus;
import in.ramakant.rpg.ui.menu.MainMenu;
import in.ramakant.rpg.ui.menu.PlayerConfigurationMenu;
import in.ramakant.rpg.ui.menu.WorldConfigurationMenu;

import java.util.List;

import static in.ramakant.rpg.common.constants.StaticMessages.*;
import static in.ramakant.rpg.domain.builder.WorldViewBuilder.buildWorldView;

public class GameService {

    private final GameStateProvider gameStateProvider;
    private final AllMenus allMenus;

    private final World world;
    private final Player player;

    private GameService(GameStateProvider gameStateProvider, AllMenus allMenus, List<RealmConfiguration> realmConfig) throws ConfigurationException {
        this.gameStateProvider = gameStateProvider;
        this.allMenus = allMenus;

        this.world = initWorld(realmConfig);
        this.player = initPlayer();
    }

    public GameService(GameStateProvider gameStateProvider, AllMenus allMenus) throws ConfigurationException {
        this.gameStateProvider = gameStateProvider;
        this.allMenus = allMenus;

        GameState loadedGame = gameStateProvider.loadGame();
        this.world = loadedGame.getWorld();
        this.player = loadedGame.getPlayer();

        allMenus.explorationMenu().showMessage(GAME_LOADED);
        allMenus.explorationMenu().showMap(buildWorldView(world, player));
    }

    public static void newGame(GameStateProvider gameStateProvider, AllMenus allMenus, List<RealmConfiguration> realmConfig) throws ConfigurationException {
        GameService gameManager = new GameService(gameStateProvider, allMenus, realmConfig);
        gameManager.startGame();
    }

    public static void loadGame(GameStateProvider gameStateProvider, AllMenus allMenus) throws ConfigurationException {
        try {
            GameService gameManager = new GameService(gameStateProvider, allMenus);
            gameManager.startGame();
        } catch (LoadGameException e) {
            allMenus.mainMenu().showMessage(e.getMessage());
        }

    }

    private World initWorld(List<RealmConfiguration> realmConfigs) throws ConfigurationException {
        WorldConfigurationMenu worldConfigMenu = allMenus.worldConfigMenu();

        RealmConfiguration realmConfig = worldConfigMenu.chooseConfiguration(REALM_QUESTION, realmConfigs);

        World world = new World(realmConfig);
        worldConfigMenu.confirmRealmConfiguration(realmConfigDone(world));

        return world;
    }

    private Player initPlayer() {
        PlayerConfigurationMenu playerConfigMenu = allMenus.playerConfigMenu();

        playerConfigMenu.showIntroduction(INTRODUCTION);
        PlayerConfiguration playerConfig = playerConfigMenu.askForPlayerConfig(questionsToPlayer());

        Player player = new Player(playerConfig, world.randomCoordinatesWithoutAnyone());
        playerConfigMenu.greetPlayer(greeting(player, world));

        return player;
    }

    void startGame() throws ConfigurationException {
        MainMenu mainMenu = allMenus.mainMenu();

        ExplorationService explorationManager = new ExplorationService(gameStateProvider, allMenus, world, player);
        try {
            explorationManager.startExploring();
        } catch (Victory | PlayerDied e) {
            mainMenu.showMessage(e.getMessage());
        }
    }
}
