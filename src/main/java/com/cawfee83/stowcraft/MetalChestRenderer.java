
package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class MetalChestRenderer
        implements BlockEntityRenderer<MetalChestBlockEntity> {

    
    private final MetalChestModel model;

    public MetalChestRenderer(
            BlockEntityRendererProvider.Context context) {

        model = new MetalChestModel(
                context.bakeLayer(MetalChestModel.LAYER_LOCATION));
    }

    @Override
    public void render(
            MetalChestBlockEntity satchel,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            int packedOverlay) {

        Direction facing = satchel.getBlockState()
                .getValue(MetalChestBlock.FACING);

        poseStack.pushPose();

        poseStack.translate(0.5, 1.5, 0.5);

        poseStack.mulPose(Vector3f.YP.rotationDegrees(
                180.0F - facing.toYRot()));

        poseStack.scale(-1.0F, -1.0F, 1.0F);

        float openness = satchel.getOpenNess(partialTick);
        model.setOpenness(openness);

        model.render(
                poseStack,
                buffer.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(Stowcraft.MODID, "textures/block/" + satchel.variant() + ".png"))),
                packedLight,
                packedOverlay);

        String label = satchel.getLabel();
        if (!label.isEmpty()) {
            var font = net.minecraft.client.Minecraft.getInstance().font;
            int width = font.width(label);
            float scale = Math.min(0.008F, 0.40F / Math.max(1, width));
            poseStack.pushPose();
            poseStack.translate(0, 9.5 / 16.0, -7.62 / 16.0);
            poseStack.scale(scale, scale, scale);
            font.drawInBatch(label, -width / 2.0F, -4.0F, 0xffffefd0, true, poseStack.last().pose(), buffer, false, 0, packedLight);
            poseStack.popPose();
        }
        poseStack.popPose();
    }
}