package net.quiltmc.users.cosmo.galactic_curiosities.entities.client;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormats;
import net.minecraft.client.model.Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Axis;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.ModEntities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.ShipEntity;
import team.lodestar.lodestone.systems.rendering.LodestoneRenderType;
import team.lodestar.lodestone.systems.rendering.StateShards;

import static net.minecraft.client.render.RenderPhase.POSITION_TEXTURE_SHADER;
import static net.minecraft.client.render.entity.LivingEntityRenderer.getOverlay;
import static team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry.builder;
import static team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry.createGenericRenderType;

public class ShipRenderer<T extends ShipEntity> extends EntityRenderer<ShipEntity> {


	protected final EntityModel<ShipEntity> model;
	private static final Identifier texture = new Identifier(GalacticCuriosities.MOD_ID,"textures/space/space.png");

	public ShipRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model  = new ShipModel<>(context.getPart(ModModelLayers.SHIP));
	}

	@Override
	public Identifier getTexture(ShipEntity entity) {
		return texture;
	}

	public EntityModel<ShipEntity> getModel() {
		return model;
	}

	@Override
	public void render(ShipEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
		int p = getOverlay(mobEntity, this.getAnimationCounter(mobEntity, g));
		this.setupTransforms(mobEntity,matrixStack,1,1,1);
		model.render(matrixStack, vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutoutNoCullZOffset(texture)),i,p,1.0f,1.0f,1.0f,1.0f);
	}

	public static int getOverlay(ShipEntity entity, float whiteOverlayProgress) {
		return OverlayTexture.packUv(OverlayTexture.getU(whiteOverlayProgress), OverlayTexture.getV(false));
	}


	protected float getAnimationCounter(ShipEntity entity, float tickDelta) {
		return 0.0F;
	}

	public static boolean renderFlipped(LivingEntity entity) {
		if (entity instanceof PlayerEntity || entity.hasCustomName()) {
			String string = Formatting.strip(entity.getName().getString());
			if ("Dinnerbone".equals(string) || "Grumm".equals(string)) {
				return !(entity instanceof PlayerEntity) || ((PlayerEntity)entity).isPartVisible(PlayerModelPart.CAPE);
			}
		}
		return false;
	}

	protected void setupTransforms(Entity entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
		matrices.translate(0.0F, entity.getHeight() + 0.1F, 0.0F);
		matrices.multiply(Axis.Z_POSITIVE.rotationDegrees(180.0F));
	}
}
