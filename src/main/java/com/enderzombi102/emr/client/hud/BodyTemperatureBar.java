package com.enderzombi102.emr.client.hud;

import com.enderzombi102.emr.Content;
import net.minecraft.client.MinecraftClient;

public class BodyTemperatureBar extends HudBar {

	// TODO: finish this

	public BodyTemperatureBar() {
		this.width = 64;
		this.height = 8;
		this.row = 4;
	}

	@Override
	public int getU() {
		return 0;
	}

	@Override
	public float getFullLenght() {
		return ( Content.PLAYER_DATA_TRACKER.get(MinecraftClient.getInstance().player).bodyTemp / 100 ) * this.getWidth();
	}

	@Override
	public boolean blinking() {
		float temp = Content.PLAYER_DATA_TRACKER.get(MinecraftClient.getInstance().player).bodyTemp;
		return temp < 35 && temp > 39;
	}
}
