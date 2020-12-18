package com.enderzombi102.emr.handler;

import com.enderzombi102.emr.Content;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistrationHandler {

	public static void registerItems() {
		Registry.register( Registry.ITEM,"emr:air_filter", Content.airFilter);
		Registry.register( Registry.ITEM, "emr:rotten_food", Content.rottenFood );
		// armor
		Registry.register( Registry.ITEM, "emr:air_mask", Content.airMask );
		Registry.register( Registry.ITEM, "emr:camel_pack", Content.camelPack );
		Registry.register( Registry.ITEM, "emr:hard_hat", Content.hardHat );
		Registry.register( Registry.ITEM, "emr:gas_mask", Content.gasMask );
		// bottles
		Registry.register( Registry.ITEM, "emr:bad_water_bottle", Content.badWaterBottle);
		Registry.register( Registry.ITEM, "emr:salty_water_bottle", Content.saltWaterBottle);
		Registry.register( Registry.ITEM, "emr:cold_water_bottle", Content.coldWaterBottle);
	}

	public static void registerSounds() {
		Registry.register( Registry.SOUND_EVENT, Content.SOUND_WHISPERS_ID, Content.SOUND_WHISPERS );
	}

}
