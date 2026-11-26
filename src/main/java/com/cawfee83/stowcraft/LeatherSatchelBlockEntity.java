package com.cawfee83.stowcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockState;

public class LeatherSatchelBlockEntity extends StowcraftContainerBlockEntity {
    public LeatherSatchelBlockEntity(BlockPos pos, BlockState state) {
        super(Stowcraft.LEATHER_SATCHEL_ENTITY.get(), pos, state);
    }
    @Override protected Component getDefaultName() {
        return Component.translatable("container.stowcraft.leather_satchel");
    }
    @Override protected SoundEvent openingSound() { return Stowcraft.SATCHEL_OPEN.get(); }
    @Override protected SoundEvent closingSound() { return Stowcraft.SATCHEL_CLOSE.get(); }
}
