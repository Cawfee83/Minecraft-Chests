// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class MetalChestModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "metalchestmodel"), "main");
	private final ModelPart base;
	private final ModelPart door;
	private final ModelPart handle;

	public MetalChestModel(ModelPart root) {
		this.base = root.getChild("base");
		this.door = root.getChild("door");
		this.handle = this.door.getChild("handle");
	}

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

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		door.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}