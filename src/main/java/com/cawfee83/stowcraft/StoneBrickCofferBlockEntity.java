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
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }
    @Override protected float soundVolume() { return 0.2F; }
    @Override protected SoundEvent openingSound() { return Stowcraft.COFFER_OPEN.get(); }
    @Override protected SoundEvent closingSound() { return Stowcraft.COFFER_CLOSE.get(); }
}
