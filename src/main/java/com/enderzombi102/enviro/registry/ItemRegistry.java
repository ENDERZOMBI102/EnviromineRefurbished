package com.enderzombi102.enviro.registry;

import com.enderzombi102.enviro.EnviromineRefurbished;
import com.enderzombi102.enviro.item.RottenFoodItem;
import com.enderzombi102.enviro.item.armor.AirMaskItem;
import com.enderzombi102.enviro.item.armor.CamelPackItem;
import com.enderzombi102.enviro.item.armor.HardHatItem;
import com.enderzombi102.enviro.item.armor.GasMaskItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static com.enderzombi102.enviro.EnviromineRefurbished.getID;

public class ItemRegistry {

	private static final HashMap<String, Item> ITEMS = new HashMap<String, Item>() {{
		put( "air_filter", new Item( new Item.Settings().group(EnviromineRefurbished.EnviroTab) ) );
		put( "air_mask", new AirMaskItem() );
		put( "camel_pack", new CamelPackItem() );
		put( "hard_hat", new HardHatItem() );
		put( "gas_mask", new GasMaskItem() );
		put( "rotten_food", new RottenFoodItem() );
	}};

	public static void register() {
		for ( Map.Entry<String, Item> item : ITEMS.entrySet() ) {
			Registry.register(
					Registry.ITEM,
					getID( item.getKey() ),
					item.getValue()
			);
		}
	}

	public static Item get(String itemId) {
		return ITEMS.getOrDefault(itemId, Items.AIR);
	}

	public static void registerClient() {

	}

}
