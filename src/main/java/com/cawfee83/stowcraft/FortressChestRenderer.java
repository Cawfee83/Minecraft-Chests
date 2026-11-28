package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public final class FortressChestRenderer implements BlockEntityRenderer<FortressChestBlockEntity> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Stowcraft.MODID, "textures/block/fortress_nether_brick.png");
    private final FortressChestModel model;

    public FortressChestRenderer(BlockEntityRendererProvider.Context context) {
        model = new FortressChestModel(context.bakeLayer(FortressChestModel.LAYER_LOCATION));
    }

    @Override public void render(FortressChestBlockEntity chest, float partialTick, PoseStack pose,
            MultiBufferSource buffer, int light, int overlay) {
        Direction facing = chest.getBlockState().getValue(FortressChestBlock.FACING);
        pose.pushPose();
        pose.translate(.5D, 1.5D, .5D);
        pose.mulPose(Vector3f.YP.rotationDegrees(180F - facing.toYRot()));
        pose.scale(-1F, -1F, 1F);
        model.setOpenness(chest.getOpenNess(partialTick));
        model.render(pose, buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE)), light, overlay);

        // Stationary inset nameplate: y 10.5..12.5, on the -Z front face.
        String label = chest.getLabel();
        if (!label.isEmpty()) {
            var font = Minecraft.getInstance().font;
            int width = font.width(label);
            float scale = Math.min(.012F, .48F / Math.max(1, width));
            pose.pushPose();
            // Render in the same top-origin model coordinate system as the other containers.
            pose.translate(0, 12F / 16F, -7.56F / 16F);
            pose.scale(scale, scale, scale);
            font.drawInBatch(label, -width / 2F, -4F, 0xffe6d7b5, false,
                    pose.last().pose(), buffer, false, 0, light);
            pose.popPose();
        }
        pose.popPose();
    }
}
