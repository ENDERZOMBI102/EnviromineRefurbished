package com.enderzombi102.emr;

import com.enderzombi102.emr.component.PlayerDataTracker;
import com.enderzombi102.emr.item.ItemRottenFood;
import com.enderzombi102.emr.item.armor.*;
import com.enderzombi102.emr.item.bottle.ItemBadWaterBottle;
import com.enderzombi102.emr.item.bottle.ItemColdWaterBottle;
import com.enderzombi102.emr.item.bottle.ItemSaltWaterBottle;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Content {

	// materials
	public static EnviroMaterial enviroMaterial = new EnviroMaterial();

	// items
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

	// components
	public static final ComponentKey<PlayerDataTracker> PLAYER_DATA_TRACKER = ComponentRegistry.getOrCreate(
			new Identifier("emr:component.playerdatatracker"),
			PlayerDataTracker.class
	);

	// sound indentifiers
	public static final Identifier SOUND_WHISPERS_ID = new Identifier("emr:whispers");

	// sound events
	public static final SoundEvent SOUND_WHISPERS = new SoundEvent(SOUND_WHISPERS_ID);



}
