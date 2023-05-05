package ch.origaming.papercomet.modules;

import ch.origaming.papercomet.PaperComet;
import ch.origaming.papercomet.mixin.PlayerMoveC2SMixin;
import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import meteordevelopment.orbit.EventPriority;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

public class BotWalk extends Module {
    public BotWalk() {
        super(PaperComet.CATEGORY, "Bot Walk", "Round your coordinates packet and doesn't trigger human movement detection");
    }

    @EventHandler(priority = EventPriority.HIGHEST + 1)
    private void onSendPacket(PacketEvent.Send event) {
        if (event.packet instanceof PlayerMoveC2SPacket packet) {
            double pX = packet.getX(mc.player.getX());
            double pZ = packet.getZ(mc.player.getZ());
            double pY = packet.getY(mc.player.getY());

            double currentX = (double) Math.round(pX * 100) / 100;
            double currentZ = (double) Math.round(pZ * 100) / 100;

            ((PlayerMoveC2SMixin) packet).setX(currentX);
            ((PlayerMoveC2SMixin) packet).setZ(currentZ);
        }
    }
}
