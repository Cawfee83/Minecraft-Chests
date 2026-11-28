package com.cawfee83.stowcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.BlockState;

public final class FortressChestBlockEntity extends StowcraftContainerBlockEntity {
    public FortressChestBlockEntity(BlockPos pos, BlockState state) {
        super(Stowcraft.FORTRESS_CHEST_ENTITY.get(), pos, state);
    }

    @Override protected Component getDefaultName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    @Override protected float soundPitch(net.minecraft.world.level.Level level) { return 0.6F; }
    @Override protected float soundVolume() { return 1.0F; }
    @Override protected SoundEvent openingSound() { return SoundEvents.IRON_DOOR_OPEN; }
    @Override protected SoundEvent closingSound() { return SoundEvents.IRON_DOOR_CLOSE; }
}
