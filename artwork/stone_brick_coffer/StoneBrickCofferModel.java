// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class StoneBrickCofferModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "stonebrickcoffermodel"), "main");
	private final ModelPart base;
	private final ModelPart lid;

	public StoneBrickCofferModel(ModelPart root) {
		this.base = root.getChild("base");
		this.lid = root.getChild("lid");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 16).addBox(-7.0F, -2.0F, -7.0F, 14.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(56, 43).addBox(-7.0F, -12.0F, -7.0F, 14.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 55).addBox(-7.0F, -12.0F, 5.0F, 14.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 62).addBox(5.0F, -12.0F, -5.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(24, 62).addBox(-7.0F, -12.0F, -5.0F, 2.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.5F, -1.0F, -7.5F, 15.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-7.0F, -1.5F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.25F))
		.texOffs(60, 0).addBox(-5.0F, -11.0F, -7.1F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 4).addBox(6.1F, -8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 67).addBox(-7.1F, -8.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(58, 67).addBox(-2.0F, -8.0F, 6.1F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -13.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(56, 16).addBox(-0.5F, -2.0F, -12.5F, 13.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(56, 30).addBox(0.0F, -3.0F, -12.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 12.0F, 6.0F));

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