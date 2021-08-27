package com.enderzombi102.emr.registry;

import com.enderzombi102.emr.component.PlayerDataTrackerImpl;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;

import static com.enderzombi102.emr.EnviromineRefurbished.getID;

public class EmrComponentRegistry {

	public static final ComponentKey<PlayerDataTrackerImpl> PLAYER_DATA_TRACKER = ComponentRegistry.getOrCreate(
			getID("component.playerdatatracker"),
			PlayerDataTrackerImpl.class
	);




}