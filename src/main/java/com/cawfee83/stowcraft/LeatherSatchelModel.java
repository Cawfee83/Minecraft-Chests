
package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class LeatherSatchelModel {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(
					new ResourceLocation(
							Stowcraft.MODID, "leather_satchel"),
					"main");

	private final ModelPart lid;
	private final ModelPart base;

	public LeatherSatchelModel(ModelPart root) {
		this.lid = root.getChild("lid");
		this.base = root.getChild("base");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -2.0F, -12.0F, 14.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(53, 13).addBox(-7.0F, -2.0F, -12.75F, 14.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(3.0F, -3.0F, -13.0F, 2.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(31, 29).addBox(-5.0F, -3.0F, -13.0F, 2.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(62, 26).addBox(3.0F, -3.0F, -13.75F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 35).addBox(-5.0F, -3.0F, -13.75F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(57, 65).addBox(3.0F, 1.0F, -13.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(64, 65).addBox(-5.0F, 1.0F, -13.75F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 12.0F, 6.0F));

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(56, 21).addBox(-5.0F, -6.0F, -6.1F, 10.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(46, 57).addBox(6.1F, -7.5F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(57, 57).addBox(-7.1F, -7.5F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 65).addBox(-2.0F, -7.5F, 5.1F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-7.0F, -1.0F, -6.0F, 14.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(46, 44).addBox(-7.0F, -12.0F, -6.0F, 14.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(53, 0).addBox(-7.0F, -12.0F, 5.0F, 14.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(6.0F, -12.0F, -5.0F, 1.0F, 11.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(23, 44).addBox(-7.0F, -12.0F, -5.0F, 1.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	public void setLidAngle(float openness) {
		lid.xRot = -openness * (float) (Math.PI / 2);
	}

	public void render(
			PoseStack poseStack,
			VertexConsumer consumer,
			int light,
			int overlay) {

		base.render(poseStack, consumer, light, overlay);
		lid.render(poseStack, consumer, light, overlay);
	}
}
