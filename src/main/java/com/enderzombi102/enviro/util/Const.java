package com.enderzombi102.enviro.util;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public final class Const {
	private Const() {}

	public static final String MOD_NAME = "Enviromine Refurbished";
	public static final String MOD_ID = "enviromr";
	public static final String MOD_VERSION = getMetadata()
			.getVersion()
			.getFriendlyString();

	private static ModContainer getContainer() {
		return FabricLoader.getInstance()
				.getModContainer(MOD_ID)
				.orElseThrow();
	}

	private static ModMetadata getMetadata() {
		return getContainer().getMetadata();
	}

	public static Identifier getId( @NotNull String path ) {
		return new Identifier( MOD_ID, path );
	}
}
