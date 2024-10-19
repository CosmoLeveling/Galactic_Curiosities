package net.quiltmc.users.cosmo.galactic_curiosities.entities.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;

public class ModModelLayers {
	public static final EntityModelLayer SHIP =
		new EntityModelLayer(new Identifier(GalacticCuriosities.MOD_ID,"ship"),"main");
}
