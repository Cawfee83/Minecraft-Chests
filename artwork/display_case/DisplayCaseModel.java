// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class display_case<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "display_case"), "main");
	private final ModelPart lid;
	private final ModelPart base;

	public display_case(ModelPart root) {
		this.lid = root.getChild("lid");
		this.base = root.getChild("base");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(32, 19).addBox(-8.0F, -0.95F, -15.45F, 16.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F))
		.texOffs(32, 19).addBox(-8.0F, -0.95F, -0.45F, 16.0F, 1.0F, 1.0F, new CubeDeformation(-0.05F))
		.texOffs(67, 19).addBox(-8.0F, -0.95F, -14.45F, 1.0F, 1.0F, 14.0F, new CubeDeformation(-0.05F))
		.texOffs(67, 19).addBox(7.0F, -0.95F, -14.45F, 1.0F, 1.0F, 14.0F, new CubeDeformation(-0.05F))
		.texOffs(1, 48).addBox(-7.0F, -0.95F, -14.45F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.05F, 7.45F));

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(1, 1).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(-0.05F))
		.texOffs(66, 1).addBox(-7.95F, -14.95F, -7.95F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 1).addBox(6.95F, -14.95F, -7.95F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 1).addBox(-7.95F, -14.95F, 6.95F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 1).addBox(6.95F, -14.95F, 6.95F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(71, 1).addBox(-7.0F, -14.95F, -7.45F, 14.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(71, 1).addBox(-7.0F, -14.95F, 6.45F, 14.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 19).addBox(-7.45F, -14.95F, -7.0F, 1.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(1, 19).addBox(6.45F, -14.95F, -7.0F, 1.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(58, 48).addBox(-5.0F, -3.0F, -7.5F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		lid.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}