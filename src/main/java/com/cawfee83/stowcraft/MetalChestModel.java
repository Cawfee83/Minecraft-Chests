package com.cawfee83.stowcraft;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
public class MetalChestModel {
 public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Stowcraft.MODID,"metal_chest"),"main");
 private final ModelPart base,door,handle;
 public MetalChestModel(ModelPart root){base=root.getChild("base");door=root.getChild("door");handle=door.getChild("handle");}
 public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(60, 52).addBox(-4.5F, -15.5F, -7.96F, 9.0F, 2.0F, 1.0F, new CubeDeformation(-0.35F))
		.texOffs(0, 0).addBox(-7.0F, -2.0F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(42, 72).addBox(4.0F, -1.0F, -6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(74, 71).addBox(-6.0F, -1.0F, -6.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(74, 74).addBox(4.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(42, 75).addBox(-6.0F, -1.0F, 4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(6.0F, -15.0F, -7.0F, 1.0F, 13.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(30, 30).addBox(-7.0F, -15.0F, -7.0F, 1.0F, 13.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(56, 57).addBox(-6.0F, -15.0F, 6.0F, 12.0F, 13.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-7.0F, -16.0F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 72).addBox(5.0F, -15.0F, -7.25F, 2.0F, 13.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(6, 72).addBox(-7.0F, -15.0F, -7.25F, 2.0F, 13.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(60, 48).addBox(-5.0F, -3.0F, -7.26F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(60, 50).addBox(-5.0F, -15.0F, -7.26F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(32, 77).addBox(-6.0F, -14.0F, -8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(36, 77).addBox(-6.0F, -6.0F, -8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(56, 0).addBox(-7.0F, -15.0F, -6.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.2F))
		.texOffs(56, 15).addBox(6.0F, -15.0F, -6.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.2F))
		.texOffs(60, 42).addBox(-6.0F, -15.0F, 6.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.21F))
		.texOffs(0, 57).addBox(-7.0F, -4.0F, -6.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.2F))
		.texOffs(28, 57).addBox(6.0F, -4.0F, -6.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.2F))
		.texOffs(60, 45).addBox(-6.0F, -4.0F, 6.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.21F))
		.texOffs(12, 72).addBox(-7.1F, -10.5F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 72).addBox(6.1F, -10.5F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 72).addBox(-2.0F, -10.5F, 6.1F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition door = partdefinition.addOrReplaceChild("door", CubeListBuilder.create().texOffs(60, 30).addBox(0.5F, -5.5F, 0.0F, 10.0F, 11.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(56, 71).addBox(1.5F, -4.5F, 0.0F, 8.0F, 9.0F, 1.0F, new CubeDeformation(0.1F))
		.texOffs(76, 55).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 78).addBox(-0.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 55).addBox(-0.5F, -4.5F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(68, 55).addBox(-0.5F, 3.5F, 0.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(50, 72).addBox(7.0F, -2.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.15F))
		.texOffs(44, 78).addBox(2.0F, -4.0F, -0.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(78, 77).addBox(8.0F, -4.0F, -0.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(78, 79).addBox(2.0F, 3.0F, -0.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(12, 80).addBox(8.0F, 3.0F, -0.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(-5.5F, 15.5F, -7.5F));

		PartDefinition handle = door.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(50, 75).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(74, 77).addBox(-0.5F, 3.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(8.0F, -1.5F, -0.2F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
 private static float smooth(float x){x=Math.max(0,Math.min(1,x));return x*x*(3-2*x);}
 public void setOpenness(float openness){handle.zRot=(float)Math.PI/2*(1-smooth(openness/0.2857143F));door.yRot=-(float)Math.PI*2/3*smooth((openness-0.2857143F)/0.7142857F);}
 public void render(PoseStack pose, VertexConsumer consumer,int light,int overlay){base.render(pose,consumer,light,overlay);door.render(pose,consumer,light,overlay);}
}