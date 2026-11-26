package com.cawfee83.stowcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockState;

public class StoneBrickCofferBlockEntity extends StowcraftContainerBlockEntity {
    public StoneBrickCofferBlockEntity(BlockPos pos, BlockState state) {
        super(Stowcraft.STONE_BRICK_COFFER_ENTITY.get(), pos, state);
    }
    @Override protected Component getDefaultName() {
        return Component.translatable("container.stowcraft.stone_brick_coffer");
    }
    @Override protected SoundEvent openingSound() { return net.minecraft.sounds.SoundEvents.STONE_BREAK; }
    @Override protected SoundEvent closingSound() { return net.minecraft.sounds.SoundEvents.STONE_PLACE; }
}
