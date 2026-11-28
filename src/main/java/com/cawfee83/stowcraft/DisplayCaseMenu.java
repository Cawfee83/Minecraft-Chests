package com.cawfee83.stowcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;

/** ChestMenu is intentionally retained so the base opener counter recognizes viewers. */
public final class DisplayCaseMenu extends SatchelMenu {
    public DisplayCaseMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, new SimpleContainer(27), buf.readBlockPos());
    }
    public DisplayCaseMenu(int id, Inventory inv, Container container, BlockPos pos) {
        super(Stowcraft.DISPLAY_CASE_MENU.get(), id, inv, container, pos);
    }
}
