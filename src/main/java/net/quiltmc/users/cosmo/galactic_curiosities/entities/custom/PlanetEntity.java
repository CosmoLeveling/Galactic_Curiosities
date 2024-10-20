package net.quiltmc.users.cosmo.galactic_curiosities.entities.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.TypeFilter;
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
		//Orbiting
		orbit += 0.1;
		if (getOrbiting() == null) {
			setOrbiting(this.uuid);
		}
		if (getOrbiting() != null && this.getServer() != null) {
			this.getServer().getWorlds().forEach(serverWorld -> {
				if(serverWorld.getEntity(getOrbiting())!=null) {
					this.setVelocity(10,1,1);
				}
			});
		}

		//Teleporting
		List<PigEntity> player = getWorld().getEntitiesByType(TypeFilter.instanceOf(PigEntity.class),Box.from(this.getPos()).expand(10), playerEntity -> true);
		if(player != null&&player.size() != 0 && player.get(0) != null && distanceTo(player.get(0))<=10&&getServer()!= null && getServer().getOverworld() != null && player.get(0).getFirstPassenger() != null) {
			LivingEntity Teleporting = player.get(0).getPrimaryPassenger();
			if (Teleporting != null) {
				Entity Vehicle = null;
				if (Teleporting.hasVehicle()){
					Vehicle = Teleporting.getVehicle();
					Teleporting.getVehicle().discard();
				}
				TeleportTarget location = new TeleportTarget(new Vec3d(0,100,0),Teleporting.getVelocity(),Teleporting.getYaw(),Teleporting.getPitch());
				RegistryKey<World> dimension = World.OVERWORLD;
				ServerWorld destination = ((ServerWorld) getWorld()).getServer().getWorld(dimension);
				if (Vehicle != null) {
					Teleporting.getWorld().spawnEntity(Vehicle);
					Teleporting.startRiding(Vehicle);
				}
				if (destination!=null) QuiltDimensions.teleport(Teleporting,destination,location);
			}
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
