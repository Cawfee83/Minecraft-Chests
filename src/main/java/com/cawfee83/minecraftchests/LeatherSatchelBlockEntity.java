package com.cawfee83.minecraftchests;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class LeatherSatchelBlockEntity
        extends RandomizableContainerBlockEntity {

    private final net.minecraft.world.level.block.entity.ChestLidController lid = new net.minecraft.world.level.block.entity.ChestLidController();
    private final net.minecraft.world.level.block.entity.ContainerOpenersCounter openers = new net.minecraft.world.level.block.entity.ContainerOpenersCounter() {
        protected void onOpen(net.minecraft.world.level.Level level, BlockPos pos, BlockState state) {
            level.playSound(null, pos, net.minecraft.sounds.SoundEvents.CHEST_OPEN, net.minecraft.sounds.SoundSource.BLOCKS, 0.5F, 1.0F);
        }
        protected void onClose(net.minecraft.world.level.Level level, BlockPos pos, BlockState state) {
            level.playSound(null, pos, net.minecraft.sounds.SoundEvents.CHEST_CLOSE, net.minecraft.sounds.SoundSource.BLOCKS, 0.5F, 1.0F);
        }
        protected void openerCountChanged(net.minecraft.world.level.Level level, BlockPos pos, BlockState state, int oldCount, int newCount) {
            level.blockEvent(pos, state.getBlock(), 1, newCount);
        }
        protected boolean isOwnContainer(net.minecraft.world.entity.player.Player player) {
            return player.containerMenu instanceof ChestMenu menu && menu.getContainer() == LeatherSatchelBlockEntity.this;
        }
    };

    @Override
    public void startOpen(net.minecraft.world.entity.player.Player player) {
        if (!remove && !player.isSpectator() && level != null && !level.isClientSide)
            openers.incrementOpeners(player, level, worldPosition, getBlockState());
    }

    @Override
    public void stopOpen(net.minecraft.world.entity.player.Player player) {
        if (!remove && !player.isSpectator() && level != null && !level.isClientSide)
            openers.decrementOpeners(player, level, worldPosition, getBlockState());
    }

    public void recheckOpen() {
        if (!remove && level != null) openers.recheckOpeners(level, worldPosition, getBlockState());
    }

    @Override
    public boolean triggerEvent(int id, int value) {
        if (id == 1) { lid.shouldBeOpen(value > 0); return true; }
        return super.triggerEvent(id, value);
    }

    public static void clientTick(net.minecraft.world.level.Level level, BlockPos pos, BlockState state, LeatherSatchelBlockEntity entity) {
        entity.lid.tickLid();
    }

    public float getOpenNess(float partialTick) { return lid.getOpenness(partialTick); }

    private NonNullList<ItemStack> items =
            NonNullList.withSize(27, ItemStack.EMPTY);

    public LeatherSatchelBlockEntity(BlockPos pos, BlockState state) {
        super(MinecraftChests.LEATHER_SATCHEL_ENTITY.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable(
                "container.minecraftchests.leather_satchel");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(
            int id, Inventory inventory) {
        return ChestMenu.threeRows(id, inventory, this);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        items = NonNullList.withSize(27, ItemStack.EMPTY);

        if (!tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, items);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        if (!trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, items);
        }
    }
}