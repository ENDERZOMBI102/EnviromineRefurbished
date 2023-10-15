package com.enderzombi102.enviro.mixin;

import com.enderzombi102.enviro.config.Config;
import com.enderzombi102.enviro.config.ConfigManager;
import com.enderzombi102.enviro.data.RotData;
import com.enderzombi102.enviro.imixin.FoodRotItemStack;
import com.enderzombi102.enviro.registry.ItemRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * PURPOSE: FOOD ROT MECHANICS
 */

@SuppressWarnings("DeprecatedIsStillUsed")
@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements FoodRotItemStack {
	@Unique


	@Shadow
	public abstract Item getItem();

	@Shadow
	@Final
	@Deprecated
	@Mutable
	private Item item;

	@Shadow public abstract boolean isFood();

	@Inject( method = "inventoryTick", at = @At("HEAD") )
	public void onInventoryTick(World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
		if (! Config.get().rottingMechanic.enabled )
			return;

		if ( this.getItem().isFood() && this.getItem() != ItemRegistry.get( "rotten_food" ) ) {
			if ( entity instanceof PlayerEntity player && player.isCreative() ) {
				// creative player, are we in the creative or surv itemgroup?
				
			}
			emr$rot(world);
		}
	}

	@Inject( method = "<init>(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("TAIL") )
	public void onDeserialize(NbtCompound nbt, CallbackInfo ci) {
		if ( isFood() && this.getItem() != ItemRegistry.get("rotten_food") )
			rotSpawnTime = nbt.getLong("EMR_ROT_SPAWN_TIME");

	}

	@Inject( method = "writeNbt", at = @At("TAIL") )
	public void onSerialize(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
		if ( isFood() && this.getItem() != ItemRegistry.get("rotten_food") )
			nbt.putLong( "EMR_ROT_SPAWN_TIME", rotSpawnTime );
	}


}
