package com.enderzombi102.enviro.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( ServerPlayerEntity.class )
public abstract class ServerPlayerEntityMixin extends PlayerEntity {
	@Shadow
	@Final
	private static Logger LOGGER;

	public ServerPlayerEntityMixin( World world, BlockPos pos, float yaw, GameProfile gameProfile, @Nullable PlayerPublicKey publicKey ) {
		super( world, pos, yaw, gameProfile, publicKey );
	}

	@Inject( method = "handleFall", at = @At( value = "TAIL", target = "Lnet/minecraft/entity/LivingEntity;fall(DZLnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;)V" ) )
	public void onHandleFall( double heightDifference, boolean onGround, CallbackInfo info ) {
		if ( heightDifference >= 0.0 )
			return;

		LOGGER.info( "fell {} blocks.", (int) ( this.fallDistance - heightDifference ) );
		// TODO: add bone break mechanic
	}
}
