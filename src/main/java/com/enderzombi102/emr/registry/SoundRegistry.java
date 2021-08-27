package com.enderzombi102.emr.registry;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.enderzombi102.emr.EnviromineRefurbished.getID;

public class SoundRegistry {

	public static final Identifier SOUND_WHISPERS_ID = getID("whispers");
	public static final SoundEvent SOUND_WHISPERS = new SoundEvent(SOUND_WHISPERS_ID);

	public static void registerClient() {
		Registry.register( Registry.SOUND_EVENT, SOUND_WHISPERS_ID, SOUND_WHISPERS );
	}

}
