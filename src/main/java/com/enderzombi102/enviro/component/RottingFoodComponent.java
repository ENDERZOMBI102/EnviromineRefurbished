package com.enderzombi102.enviro.component;

import net.minecraft.inventory.Inventory;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public interface RottingFoodComponent {
	int getRotPercentage( @NotNull World world );

	int getDaysPassed( @NotNull World world );

	int getRemainingDays( @NotNull World world );

	int getRequiredDaysToRot();

	void rot( @NotNull Inventory inventory, @NotNull World world );
}
