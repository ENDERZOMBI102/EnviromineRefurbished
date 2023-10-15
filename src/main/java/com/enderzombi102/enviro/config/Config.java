package com.enderzombi102.enviro.config;

import com.enderzombi102.enviro.config.data.ConfigData;

public class Config {
	private static final ConfigData DATA = new ConfigData();

	public static ConfigData get() {
		return DATA;
	}
}
