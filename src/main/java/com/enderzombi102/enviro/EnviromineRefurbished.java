package com.enderzombi102.enviro;

import com.enderzombi102.enviro.registry.BlockEntityRegistry;
import com.enderzombi102.enviro.registry.BlockRegistry;
import com.enderzombi102.enviro.registry.EventListeners;
import com.enderzombi102.enviro.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.enderzombi102.enviro.util.Const.getId;

public class EnviromineRefurbished implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger( "EMR" );

	public static final ItemGroup EnviroTab = FabricItemGroupBuilder.build(
		getId( "envirotab" ),
		() -> new ItemStack( ItemRegistry.get( "camel_pack" ) )
	);

	@Override
	public void onInitialize() {
		BlockRegistry.register();
		BlockEntityRegistry.register();
		ItemRegistry.register();
		EventListeners.register();
		LOGGER.info( "[EMR] Enviromine Refurbished loaded!" );
	}
}
