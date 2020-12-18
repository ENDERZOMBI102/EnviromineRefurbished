package com.enderzombi102.emr.config;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ConfigData {

	public static File worldDir = null;

	public static boolean enablePhysics = true;
	public static boolean enableLandslide = true;
	@ShouldOverride
	public static boolean enableAirQ = true;
	@ShouldOverride
	public static boolean enableHydrate = true;
	@ShouldOverride
	public static boolean enableSanity = true;
	@ShouldOverride
	public static boolean enableBodyTemp = true;
	public static boolean trackNonPlayer = false;

	public static boolean spreadIce = false;

	public static boolean useFarenheit = false;
	public static String heatBarPos;
	public static String waterBarPos;
	public static String sanityBarPos;
	public static String oxygenBarPos;


	public static boolean enableHypothermiaGlobal = true;
	public static boolean enableHeatstrokeGlobal = true;
	public static boolean enableFrostbiteGlobal = true;

	//Gases
	public static boolean renderGases = false;
	public static int gasTickRate = 32; //GasFires are 4x faster than this
	public static int gasPassLimit = -1;
	public static boolean gasWaterLike = true;
	public static boolean slowGases = true; // Normal gases use random ticks to move
	public static boolean noGases = false;

	//World Gen
	public static boolean shaftGen = true;
	public static boolean gasGen = true;
	public static boolean oldMineGen = true;

	//Properties
	//@ShouldOverride("enviromine.network.packet.encoders.ArmorPropsEncoder")
//	@ShouldOverride({String.class, ArmorProperties.class})
//	public static HashMap<String,ArmorProperties> armorProperties = new HashMap<String,ArmorProperties>();
	//@ShouldOverride("enviromine.network.packet.encoders.BlocksPropsEncoder")
//	@ShouldOverride({String.class, BlockProperties.class})
//	public static HashMap<String,BlockProperties> blockProperties = new HashMap<String,BlockProperties>();
//	@ShouldOverride({Integer.class, EntityProperties.class})
//	public static HashMap<Integer,EntityProperties> livingProperties = new HashMap<Integer,EntityProperties>();
//	@ShouldOverride({String.class, ItemProperties.class})
//	public static HashMap<String,ItemProperties> itemProperties = new HashMap<String,ItemProperties>();
//	@ShouldOverride({Integer.class, BiomeProperties.class})
//	public static HashMap<Integer,BiomeProperties> biomeProperties = new HashMap<Integer,BiomeProperties>();
//	@ShouldOverride({Integer.class, DimensionProperties.class})
//	public static HashMap<Integer,DimensionProperties> dimensionProperties = new HashMap<Integer,DimensionProperties>();
//
//	public static HashMap<String,StabilityType> stabilityTypes = new HashMap<String,StabilityType>();
//
//	@ShouldOverride({String.class, RotProperties.class})
//	public static HashMap<String,RotProperties> rotProperties = new HashMap<String,RotProperties>();

	public static int updateCap = 128;
	public static boolean stoneCracks = true;
	public static String defaultStability = "loose";

	public static double sanityMult = 1.0D;
	public static double hydrationMult = 1.0D;
	public static double tempMult = 1.0D;
	public static double airMult = 1.0D;

	public static boolean updateCheck = true;
	//public static boolean useDefaultConfig = true;
	public static boolean genConfigs = false;
	public static boolean genDefaults = false;

	public static int physInterval = 6;
	public static int worldDelay = 1000;
	public static int chunkDelay = 1000;
	public static int entityFailsafe = 1;
	public static boolean villageAssist = true;

	public static boolean minimalHud;
	public static boolean limitCauldron;
	public static boolean allowTinting = true;
	public static boolean torchesBurn = true;
	public static boolean torchesGoOut = true;

	public static int caveDimID = -3;
	public static int caveBiomeID = 23;
	public static boolean disableCaves = false;
	public static int limitElevatorY = 10;
	public static boolean caveOreEvent = true;
	public static boolean caveLava = false;
	public static int caveRavineRarity = 30;
	public static int caveTunnelRarity = 7;
	public static int caveDungeons = 8;
	public static int caveLiquidY = 32;
	public static boolean caveFlood = true;
	public static boolean caveRespawn = false;
	public static boolean enforceWeights = false;
//	public static ArrayList<CaveGenProperties> caveGenProperties = new ArrayList<CaveGenProperties>();
//	public static HashMap<Integer, CaveSpawnProperties> caveSpawnProperties = new HashMap<Integer, CaveSpawnProperties>();

	public static boolean foodSpoiling = true;
	public static int foodRotTime = 7;

	/** Whether or not this overridden with server settings */
	public static boolean isOverridden = false;
	public static boolean enableConfigOverride = false;
	public static boolean profileOverride = false;
	public static String profileSelected = "default";

	public static boolean enableQuakes = true;
	public static boolean quakePhysics = true;
	public static int quakeRarity = 100;

	public static boolean finiteWater = false;
	public static float thingChance = 0.000001F;
	public static boolean noNausea = false;
	public static boolean keepStatus = false;
	public static boolean renderGear = true;


	public static boolean voxelMenuExists = false;

	/**
	 * Tells the server that this field should be sent to the client to overwrite<br>
	 * Usage:<br>
	 * <tt>@ShouldOverride</tt> - for ints/booleans/floats/Strings<br>
	 * <tt>@ShouldOverride(Class[] value)</tt> - for ArrayList or HashMap types
	 * */
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ShouldOverride
	{
		Class<?>[] value() default {};
	}



}
