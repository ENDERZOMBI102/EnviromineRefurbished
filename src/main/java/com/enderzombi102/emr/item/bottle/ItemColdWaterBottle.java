package com.enderzombi102.emr.item.bottle;

import com.enderzombi102.emr.component.RegistrationHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemColdWaterBottle extends ItemSaltWaterBottle {

	public ItemColdWaterBottle() {
		this.hydrationLevel = 21.4F;
	}

	@Override
	protected void additionalEffect(ItemStack stack, World world, LivingEntity user) {
		RegistrationHandler.MagicPDT.get(user).bodyTemp -= 6F;
	}
}
