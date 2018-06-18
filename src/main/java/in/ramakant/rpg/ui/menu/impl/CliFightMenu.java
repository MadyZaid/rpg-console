package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.ui.menu.FightMenu;
import in.ramakant.rpg.ui.menu.item.FightMenuItem;

public class CliFightMenu extends CliEnumMenuBase<FightMenuItem> implements FightMenu {
    public CliFightMenu(InputParser inputParser, OutputWriter outputWriter) {
        super(inputParser, outputWriter, FightMenuItem.values());
    }
}
