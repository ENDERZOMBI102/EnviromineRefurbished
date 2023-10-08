package com.enderzombi102.enviro;

import com.enderzombi102.enviro.config.ModConfig;
import com.enderzombi102.enviro.registry.EventListeners;
import com.enderzombi102.enviro.registry.BlockEntityRegistry;
import com.enderzombi102.enviro.registry.BlockRegistry;
import com.enderzombi102.enviro.registry.ItemRegistry;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Jankson;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.enderzombi102.enviro.util.Const.MOD_ID;

public class EnviromineRefurbished implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("EMR");
	public static final Jankson JANKSON = new Jankson.Builder().build();

	public static final ItemGroup EnviroTab = FabricItemGroupBuilder.build(
			getID("envirotab"),
			() -> new ItemStack( ItemRegistry.get("camel_pack") )
	);

	@Override
	public void onInitialize() {
		AutoConfig.register( ModConfig.class, JanksonConfigSerializer::new );
		BlockRegistry.register();
		BlockEntityRegistry.register();
		ItemRegistry.register();
		EventListeners.register();
		LOGGER.info( prefix("Enviromine Refurbished loaded!") );
	}

	public static String prefix(String msg) {
		return "[EMR] " + msg;
	}

	public static Identifier getID(String path) {
		return new Identifier(MOD_ID, path);
	}
}
