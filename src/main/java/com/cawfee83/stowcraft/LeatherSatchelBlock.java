
package com.cawfee83.stowcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;

public class LeatherSatchelBlock extends BaseEntityBlock {

    public static final DirectionProperty FACING =
            BlockStateProperties.HORIZONTAL_FACING;

    public LeatherSatchelBlock(BlockBehaviour.Properties properties) {
        super(properties);

        registerDefaultState(stateDefinition.any()
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(
                FACING,
                context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LeatherSatchelBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> net.minecraft.world.level.block.entity.BlockEntityTicker<T> getTicker(Level level, BlockState state, net.minecraft.world.level.block.entity.BlockEntityType<T> type) {
        return level.isClientSide ? createTickerHelper(type, Stowcraft.LEATHER_SATCHEL_ENTITY.get(), LeatherSatchelBlockEntity::clientTick) : null;
    }

    @Override
    public void tick(BlockState state, net.minecraft.server.level.ServerLevel level, BlockPos pos, net.minecraft.util.RandomSource random) {
        if (level.getBlockEntity(pos) instanceof LeatherSatchelBlockEntity satchel) satchel.recheckOpen();
    }

    @Override
    public net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState state, net.minecraft.world.level.BlockGetter level, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST, WEST -> Block.box(0, 0, 0.9, 16, 15, 15.1);
            default -> Block.box(0.9, 0, 0, 15.1, 15, 16);
        };
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public InteractionResult use(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit) {

        if (!level.isClientSide) {
            if (level.getBlockEntity(pos)
                    instanceof LeatherSatchelBlockEntity satchel) {
                if (player instanceof net.minecraft.server.level.ServerPlayer serverPlayer) net.minecraftforge.network.NetworkHooks.openScreen(serverPlayer, satchel, pos);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void onRemove(
            BlockState state,
            Level level,
            BlockPos pos,
            BlockState newState,
            boolean moving) {

        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos)
                    instanceof LeatherSatchelBlockEntity satchel) {

                Containers.dropContents(level, pos, satchel);
                level.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, level, pos, newState, moving);
        }
    }
}
