package net.quiltmc.users.cosmo.galactic_curiosities.entities.client;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormats;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Axis;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.PlanetEntity;
import team.lodestar.lodestone.systems.rendering.LodestoneRenderType;
import team.lodestar.lodestone.systems.rendering.StateShards;
import team.lodestar.lodestone.systems.rendering.VFXBuilders;
import team.lodestar.lodestone.systems.rendering.rendeertype.RenderTypeToken;

import java.awt.*;

import static team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry.*;

public class PlanetEntityRenderer extends EntityRenderer<PlanetEntity> {
	public static final Identifier DEFAULT_SKIN_LOCATION = new Identifier(GalacticCuriosities.MOD_ID,"textures/jupiter.png");
	public static final Identifier DEFAULT_SKIN_LOCATIONS = new Identifier("textures/block/dripstone_block.png");

	public static float rot = 1;

	public PlanetEntityRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	public Identifier getTexture(PlanetEntity entity) {
		return DEFAULT_SKIN_LOCATION;
	}

	public static final LodestoneRenderType PLANET = ADDITIVE_TEXTURE_TRIANGLE.apply(RenderTypeToken.createToken(DEFAULT_SKIN_LOCATION));

	public static final LodestoneRenderType RENDER_TYPE =  createGenericRenderType("additive_block",VertexFormats.POSITION_TEXTURE,
		VertexFormat.DrawMode.TRIANGLES, builder().setShaderState(POSITION_TEXTURE_SHADER)
			.setTransparencyState(StateShards.NO_TRANSPARENCY).setTextureState(DEFAULT_SKIN_LOCATION));

	@Override
	public void render(PlanetEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		if(rot <= 359) {
			rot += 0.1;
		}else{
			rot = 0;
		}
		matrices.multiply(Axis.Y_POSITIVE.rotationDegrees(rot));
		matrices.scale(10,10,10);

		VFXBuilders.createWorld().setColor(new Color(100,200,200)).setAlpha(1F).setRenderType(RENDER_TYPE).setUV(0,0,1,1).renderSphere( matrices, 1,20,20);
	}

	@Override
	public boolean shouldRender(PlanetEntity entity, Frustum frustum, double x, double y, double z) {
		return true;
	}
}
