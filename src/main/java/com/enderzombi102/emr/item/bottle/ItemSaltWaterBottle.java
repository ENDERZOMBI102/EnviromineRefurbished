package com.enderzombi102.emr.item.bottle;

import com.enderzombi102.emr.component.RegistrationHandler;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ItemSaltWaterBottle extends Item {

	protected float hydrationLevel = 11.6F;

	public ItemSaltWaterBottle() {
		super( new Settings() );
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return 32;
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

		if (! ( user instanceof PlayerEntity ) ) return stack;

		if (user instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) user;
			Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
			serverPlayerEntity.incrementStat( Stats.USED.getOrCreateStat(this) );
		}

		if ( !( (PlayerEntity) user ).abilities.creativeMode ) {
			stack.decrement(1);
		}

		if (!world.isClient) {
			RegistrationHandler.MagicPDT.get(user).hydration += this.hydrationLevel;
			this.additionalEffect(stack, world, user);
		}

		return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
	}


	protected void additionalEffect(ItemStack stack, World world, LivingEntity user) {}
}
