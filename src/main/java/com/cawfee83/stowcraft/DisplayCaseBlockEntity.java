package com.cawfee83.stowcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

/** The sample is never part of the 27 real slots or exposed to automation. */
public final class DisplayCaseBlockEntity extends StowcraftContainerBlockEntity {
    private ItemStack display = ItemStack.EMPTY;
    private boolean rotating;
    private float angle;
    private long rotationAnchor;
    private float rotationAnchorAngle;

    public DisplayCaseBlockEntity(BlockPos pos, BlockState state) {
        super(Stowcraft.DISPLAY_CASE_ENTITY.get(), pos, state);
    }

    @Override protected Component getDefaultName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }
    @Override protected SoundEvent openingSound() { return net.minecraft.sounds.SoundEvents.IRON_TRAPDOOR_OPEN; }
    @Override protected SoundEvent closingSound() { return net.minecraft.sounds.SoundEvents.IRON_TRAPDOOR_CLOSE; }
    @Override protected boolean soundsFollowLid() { return true; }
    @Override protected float soundVolume() { return 0.12F; }

    @Override protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new DisplayCaseMenu(id, inventory, this, worldPosition);
    }

    public ItemStack getDisplay() { return display.copy(); }
    public boolean isRotating() { return rotating; }
    public float getAngle() { return angle; }

    private void sync() {
        setChanged();
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    public void copyFrom(ItemStack carried) {
        if (carried.isEmpty()) return;
        display = carried.copy();
        display.setCount(1);
        sync();
    }
    public void clearDisplay() {
        display = ItemStack.EMPTY;
        sync();
    }
    private float currentAngle(double time) {
        if (!rotating) return angle;
        return (float)((rotationAnchorAngle + (time - rotationAnchor) * 360.0 / 600.0) % 360.0);
    }
    public float renderAngle(float partialTick) {
        if (level == null) return angle;
        return currentAngle(level.getGameTime() + partialTick);
    }
    public void setRotating(boolean newValue) {
        if (level == null || rotating == newValue) return;
        // Keep the manually selected resting orientation independent of spin phase.
        rotating = newValue;
        rotationAnchor = level.getGameTime();
        rotationAnchorAngle = angle;
        sync();
    }
    public void rotateBy(int degrees) {
        if (level == null) return;
        float phase = currentAngle(level.getGameTime());
        angle = (angle + degrees + 360.0F) % 360.0F;
        rotationAnchor = level.getGameTime();
        rotationAnchorAngle = rotating ? (phase + degrees + 360.0F) % 360.0F : angle;
        sync();
    }

    private void readDisplay(CompoundTag tag) {
        display = tag.contains("DisplayItem", 10) ? ItemStack.of(tag.getCompound("DisplayItem")) : ItemStack.EMPTY;
        if (!display.isEmpty()) display.setCount(1);
        rotating = tag.getBoolean("DisplayRotating");
        angle = ((tag.getFloat("DisplayAngle") % 360.0F) + 360.0F) % 360.0F;
        rotationAnchorAngle = tag.contains("DisplaySpinAngle") ? tag.getFloat("DisplaySpinAngle") : angle;
        rotationAnchor = tag.contains("DisplaySpinAnchor") ? tag.getLong("DisplaySpinAnchor") : (level == null ? 0L : level.getGameTime());
    }
    private void writeDisplay(CompoundTag tag) {
        // Persist the resting orientation separately from the running spin phase.
        tag.putBoolean("DisplayRotating", rotating);
        tag.putFloat("DisplayAngle", angle);
        tag.putFloat("DisplaySpinAngle", rotationAnchorAngle);
        tag.putLong("DisplaySpinAnchor", rotationAnchor);
        if (!display.isEmpty()) tag.put("DisplayItem", display.save(new CompoundTag()));
    }
    @Override public void load(CompoundTag tag) {
        super.load(tag);
        readDisplay(tag);
    }
    @Override protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        writeDisplay(tag);
    }
    @Override public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        writeDisplay(tag);
        return tag;
    }
    @Override public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        readDisplay(tag);
    }
}
