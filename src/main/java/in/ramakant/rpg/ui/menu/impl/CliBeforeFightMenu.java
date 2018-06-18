package in.ramakant.rpg.ui.menu.impl;

import in.ramakant.rpg.common.utils.InputParser;
import in.ramakant.rpg.common.utils.OutputWriter;
import in.ramakant.rpg.ui.menu.BeforeFightMenu;
import in.ramakant.rpg.ui.menu.item.BeforeFightMenuItem;

public class CliBeforeFightMenu extends CliEnumMenuBase<BeforeFightMenuItem> implements BeforeFightMenu {
    public CliBeforeFightMenu(InputParser inputParser, OutputWriter outputWriter) {
        super(inputParser, outputWriter, BeforeFightMenuItem.values());
    }
}
