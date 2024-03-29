package com.enderzombi102.enviro.item.armor;

import com.enderzombi102.enviro.EnviromineRefurbished;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GasMaskItem extends ArmorItem {

	public GasMaskItem() {
		super(
				EnviroMaterial.MATERIAL,
				EquipmentSlot.HEAD,
				new Settings().group(EnviromineRefurbished.EnviroTab).maxDamage(100)
		);
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (! (entity instanceof PlayerEntity player) )
			return;

	}

	@Override
	public boolean isDamageable() {
		return false;
	}
}
