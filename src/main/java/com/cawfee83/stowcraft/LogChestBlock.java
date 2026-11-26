package com.cawfee83.stowcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class LogChestBlock extends StowcraftContainerBlock {
    public LogChestBlock(BlockBehaviour.Properties properties) { super(properties); }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LogChestBlockEntity(pos, state);
    }
    @Override protected BlockEntityType<? extends StowcraftContainerBlockEntity> containerType() {
        return Stowcraft.LOG_CHEST_ENTITY.get();
    }
    @Override public net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return Block.box(1, 0, 0, 15, 15, 15);
    }
}
