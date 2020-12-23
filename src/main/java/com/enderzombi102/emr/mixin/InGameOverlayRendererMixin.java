package com.enderzombi102.emr.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {

	@Inject(method = "renderOverlays", at = @At("INVOKE") )
	private static void onRenderOverlays(MinecraftClient client, MatrixStack matrixStack, CallbackInfo info) {

		//OverlayRenderer.renderOverlays(client, matrixStack);

	}






}
