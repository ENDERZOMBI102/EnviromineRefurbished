package com.enderzombi102.emr.component;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;

@SuppressWarnings("UnstableApiUsage")
public interface PlayerDataTracker extends PlayerComponent<PlayerDataTracker>, AutoSyncedComponent, ServerTickingComponent {}
