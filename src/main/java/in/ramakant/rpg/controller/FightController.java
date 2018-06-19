package in.ramakant.rpg.controller;

import in.ramakant.rpg.domain.character.Character;
import in.ramakant.rpg.domain.character.NPC;
import in.ramakant.rpg.domain.character.Player;
import in.ramakant.rpg.domain.exception.ShouldNeverHappen;
import in.ramakant.rpg.domain.world.World;
import in.ramakant.rpg.domain.world.location.Coordinates;
import in.ramakant.rpg.domain.world.location.Location;
import in.ramakant.rpg.ui.menu.BeforeFightMenu;
import in.ramakant.rpg.ui.menu.FightMenu;
import in.ramakant.rpg.ui.menu.item.BeforeFightMenuItem;
import in.ramakant.rpg.ui.menu.item.FightMenuItem;

import static in.ramakant.rpg.common.constants.StaticMessages.GET_AWAY_FROM_THE_FIGHT;
import static in.ramakant.rpg.common.utils.ColorFormatter.red;
import static in.ramakant.rpg.common.utils.ColorFormatter.yellow;
import static in.ramakant.rpg.ui.menu.item.FightMenuItem.FLEE;

public class FightController {
    private static final String ATTACK_MESSAGE = "%s attacked for %s damage.";

    private final FightMenu fightMenu;
    private final BeforeFightMenu beforeFightMenu;
    private final World world;
    private final Player player;
    private final Coordinates newCoordinates;
    private final NPC npc;

    FightController(FightMenu fightMenu, BeforeFightMenu beforeFightMenu, World world, Player player, Location fightLocation) {
        this.fightMenu = fightMenu;
        this.beforeFightMenu = beforeFightMenu;
        this.world = world;
        this.player = player;
        this.newCoordinates = fightLocation.getCoordinates();
        this.npc = fightLocation.getNpc();
    }

    public void fight() {
        if (isPlayerWantsToFight()) {
            startTheFight();
        } else {
            beforeFightMenu.showMessage(GET_AWAY_FROM_THE_FIGHT);
        }
    }

    private void startTheFight() {
        FightMenuItem fightMenuItem = fightMenu.showMenu();
        do {
            switch (fightMenuItem) {
                case ATTACK:
                    attack(player, npc);
                    if (npc.isDead()) {
                        fightMenu.showMessage(player.killed(npc));
                        player.setCoordinates(newCoordinates);
                        fightMenu.showMessage(player.currentStatus());
                        world.setLocation(newCoordinates, new Location(newCoordinates, npc));
                        break;
                    }

                    attack(npc, player);
                    fightMenu.showMessage(player.currentStatus());
                    fightMenu.showMessage(npc.currentStatus());
                    break;
                case FLEE:
                    fightMenu.showMessage(player.flee());
                    break;
                default:
                    throw new ShouldNeverHappen();
            }

            if (npc.isAlive()) {
                fightMenuItem = fightMenu.showMenu();
            }

        } while (canContinueFight(npc, fightMenuItem));
    }

    private boolean isPlayerWantsToFight() {
        BeforeFightMenuItem item = beforeFightMenu.showMenu();
        switch (item) {
            case ATTACK:
                return true;
            case FALL_BACK:
                return false;
            default:
                throw new ShouldNeverHappen();
        }
    }

    private void attack(Character attacker, Character defender) {
        int damageDealt = attacker.attack(defender);
        showAttackMessage(attacker, damageDealt);
    }

    private void showAttackMessage(Character attacker, int attackedFor) {
        fightMenu.showMessage(String.format(ATTACK_MESSAGE, yellow(attacker.getClass().getSimpleName()), red(String.valueOf(attackedFor))));
    }

    private boolean canContinueFight(NPC npc, FightMenuItem fightMenuItem) {
        return npc.isAlive() && player.isAlive() && fightMenuItem != null && !FLEE.equals(fightMenuItem);
    }
}
