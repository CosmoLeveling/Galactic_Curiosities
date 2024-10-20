package net.quiltmc.users.cosmo.galactic_curiosities;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.quiltmc.users.cosmo.galactic_curiosities.datagen.ModModelProvider;
import net.quiltmc.users.cosmo.galactic_curiosities.datagen.ModWorldGenerator;
import net.quiltmc.users.cosmo.galactic_curiosities.world.dimension.ModDimensions;

public class GalacticCuriositiesDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModModelProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType);
	}
}
