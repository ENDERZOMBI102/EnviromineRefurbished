package com.enderzombi102.enviro.item.armor;

import com.enderzombi102.enviro.EnviromineRefurbished;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;

public class HardHatItem extends ArmorItem {

	public HardHatItem() {
		super(
				EnviroMaterial.MATERIAL,
				EquipmentSlot.HEAD,
				new Settings().group(EnviromineRefurbished.EnviroTab).maxDamage(100)
		);
	}

//	@Override
//	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
//		if ( world.isClient() || ! (entity instanceof PlayerEntity ) ) return;
//	}

	@Override
	public boolean isDamageable() {
		return false;
	}
}
