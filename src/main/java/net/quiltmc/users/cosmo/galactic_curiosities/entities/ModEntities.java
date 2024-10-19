package net.quiltmc.users.cosmo.galactic_curiosities.entities;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.PlanetEntity;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.ParticleEntityExample;
import net.quiltmc.users.cosmo.galactic_curiosities.entities.custom.ShipEntity;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class ModEntities {
	public static final EntityType<ParticleEntityExample> PORTAL = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(GalacticCuriosities.MOD_ID,"portal"),
		QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, ParticleEntityExample::new)
			.setDimensions(EntityDimensions.fixed(0.65f,0.65f)).build());
	public static final EntityType<PlanetEntity> PLANET = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(GalacticCuriosities.MOD_ID,"planet"),
		QuiltEntityTypeBuilder.create(SpawnGroup.MONSTER, PlanetEntity::new)
			.setDimensions(EntityDimensions.fixed(0.65f,0.65f)).build());

	public static final EntityType<ShipEntity> SHIP = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(GalacticCuriosities.MOD_ID,"ship"),
		QuiltEntityTypeBuilder.create(SpawnGroup.MISC, ShipEntity::new)
			.setDimensions(EntityDimensions.fixed(0.65f,0.65f)).build());
}
