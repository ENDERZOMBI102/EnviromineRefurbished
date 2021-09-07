package com.enderzombi102.emr.mixin;

import com.enderzombi102.emr.config.ConfigManager;
import com.enderzombi102.emr.data.RotData;
import com.enderzombi102.emr.imixin.FoodRotItemStack;
import com.enderzombi102.emr.registry.ItemRegistry;
import net.minecraft.entity.Entity;
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
	private long rotSpawnTime = 0;

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
		if (
				ConfigManager.getLoadedConfig().rottingMechanic.enabled &&
				this.getItem().isFood() &&
				this.getItem() != ItemRegistry.get("rotten_food")
		) {
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

	@Override
	public int emr$getRotPercentage(World world) {
		return ( emr$getRequiredDaysToRot() % 100  ) * emr$getDaysPassed(world);
	}

	@Override
	public void emr$rot(World world) {
		if ( ( world.getTime() - rotSpawnTime ) > emr$getRequiredDaysToRot() * 24000L ) {
			// its rotten
			this.item = ItemRegistry.get("rotten_food");
		}
	}

	@Override
	public int emr$getDaysPassed(World world) {
		return (int) ( ( world.getTime() - rotSpawnTime ) / 24000L );
	}

	@Override
	public int emr$getRemainingDays(World world) {
		return emr$getDaysPassed(world) > emr$getRequiredDaysToRot() ? 0 : emr$getDaysPassed(world) - emr$getRequiredDaysToRot();
	}

	@Override
	public int emr$getRequiredDaysToRot() {
		return RotData.getRequiredDaysToRot( getItem() );
	}

}
