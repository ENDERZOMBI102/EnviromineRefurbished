package com.enderzombi102.emr.handler;

import com.enderzombi102.emr.Content;
import com.enderzombi102.emr.component.PlayerDataTracker;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.player.PlayerEntity;

public class EventHandlers {

	static {
		ServerEntityEvents.ENTITY_LOAD.register( (entity, serverWorld) -> {
			if (entity instanceof PlayerEntity) {
				ComponentRegistry.getOrCreate(Content.PLAYER_DATA_TRACKER.getId(), PlayerDataTracker.class);
			}
		} );
	}

}
