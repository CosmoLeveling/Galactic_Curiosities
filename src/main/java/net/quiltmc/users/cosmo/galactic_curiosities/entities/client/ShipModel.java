// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.quiltmc.users.cosmo.galactic_curiosities.entities.client;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.ShipEntity;

public class ShipModel<T extends ShipEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Ship;
	public ShipModel(ModelPart root) {
		this.Ship = root.getChild("Ship");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Ship = modelPartData.addChild("Ship", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Hull = Ship.addChild("Hull", ModelPartBuilder.create().uv(51, 83).cuboid(-2.0F, -39.0F, -8.0F, 4.0F, 20.0F, 43.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-9.0F, -20.0F, -23.0F, 18.0F, 20.0F, 43.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = Hull.addChild("cube_r1", ModelPartBuilder.create().uv(0, 63).cuboid(-2.0F, -20.0F, -23.0F, 4.0F, 20.0F, 43.0F, new Dilation(0.0F)), ModelTransform.of(-9.0F, -10.0F, 15.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData cube_r2 = Hull.addChild("cube_r2", ModelPartBuilder.create().uv(79, 20).cuboid(-2.0F, -20.0F, -23.0F, 4.0F, 20.0F, 43.0F, new Dilation(0.0F)), ModelTransform.of(29.0F, -10.0F, 15.0F, 0.0F, 0.0F, -1.5708F));
		return TexturedModelData.of(modelData, 256, 256);
	}
	@Override
	public void setAngles(ShipEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Ship.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Ship;
	}
}
