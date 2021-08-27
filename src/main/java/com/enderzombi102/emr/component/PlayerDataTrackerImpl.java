package com.enderzombi102.emr.component;

import net.minecraft.nbt.NbtCompound;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("UnstableApiUsage")
public class PlayerDataTrackerImpl implements PlayerDataTracker {


	@Override
	public void serverTick() {

	}

	@Override
	public void readFromNbt(@NotNull NbtCompound tag) {

	}

	@Override
	public void writeToNbt(@NotNull NbtCompound tag) {

	}

	@Override
	public boolean shouldCopyForRespawn(boolean lossless, boolean keepInventory) {
		return false;
	}
}
