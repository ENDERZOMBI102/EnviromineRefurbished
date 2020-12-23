package com.enderzombi102.emr.client.hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class OverlayRenderer extends DrawableHelper {

	public static final Identifier BARS = new Identifier("emr:textures/gui/gui_status.png");
	public static ArrayList<HudBar> HudBars = new ArrayList<>();
	static {
		HudBars.add( new AirQualityBar() );
	}

	public static void renderOverlays(MinecraftClient client, MatrixStack stack) {

		// TODO: figure out why the second draw overwrites the first even with alpha

		client.getTextureManager().bindTexture(BARS);

		for (HudBar bar : HudBars) {
			drawTexture(
					stack,
					bar.getX(),
					bar.getY(),
					1,
					bar.getU(),
					bar.getV(),
					64,
					8,
					256,
					256
			);
			// frame
			drawTexture(
					stack,
					bar.getX(),
					bar.getY(),
					2,
					0,
					bar.blinking() ? 40 : 32,
					64,
					8,
					256,
					256
			);
		}

	}




}
