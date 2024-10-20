package net.quiltmc.users.cosmo.galactic_curiosities.entities.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.math.Axis;
import foundry.veil.api.client.util.VertexFormatCodec;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.PlanetEntity;
import org.joml.Matrix3dStack;
import team.lodestar.lodestone.systems.rendering.LodestoneRenderType;
import team.lodestar.lodestone.systems.rendering.StateShards;
import team.lodestar.lodestone.systems.rendering.VFXBuilders;
import team.lodestar.lodestone.systems.rendering.rendeertype.RenderTypeToken;

import java.awt.*;

import static team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry.*;

public class PlanetEntityRenderer extends EntityRenderer<PlanetEntity> {
	public static final ResourceLocation DEFAULT_SKIN_LOCATION = new ResourceLocation(GalacticCuriosities.MOD_ID,"textures/mars.png");

	public static int scale = 20;

	public static float rot = 1;

	protected PlanetEntityRenderer(EntityRendererProvider.Context ctx) {
		super(ctx);
	}


	public static final LodestoneRenderType PLANET = ADDITIVE_TEXTURE_TRIANGLE.apply(RenderTypeToken.createToken(DEFAULT_SKIN_LOCATION));

	public static final LodestoneRenderType RENDER_TYPE =  createGenericRenderType("additive_block", ,
		VertexFormat.Mode.TRIANGLES, builder().setShaderState(POSITION_TEX_SHADER)
			.setTransparencyState(StateShards.NO_TRANSPARENCY).setTextureState(DEFAULT_SKIN_LOCATION));

	@Override
	public void render(PlanetEntity entity, float yaw, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light) {
		if(rot <= 359) {
			rot += 0.1;
		}else{
			rot = 0;
		}
		matrices.rotateAround(Axis.YP.rotationDegrees(rot),0,0,0);
		matrices.scale(scale,scale,scale);

		VFXBuilders.createWorld().setColor(new Color(100,200,200)).setAlpha(1F).setRenderType(RENDER_TYPE).setUV(0,0,1,1).renderSphere( matrices, 1,20,20);
	}

	@Override
	public ResourceLocation getTextureLocation(PlanetEntity entity) {
		return DEFAULT_SKIN_LOCATION;
	}
}
