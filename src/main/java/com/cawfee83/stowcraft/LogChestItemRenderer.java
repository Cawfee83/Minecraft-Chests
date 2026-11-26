package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.BlockPos;

public class LogChestItemRenderer extends BlockEntityWithoutLevelRenderer {
    public LogChestItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transform, PoseStack pose, MultiBufferSource buffer, int light, int overlay) {
        LogChestBlockEntity entity = new LogChestBlockEntity(BlockPos.ZERO, ((net.minecraft.world.item.BlockItem)stack.getItem()).getBlock().defaultBlockState());
        Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(entity, pose, buffer, light, overlay);
    }
}
