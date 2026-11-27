package com.cawfee83.stowcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

/** Behaves as a standard Stowcraft container; the ports and lighting are cosmetic. */
public final class MineralChestBlock extends MetalChestBlock {
    public MineralChestBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MineralChestBlockEntity(pos, state);
    }

    @Override
    protected BlockEntityType<? extends StowcraftContainerBlockEntity> containerType() {
        return Stowcraft.MINERAL_CHEST_ENTITY.get();
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide
                ? createTickerHelper(type, Stowcraft.MINERAL_CHEST_ENTITY.get(), MineralChestBlockEntity::clientTick)
                : null;
    }

    private void pulse(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            level.blockEvent(pos, this, MineralChestBlockEntity.GLOW_EVENT, 0);
        }
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        super.attack(state, level, pos, player);
        pulse(level, pos);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        InteractionResult result = super.use(state, level, pos, player, hand, hit);
        pulse(level, pos);
        return result;
    }
}
