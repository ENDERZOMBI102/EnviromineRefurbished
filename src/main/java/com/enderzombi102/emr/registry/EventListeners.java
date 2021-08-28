package com.enderzombi102.emr.registry;

import com.enderzombi102.emr.EnviromineRefurbished;
import com.enderzombi102.emr.component.PlayerDataTrackerImpl;
import com.enderzombi102.emr.config.ConfigManager;
import com.enderzombi102.emr.config.data.MainConfig;
import com.google.gson.JsonSyntaxException;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Style;
import net.minecraft.text.TextColor;
import net.minecraft.text.TranslatableText;


import static com.enderzombi102.emr.util.Const.CONFIG_SYNC_ID;
import static com.enderzombi102.emr.util.Const.MOD_VERSION;

public final class EventListeners {

	private EventListeners() {}

	public static void register() {
		ServerEntityEvents.ENTITY_LOAD.register( (entity, serverWorld) -> {
			if (entity instanceof PlayerEntity) {
				ComponentRegistry.getOrCreate(
						EmrComponentRegistry.PLAYER_DATA_TRACKER.getId(),
						PlayerDataTrackerImpl.class
				);
			}
		});
	}

	public static void registerClient() {
		ClientPlayNetworking.registerGlobalReceiver(
				CONFIG_SYNC_ID,
				(client, networkHandler, data, sender) -> {
					MainConfig config = null;
					try {
						if ( MOD_VERSION.equals( data.readString() ) )
							config = ConfigManager.CONFIG_GSON.fromJson(data.readString(), MainConfig.class);
					} catch (JsonSyntaxException e) {
						EnviromineRefurbished.LOGGER.error("Can't parse config!", e);
					}
					if (config == null)
						EnviromineRefurbished.LOGGER.warn(
								"Failed to load synced config, falling back to local config!"
						);

					MainConfig finalConfig = config;
					client.execute(() -> {
						ConfigManager.loadConfig(finalConfig);
						ConfigManager.onLoad();
					});
				}
		);
		ItemTooltipCallback.EVENT.register(
				(stack, ctx, lines) -> {
					if (
							stack.getItem() == Items.WATER_BUCKET ||
							(
									stack.getItem() == Items.POTION &&
									stack.getNbt() != null &&
									stack.getNbt().getString("Potion").equals("minecraft:water")
							)
					) {
						var comp = EmrComponentRegistry
								.WATER_CONTAINER_ITEM_COMPONENT
								.get( stack );
						if ( comp.isSalty() )
							lines.add(
									new TranslatableText("tooltip.emr.item.water_container.salty")
											.setStyle( Style.EMPTY.withColor( TextColor.parse("gray") ) )
							);
						if ( comp.isDirty() )
							lines.add(
									new TranslatableText("tooltip.emr.item.water_container.dirty")
											.setStyle( Style.EMPTY.withColor( TextColor.parse("gray") ) )
							);
						if ( comp.isCold() )
							lines.add(
								new TranslatableText("tooltip.emr.item.water_container.cold")
										.setStyle( Style.EMPTY.withColor( TextColor.parse("gray") ) )
							);
					}
				}
		);
	}
}
