
package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class LogChestRenderer
        implements BlockEntityRenderer<LogChestBlockEntity> {

    
    private final LogChestModel model;

    public LogChestRenderer(
            BlockEntityRendererProvider.Context context) {

        model = new LogChestModel(
                context.bakeLayer(LogChestModel.LAYER_LOCATION));
    }

    @Override
    public void render(
            LogChestBlockEntity satchel,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            int packedOverlay) {

        Direction facing = satchel.getBlockState()
                .getValue(LogChestBlock.FACING);

        poseStack.pushPose();

        poseStack.translate(0.5, 1.5, 0.5);

        poseStack.mulPose(Vector3f.YP.rotationDegrees(
                180.0F - facing.toYRot()));

        poseStack.scale(-1.0F, -1.0F, 1.0F);

        float openness = satchel.getOpenNess(partialTick);
        model.setLidAngle(1.0F - (float)Math.pow(1.0F - openness, 3));

        model.render(
                poseStack,
                buffer.getBuffer(RenderType.entityCutoutNoCull(new ResourceLocation(Stowcraft.MODID, "textures/block/" + satchel.variant() + ".png"))),
                packedLight,
                packedOverlay);

        String label = satchel.getLabel();
        if (!label.isEmpty()) {
            var font = net.minecraft.client.Minecraft.getInstance().font;
            int width = font.width(label);
            float scale = Math.min(0.0153F, 0.40F / Math.max(1, width));
            poseStack.pushPose();
            poseStack.translate(0, 17.0 / 16.0, -7.12 / 16.0);
            poseStack.scale(scale, scale, scale);
            font.drawInBatch(label, -width / 2.0F, -4.0F, 0xfffff3d6, true, poseStack.last().pose(), buffer, false, 0, packedLight);
            poseStack.popPose();
        }
        poseStack.popPose();
    }
}