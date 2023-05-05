package ch.origaming.papercomet;

import ch.origaming.papercomet.commands.CommandExample;
import ch.origaming.papercomet.hud.HudExample;
import ch.origaming.papercomet.modules.*;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class PaperComet extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Paper Comet");
    public static final HudGroup HUD_GROUP = new HudGroup("Paper Comet");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Addon Template");

        // Modules

        Modules.get().add(new BotWalk());
        Modules.get().add(new Worldborder());
        Modules.get().add(new DemoScreen());
        Modules.get().add(new CancelGamemode());
        // Commands
        Commands.get().add(new CommandExample());

        // HUD
        Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "ch.origaming.papercomet";
    }
}
