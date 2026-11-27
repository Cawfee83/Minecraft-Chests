package com.cawfee83.stowcraft;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

/** Shares inventory, openers, label synchronization and lid animation with all Stowcraft containers. */
public final class MineralChestBlockEntity extends StowcraftContainerBlockEntity {
    public static final int GLOW_EVENT = 2;
    private float glow = 0.0F;
    private int holdGlowTicks = 0;

    public MineralChestBlockEntity(BlockPos pos, BlockState state) {
        super(Stowcraft.MINERAL_CHEST_ENTITY.get(), pos, state);
    }

    public String variant() {
        return ForgeRegistries.BLOCKS.getKey(getBlockState().getBlock()).getPath();
    }

    public boolean isLapis() {
        return variant().equals("lapis_chest");
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.stowcraft." + variant());
    }

    @Override
    protected SoundEvent openingSound() {
        return SoundEvents.CHEST_OPEN;
    }

    @Override
    protected SoundEvent closingSound() {
        return SoundEvents.CHEST_CLOSE;
    }

    @Override
    public boolean triggerEvent(int id, int value) {
        if (id == GLOW_EVENT) {
            glow = 1.0F;
            holdGlowTicks = 20;
            return true;
        }
        return super.triggerEvent(id, value);
    }

    public float glowStrength() {
        return glow;
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, MineralChestBlockEntity entity) {
        StowcraftContainerBlockEntity.clientTick(level, pos, state, entity);
        if (entity.getOpenNess(0.0F) > 0.01F) {
            entity.glow = 1.0F;
            entity.holdGlowTicks = 12;
        } else if (entity.holdGlowTicks > 0) {
            entity.holdGlowTicks--;
        } else {
            entity.glow *= 0.88F;
            if (entity.glow < 0.005F) entity.glow = 0.0F;
        }

        if (entity.glow > 0.25F && level.random.nextInt(entity.isLapis() ? 9 : 12) == 0) {
            double x = pos.getX() + 0.15D + level.random.nextDouble() * 0.70D;
            double y = pos.getY() + 0.2D + level.random.nextDouble() * 0.65D;
            double z = pos.getZ() + 0.15D + level.random.nextDouble() * 0.70D;
            if (entity.isLapis()) {
                level.addParticle(ParticleTypes.ENCHANT, x, y, z, 0, 0.05D, 0);
            } else {
                level.addParticle(DustParticleOptions.REDSTONE, x, y, z, 0, 0.012D, 0);
            }
        }
    }
}
