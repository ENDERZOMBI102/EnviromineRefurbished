package com.enderzombi102.emr.imixin;

public interface FoodRotItemStack {
	int emr$getRotPercentage();
	int emr$getDaysPassed();
	int emr$getRemainingDays();
	int emr$getRequiredDaysToRot();
	void emr$rot();
}
