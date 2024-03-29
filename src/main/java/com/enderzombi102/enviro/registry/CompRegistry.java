package com.enderzombi102.enviro.registry;

import com.enderzombi102.enviro.component.RottingFoodComponentImpl;
import com.enderzombi102.enviro.component.PlayerDataTrackerImpl;
import com.enderzombi102.enviro.component.WaterContainerItemComponentImpl;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;

import static com.enderzombi102.enviro.EnviromineRefurbished.getId;

public class CompRegistry {

	public static final ComponentKey<PlayerDataTrackerImpl> PLAYER_DATA_TRACKER = ComponentRegistry.getOrCreate(
		getId( "component.entity.playerdatatracker" ),
		PlayerDataTrackerImpl.class
	);

	public static final ComponentKey<WaterContainerItemComponentImpl> WATER_CONTAINER_ITEM_COMPONENT = ComponentRegistry.getOrCreate(
		getId( "component.item.water_container" ),
		WaterContainerItemComponentImpl.class
	);


	public static final ComponentKey<RottingFoodComponentImpl> ROTTING_FOOD_ITEM_COMPONENT = ComponentRegistry.getOrCreate(
		getId( "component.item.food_component" ),
		RottingFoodComponentImpl.class
	);
}