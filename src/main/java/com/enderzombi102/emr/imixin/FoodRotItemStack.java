package com.enderzombi102.emr.imixin;

import net.minecraft.world.World;

public interface FoodRotItemStack {
	int emr$getRotPercentage(World world);
	int emr$getDaysPassed(World world);
	int emr$getRemainingDays(World world);
	int emr$getRequiredDaysToRot();
	void emr$rot(World world);
}
