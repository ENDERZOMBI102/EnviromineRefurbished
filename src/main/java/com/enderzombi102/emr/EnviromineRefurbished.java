package com.enderzombi102.emr;

import net.fabricmc.api.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@EnvironmentInterface(value = EnvType.CLIENT, itf = ClientModInitializer.class)
public class EnviromineRefurbished implements ClientModInitializer, ModInitializer {

	public static final Item FABRIC_ITEM = new Item( new FabricItemSettings().group(ItemGroup.MISC) );

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("emr", "item"), FABRIC_ITEM);
	}

	@Environment(EnvType.CLIENT)
	@Override
	public void onInitializeClient() {

	}
}
