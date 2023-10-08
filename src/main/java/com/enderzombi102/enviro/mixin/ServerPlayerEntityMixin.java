package com.enderzombi102.enviro.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerRecipeBook;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {

	@Shadow @Final private ServerRecipeBook recipeBook;

	public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
		super(world, pos, yaw, profile);
	}

	@Inject(method = "handleFall", at = @At(value = "TAIL", target = "Lnet/minecraft/entity/LivingEntity;fall(DZLnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)V") )
	public void onHandleFall(double heightDifference, boolean onGround, CallbackInfo info) {
		if ( heightDifference >= 0.0 ) return;
		LOGGER.info("falled " + Double.valueOf( this.fallDistance - heightDifference).intValue() + " blocks.");
		// TODO: add bone break mechanic
	}
}
