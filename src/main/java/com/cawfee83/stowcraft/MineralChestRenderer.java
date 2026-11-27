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

public final class MineralChestRenderer implements BlockEntityRenderer<MineralChestBlockEntity> {
    private final MineralChestModel model;

    public MineralChestRenderer(BlockEntityRendererProvider.Context context) {
        model = new MineralChestModel(context.bakeLayer(MineralChestModel.LAYER_LOCATION));
    }

    @Override
    public void render(MineralChestBlockEntity chest, float partialTick, PoseStack pose,
                       MultiBufferSource buffer, int light, int overlay) {
        Direction facing = chest.getBlockState().getValue(MineralChestBlock.FACING);
        String variant = chest.variant();
        ResourceLocation texture = new ResourceLocation(Stowcraft.MODID, "textures/block/" + variant + ".png");
        ResourceLocation emissive = new ResourceLocation(Stowcraft.MODID,
                "textures/block/" + variant + "_emissive.png");

        pose.pushPose();
        pose.translate(0.5D, 1.5D, 0.5D);
        pose.mulPose(Vector3f.YP.rotationDegrees(180.0F - facing.toYRot()));
        pose.scale(-1.0F, -1.0F, 1.0F);

        model.setOpenness(chest.getOpenNess(partialTick));
        model.render(pose, buffer.getBuffer(RenderType.entityCutoutNoCull(texture)), light, overlay);

        float glow = chest.glowStrength();
        if (glow > 0.005F) {
            // Overlay is full-bright and alpha-faded; only masked texture pixels emit light.
            model.render(pose, buffer.getBuffer(RenderType.entityTranslucent(emissive)),
                    0xF000F0, overlay, glow);
        }

        String label = chest.getLabel();
        if (!label.isEmpty()) {
            var font = Minecraft.getInstance().font;
            int width = font.width(label);
            float scale = Math.min(0.008F, 0.40F / Math.max(1, width));
            pose.pushPose();
            // The approved nameplate is at Blockbench Y 4.5..6.5, front Z = -8.
            pose.translate(0, 18.5 / 16.0, -8.05 / 16.0);
            pose.scale(scale, scale, scale);
            font.drawInBatch(label, -width / 2.0F, -4.0F, 0xfff0dfbd,
                    false, pose.last().pose(), buffer, false, 0, light);
            pose.popPose();
        }
        pose.popPose();
    }
}
