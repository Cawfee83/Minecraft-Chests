// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class FortressChest<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "fortresschest"), "main");
	private final ModelPart body;
	private final ModelPart gate;

	public FortressChest(ModelPart root) {
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

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		gate.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}