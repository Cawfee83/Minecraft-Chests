package com.cawfee83.stowcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class MetalChestBlock extends StowcraftContainerBlock {
    public MetalChestBlock(BlockBehaviour.Properties properties) { super(properties); }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MetalChestBlockEntity(pos, state);
    }
    @Override protected BlockEntityType<? extends StowcraftContainerBlockEntity> containerType() {
        return Stowcraft.METAL_CHEST_ENTITY.get();
    }
    @Override public net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return Block.box(0, 0, 0, 16, 16, 16);
    }
    @Override
    public float getDestroyProgress(BlockState state, net.minecraft.world.entity.player.Player player, net.minecraft.world.level.BlockGetter level, BlockPos pos) {
        if (!player.isCreative() && !player.hasCorrectToolForDrops(state)) {
            return 0.0F;
        }
        return super.getDestroyProgress(state, player, level, pos);
    }
}
