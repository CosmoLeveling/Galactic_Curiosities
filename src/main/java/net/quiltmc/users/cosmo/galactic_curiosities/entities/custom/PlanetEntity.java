package net.quiltmc.users.cosmo.galactic_curiosities.entities.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.worldgen.dimension.api.QuiltDimensions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlanetEntity extends Entity {
	public static List<UUID> entities = List.of();
	private static final TrackedData<Optional<UUID>> orbiting = DataTracker.registerData(PlanetEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
	float orbit = 1;
	public PlanetEntity(EntityType<?> variant, World world) {
		super(variant, world);
	}

	@Override
	protected void initDataTracker() {
		this.dataTracker.startTracking(orbiting, Optional.empty());
	}

	@Override
	public void tick() {
		super.tick();
		//Teleporting
		List<LivingEntity> player = getWorld().getEntitiesByType(TypeFilter.instanceOf(LivingEntity.class),Box.from(this.getPos()).expand(20), playerEntity -> true);
		if (!player.isEmpty()&&distanceTo(player.get(0)) <=20) {
			onEntityCollision(player.get(0).getWorld(), player.get(0));
		}
	}

	public void onEntityCollision(World world, Entity entity) {
		if (world instanceof ServerWorld && entity.canUsePortals()) {
			RegistryKey<World> dimension = RegistryKey.of(RegistryKeys.WORLD,new Identifier("toast","the_nether"));
			ServerWorld destination = ((ServerWorld) world).getServer().getWorld(dimension);
			TeleportTarget location = new TeleportTarget(entity.getPos(),entity.getVelocity(),entity.getYaw(),entity.getPitch());

			QuiltDimensions.teleport(entity,destination,location);
		}
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		// Save the current value of the number to the nbt
		if(getOrbiting() != null) {
			nbt.putUuid("orbiting", getOrbiting());
		}
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		if(getOrbiting() != null) {
			setOrbiting(nbt.getUuid("orbiting"));
		}
	}

	@Nullable
	public UUID getOrbiting() {
		return this.dataTracker.get(orbiting).orElse(null);
	}

	public void setOrbiting(@Nullable UUID uuid) {
		this.dataTracker.set(orbiting, Optional.ofNullable(uuid));
	}
}
