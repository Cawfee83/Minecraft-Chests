package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public final class FortressChestModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Stowcraft.MODID, "fortress_chest"), "main");
    private final ModelPart body;
    private final ModelPart gate;

    public FortressChestModel(ModelPart root) {
        this.body = root.getChild("body");
        this.gate = root.getChild("gate");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(-0.05F))
        .texOffs(64, 0).addBox(-8.0F, -13.5F, -8.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(64, 0).addBox(5.0F, -13.5F, -8.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(64, 0).addBox(-8.0F, -13.5F, 5.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(64, 0).addBox(5.0F, -13.5F, 5.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(76, 0).addBox(-7.0F, -13.5F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
        .texOffs(76, 0).addBox(5.0F, -13.5F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
        .texOffs(0, 24).addBox(-6.0F, -13.5F, 5.0F, 12.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
        .texOffs(28, 24).addBox(-6.0F, -13.1F, -7.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
        .texOffs(56, 24).addBox(-8.0F, -14.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(-0.05F))
        .texOffs(0, 41).addBox(-8.0F, -15.85F, -8.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(0, 41).addBox(5.0F, -15.85F, -8.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(0, 41).addBox(-8.0F, -15.85F, 5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(0, 41).addBox(5.0F, -15.85F, 5.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(12, 41).addBox(-2.0F, -15.85F, -8.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(12, 41).addBox(-2.0F, -15.85F, 5.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(-0.025F))
        .texOffs(26, 41).addBox(-8.0F, -15.85F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(-0.025F))
        .texOffs(26, 41).addBox(5.0F, -15.85F, -2.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(-0.025F))
        .texOffs(66, 41).addBox(-5.0F, -12.5F, -7.5F, 10.0F, 2.0F, 1.0F, new CubeDeformation(-0.05F))
        .texOffs(88, 41).addBox(-7.5F, -9.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(-0.05F))
        .texOffs(88, 41).addBox(6.5F, -9.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(-0.05F))
        .texOffs(98, 41).addBox(-2.0F, -9.0F, 6.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition gate = partdefinition.addOrReplaceChild("gate", CubeListBuilder.create().texOffs(40, 41).addBox(-5.0F, -1.0F, 0.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F))
        .texOffs(62, 41).addBox(-4.5F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.15F))
        .texOffs(62, 41).addBox(-2.5F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.15F))
        .texOffs(62, 41).addBox(-0.5F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.15F))
        .texOffs(62, 41).addBox(1.5F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.15F))
        .texOffs(62, 41).addBox(3.5F, -8.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.15F))
        .texOffs(40, 41).addBox(-5.0F, -3.0F, 0.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
        .texOffs(40, 41).addBox(-5.0F, -6.0F, 0.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 22.0F, -7.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void setOpenness(float openness) {
        float eased = openness * openness * (3F - 2F * openness);
        gate.xRot = (float) (Math.PI / 2D) * eased;
    }

    public void render(PoseStack pose, VertexConsumer consumer, int light, int overlay) {
        body.render(pose, consumer, light, overlay);
        gate.render(pose, consumer, light, overlay);
    }
}
