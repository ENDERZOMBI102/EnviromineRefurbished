package com.enderzombi102.emr;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class EnviroDamageSource extends DamageSource {

	public static final EnviroDamageSource heatstroke = new EnviroDamageSource("heatstroke", true);
	public static final EnviroDamageSource organfailure = new EnviroDamageSource("organfailure", true);
	public static final EnviroDamageSource bleedout = new EnviroDamageSource("bleedout", true);
	public static final EnviroDamageSource suffocate = new EnviroDamageSource("suffocate", true);
	public static final EnviroDamageSource frostbite = new EnviroDamageSource("frostbite", true);
	public static final EnviroDamageSource dehydrate = new EnviroDamageSource("dehydrate", true);
	public static final EnviroDamageSource landslide = new EnviroDamageSource("landslide", false);
	public static final EnviroDamageSource avalanche = new EnviroDamageSource("avalanche", false);
	public static final EnviroDamageSource gasfire = new EnviroDamageSource("gasfire", true);
	public static final EnviroDamageSource thething = new EnviroDamageSource("thething", true);

	protected EnviroDamageSource(String name, boolean bypassesArmor) {
		super(name);
		if (bypassesArmor) this.setBypassesArmor();
	}

	@Override
	public Text getDeathMessage(LivingEntity entity) {
		if (! this.getName().equals("thething") ) {
			return new TranslatableText("deathmessage.emr." + this.getName(), entity.getDisplayName() );
		}
		return new LiteralText("");
	}

}
