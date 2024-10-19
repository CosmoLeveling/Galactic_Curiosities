package net.quiltmc.users.cosmo.galactic_curiosities.entities.client;

import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormats;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.ParticleEntityExample;
import team.lodestar.lodestone.systems.rendering.LodestoneRenderType;
import team.lodestar.lodestone.systems.rendering.StateShards;

import static net.minecraft.client.render.RenderPhase.POSITION_COLOR_LIGHTMAP_SHADER;
import static team.lodestar.lodestone.registry.client.LodestoneRenderTypeRegistry.*;

public class ParticleEntityExampleRenderer extends EntityRenderer<ParticleEntityExample> {
	public static final Identifier DEFAULT_SKIN_LOCATION = new Identifier(GalacticCuriosities.MOD_ID,"textures/texture.png");

	public ParticleEntityExampleRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
	}

	@Override
	public Identifier getTexture(ParticleEntityExample entity) {
		return DEFAULT_SKIN_LOCATION;
	}

}
