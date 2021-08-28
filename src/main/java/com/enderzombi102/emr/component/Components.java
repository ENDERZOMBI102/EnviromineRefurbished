package com.enderzombi102.emr.component;

import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;

import com.enderzombi102.emr.registry.EmrComponentRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import net.minecraft.item.Items;

@SuppressWarnings("UnstableApiUsage")
public class Components implements EntityComponentInitializer, ItemComponentInitializer {

	@Override
	@SuppressWarnings("experimental")
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerForPlayers(
				EmrComponentRegistry.PLAYER_DATA_TRACKER,
				PlayerDataTrackerImpl::new
		);
	}

	@Override
	public void registerItemComponentFactories(ItemComponentFactoryRegistry registry) {
		registry.register(
				Items.WATER_BUCKET,
				EmrComponentRegistry.WATER_CONTAINER_ITEM_COMPONENT,
				WaterContainerItemComponentImpl::new
		);
		registry.register(
				Items.POTION,
				EmrComponentRegistry.WATER_CONTAINER_ITEM_COMPONENT,
				WaterContainerItemComponentImpl::new
		);
	}
}
