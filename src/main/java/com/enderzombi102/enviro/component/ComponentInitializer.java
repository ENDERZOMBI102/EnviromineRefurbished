package com.enderzombi102.enviro.component;

import com.enderzombi102.enviro.registry.ItemRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;

import com.enderzombi102.enviro.registry.CompRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import net.minecraft.item.Items;

@SuppressWarnings( "UnstableApiUsage" )
public class ComponentInitializer implements EntityComponentInitializer, ItemComponentInitializer {
	@Override
	@SuppressWarnings( "experimental" )
	public void registerEntityComponentFactories( EntityComponentFactoryRegistry registry ) {
		registry.registerForPlayers( CompRegistry.PLAYER_DATA_TRACKER, PlayerDataTrackerImpl::new );
	}

	@Override
	public void registerItemComponentFactories( ItemComponentFactoryRegistry registry ) {
		registry.register(
			Items.WATER_BUCKET,
			CompRegistry.WATER_CONTAINER_ITEM_COMPONENT,
			WaterContainerItemComponentImpl::new
		);
		registry.register(
			Items.POTION,
			CompRegistry.WATER_CONTAINER_ITEM_COMPONENT,
			WaterContainerItemComponentImpl::new
		);
		registry.register(
			comp -> comp.isFood() && comp.asItem() != ItemRegistry.get( "rotten_food" ),
			CompRegistry.ROTTING_FOOD_ITEM_COMPONENT,
			RottingFoodComponentImpl::new
		);
	}
}
