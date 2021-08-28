package com.enderzombi102.emr.config.data;

import com.enderzombi102.emr.util.Const;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@SuppressWarnings("unused")
@Config(name = Const.MOD_ID)
public class MainConfig extends PartitioningSerializer.GlobalData {

	@ConfigEntry.Gui.TransitiveObject
	@ConfigEntry.Category("rottingMechanic")
	public RottingMechanic rottingMechanic = new RottingMechanic();
}
