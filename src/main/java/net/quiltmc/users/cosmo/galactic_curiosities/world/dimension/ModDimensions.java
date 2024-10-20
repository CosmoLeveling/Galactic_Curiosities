package net.quiltmc.users.cosmo.galactic_curiosities.world.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;

import java.util.OptionalLong;

public class ModDimensions {
	public static final ResourceKey<LevelStem> SPACE_KEY = ResourceKey.create(Registries.LEVEL_STEM,
		new ResourceLocation(GalacticCuriosities.MOD_ID,"space"));
	public static final ResourceKey<Level> SPACE_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
		new ResourceLocation(GalacticCuriosities.MOD_ID,"space"));
	public static final ResourceKey<DimensionType> SPACE_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
		new ResourceLocation(GalacticCuriosities.MOD_ID,"space_type"));
	public static void bootstrapType(BootstapContext<DimensionType> context) {
		context.register(SPACE_DIM_TYPE,new DimensionType(
			OptionalLong.of(12000),
			false,
			false,
			false,
			false,
			1.0,
			true,
			false,
			0,
			256,
			256,
			BlockTags.INFINIBURN_END,
			new ResourceLocation("the_end"),
			1.0f,
			new DimensionType.MonsterSettings(false,false, UniformInt.of(0,0),0)));
	}
}
