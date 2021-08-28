package com.enderzombi102.emr.gui;

import com.enderzombi102.emr.config.data.MainConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class MainScreen extends Screen {
	private final Screen parent;

	public MainScreen(Text title, Screen parent) {
		super(title);
		this.parent = parent;
	}

	@Override
	protected void init() {
		addDrawableChild(
				new ButtonWidget(
						this.width / 2 - 155,
						this.height / 6 + 48 - 6,
						150,
						20,
						new TranslatableText("gui.gwwhit.config"),
						(button) -> this.client.setScreen(
								AutoConfig.getConfigScreen(MainConfig.class, this).get()
						)
				)
		);
		addDrawableChild(
				new ButtonWidget(
						this.width / 2 + 5,
						this.height / 6 + 48 - 6,
						150,
						20,
						new TranslatableText("gui.gwwhit.reload"),
						(button) -> MinecraftClient.getInstance().reloadResources()
				)
		);
		addDrawableChild(
				new ButtonWidget(
						this.width / 2 - 100,
						this.height / 6 + 168,
						200,
						20,
						ScreenTexts.DONE,
						(button) -> client.setScreen(this.parent)
				)
		);
	}

	@Override
	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		renderBackground(matrices);
		drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
		super.render(matrices, mouseX, mouseY, delta);
	}


}
