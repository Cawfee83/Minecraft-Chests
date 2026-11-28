package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public final class DisplayCaseRenderer implements BlockEntityRenderer<DisplayCaseBlockEntity> {
    private final DisplayCaseModel model;
    public DisplayCaseRenderer(BlockEntityRendererProvider.Context ctx) {
        model = new DisplayCaseModel(ctx.bakeLayer(DisplayCaseModel.LAYER_LOCATION));
    }
    @Override public void render(DisplayCaseBlockEntity entity, float partialTick, PoseStack pose,
                                MultiBufferSource buffer, int light, int overlay) {
        Direction facing = entity.getBlockState().getValue(DisplayCaseBlock.FACING);
        String variant = net.minecraftforge.registries.ForgeRegistries.BLOCKS
                .getKey(entity.getBlockState().getBlock()).getPath();
        ResourceLocation tex = new ResourceLocation(Stowcraft.MODID,"textures/block/" + variant + ".png");
        pose.pushPose();
        pose.translate(.5D,1.5D,.5D);
        pose.mulPose(Vector3f.YP.rotationDegrees(180F-facing.toYRot()));
        pose.scale(-1F,-1F,1F);
        model.setOpenness(entity.getOpenNess(partialTick));
        model.renderFrame(pose,buffer.getBuffer(RenderType.entityCutoutNoCull(tex)),light,overlay);
        ItemStack stack = entity.getDisplay();
        if (!stack.isEmpty()) {
            pose.pushPose();
            // Model uses top-origin Y-down units; item space is in Minecraft world coordinates.
            pose.translate(0, 1F, 0);
            pose.mulPose(Vector3f.YP.rotationDegrees(entity.renderAngle(partialTick)));
            pose.scale(.65F,.65F,.65F);
            Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemTransforms.TransformType.FIXED,
                    light,overlay,pose,buffer,0);
            pose.popPose();
        }
        model.renderGlass(pose,buffer.getBuffer(RenderType.entityTranslucent(tex)),light,overlay);
        String label = entity.getLabel();
        if (!label.isEmpty()) {
            var font = Minecraft.getInstance().font;
            int width = font.width(label);
            float scale = Math.min(.009F,.52F/Math.max(1,width));
            pose.pushPose();
            pose.translate(0,21.9F/16F,-7.56F/16F);
            pose.scale(scale,scale,scale);
            font.drawInBatch(label,-width/2F,-4F,0xfff4edd8,false,pose.last().pose(),buffer,false,0,light);
            pose.popPose();
        }
        pose.popPose();
    }
}
