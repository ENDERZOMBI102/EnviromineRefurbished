package com.enderzombi102.emr.advancement;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.server.function.CommandFunction;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class Advancements {

	private static final AdvancementRewards EMPTY_REWARD = new AdvancementRewards(
	0,
			new Identifier[]{
				new Identifier("")
			},
			new Identifier[]{},
			CommandFunction.LazyContainer.EMPTY
	);

	public static Advancement tenSecondsRule;
	public static Advancement itsPitchBlack;

	public static void initAdvancements() {
		tenSecondsRule = new Advancement(
				new Identifier("emr", "ten_seconds_rule"),
				null,
				null,
				EMPTY_REWARD,
				new HashMap<>(),
				new String[][] {}
		);

		HashMap<String, AdvancementCriterion> itsPitchBlackMap = new HashMap<>();
		itsPitchBlack = new Advancement(
				new Identifier("emr", "its_pitch_black"),
				null,
				null,
				EMPTY_REWARD,
				itsPitchBlackMap,
				new String[][] {}
		);
	}

}
