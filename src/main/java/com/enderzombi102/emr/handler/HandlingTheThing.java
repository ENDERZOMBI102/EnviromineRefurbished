package com.enderzombi102.emr.handler;

import com.enderzombi102.emr.Content;
import com.enderzombi102.emr.EnviroDamageSource;
import com.enderzombi102.emr.advancement.Advancements;
import com.enderzombi102.emr.component.PlayerDataTracker;
import com.enderzombi102.emr.config.ConfigData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Calendar;

public class HandlingTheThing {

	public static Calendar date = Calendar.getInstance();
	static ArrayList<String> messages = new ArrayList<>();
	
	public static void stalkPlayer(PlayerEntity player) {

		PlayerDataTracker playerData = Content.PLAYER_DATA_TRACKER.get(player);
		World world = player.getEntityWorld();

		boolean flag = playerData.isTargettedByTheThing || ( world.getTime() % 6000 == 0 && ConfigData.thingChance > player.getRandom().nextFloat() );
		
		// Check if Halloween or Friday 13th. Guarantees attack if true!
		if (
				(date.get(Calendar.MONTH) == Calendar.OCTOBER && date.get(Calendar.DAY_OF_MONTH) == 31) ||
				(date.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && date.get(Calendar.DAY_OF_MONTH) == 13)
		) {
			flag = true;
		}


		if (
				!player.isAlive() ||
				!flag ||
				// player.getEntityWorld().getRegistryKey() != EM_Settings.caveDimID ||
				world.getDifficulty() == Difficulty.PEACEFUL
		) {
			playerData.isTargettedByTheThing = false;
			playerData.thing = 0;
			return;
		}
		
		playerData.isTargettedByTheThing = true;

//		if (! world.isClient) {
//			( (ServerPlayerEntity) player ).getAdvancementTracker().grantCriterion(Advancements.itsPitchBlack, "void");
//		}

		int i = MathHelper.floor( player.getX() );
		int j = MathHelper.floor( player.getY() );
		int k = MathHelper.floor( player.getZ() );
		
		int darkness = playerData.thing;
		int deathSpeed = 1;

		if (playerData.sanity <= 25) {
			deathSpeed = 3;
		} else if ( playerData.sanity <= 50 ) {
			deathSpeed = 2;

		}
		
		if (
				world.getLightLevel( new BlockPos(i, j, k) ) < 10 &&
				world.getBaseLightLevel( new BlockPos(i, j, k), world.getAmbientDarkness() ) < 10 &&
				!player.isCreative() &&
				!player.hasStatusEffect(StatusEffects.NIGHT_VISION)
		) {
			if(! hasWitnesses(player) ) {
				darkness += deathSpeed;
			}
		} else {
			if(darkness > 0) {
				darkness -= 1;
			} else {
				darkness = 0;
				playerData.isTargettedByTheThing = false;
			}
			
			if(player.hasStatusEffect( StatusEffects.BLINDNESS ) && darkness < 2000) {
				player.removeStatusEffect( StatusEffects.BLINDNESS );
			}
		}
		
		playerData.thing = darkness;
		
		if(darkness >= 500) {
			if(playerData.sanity > 50F) {
				playerData.sanity -= 0.001F;
			}
		}
		
		if(darkness >= 1000 && darkness % 20 == 0 && world.getRandom().nextInt(5) == 0) {
			float rndX = (player.getRandom().nextInt(6) - 3) * player.getRandom().nextFloat();
			float rndY = (player.getRandom().nextInt(6) - 3) * player.getRandom().nextFloat();
			float rndZ = (player.getRandom().nextInt(6) - 3) * player.getRandom().nextFloat();

			if( !world.isClient() && player instanceof ServerPlayerEntity ) {
				( (ServerPlayerEntity) player ).networkHandler.sendPacket(
					new PlaySoundS2CPacket(
						Content.SOUND_WHISPERS,
						SoundCategory.MASTER,
						player.getX() + rndX,
						player.getY() + rndY,
						player.getZ() + rndZ,
						0.5F,
						player.getRandom().nextBoolean()? 0.2F : ( player.getRandom().nextFloat() - player.getRandom().nextFloat() ) * 0.2F + 1.0F
					)
				);
			}
		}
		
		if(darkness >= 2000) {
			player.addStatusEffect( new StatusEffectInstance( StatusEffects.BLINDNESS, 100 ) );
		}
		
		if(darkness >= 3000) {
			player.damage( EnviroDamageSource.thething, 1000F );
		}
	}
	
	public static boolean hasWitnesses(PlayerEntity victim) {

		for (Entity entity : victim.getEntityWorld().getOtherEntities(victim, victim.getBoundingBox().expand(128, 128, 128) ) ) {
			if ( entity instanceof PlayerEntity ) {

				PlayerEntity witness = (PlayerEntity) entity;

				if ( witness.equals(victim) ) {
					continue;
				}

				if ( victim.canSee(witness) ) {
					return true;
				}
			}
		}
		return false;
	}
	
	static
	{
		messages.add("Stay in the light!");
		messages.add("It's too dark...");
		messages.add("ESCAPE!");
		messages.add("...never safe...");
		messages.add("Where did they go...");
		messages.add("NOT INSANE... NOT INSANE...");
		messages.add("help... me...");
		messages.add("I hear it coming...");
		messages.add("...why can't they hear me...");
		messages.add("So alone...");
		messages.add("HELP!");
		messages.add("...can't hide...");
		messages.add("Run!");
		messages.add("Why me?");
	}
}
