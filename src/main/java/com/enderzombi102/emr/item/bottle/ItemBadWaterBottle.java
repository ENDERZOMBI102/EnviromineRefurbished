package com.enderzombi102.emr.item.bottle;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBadWaterBottle extends ItemSaltWaterBottle {

	public ItemBadWaterBottle() {
		this.hydrationLevel = 6.5F;
	}

	@Override
	protected void additionalEffect(ItemStack stack, World world, LivingEntity user) {
		user.addStatusEffect( new StatusEffectInstance(StatusEffects.NAUSEA, 40) );
	}

}
