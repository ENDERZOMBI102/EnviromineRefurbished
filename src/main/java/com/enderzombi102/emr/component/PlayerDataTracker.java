package com.enderzombi102.emr.component;

import com.enderzombi102.emr.utils.PlayerSleepState;
import com.mojang.serialization.Dynamic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerDataTracker implements IPlayerDataTracker {

//	public float prevBodyTemp = 37F;
//	public float prevHydration = 100F;
//	public float prevAirQuality = 100;
//	public float prevSanity = 100F;

	public float gasAirDiff = 0F;

	public float airQuality;

	public float bodyTemp;
	public float airTemp;

	public float hydration;
	public float wetness;

	public float sanity;

	public int attackDelay = 1;
	public int curAttackTime = 0;
	public boolean isDisabled = false;

	public int frostbiteLevel = 0;
	public boolean frostIrreversible = false;

	public boolean brokenLeg = false;
	public boolean brokenArm = false;
	public boolean bleedingOut = false;

	public PlayerSleepState sleepState = PlayerSleepState.Awake;
	public int lastSleepTime = 0;

	public int timeBelow10 = 0;

	public int updateTimer = 0;

	public PlayerDataTracker() {

	}

	@Override
	public void readFromNbt(CompoundTag compoundTag) {

	}

	@Override
	public void writeToNbt(CompoundTag compoundTag) {

	}

	/**
	 * This is used as "brain" for the main EnviroMine features:
	 * -
	 */
	@Override
	public void serverTick() {

	}

	@Override
	public boolean shouldSyncWith(ServerPlayerEntity player) {
		return false;
	}

	@Override
	public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity recipient) {
		CompoundTag tag = new CompoundTag();
		tag.putFloat("airQuality", this.airQuality);
		tag.putFloat("bodytemp", this.bodyTemp);
		tag.putFloat("airTemp", this.airTemp);
		tag.putFloat("hydration", this.hydration);
		tag.putFloat("airQuality", this.airQuality);
	}

	@Override
	public void applySyncPacket(PacketByteBuf buf) {
		CompoundTag tag = buf.readCompoundTag();
		this.airQuality = tag.getFloat("airQuality");
		this.airQuality = tag.getFloat("airQuality");
		this.airQuality = tag.getFloat("airQuality");
		this.airQuality = tag.getFloat("airQuality");
		this.airQuality = tag.getFloat("airQuality");
	}

	@Override
	public void fromDynamic(Dynamic<?> dynamic) {

	}

	@Override
	public <T> Dynamic<T> toDynamic(Dynamic<T> dynamic) {
		return null;
	}
}
