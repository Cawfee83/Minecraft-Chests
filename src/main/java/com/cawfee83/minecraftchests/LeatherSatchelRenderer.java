
package com.cawfee83.minecraftchests;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class LeatherSatchelRenderer
        implements BlockEntityRenderer<LeatherSatchelBlockEntity> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    MinecraftChests.MODID,
                    "textures/block/leather_satchel.png");

    private final LeatherSatchelModel model;

    public LeatherSatchelRenderer(
            BlockEntityRendererProvider.Context context) {

        model = new LeatherSatchelModel(
                context.bakeLayer(LeatherSatchelModel.LAYER_LOCATION));
    }

    @Override
    public void render(
            LeatherSatchelBlockEntity satchel,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            int packedOverlay) {

        Direction facing = satchel.getBlockState()
                .getValue(LeatherSatchelBlock.FACING);

        poseStack.pushPose();

        poseStack.translate(0.5, 1.5, 0.5);

        poseStack.mulPose(Vector3f.YP.rotationDegrees(
                180.0F - facing.toYRot()));

        poseStack.scale(-1.0F, -1.0F, 1.0F);

        float openness = satchel.getOpenNess(partialTick);
        model.setLidAngle(1.0F - (float)Math.pow(1.0F - openness, 3));

        model.render(
                poseStack,
                buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)),
                packedLight,
                packedOverlay);

        poseStack.popPose();
    }
}