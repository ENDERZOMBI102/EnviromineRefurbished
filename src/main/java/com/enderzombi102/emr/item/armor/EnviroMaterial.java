package com.enderzombi102.emr.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EnviroMaterial implements ArmorMaterial {

	@Override
	public int getDurability(EquipmentSlot slot) {
		return 100;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		switch (slot) {
			case HEAD:
			case CHEST:
				return 2;
			case LEGS:
			case FEET:
			default:
				return 0;
		}
	}

	@Override
	public int getEnchantability() {
		return 0;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return null;
	}

	@Override
	public String getName() {
		return "enviro_material";
	}

	@Override
	public float getToughness() {
		return 0;
	}

	@Override
	public float getKnockbackResistance() {
		return 0;
	}
}
