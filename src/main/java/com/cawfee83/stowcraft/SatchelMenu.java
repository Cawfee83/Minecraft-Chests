package com.cawfee83.stowcraft;
import net.minecraft.world.inventory.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.SimpleContainer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
public class SatchelMenu extends ChestMenu {
    public final BlockPos pos;
    public SatchelMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, new SimpleContainer(27), buf.readBlockPos());
    }
    public SatchelMenu(int id, Inventory inv, net.minecraft.world.Container container, BlockPos pos) {
        this(Stowcraft.SATCHEL_MENU.get(), id, inv, container, pos);
    }
    protected SatchelMenu(MenuType<?> type, int id, Inventory inv, net.minecraft.world.Container container, BlockPos pos) {
        super(type, id, inv, container, 3);
        this.pos = pos;
    }
}
