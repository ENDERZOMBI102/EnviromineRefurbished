package com.enderzombi102.emr.item;

import com.enderzombi102.emr.EnviromineRefurbished;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class ItemSpoiledMilk extends Item {

	public ItemSpoiledMilk() {
		super(
				new FabricItemSettings().group(EnviromineRefurbished.EnviroTab).food(
						new FoodComponent
								.Builder()
								.hunger(0)
								.saturationModifier(0.0F)
								.statusEffect( new StatusEffectInstance(StatusEffects.HUNGER, 3), 1.0F )
								.build()
				)
		);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		return ActionResult.PASS;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		stack.decrement(1);
		return new ItemStack(Items.BUCKET);
	}
}
