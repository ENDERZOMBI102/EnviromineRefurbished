package com.enderzombi102.emr.component;

import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;

import com.enderzombi102.emr.registry.EmrComponentRegistry;

public class Components implements EntityComponentInitializer {

	@Override
	@SuppressWarnings({"experimental", "UnstableApiUsage"})
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerForPlayers(
				EmrComponentRegistry.PLAYER_DATA_TRACKER,
				PlayerDataTrackerImpl::new
		);
	}

}
