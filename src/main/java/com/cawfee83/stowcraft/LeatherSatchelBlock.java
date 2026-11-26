package com.cawfee83.stowcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class LeatherSatchelBlock extends StowcraftContainerBlock {
    public LeatherSatchelBlock(BlockBehaviour.Properties properties) { super(properties); }
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LeatherSatchelBlockEntity(pos, state);
    }
    @Override protected BlockEntityType<? extends StowcraftContainerBlockEntity> containerType() {
        return Stowcraft.LEATHER_SATCHEL_ENTITY.get();
    }
    @Override public net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST, WEST -> Block.box(0, 0, 0.9, 16, 15, 15.1);
            default -> Block.box(0.9, 0, 0, 15.1, 15, 16);
        };
    }
}
