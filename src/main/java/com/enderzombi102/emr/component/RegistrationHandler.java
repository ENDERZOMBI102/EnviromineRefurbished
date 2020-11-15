package com.enderzombi102.emr.component;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import net.minecraft.util.Identifier;

public class RegistrationHandler implements EntityComponentInitializer {

	public static final ComponentKey<PlayerDataTracker> MAGIK = ComponentRegistry.getOrCreate(
			new Identifier("emr", "component.playerdatatracker"),
			PlayerDataTracker.class
	);



	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerForPlayers();
	}

}
