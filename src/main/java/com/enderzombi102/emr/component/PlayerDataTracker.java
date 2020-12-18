package com.enderzombi102.emr.component;

import com.enderzombi102.emr.utils.PlayerSleepState;
import com.mojang.serialization.Dynamic;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;
import static com.enderzombi102.emr.EnviromineRefurbished.LOGGER;

public class PlayerDataTracker implements IPlayerDataTracker {

//	public float prevBodyTemp = 37F;
//	public float prevHydration = 100F;
//	public float prevAirQuality = 100;
//	public float prevSanity = 100F;

	public PlayerEntity player;

	// bar-red properies
	public float gasAirDiff = 0F;
	public float bodyTemp = 0F;
	public float airTemp;
	public float hydration;
	public float wetness;
	public float sanity;

	public float airQuality;
	public int attackDelay = 1;
	public int curAttackTime = 0;

	// thing properties
	public boolean isTargettedByTheThing = false;
	public int thing = 0;

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

	public PlayerDataTracker(PlayerEntity playerEntity) {
		this.player = playerEntity;
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
		if( getWorld().getPlayerByUuid( this.player.getUuid() ) == null ) {
			return;
		}
		if(this.bodyTemp == 20F) {
			LOGGER.info("1t passed");
			this.bodyTemp = 0F;
		}
		else this.bodyTemp += 1F;
	}

	private World getWorld() {
		return this.player.getEntityWorld();
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
		tag.putFloat("wetness", this.wetness);
		tag.putFloat("sanity", this.sanity);
	}

	@Override
	public void applySyncPacket(PacketByteBuf buf) {
		CompoundTag tag = buf.readCompoundTag();
		this.airQuality = tag.getFloat("airQuality");
		this.bodyTemp = tag.getFloat("bodytemp");
		this.airTemp = tag.getFloat("airTemp");
		this.hydration = tag.getFloat("hydration");
		this.wetness = tag.getFloat("wetness");
		this.sanity = tag.getFloat("sanity");
	}

	@Override
	public void fromDynamic(Dynamic<?> dynamic) {

	}

	@Override
	public <T> Dynamic<T> toDynamic(Dynamic<T> dynamic) {
		return null;
	}
}
