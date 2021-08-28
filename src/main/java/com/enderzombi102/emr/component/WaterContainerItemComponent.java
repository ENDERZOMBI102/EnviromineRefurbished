package com.enderzombi102.emr.component;

import dev.onyxstudios.cca.api.v3.item.ItemComponent;
import net.minecraft.item.ItemStack;

public abstract class WaterContainerItemComponent extends ItemComponent {

	public WaterContainerItemComponent(ItemStack stack) {
		super(stack);
	}

	public boolean isSalty() {
		return this.getBoolean("salty");
	}

	public boolean isCold() {
		return this.getBoolean("cold");
	}

	public boolean isDirty() {
		return this.getBoolean("dirty");
	}
}
