package com.cawfee83.stowcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public final class FortressChestBlock extends StowcraftContainerBlock {
    public FortressChestBlock(BlockBehaviour.Properties properties) { super(properties); }

    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FortressChestBlockEntity(pos, state);
    }

    @Override protected BlockEntityType<? extends StowcraftContainerBlockEntity> containerType() {
        return Stowcraft.FORTRESS_CHEST_ENTITY.get();
    }

    @Override public net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState state,
            net.minecraft.world.level.BlockGetter level, BlockPos pos,
            net.minecraft.world.phys.shapes.CollisionContext context) {
        return Block.box(0.05, 0, 0.05, 15.95, 15.95, 15.95);
    }

    @Override public float getDestroyProgress(BlockState state,
            net.minecraft.world.entity.player.Player player,
            net.minecraft.world.level.BlockGetter level, BlockPos pos) {
        if (!player.isCreative() && !player.hasCorrectToolForDrops(state)) return 0F;
        return super.getDestroyProgress(state, player, level, pos);
    }
}
