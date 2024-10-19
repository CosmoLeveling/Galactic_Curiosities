package net.quiltmc.users.cosmo.galactic_curiosities;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistrySetBuilder;
import net.quiltmc.users.cosmo.galactic_curiosities.datagen.ModWorldGenerator;
import net.quiltmc.users.cosmo.galactic_curiosities.world.dimension.ModDimensions;

public class GalacticCuriositiesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(RegistryKeys.DIMENSION_TYPE, ModDimensions::bootstrapType);
	}
}
