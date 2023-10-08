package com.enderzombi102.enviro.config;

import com.enderzombi102.enviro.util.Const;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.enderzombi102.enviro.gui.MainScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.LiteralText;

@Environment(EnvType.CLIENT)
public class ModmenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		//return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
		return parent -> new MainScreen( new LiteralText( Const.MOD_NAME ), parent);
	}
}

