package net.quiltmc.users.cosmo.galactic_curiosities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.ModEntities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.ShipEntity;
import net.quiltmc.users.cosmo.galactic_curiosities.items.ModItems;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GalacticCuriosities implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Galactic curiosities");
	public static String MOD_ID = "galactic_curiosities";
    @Override
    public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());
		ModItems.registerModItems();
	}
}
