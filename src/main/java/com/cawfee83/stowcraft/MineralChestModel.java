package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

/** Generated from the approved Mineral_Chest.bbmodel, Modded Entity, Box UV, Y flipped. */
public final class MineralChestModel {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation(Stowcraft.MODID, "mineral_chest"), "main");
    private final ModelPart base, lidLeft, lidRight;

    public MineralChestModel(ModelPart root) {
        base = root.getChild("base");
        lidLeft = root.getChild("lid_left");
        lidRight = root.getChild("lid_right");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("base", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-7F, -1F, -7F, 14F, 1F, 14F, new CubeDeformation(0F)) // bottom_plate
                .texOffs(0, 45).addBox(-7F, -11F, -7F, 14F, 10F, 1F, new CubeDeformation(-0.01F)) // wall_front
                .texOffs(60, 51).addBox(-7F, -11F, 6F, 14F, 10F, 1F, new CubeDeformation(-0.01F)) // wall_back
                .texOffs(100, 0).addBox(-7F, -11F, -6F, 1F, 10F, 12F, new CubeDeformation(-0.01F)) // wall_right
                .texOffs(44, 17).addBox(6F, -11F, -6F, 1F, 10F, 12F, new CubeDeformation(-0.01F)) // wall_left
                .texOffs(118, 38).addBox(-7.5F, -11F, -7.5F, 2F, 11F, 2F, new CubeDeformation(0F)) // post_front_right
                .texOffs(114, 51).addBox(5.5F, -11F, -7.5F, 2F, 11F, 2F, new CubeDeformation(0F)) // post_front_left
                .texOffs(24, 65).addBox(-7.5F, -11F, 5.5F, 2F, 11F, 2F, new CubeDeformation(0F)) // post_back_right
                .texOffs(32, 65).addBox(5.5F, -11F, 5.5F, 2F, 11F, 2F, new CubeDeformation(0F)) // post_back_left
                .texOffs(70, 17).addBox(-5.5F, -2F, -7.5F, 11F, 2F, 1F, new CubeDeformation(0F)) // band_lower_front
                .texOffs(0, 69).addBox(-5.5F, -2F, 6.5F, 11F, 2F, 1F, new CubeDeformation(0F)) // band_lower_back
                .texOffs(90, 51).addBox(-7.5F, -2F, -5.5F, 1F, 2F, 11F, new CubeDeformation(0F)) // band_lower_right
                .texOffs(30, 52).addBox(6.5F, -2F, -5.5F, 1F, 2F, 11F, new CubeDeformation(0F)) // band_lower_left
                .texOffs(78, 71).addBox(-5.5F, -11F, -7.5F, 11F, 2F, 1F, new CubeDeformation(0F)) // band_upper_front
                .texOffs(102, 71).addBox(-5.5F, -11F, 6.5F, 11F, 2F, 1F, new CubeDeformation(0F)) // band_upper_back
                .texOffs(0, 56).addBox(-7.5F, -11F, -5.5F, 1F, 2F, 11F, new CubeDeformation(0F)) // band_upper_right
                .texOffs(54, 62).addBox(6.5F, -11F, -5.5F, 1F, 2F, 11F, new CubeDeformation(0F)) // band_upper_left
                .texOffs(78, 64).addBox(-5F, -8.5F, -7.6F, 10F, 6F, 1F, new CubeDeformation(-0.3F)) // panel_front
                .texOffs(100, 64).addBox(-5F, -8.5F, 6.6F, 10F, 6F, 1F, new CubeDeformation(-0.3F)) // panel_back
                .texOffs(104, 22).addBox(6.6F, -8.5F, -5F, 1F, 6F, 10F, new CubeDeformation(-0.3F)) // panel_left
                .texOffs(70, 35).addBox(-7.6F, -8.5F, -5F, 1F, 6F, 10F, new CubeDeformation(-0.3F)) // panel_right
                .texOffs(60, 39).addBox(6.5F, -12F, -5.5F, 1F, 2F, 2F, new CubeDeformation(0.1F)) // hinge_left_front
                .texOffs(60, 43).addBox(6.5F, -12F, 3.5F, 1F, 2F, 2F, new CubeDeformation(0.1F)) // hinge_left_back
                .texOffs(60, 47).addBox(-7.5F, -12F, -5.5F, 1F, 2F, 2F, new CubeDeformation(0.1F)) // hinge_right_front
                .texOffs(122, 51).addBox(-7.5F, -12F, 3.5F, 1F, 2F, 2F, new CubeDeformation(0.1F)) // hinge_right_back
                .texOffs(92, 38).addBox(6.5F, -11.5F, -6F, 1F, 1F, 12F, new CubeDeformation(-0.15F)) // hinge_pin_left
                .texOffs(34, 39).addBox(-7.5F, -11.5F, -6F, 1F, 1F, 12F, new CubeDeformation(-0.15F)) // hinge_pin_right
                .texOffs(0, 90).addBox(-1.5F, -7F, 7F, 3F, 3F, 1F, new CubeDeformation(-0.1F)) // port_back
                .texOffs(12, 90).addBox(7F, -7F, -1.5F, 1F, 3F, 3F, new CubeDeformation(-0.1F)) // port_left
                .texOffs(24, 90).addBox(-8F, -7F, -1.5F, 1F, 3F, 3F, new CubeDeformation(-0.1F)) // port_right
                .texOffs(36, 90).addBox(-4F, -6.5F, -8F, 8F, 2F, 1F, new CubeDeformation(-0.1F)) // nameplate
                , PartPose.offset(0F, 24F, 0F));
        root.addOrReplaceChild("lid_left", CubeListBuilder.create()
                .texOffs(56, 0).addBox(-6.95F, -2F, -7.5F, 7F, 2F, 15F, new CubeDeformation(0F)) // lid_left_plate
                .texOffs(70, 22).addBox(-6F, -2.8F, -6F, 5F, 1F, 12F, new CubeDeformation(-0.1F)) // lid_left_panel
                .texOffs(94, 17).addBox(-6.95F, -2F, -8F, 2F, 3F, 1F, new CubeDeformation(-0.05F)) // lock_left
                , PartPose.offset(7F, 13F, 0F));
        root.addOrReplaceChild("lid_right", CubeListBuilder.create()
                .texOffs(0, 15).addBox(-0.05F, -2F, -7.5F, 7F, 2F, 15F, new CubeDeformation(0F)) // lid_right_plate
                .texOffs(0, 32).addBox(1F, -2.8F, -6F, 5F, 1F, 12F, new CubeDeformation(-0.1F)) // lid_right_panel
                .texOffs(34, 32).addBox(4.95F, -2F, -8F, 2F, 3F, 1F, new CubeDeformation(-0.05F)) // lock_right
                , PartPose.offset(-7F, 13F, 0F));
        return LayerDefinition.create(mesh, 128, 128);
    }

    private static float smooth(float t) {
        t = Math.max(0.0F, Math.min(1.0F, t));
        return t * t * (3.0F - 2.0F * t);
    }

    public void setOpenness(float openness) {
        float radians = (float) (Math.PI * 0.5) * smooth(openness);
        // Blockbench Y-up coordinates map to Java Y-down model coordinates.
        lidLeft.zRot = radians;
        lidRight.zRot = -radians;
    }

    public void render(PoseStack pose, VertexConsumer consumer, int light, int overlay) {
        render(pose, consumer, light, overlay, 1.0F);
    }

    public void render(PoseStack pose, VertexConsumer consumer, int light, int overlay, float alpha) {
        base.render(pose, consumer, light, overlay, 1.0F, 1.0F, 1.0F, alpha);
        lidLeft.render(pose, consumer, light, overlay, 1.0F, 1.0F, 1.0F, alpha);
        lidRight.render(pose, consumer, light, overlay, 1.0F, 1.0F, 1.0F, alpha);
    }
}
