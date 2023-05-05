package ch.origaming.papercomet.modules;

import ch.origaming.papercomet.PaperComet;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.*;

public class Worldborder extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    private final SettingGroup sgWorldborder = settings.createGroup("Worldborder");
    public Worldborder() {
        super(PaperComet.CATEGORY, "Worldborder", "Let you disable the worldborder client-side");
    }

    @EventHandler
    void onReceivedPacket(PacketEvent.Receive event) {
        if ((event.packet instanceof WorldBorderCenterChangedS2CPacket || event.packet instanceof WorldBorderSizeChangedS2CPacket
            || event.packet instanceof WorldBorderInitializeS2CPacket
            || event.packet instanceof WorldBorderInterpolateSizeS2CPacket
            || event.packet instanceof WorldBorderWarningBlocksChangedS2CPacket)) {
            event.cancel();
        }
    }
}
