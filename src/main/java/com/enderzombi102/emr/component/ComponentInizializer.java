package com.enderzombi102.emr.component;

import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;

import static com.enderzombi102.emr.Content.PLAYER_DATA_TRACKER;

public class ComponentInizializer implements EntityComponentInitializer {

	@Override
	@SuppressWarnings({"unchecked", "experimental"})
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerForPlayers(PLAYER_DATA_TRACKER, PlayerDataTracker::new);
	}

}
