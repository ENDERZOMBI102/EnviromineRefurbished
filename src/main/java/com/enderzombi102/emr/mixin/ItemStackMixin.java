package com.enderzombi102.emr.mixin;

import com.enderzombi102.emr.config.ConfigManager;
import com.enderzombi102.emr.imixin.FoodRotItemStack;
import com.enderzombi102.emr.registry.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * PURPOSE: FOOD ROT MECHANICS
 */

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements FoodRotItemStack {

	@Unique
	private int rotPercent = 0;

	@Shadow public abstract Item getItem();

	@Shadow
	@Final
	@Deprecated
	@Mutable
	private Item item;

	@Inject( method = "inventoryTick", at = @At("HEAD") )
	public void onInventoryTick(World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
		if ( ConfigManager.getLoadedConfig().rottingMechanic.enabled && this.getItem().isFood() ) {
			emr$rot();
		}
	}

	@Override
	public int emr$getRotPercentage() {
		return rotPercent;
	}

	@Override
	public void emr$rot() {
		rotPercent++;
		if ( rotPercent > 99 ) {
			// its rotten
			this.item = ItemRegistry.get("rotten_food");
		}
	}
}
