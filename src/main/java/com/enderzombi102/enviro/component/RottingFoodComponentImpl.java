package com.enderzombi102.enviro.component;

import com.enderzombi102.enviro.data.RotData;
import com.enderzombi102.enviro.registry.ItemRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponent;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class RottingFoodComponentImpl extends ItemComponent implements RottingFoodComponent {
	private long rotSpawnTime = 0;

	public RottingFoodComponentImpl( @NotNull ItemStack stack ) {
		super( stack );
	}


	@Override
	public int getRotPercentage( @NotNull World world ) {
		return ( this.getRequiredDaysToRot() % 100 ) * this.getDaysPassed( world );
	}

	@Override
	public void rot( @NotNull Inventory inventory, @NotNull World world ) {
		// its rotten
		if ( ( world.getTime() - this.rotSpawnTime ) > this.getRequiredDaysToRot() * 24000L ) {

			this.stack = ItemRegistry.get( "rotten_food" );
		}
	}

	@Override
	public int getDaysPassed( @NotNull World world ) {
		return (int) ( ( world.getTime() - this.rotSpawnTime ) / 24000L );
	}

	@Override
	public int getRemainingDays( @NotNull World world ) {
		return this.getDaysPassed( world ) > this.getRequiredDaysToRot() ? 0 : this.getDaysPassed( world ) - this.getRequiredDaysToRot();
	}

	@Override
	public int getRequiredDaysToRot() {
		return RotData.getRequiredDaysToRot( this.stack.getItem() );
	}
}
