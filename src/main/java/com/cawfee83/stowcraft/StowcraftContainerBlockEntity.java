package com.cawfee83.stowcraft;

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

public abstract class StowcraftContainerBlockEntity
        extends RandomizableContainerBlockEntity {

    private final net.minecraft.world.level.block.entity.ChestLidController lid = new net.minecraft.world.level.block.entity.ChestLidController();
    private final net.minecraft.world.level.block.entity.ContainerOpenersCounter openers = new net.minecraft.world.level.block.entity.ContainerOpenersCounter() {
        protected void onOpen(net.minecraft.world.level.Level level, BlockPos pos, BlockState state) {
            if (!soundsFollowLid()) level.playSound(null, pos, openingSound(), net.minecraft.sounds.SoundSource.BLOCKS, soundVolume(), soundPitch(level));
        }
        protected void onClose(net.minecraft.world.level.Level level, BlockPos pos, BlockState state) {
            if (!soundsFollowLid()) level.playSound(null, pos, closingSound(), net.minecraft.sounds.SoundSource.BLOCKS, closingSoundVolume(), soundPitch(level));
        }
        protected void openerCountChanged(net.minecraft.world.level.Level level, BlockPos pos, BlockState state, int oldCount, int newCount) {
            level.blockEvent(pos, state.getBlock(), 1, newCount);
        }
        protected boolean isOwnContainer(net.minecraft.world.entity.player.Player player) {
            return player.containerMenu instanceof ChestMenu menu && menu.getContainer() == StowcraftContainerBlockEntity.this;
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

    public static void clientTick(net.minecraft.world.level.Level level, BlockPos pos, BlockState state, StowcraftContainerBlockEntity entity) {
        float before = entity.lid.getOpenness(1F);
        entity.lid.tickLid();
        float after = entity.lid.getOpenness(1F);
        if (entity.soundsFollowLid()) {
            if (before == 0F && after > 0F)
                level.playLocalSound(pos.getX()+.5, pos.getY()+.5, pos.getZ()+.5, entity.openingSound(), net.minecraft.sounds.SoundSource.BLOCKS, entity.soundVolume(), 1.35F, false);
            else if (before > 0F && after == 0F)
                level.playLocalSound(pos.getX()+.5, pos.getY()+.5, pos.getZ()+.5, entity.closingSound(), net.minecraft.sounds.SoundSource.BLOCKS, entity.closingSoundVolume(), 1.15F, false);
        }
    }

    public float getOpenNess(float partialTick) { return lid.getOpenness(partialTick); }

    private NonNullList<ItemStack> items =
            NonNullList.withSize(27, ItemStack.EMPTY);

    protected StowcraftContainerBlockEntity(net.minecraft.world.level.block.entity.BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    protected float soundPitch(net.minecraft.world.level.Level level) { return 0.95F + level.random.nextFloat() * 0.1F; }
    protected boolean soundsFollowLid() { return false; }
    protected float soundVolume() { return 0.3F; }
    protected float closingSoundVolume() { return soundVolume(); }
    protected abstract net.minecraft.sounds.SoundEvent openingSound();
    protected abstract net.minecraft.sounds.SoundEvent closingSound();

    @Override
    public int getContainerSize() {
        return 27;
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
        return new SatchelMenu(id, inventory, this, worldPosition);
    }

    private String label = "";
    public String getLabel() { return label; }
    public void setLabel(String value) {
        label = value;
        setChanged();
        if (level != null && !level.isClientSide) level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
    }
    @Override public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        tag.putString("SatchelLabel", label);
        return tag;
    }
    @Override public void handleUpdateTag(CompoundTag tag) { label = tag.getString("SatchelLabel"); }
    @Override public net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket getUpdatePacket() {
        return net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket.create(this);
    }
    @Override public void onDataPacket(net.minecraft.network.Connection connection, net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket packet) {
        if (packet.getTag() != null) handleUpdateTag(packet.getTag());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        label = tag.getString("SatchelLabel");

        items = NonNullList.withSize(27, ItemStack.EMPTY);

        if (!tryLoadLootTable(tag)) {
            ContainerHelper.loadAllItems(tag, items);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("SatchelLabel", label);

        if (!trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, items);
        }
    }
}