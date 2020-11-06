package com.enderzombi102.emr.item.armor;

import com.enderzombi102.emr.Content;
import com.enderzombi102.emr.EnviromineRefurbished;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class EnviroArmor extends ArmorItem {

	public EnviroArmor(EquipmentSlot slot, Settings settings) {
		super(Content.enviroMaterial, slot, settings.maxDamage(100).group(EnviromineRefurbished.EnviroTab) );
	}

	@Override
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return false;
	}
}
