package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

/** Faithful 15-cube approved Blockbench export, split by render pass. */
public final class DisplayCaseModel {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Stowcraft.MODID, "display_case"), "main");
    private final ModelPart frameBase, glassBase, frameLid, glassLid;
    public DisplayCaseModel(ModelPart root) {
        frameBase = root.getChild("frame_base"); glassBase = root.getChild("glass_base");
        frameLid = root.getChild("frame_lid"); glassLid = root.getChild("glass_lid");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("frame_lid", CubeListBuilder.create()
            .texOffs(32,19).addBox(-8F,-.95F,-15.45F,16F,1F,1F,new CubeDeformation(-.05F))
            .texOffs(32,19).addBox(-8F,-.95F,-.45F,16F,1F,1F,new CubeDeformation(-.05F))
            .texOffs(67,19).addBox(-8F,-.95F,-14.45F,1F,1F,14F,new CubeDeformation(-.05F))
            .texOffs(67,19).addBox(7F,-.95F,-14.45F,1F,1F,14F,new CubeDeformation(-.05F)),
            PartPose.offset(0F,9.05F,7.45F));
        root.addOrReplaceChild("glass_lid", CubeListBuilder.create()
            .texOffs(1,48).addBox(-7F,-.95F,-14.45F,14F,1F,14F,new CubeDeformation(0F)),
            PartPose.offset(0F,9.05F,7.45F));
        root.addOrReplaceChild("frame_base", CubeListBuilder.create()
            .texOffs(1,1).addBox(-8F,-1F,-8F,16F,1F,16F,new CubeDeformation(-.05F))
            .texOffs(66,1).addBox(-7.95F,-14.95F,-7.95F,1F,14F,1F,new CubeDeformation(0F))
            .texOffs(66,1).addBox(6.95F,-14.95F,-7.95F,1F,14F,1F,new CubeDeformation(0F))
            .texOffs(66,1).addBox(-7.95F,-14.95F,6.95F,1F,14F,1F,new CubeDeformation(0F))
            .texOffs(66,1).addBox(6.95F,-14.95F,6.95F,1F,14F,1F,new CubeDeformation(0F))
            .texOffs(58,48).addBox(-5F,-3F,-7.5F,10F,2F,1F,new CubeDeformation(0F)),
            PartPose.offset(0F,24F,0F));
        root.addOrReplaceChild("glass_base", CubeListBuilder.create()
            .texOffs(71,1).addBox(-7F,-14.95F,-7.45F,14F,14F,1F,new CubeDeformation(0F))
            .texOffs(71,1).addBox(-7F,-14.95F,6.45F,14F,14F,1F,new CubeDeformation(0F))
            .texOffs(1,19).addBox(-7.45F,-14.95F,-7F,1F,14F,14F,new CubeDeformation(0F))
            .texOffs(1,19).addBox(6.45F,-14.95F,-7F,1F,14F,14F,new CubeDeformation(0F)),
            PartPose.offset(0F,24F,0F));
        return LayerDefinition.create(mesh,128,128);
    }
    public void setOpenness(float t) {
        t = Math.max(0F,Math.min(1F,t));
        float angle = -t*t*(3F-2F*t)*(float)(Math.PI/2);
        frameLid.xRot = angle;
        glassLid.xRot = angle;
    }
    public void renderFrame(PoseStack pose, VertexConsumer vertex, int light, int overlay) {
        frameBase.render(pose,vertex,light,overlay);
        frameLid.render(pose,vertex,light,overlay);
    }
    public void renderGlass(PoseStack pose, VertexConsumer vertex, int light, int overlay) {
        glassBase.render(pose,vertex,light,overlay);
        glassLid.render(pose,vertex,light,overlay);
    }
}
