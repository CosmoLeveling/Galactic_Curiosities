package net.quiltmc.users.cosmo.galactic_curiosities.items;

import foundry.veil.api.quasar.particle.ParticleEmitter;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import org.jetbrains.annotations.Nullable;
import team.lodestar.lodestone.handlers.screenparticle.ParticleEmitterHandler;
import team.lodestar.lodestone.registry.common.particle.LodestoneScreenParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.ScreenParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;
import team.lodestar.lodestone.systems.particle.screen.ScreenParticleHolder;

import java.util.List;

public class SparklyItem extends Item implements ParticleEmitterHandler.ItemParticleSupplier {

	public SparklyItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if(user.isSneaking()){
			user.teleport(user.getStackInHand(hand).getNbt().getInt("galactic_curiosities.x"),user.getStackInHand(hand).getNbt().getInt("galactic_curiosities.y"),user.getStackInHand(hand).getNbt().getInt("galactic_curiosities.z"));
			return super.use(world,user,hand);
		}
		NbtCompound nbtData = new NbtCompound();
		nbtData.putInt("galactic_curiosities.x", user.getBlockX());
		nbtData.putInt("galactic_curiosities.y", user.getBlockY());
		nbtData.putInt("galactic_curiosities.z", user.getBlockZ());
		user.getStackInHand(hand).setNbt(nbtData);

		return super.use(world, user, hand);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if(stack.hasNbt()){
			int x = stack.getNbt().getInt("galactic_curiosities.x");
			int y = stack.getNbt().getInt("galactic_curiosities.y");
			int z = stack.getNbt().getInt("galactic_curiosities.z");
			tooltip.add(Text.literal("X: " + x));
			tooltip.add(Text.literal("Y: " + y));
			tooltip.add(Text.literal("Z: " + z));
		}
		super.appendTooltip(stack, world, tooltip, context);
	}

	@Override
	public void spawnLateParticles(ScreenParticleHolder target, World level, float partialTick, ItemStack stack, float x, float y) {
		ScreenParticleBuilder.create(LodestoneScreenParticleRegistry.WISP, target).setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((level.getTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build()).setColorData(ColorParticleData.create(0,0,10).build()).setTransparencyData(GenericParticleData.constrictTransparency(GenericParticleData.create(100f).build())).setScaleData(GenericParticleData.create(0.5f, 0).build()).spawn(x,y);
	}
}
