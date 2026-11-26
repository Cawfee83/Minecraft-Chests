package com.cawfee83.minecraftchests;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.BlockPos;

public class LeatherSatchelItemRenderer extends BlockEntityWithoutLevelRenderer {
    public LeatherSatchelItemRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transform, PoseStack pose, MultiBufferSource buffer, int light, int overlay) {
        LeatherSatchelBlockEntity entity = new LeatherSatchelBlockEntity(BlockPos.ZERO, MinecraftChests.LEATHER_SATCHEL.get().defaultBlockState());
        Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(entity, pose, buffer, light, overlay);
    }
}
