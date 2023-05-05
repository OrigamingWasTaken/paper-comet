package ch.origaming.papercomet.modules;

import ch.origaming.papercomet.PaperComet;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.*;

public class DemoScreen extends Module {
    public DemoScreen() {
        super(PaperComet.CATEGORY, "Demo Screen", "Let you disable the demo screen");
    }

    @EventHandler
    void onReceivedPacket(PacketEvent.Receive event) {
        if (event.packet instanceof GameStateChangeS2CPacket packet) {
            if (packet.getReason() == new GameStateChangeS2CPacket.Reason(5)) {
                event.cancel();
            }
        }
    }
}
