package com.enderzombi102.enviro.config;

import com.enderzombi102.enviro.EnviromineRefurbished;
import com.enderzombi102.enviro.util.Const;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import org.jetbrains.annotations.Nullable;

@Config( name = Const.MOD_NAME )
public class ModConfig implements ConfigData {

	@ConfigEntry.Gui.Excluded
	private static ModConfig CURRENT_CONFIG = null;

	private ModConfig() {}

	public static ModConfig getLoadedConfig() {
		if (CURRENT_CONFIG == null) CURRENT_CONFIG = getHolder().getConfig();

		return CURRENT_CONFIG;
	}

	public static void loadConfig(@Nullable ModConfig config) {
		if (config == null) config = getHolder().getConfig();

		CURRENT_CONFIG = config;
	}

	public static ConfigHolder<ModConfig> getHolder() {
		return AutoConfig.getConfigHolder(ModConfig.class);
	}

	public PacketByteBuf toPacketByteBuf() {
		String config = EnviromineRefurbished.JANKSON.toJson(this).toJson();
		PacketByteBuf buf = PacketByteBufs.create();
		buf.writeString(config);
		return buf;
	}
}
