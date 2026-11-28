package com.cawfee83.stowcraft;

import java.util.function.Supplier;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraft.resources.ResourceLocation;

public final class DisplayCaseNetwork {
    private DisplayCaseNetwork() {}
    private static final String VERSION = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Stowcraft.MODID, "display_case"),
            () -> VERSION, VERSION::equals, VERSION::equals);
    // action: 0 copy, 1 clear, 2 toggle rotation, 3 rotate -15, 4 rotate +15
    public record Action(int menuId, int action) {}
    public static void init() {
        CHANNEL.registerMessage(0, Action.class,
                (m, buf) -> { buf.writeVarInt(m.menuId()); buf.writeVarInt(m.action()); },
                buf -> new Action(buf.readVarInt(), buf.readVarInt()),
                DisplayCaseNetwork::handle,
                java.util.Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }
    private static void handle(Action msg, Supplier<NetworkEvent.Context> supplier) {
        var ctx = supplier.get();
        ctx.enqueueWork(() -> {
            var player = ctx.getSender();
            if (player == null || !(player.containerMenu instanceof DisplayCaseMenu menu)
                    || menu.containerId != msg.menuId() || !menu.stillValid(player)
                    || !(menu.getContainer() instanceof DisplayCaseBlockEntity entity)) return;
            switch (msg.action()) {
                // Never accept an ItemStack from the client. Only the server-held cursor is authoritative.
                case 0 -> entity.copyFrom(menu.getCarried());
                case 1 -> entity.clearDisplay();
                case 2 -> entity.setRotating(!entity.isRotating());
                case 3 -> entity.rotateBy(-15);
                case 4 -> entity.rotateBy(15);
                case 5 -> entity.resetOrientation();
                default -> {}
            }
        });
        ctx.setPacketHandled(true);
    }
}
