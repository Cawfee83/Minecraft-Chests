package com.cawfee83.stowcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class StoneBrickCofferBlock extends StowcraftContainerBlock {
    public StoneBrickCofferBlock(BlockBehaviour.Properties properties) { super(properties); }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StoneBrickCofferBlockEntity(pos, state);
    }
    @Override protected BlockEntityType<? extends StowcraftContainerBlockEntity> containerType() {
        return Stowcraft.STONE_BRICK_COFFER_ENTITY.get();
    }
    @Override public net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return Block.box(0.5, 0, 0.5, 15.5, 15, 15.5);
    }
}
