package net.quiltmc.users.cosmo.galactic_curiosities.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.HolderLookup;
import net.minecraft.registry.RegistryKeys;

import java.util.concurrent.CompletableFuture;

public class ModWorldGenerator extends FabricDynamicRegistryProvider {
	public ModWorldGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		entries.addAll(registries.getLookupOrThrow(RegistryKeys.DIMENSION_TYPE));
	}

	@Override
	public String getName() {
		return "World Gen";
	}
}
