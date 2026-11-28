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
        return Component.translatable("block.stowcraft.fortress_nether_brick");
    }

    // Iron trapdoors give the wrought-iron drawbridge a mechanical sound
    // without introducing a custom sound asset into this first prototype.
    @Override protected SoundEvent openingSound() { return SoundEvents.IRON_TRAPDOOR_OPEN; }
    @Override protected SoundEvent closingSound() { return SoundEvents.IRON_TRAPDOOR_CLOSE; }
}
