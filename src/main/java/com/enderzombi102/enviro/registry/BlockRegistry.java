package com.enderzombi102.enviro.registry;

import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

import static com.enderzombi102.enviro.EnviromineRefurbished.getID;

public class BlockRegistry {

	private static final HashMap<String, Block> BLOCKS = new HashMap<String, Block>() {{

	}};

	public static void register() {
		for ( Map.Entry<String, Block> entry : BLOCKS.entrySet() ) {
			Registry.register(
					Registry.BLOCK,
					getID( entry.getKey() ),
					entry.getValue()
			);
		}
	}


}
