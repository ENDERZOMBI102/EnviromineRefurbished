package com.enderzombi102.emr.client.hud;

import com.enderzombi102.emr.Content;
import net.minecraft.client.MinecraftClient;

public class AirQualityBar extends HudBar {

	// TODO: finish this

	public AirQualityBar() {
		this.width = 64;
		this.height = 8;
		this.row = 2;
		this.x = 0;
	}

	@Override
	public float getFullLenght() {
		return ( Content.PLAYER_DATA_TRACKER.get(MinecraftClient.getInstance().player).airQuality / 100 ) * this.getWidth();
	}

	@Override
	public boolean blinking() {
		return Content.PLAYER_DATA_TRACKER.get(MinecraftClient.getInstance().player).airQuality < 25;
	}


}
