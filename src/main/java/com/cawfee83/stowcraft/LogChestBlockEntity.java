package com.cawfee83.stowcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
public class LogChestBlockEntity extends StowcraftContainerBlockEntity {
 public LogChestBlockEntity(BlockPos pos, BlockState state){super(Stowcraft.LOG_CHEST_ENTITY.get(),pos,state);}
 public String variant(){return ForgeRegistries.BLOCKS.getKey(getBlockState().getBlock()).getPath();}
 @Override protected Component getDefaultName(){return Component.translatable("block.stowcraft."+variant());}
 @Override protected SoundEvent openingSound(){return SoundEvents.CHEST_OPEN;}
 @Override protected SoundEvent closingSound(){return SoundEvents.CHEST_CLOSE;}
}