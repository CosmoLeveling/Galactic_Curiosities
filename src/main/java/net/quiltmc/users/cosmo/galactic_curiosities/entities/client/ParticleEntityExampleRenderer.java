package net.quiltmc.users.cosmo.galactic_curiosities.entities.client;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormats;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.ParticleEntityExample;
import team.lodestar.lodestone.systems.rendering.LodestoneRenderType;
import team.lodestar.lodestone.systems.rendering.StateShards;

import static net.minecraft.client.render.RenderPhase.POSITION_COLOR_LIGHTMAP_SHADER;
import static team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry.*;

public class ParticleEntityExampleRenderer extends EntityRenderer<ParticleEntityExample> {
	public static final ResourceLocation DEFAULT_SKIN_LOCATION = new ResourceLocation(GalacticCuriosities.MOD_ID,"textures/texture.png");

	protected ParticleEntityExampleRenderer(EntityRendererProvider.Context ctx) {
		super(ctx);
	}


	@Override
	public ResourceLocation getTextureLocation(ParticleEntityExample entity) {
		return DEFAULT_SKIN_LOCATION;
	}
}
