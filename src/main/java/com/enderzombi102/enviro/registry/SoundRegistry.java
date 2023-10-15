package com.enderzombi102.enviro.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.enderzombi102.enviro.EnviromineRefurbished.getId;

public class SoundRegistry {

	public static final Identifier SOUND_WHISPERS_ID = getId("whispers");
	public static final SoundEvent SOUND_WHISPERS = new SoundEvent(SOUND_WHISPERS_ID);

	public static void registerClient() {
		Registry.register( Registry.SOUND_EVENT, SOUND_WHISPERS_ID, SOUND_WHISPERS );
	}

}
