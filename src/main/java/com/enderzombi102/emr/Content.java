package com.enderzombi102.emr;

import com.enderzombi102.emr.item.ItemRottenFood;
import com.enderzombi102.emr.item.armor.*;
import com.enderzombi102.emr.item.bottle.ItemBadWaterBottle;
import com.enderzombi102.emr.item.bottle.ItemColdWaterBottle;
import com.enderzombi102.emr.item.bottle.ItemSaltWaterBottle;
import net.minecraft.item.Item;

public class Content {

	public static EnviroMaterial enviroMaterial = new EnviroMaterial();
	public static Item airFilter = new Item( new Item.Settings().group(EnviromineRefurbished.EnviroTab) );
	public static Item airMask = new ItemAirMask();
	public static Item camelPack = new ItemCamelPack();
	public static Item hardHat = new ItemHardHat();
	public static Item gasMask = new ItemGasMask();
	public static Item rottenFood = new ItemRottenFood();
	// bottles
	public static Item badWaterBottle = new ItemBadWaterBottle();
	public static Item coldWaterBottle = new ItemColdWaterBottle();
	public static Item saltWaterBottle = new ItemSaltWaterBottle();





}
