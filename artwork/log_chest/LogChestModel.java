// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class LogChestModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "logchestmodel"), "main");
	private final ModelPart base;
	private final ModelPart lid;

	public LogChestModel(ModelPart root) {
		this.base = root.getChild("base");
		this.lid = root.getChild("lid");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(24, 41).addBox(-7.0F, -2.0F, -7.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 23).addBox(-7.0F, -2.0F, 5.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 27).addBox(5.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(24, 45).addBox(-7.0F, -2.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(46, 65).addBox(5.0F, -10.0F, -7.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 65).addBox(-7.0F, -10.0F, -7.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 65).addBox(5.0F, -10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(-7.0F, -10.0F, 5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 45).addBox(-7.0F, -12.0F, -7.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 49).addBox(-7.0F, -12.0F, 5.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 53).addBox(5.0F, -12.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-7.0F, -12.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(24, 57).addBox(-5.0F, -10.0F, -6.0F, 10.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 10).addBox(-5.0F, -10.0F, 5.0F, 10.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(5.0F, -10.0F, -5.0F, 1.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(22, 23).addBox(-6.0F, -10.0F, -5.0F, 1.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-5.0F, -9.0F, -7.0F, 10.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 66).addBox(6.0F, -7.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(14, 66).addBox(-7.0F, -7.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 66).addBox(-1.0F, -7.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(40, 0).addBox(-7.0F, -3.0F, -14.0F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 5).addBox(-7.0F, -3.0F, -2.0F, 14.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 10).addBox(5.0F, -3.0F, -12.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 41).addBox(-7.0F, -3.0F, -12.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, -3.0F, -12.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(64, 19).addBox(-1.5F, -2.0F, -15.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 66).addBox(-1.0F, 0.0F, -15.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lid.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}