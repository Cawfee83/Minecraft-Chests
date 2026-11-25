
package com.cawfee83.minecraftchests;

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
							MinecraftChests.MODID, "leather_satchel"),
					"main");

	private final ModelPart lid;
	private final ModelPart base;

	public LeatherSatchelModel(ModelPart root) {
		this.lid = root.getChild("lid");
		this.base = root.getChild("base");
	}

	public static LayerDefinition createBodyLayer() {

		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();

		root.addOrReplaceChild("lid",
				CubeListBuilder.create()
						.texOffs(0, 0)
						.addBox(-7, -2, -12, 14, 2, 12)
						.texOffs(53, 10)
						.addBox(-7, -2, -12.75F, 14, 5, 1)
						.texOffs(0, 29)
						.addBox(3, -3, -13, 2, 1, 13)
						.texOffs(31, 29)
						.addBox(-5, -3, -13, 2, 1, 13)
						.texOffs(62, 22)
						.addBox(3, -3, -13.75F, 2, 7, 1)
						.texOffs(62, 31)
						.addBox(-5, -3, -13.75F, 2, 7, 1)
						.texOffs(53, 22)
						.addBox(3, 1, -13.75F, 2, 2, 1,
								new CubeDeformation(0.25F))
						.texOffs(62, 40)
						.addBox(-5, 1, -13.75F, 2, 2, 1,
								new CubeDeformation(0.25F)),
				PartPose.offset(0, 15, 6));

		root.addOrReplaceChild("base",
				CubeListBuilder.create()
						.texOffs(0, 80)
						.addBox(-6, -5, -7, 12, 4, 1)
						.texOffs(46, 54)
						.addBox(6.1F, -6, -2, 1, 3, 4)
						.texOffs(57, 54)
						.addBox(-7.1F, -6, -2, 1, 3, 4)
						.texOffs(46, 62)
						.addBox(-2, -6, 5.1F, 4, 3, 1)
						.texOffs(0, 15)
						.addBox(-7, -1, -6, 14, 1, 12)
						.texOffs(46, 44)
						.addBox(-7, -9, -6, 14, 8, 1)
						.texOffs(53, 0)
						.addBox(-7, -9, 5, 14, 8, 1)
						.texOffs(0, 44)
						.addBox(6, -9, -5, 1, 8, 10)
						.texOffs(23, 44)
						.addBox(-7, -9, -5, 1, 8, 10),
				PartPose.offset(0, 24, 0));

		return LayerDefinition.create(mesh, 128, 128);
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
