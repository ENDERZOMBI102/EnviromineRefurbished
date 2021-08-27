package com.enderzombi102.emr;

import com.enderzombi102.emr.registry.EventListeners;
import com.enderzombi102.emr.registry.ItemRegistry;
import com.enderzombi102.emr.registry.SoundRegistry;
import net.fabricmc.api.ClientModInitializer;

public class EnviromineRefurbishedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ItemRegistry.registerClient();
		SoundRegistry.registerClient();
		EventListeners.registerClient();
	}
}
