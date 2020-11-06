package com.enderzombi102.emr;

import com.enderzombi102.emr.handler.RegistrationHandler;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@EnvironmentInterface(value = EnvType.CLIENT, itf = ClientModInitializer.class)
public class EnviromineRefurbished implements ClientModInitializer, ModInitializer {

	public static EnviromineRefurbished instance = null;
	public static final ItemGroup EnviroTab = FabricItemGroupBuilder.build(
			new Identifier("emr", "envirotab"),
			() -> new ItemStack( Content.airMask )
	);

	public EnviromineRefurbished() {
		instance = this;
	}


	@Override
	public void onInitialize() {
		RegistrationHandler.registerItems();
	}

	@Environment(EnvType.CLIENT)
	@Override
	public void onInitializeClient() {

	}
}
