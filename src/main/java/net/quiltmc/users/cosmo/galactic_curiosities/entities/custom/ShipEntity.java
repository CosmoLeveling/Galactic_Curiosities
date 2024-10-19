package net.quiltmc.users.cosmo.galactic_curiosities.entities.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;

public class ShipEntity extends Entity{
	private boolean pressingLeft;
	private boolean pressingRight;
	private boolean pressingForward;
	private boolean pressingBack;

	@Override
	public boolean isInvulnerable() {
		return true;
	}

	public ShipEntity(EntityType<? extends Entity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void initDataTracker() {
	}

	@Override
	public boolean collides() {
		return true;
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {

	}
	public void setInputs(boolean pressingLeft, boolean pressingRight, boolean pressingForward, boolean pressingBack) {
		this.pressingLeft = pressingLeft;
		this.pressingRight = pressingRight;
		this.pressingForward = pressingForward;
		this.pressingBack = pressingBack;
	}
	@Override
	public void tick() {
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {

	}

	@Override
	public ActionResult interact(PlayerEntity player, Hand hand) {
		if(player.shouldCancelInteraction()){
			return ActionResult.PASS;
		}else {
			return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
		}
	}
}
