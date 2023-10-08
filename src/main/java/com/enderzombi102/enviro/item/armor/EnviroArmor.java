package com.enderzombi102.enviro.item.armor;

import com.enderzombi102.enviro.EnviromineRefurbished;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class EnviroArmor extends ArmorItem {

	public EnviroArmor(EquipmentSlot slot, Settings settings) {
		super(EnviroMaterial.MATERIAL, slot, settings.maxDamage(100).group(EnviromineRefurbished.EnviroTab) );
	}

	@Override
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return false;
	}
}
