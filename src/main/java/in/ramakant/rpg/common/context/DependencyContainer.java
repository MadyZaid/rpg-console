package in.ramakant.rpg.common.context;

import in.ramakant.rpg.common.exceptions.DependencyException;
import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.persistence.GameStateProvider;
import in.ramakant.rpg.persistence.RealmConfigurationProvider;
import in.ramakant.rpg.persistence.impl.SerializedGameStateProvider;
import in.ramakant.rpg.persistence.impl.SerializedRealmConfigurationProvider;
import in.ramakant.rpg.ui.AllMenus;
import in.ramakant.rpg.ui.MainMenuManager;
import in.ramakant.rpg.ui.menu.*;
import in.ramakant.rpg.ui.menu.impl.*;

import java.util.HashMap;
import java.util.Map;

public class DependencyContainer {

    private static final Map<Class, Object> dependencies = new HashMap<>();

    static {
        consoleIo();
        registerRealmConfigurationProviders();
        registerGameStateProvider();
        menus();
        managers();
    }

    private DependencyContainer() {
    }

    private static void consoleIo() {
        OutputWriter outputWriter = new OutputWriter(System.out);
        register(OutputWriter.class, outputWriter);

        InputParser inputParser = new InputParser(outputWriter, System.in);
        register(InputParser.class, inputParser);
    }

    private static void registerRealmConfigurationProviders() {
        RealmConfigurationProvider realmConfigurationProvider = new SerializedRealmConfigurationProvider();
        register(RealmConfigurationProvider.class, realmConfigurationProvider);
    }

    private static void registerGameStateProvider() {
        GameStateProvider gameStateProvider = new SerializedGameStateProvider();
        register(GameStateProvider.class, gameStateProvider);
    }

    private static void menus() {
        OutputWriter outputWriter = resolve(OutputWriter.class);
        InputParser inputParser = resolve(InputParser.class);

        PlayerConfigurationMenu playerConfigurationMenu = new CliPlayerConfigurationMenu(inputParser, outputWriter);
        register(PlayerConfigurationMenu.class, playerConfigurationMenu);

        WorldConfigurationMenu worldConfigurationMenu = new CliWorldConfigurationMenu(inputParser, outputWriter);
        register(WorldConfigurationMenu.class, worldConfigurationMenu);

        MainMenu mainMenu = new CliMainMenu(inputParser, outputWriter);
        register(MainMenu.class, mainMenu);

        ExplorationMenu explorationMenu = new CliExplorationMenu(inputParser, outputWriter);
        register(ExplorationMenu.class, explorationMenu);

        FightMenu fightMenu = new CliFightMenu(inputParser, outputWriter);
        register(FightMenu.class, fightMenu);

        BeforeFightMenu beforeFightMenu = new CliBeforeFightMenu(inputParser, outputWriter);
        register(BeforeFightMenu.class, beforeFightMenu);

        AllMenus allMenus = new AllMenus(mainMenu, playerConfigurationMenu, worldConfigurationMenu, explorationMenu, beforeFightMenu, fightMenu);
        register(AllMenus.class, allMenus);
    }

    private static void managers() {
        AllMenus allMenus = resolve(AllMenus.class);
        GameStateProvider gameStateProvider = resolve(GameStateProvider.class);
        RealmConfigurationProvider realmConfigurationProvider = resolve(RealmConfigurationProvider.class);

        MainMenuManager mainMenuManager = new MainMenuManager(realmConfigurationProvider, allMenus, gameStateProvider);
        register(MainMenuManager.class, mainMenuManager);
    }

    private static void register(Class type, Object impl) {
        dependencies.put(impl.getClass(), impl);
        dependencies.put(type, impl);
    }

    public static <T> T resolve(Class<T> clazz) {
        T dependency;

        try {
            dependency = (T) dependencies.get(clazz);
        } catch (Throwable t) {
            throw new DependencyException(t);
        }

        if (dependency == null) {
            throw new DependencyException();
        }

        return dependency;
    }
}
