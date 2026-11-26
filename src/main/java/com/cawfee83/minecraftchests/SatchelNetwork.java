package com.cawfee83.minecraftchests;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.*;
import net.minecraft.network.FriendlyByteBuf;
import java.util.function.Supplier;
public class SatchelNetwork {
    public static final net.minecraftforge.network.simple.SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(MinecraftChests.MODID,"labels"), () -> "1", "1"::equals, "1"::equals);
    public static void init() {
        CHANNEL.registerMessage(0, Rename.class, (m,b)->{b.writeVarInt(m.id());b.writeUtf(m.label(),24);}, b->new Rename(b.readVarInt(),b.readUtf(24)), SatchelNetwork::handle, java.util.Optional.of(NetworkDirection.PLAY_TO_SERVER));
    }
    public record Rename(int id,String label) {}
    private static void handle(Rename msg,Supplier<NetworkEvent.Context> supplier) {
        var ctx=supplier.get();
        ctx.enqueueWork(()->{
            var player=ctx.getSender();
            if(player!=null && player.containerMenu instanceof SatchelMenu menu && menu.containerId==msg.id() && menu.stillValid(player) && menu.getContainer() instanceof LeatherSatchelBlockEntity satchel) {
                satchel.setLabel(net.minecraft.SharedConstants.filterText(msg.label()).trim());
            }
        });
        ctx.setPacketHandled(true);
    }
}
