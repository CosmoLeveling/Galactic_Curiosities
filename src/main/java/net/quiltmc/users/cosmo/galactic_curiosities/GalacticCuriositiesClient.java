package net.quiltmc.users.cosmo.galactic_curiosities;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.*;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.client.*;
import net.quiltmc.users.cosmo.galactic_curiosities.event.KeyInputHandler;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GalacticCuriositiesClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Galactic curiosities");
	public static String MOD_ID = "galactic_curiosities";

	@Override
	public void onInitializeClient(ModContainer mod) {
		EntityRendererRegistry.register(ModEntities.PORTAL, ParticleEntityExampleRenderer::new);
		EntityRendererRegistry.register(ModEntities.PLANET, PlanetEntityRenderer::new);
		EntityRendererRegistry.register(ModEntities.SHIP, ShipRenderer::new);
		KeyInputHandler.register();

		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHIP, ShipModel::getTexturedModelData);
	}
}
