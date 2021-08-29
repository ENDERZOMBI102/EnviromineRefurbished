package com.enderzombi102.emr.data;

import com.enderzombi102.emr.api.RotProvider;
import com.enderzombi102.emr.util.Utils;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class RotData {

	private static final HashMap<Identifier, Integer> ROT_DAYS = new HashMap<>() {{
		put( new Identifier("minecraft", "potato"), 10 );
	}};

	public static int getRequiredDaysToRot(Item item) {
		if ( item instanceof RotProvider provider ) {
			return provider.getRotDays();
		}
		return ROT_DAYS.getOrDefault( Utils.getIdentifier(item), 3 );
	}


}
