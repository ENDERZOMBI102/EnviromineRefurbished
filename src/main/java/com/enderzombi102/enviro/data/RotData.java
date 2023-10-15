package com.enderzombi102.enviro.data;

import com.enderzombi102.enviro.api.RotProvider;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class RotData {

	private static final HashMap<Identifier, Integer> ROT_DAYS = new HashMap<>() {{
		put( new Identifier( "minecraft", "potato" ), 10 );
	}};

	public static int getRequiredDaysToRot( @NotNull Item item ) {
		if ( item instanceof RotProvider provider )
			return provider.getRotDays();

		return ROT_DAYS.getOrDefault( Registry.ITEM.getId( item ), 3 );
	}
}
