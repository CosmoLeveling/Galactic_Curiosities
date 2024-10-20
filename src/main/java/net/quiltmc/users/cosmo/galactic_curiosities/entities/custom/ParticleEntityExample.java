package net.quiltmc.users.cosmo.galactic_curiosities.entities.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleRegistry;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;

import java.awt.*;

public class ParticleEntityExample extends Entity {

	public ParticleEntityExample(EntityType<?> variant, World world) {
		super(variant, world);
	}

	@Override
	protected void initDataTracker() {

	}

	@Override
    public void tick() {
        super.tick();
        MinecraftClient minecraft = MinecraftClient.getInstance();
        Color startingColor = new Color(0, 255, 208);
        Color endingColor = new Color(7, 0, 200);
        double x = this.getX() + 0.5f;
        double y = this.getY() + 0.5f;
        double z = this.getZ() + 0.5f;
		if(minecraft.world != null) {
			WorldParticleBuilder.create(LodestoneParticleRegistry.WISP_PARTICLE)
				.setScaleData(GenericParticleData.create(0.5f, 0).build())
				.setTransparencyData(GenericParticleData.create(0.75f, 0.25f).build())
				.setColorData(ColorParticleData.create(startingColor, endingColor).setCoefficient(1.4f).setEasing(Easing.BOUNCE_IN_OUT).build())
				.setSpinData(SpinParticleData.create(0.2f, 0.4f).setSpinOffset((this.getWorld().getTime() * 0.2f) % 6.28f).setEasing(Easing.QUARTIC_IN).build())
				.setLifetime(40)
				.addMotion(0, 0.1, 0)
				.enableNoClip()
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2))*2, y, z+Math.sin(Math.toRadians(this.age*2))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+36))*2, y, z+Math.sin(Math.toRadians(this.age*2+36))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+72))*2, y, z+Math.sin(Math.toRadians(this.age*2+72))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+108))*2, y, z+Math.sin(Math.toRadians(this.age*2+108))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+144))*2, y, z+Math.sin(Math.toRadians(this.age*2+144))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+180))*2, y, z+Math.sin(Math.toRadians(this.age*2+180))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+216))*2, y, z+Math.sin(Math.toRadians(this.age*2+216))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+252))*2, y, z+Math.sin(Math.toRadians(this.age*2+252))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+288))*2, y, z+Math.sin(Math.toRadians(this.age*2+288))*2)
				.spawn(minecraft.world, x+Math.cos(Math.toRadians(this.age*2+324))*2, y, z+Math.sin(Math.toRadians(this.age*2+324))*2);
		}
    }

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {

	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {

	}

}
