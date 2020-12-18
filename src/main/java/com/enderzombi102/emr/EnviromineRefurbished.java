package com.enderzombi102.emr;

import com.enderzombi102.emr.advancement.Advancements;
import com.enderzombi102.emr.handler.RegistrationHandler;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EnvironmentInterface(value = EnvType.CLIENT, itf = ClientModInitializer.class)
public class EnviromineRefurbished implements ClientModInitializer, ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("EMR");

	public static final ItemGroup EnviroTab = FabricItemGroupBuilder.build(
			new Identifier("emr", "envirotab"),
			() -> new ItemStack( Content.airMask )
	);

	@Override
	public void onInitialize() {
		RegistrationHandler.registerItems();
		Advancements.initAdvancements();
	}

	@Environment(EnvType.CLIENT)
	@Override
	public void onInitializeClient() {
	}
}
