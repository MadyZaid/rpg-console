package in.ramakant.rpg.domain.service;

import in.ramakant.rpg.common.exceptions.ConfigurationException;
import in.ramakant.rpg.common.utils.AsciiArtLoader;
import in.ramakant.rpg.domain.exception.ExplorationException;
import in.ramakant.rpg.domain.exception.ShouldNeverHappen;
import in.ramakant.rpg.domain.model.Medic;
import in.ramakant.rpg.domain.model.NPC;
import in.ramakant.rpg.domain.model.Player;
import in.ramakant.rpg.domain.world.World;
import in.ramakant.rpg.domain.world.location.Coordinates;
import in.ramakant.rpg.domain.world.location.Location;
import in.ramakant.rpg.persistence.GameStateProvider;
import in.ramakant.rpg.persistence.dto.GameState;
import in.ramakant.rpg.ui.AllMenus;
import in.ramakant.rpg.ui.menu.ExplorationMenu;
import in.ramakant.rpg.ui.menu.item.ExplorationMenuItem;

import static in.ramakant.rpg.common.constants.StaticMessages.GAME_SAVED;
import static in.ramakant.rpg.domain.builder.LegendBuilder.buildLegend;
import static in.ramakant.rpg.domain.builder.StatisticsBuilder.buildStatistics;
import static in.ramakant.rpg.domain.builder.WorldViewBuilder.buildWorldView;
import static in.ramakant.rpg.domain.exception.Victory.victory;

public class ExplorationService {
    private final GameStateProvider gameStateProvider;
    private final ExplorationMenu explorationMenu;
    private final AllMenus allMenus;
    private final World world;
    private final Player player;

    ExplorationService(GameStateProvider gameStateProvider, AllMenus allMenus, World world, Player player) {
        this.gameStateProvider = gameStateProvider;
        this.explorationMenu = allMenus.explorationMenu();
        this.allMenus = allMenus;
        this.world = world;
        this.player = player;
    }

    public void startExploring() throws ConfigurationException {
        ExplorationMenuItem choice = explorationMenu.showMenu();

        while (choice != ExplorationMenuItem.EXIT) {
            switch (choice) {
                case UP:
                    travel(player.up());
                    break;
                case DOWN:
                    travel(player.down());
                    break;
                case LEFT:
                    travel(player.left());
                    break;
                case RIGHT:
                    travel(player.right());
                    break;
                case COMMANDS:
                    explorationMenu.printAllOptions();
                    break;
                case MAP:
                    showMap();
                    break;
                case LEGEND:
                    showLegend();
                    break;
                case PLAYER:
                    explorationMenu.showMessage(player.toStringWithColors());
                    break;
                case STATS:
                    explorationMenu.showStatistics(buildStatistics(world, player));
                    break;
                case SAVE:
                    saveGame();
                    break;
                case EXIT:
                    throw new ShouldNeverHappen();
                default:
                    throw new ShouldNeverHappen();
            }

            choice = explorationMenu.selectOption();
        }
    }

    private void showMap() {
        explorationMenu.showMap(buildWorldView(world, player));
    }

    private void showLegend() {
        explorationMenu.showMessage(buildLegend());
    }

    private void travel(Coordinates coordinates) {
        try {
            Location newLocation = world.getLocation(coordinates);
            if (newLocation.isAnyoneThere()) {
                interactWithNpc(newLocation);
            } else {
                moveToEmptySpace(newLocation);
            }
        } catch (ExplorationException e) {
            explorationMenu.showMessage(e.getMessage());
        }
        showMap();
    }

    private void interactWithNpc(Location newLocation) {
        NPC npc = newLocation.getNpc();
        explorationMenu.showMessage(AsciiArtLoader.loadIfPossible(npc.getName()));
        explorationMenu.showMessage(npc.toStringWithColors());
        explorationMenu.showMessage(npc.greeting());
        if (npc.isEnemy()) {
            fight(newLocation);

            if (world.areAllEnemiesDead()) {
                victory(world, player);
            }
        } else if (npc.isMedic()) {
            player.getMedicHelp((Medic) npc);
            world.setLocation(newLocation.getCoordinates(), new Location(newLocation.getCoordinates(), npc));
        }
    }

    private void fight(Location newLocation) {
        new FightService(allMenus.fightMenu(), allMenus.beforeFightMenu(), world, player, newLocation).fight();
    }

    private void moveToEmptySpace(Location newLocation) {
        player.setCoordinates(newLocation.getCoordinates());
        explorationMenu.showMessage(newLocation.desc());
    }

    private void saveGame() throws ConfigurationException {
        gameStateProvider.saveGame(new GameState(world, player));
        explorationMenu.showMessage(GAME_SAVED);
    }
}
