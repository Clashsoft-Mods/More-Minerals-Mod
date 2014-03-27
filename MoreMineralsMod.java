package clashsoft.mods.moreminerals;

import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.mods.moreminerals.common.MMMProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = MoreMineralsMod.VERSION, name = MoreMineralsMod.NAME, version = MoreMineralsMod.VERSION)
public class MoreMineralsMod
{
	public static final String		MODID				= "moreminerals";
	public static final String		NAME				= "More Minerals Mod";
	public static final String		ACRONYM				= "mmm";
	public static final String		VERSION				= CSUpdate.CURRENT_VERSION + "-0.0.0";
	
	@Instance(MODID)
	public static MoreMineralsMod	INSTANCE;
	
	@SidedProxy(clientSide = "clashsoft.mods.moreminerals.client.MMMClientProxy", serverSide = "clashsoft.mods.moreminerals.common.MMMProxy")
	public static MMMProxy	proxy;
	
	public static int[]				overworldGen		= new int[] {
			12,
			14,
			20,
			16,
			24,
			24,
			24,
			24,
			16,
			16											};
	public static int[]				overworldGenVanilla	= new int[] {
			128,
			16,
			32,
			32,
			64,
			32,
			16											};
	
	public static String[]			oreNames			= new String[] {
			"Adamantite",
			"Cobalt",
			"Demonite",
			"Mythril",
			"Vibranium",
			"Amethyst",
			"Ruby",
			"Sapphire",
			"Topaz",
			"Spinel",
			"Opal",									};
	
	public static String[]			oreNamesVanilla		= new String[] {
			"Coal",
			"Diamond",
			"Emerald",
			"Gold",
			"Iron",
			"Lapislazuli",
			"Redstone"									};
	
	public static String[]			gemNames			= new String[] {
			"Amethyst",
			"Ruby",
			"Sapphire",
			"Topaz",
			"Spinel",
			"Opal"										};
	
	@EventHandler
	public void preInit()
	{
		
	}
}