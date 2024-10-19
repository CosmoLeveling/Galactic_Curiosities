package net.quiltmc.users.cosmo.galactic_curiosities.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ModItems {
	public static final Item Corrupted_Chorus = registerItem("corrupted_chorus",new SparklyItem(new QuiltItemSettings().maxCount(1)));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM,new Identifier(GalacticCuriosities.MOD_ID,name), item);
	}
	public static void registerModItems() {
		GalacticCuriosities.LOGGER.info("Registering Mod Items for "+GalacticCuriosities.MOD_ID);
	}
}
