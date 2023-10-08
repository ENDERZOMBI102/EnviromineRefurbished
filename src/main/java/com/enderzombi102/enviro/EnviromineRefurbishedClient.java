package com.enderzombi102.enviro;

import com.enderzombi102.enviro.registry.EventListeners;
import com.enderzombi102.enviro.registry.ItemRegistry;
import com.enderzombi102.enviro.registry.SoundRegistry;
import net.fabricmc.api.ClientModInitializer;

public class EnviromineRefurbishedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ItemRegistry.registerClient();
		SoundRegistry.registerClient();
		EventListeners.registerClient();
	}
}
