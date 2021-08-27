package com.enderzombi102.emr.item;

import com.enderzombi102.emr.EnviromineRefurbished;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RottenFoodItem extends Item {

	public RottenFoodItem() {
		super(
				new FabricItemSettings().group(EnviromineRefurbished.EnviroTab).food(
				new FoodComponent
						.Builder()
						.hunger(0)
						.saturationModifier(0.0F)
						.statusEffect( new StatusEffectInstance(StatusEffects.HUNGER, 60), 1.0F )
						.build()
				)
		);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext ctx) {
		// if we're on client, just skip this
		if ( ctx.getWorld().isClient() ) return ActionResult.PASS;
		// variables
		World world = ctx.getWorld();
		BlockPos pos = ctx.getBlockPos();
		BlockState blockState = world.getBlockState(pos);
		// return if no player
		if ( ctx.getPlayer() == null ) return ActionResult.PASS;
		ItemStack stack = ctx.getPlayer().getActiveItem();
		// is it a valid block?
		if ( blockState.getBlock() instanceof Fertilizable ) {
			Fertilizable fertilizable = (Fertilizable) blockState.getBlock();
			// if it can grow, let it grow!
			if ( fertilizable.canGrow( world, world.random, pos, blockState) ) {
				fertilizable.grow( (ServerWorld) world, world.random, pos, blockState );
				stack.decrement(1);
			}
		}
		return ActionResult.SUCCESS;
	}
}
