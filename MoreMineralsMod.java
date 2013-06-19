package clashsoft.mods.moreminerals;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import clashsoft.clashsoftapi.*;
import clashsoft.clashsoftapi.datatools.ItemDataAxe;
import clashsoft.clashsoftapi.datatools.ItemDataHoe;
import clashsoft.clashsoftapi.datatools.ItemDataPickaxe;
import clashsoft.clashsoftapi.datatools.ItemDataSpade;
import clashsoft.clashsoftapi.datatools.ItemDataSword;
import clashsoft.clashsoftapi.datatools.ItemDataTool;
import clashsoft.clashsoftapi.util.CSArray;
import clashsoft.clashsoftapi.util.CSCrafting;
import clashsoft.clashsoftapi.util.CSItems;
import clashsoft.clashsoftapi.util.CSLang;
import clashsoft.clashsoftapi.util.CSUtil;
import clashsoft.mods.moreminerals.orecrusher.OreCrusherRecipes;
import clashsoft.mods.moreminerals.orecrusher.TileEntityOreCrusher;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "MoreMineralsMod", name = "More Minerals Mod", version = CSUtil.CURRENT_VERION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreMineralsMod
{
	@Instance("MoreMineralsMod")
	public static MoreMineralsMod INSTANCE;

	@SidedProxy(clientSide = "clashsoft.mods.moreminerals.ClientProxy", serverSide = "clashsoft.mods.moreminerals.CommonProxy")
	public static CommonProxy proxy;

	public static CustomCreativeTab stoneOresTab = new CustomCreativeTab("MM_stoneores", null);
	public static CustomCreativeTab netherOresTab = new CustomCreativeTab("MM_netherores", null);
	public static CustomCreativeTab endOresTab = new CustomCreativeTab("MM_endores", null);
	public static CustomCreativeTab dirtOresTab = new CustomCreativeTab("MM_dirtores", null);
	public static CustomCreativeTab sandOresTab = new CustomCreativeTab("MM_sandores", null);
	public static CustomCreativeTab rawMaterialsTab = new CustomCreativeTab("MM_rawmaterials", null);
	public static CustomCreativeTab toolsTab = new CustomCreativeTab("MM_tools", null);

	public static int OreCrusher_TEID = 15;

	public static int vanillaOres_ID = 1200;
	public static int vanillaOres_ID2 = 1201;
	public static int oreCrusher_ID = 1250;
	public static int oreCrusherActive_ID = 1251;

	public static int stoneOres_ID1 = 1202;
	public static int stoneOres_ID2 = 1203;
	public static int stoneOres_ID3 = 1204;
	public static int stoneOres_ID4 = 1205;
	public static int stoneOres_ID5 = 1206;
	public static int stoneOres_ID6 = 1207;
	public static int stoneOres_ID7 = 1208;
	public static int stoneOres_ID8 = 1209;
	public static int netherOres_ID1 = 1210;
	public static int netherOres_ID2 = 1211;
	public static int netherOres_ID3 = 1212;
	public static int netherOres_ID4 = 1213;
	public static int netherOres_ID5 = 1214;
	public static int netherOres_ID6 = 1215;
	public static int netherOres_ID7 = 1216;
	public static int netherOres_ID8 = 1217;
	public static int endOres_ID1 = 1218;
	public static int endOres_ID2 = 1219;
	public static int endOres_ID3 = 1220;
	public static int endOres_ID4 = 1221;
	public static int endOres_ID5 = 1222;
	public static int endOres_ID6 = 1223;
	public static int endOres_ID7 = 1224;
	public static int endOres_ID8 = 1225;
	public static int dirtOres_ID1 = 1226;
	public static int dirtOres_ID2 = 1227;
	public static int dirtOres_ID3 = 1228;
	public static int dirtOres_ID4 = 1229;
	public static int dirtOres_ID5 = 1230;
	public static int dirtOres_ID6 = 1231;
	public static int dirtOres_ID7 = 1232;
	public static int dirtOres_ID8 = 1233;
	public static int sandOres_ID1 = 1234;
	public static int sandOres_ID2 = 1235;
	public static int sandOres_ID3 = 1236;
	public static int sandOres_ID4 = 1237;
	public static int sandOres_ID5 = 1238;
	public static int sandOres_ID6 = 1239;
	public static int sandOres_ID7 = 1240;
	public static int sandOres_ID8 = 1241;
	public static int storageBlocks_ID1 = 1242;
	public static int storageBlocks_ID2 = 1243;
	public static int storageBlocks_ID3 = 1244;
	public static int storageBlocks_ID4 = 1245;
	public static int storageBlocks_ID5 = 1246;
	public static int storageBlocks_ID6 = 1247;
	public static int storageBlocks_ID7 = 1248;
	public static int storageBlocks_ID8 = 1249;

	public static int vanillaSpecialItems_ID = 11000;
	public static int ingots_ID = 11001;
	public static int dusts_ID = 11002;
	public static int nuggets_ID = 11003;
	public static int gems_ID = 11004;

	public static int dataSword_ID = 11005;
	public static int dataSpade_ID = 11006;
	public static int dataPickaxe_ID = 11007;
	public static int dataAxe_ID = 11008;
	public static int dataHoe_ID = 11009;

	public static int[] gentypes = new int[] //maxGenHeight
		{
		32, 32, 0, 0, 0, 28, 13, 0, //Silicon
			0, 0, 0, 0, 0, 12, 32, 16, //Chrome
		24, 0, 0, 32, 64, 0, 0, 0, //Germanium
			0, 0, 0, 0, 0, 0, 0, 16, //Molybdenum
		0, 0, 0, 0, 32, 0, 0, 64, //Tin
			0, 0, 0, 0, 0, 0, 0, 0, //Preasodynmium
		0, 0, 0, 0, 0, 0, 0, 0, //Holmium
			0, 0, 0, 0, 0, 0, 16, 0, //Rhemium
		0, 12, 16, 0, 0, 0, 48, 0, //Bismuth
			0, 0, 0, 0, 0, 0, 0, 24, //Uranium
		0, 0, 12, 14, 20, 16, 24, 24, //Ruby
			24, 24, 16, 16, 0, 0, 0, 0, //-
		0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0
		};
	public static int[] vanillagentypes = new int[] { 128, 16, 32, 32, 64, 32, 16 };

	public static String[] allnames = new String[]
		{
		"Lithium", "Beryllium", "%&Boron", "%&Carbon", "%&Sodium", "Magnesium", "Aluminium", "%&Silicon",
			"%&Phosphorus", "%&Sulfur", "%&Potassium", "%&Calcium", "%&Scandium", "Titanium", "Vanadium", "Chrome",
		"Manganese", "%&Iron", "%&Cobalt", "Nickel", "Copper", "%&Zinc", "%&Gallium", "%&Germanium",	
			"%&Arsenic", "%&Selenium", "%&Rubidium", "%&Strontium", "%&Yttrium", "%&Zirconium", "%&Niobium", "Molybdenum",
		"%&Technetium", "%&Ruthenium", "%&Rhodium", "%&Palladium", "Silver", "%&Cadmium", "%&Indium", "Tin",
			"%&Antimony", "%&Tellurium", "%&Iodine", "%&Caesium", "%&Barium", "%&Lanthanum", "%&Cerium", "%&Praseodymium",
		"%&Neodynium", "%&Promethium", "%&Samarium", "%&Europium", "%&Gadolinium", "%&Terbium", "%&Dysprosium", "%&Holmium",
			"%&Erbium", "%&Thulium", "%&Ytterbium", "%&Lutetium", "%&Hafnium", "%&Tantalum", "Tungsten", "%&Rhenium",
		"%&Osmium", "Iridium", "Platinum", "%&Gold", "%&Mercury", "%&Thallium", "Lead", "%&Bismuth",
			"%&Polonium","%&Astatine", "%&Francium", "%&Radium", "%&Actinium", "%&Thorium", "%&Protactinium", "Uranium",
		"%&Neptunium", "%&Plutonium", "Adamantite", "Cobalt", "Demonite", "Mythril", "Amethyst", "Ruby",
			"Sapphire", "Topaz", "Spinel", "Opal", "%&", "%&", "%&", "%&",
		"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&",
			"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&",
		"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&",
			"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&",
		};
	public static String[][] splitnames = CSArray.split(allnames, 16);
	public static String[] names1 = splitnames[0];
	public static String[] names2 = splitnames[1];
	public static String[] names3 = splitnames[2];
	public static String[] names4 = splitnames[3];
	public static String[] names5 = splitnames[4];
	public static String[] names6 = splitnames[5];
	public static String[] names7 = splitnames[6];
	public static String[] names8 = splitnames[7];
	public static String[] gemnames = new String[] {"Amethyst", "Ruby", "Sapphire", "Topaz", "Spinel", "Opal"};
	public static String[] vanillanames = new String[] {"Coal", "Diamond", "Emerald", "Gold", "Iron", "Lapislazuli", "Redstone"};

	public static String[] alloverlays = CSArray.caseAll(allnames, 0);
	public static String[] overlays1 = CSArray.caseAll(names1, 0);
	public static String[] overlays2 = CSArray.caseAll(names2, 0);
	public static String[] overlays3 = CSArray.caseAll(names3, 0);
	public static String[] overlays4 = CSArray.caseAll(names4, 0);
	public static String[] overlays5 = CSArray.caseAll(names5, 0);
	public static String[] overlays6 = CSArray.caseAll(names6, 0);
	public static String[] overlays7 = CSArray.caseAll(names7, 0);
	public static String[] overlays8 = CSArray.caseAll(names8, 0);
	public static String[] gemoverlays = CSArray.caseAll(gemnames, 0);
	public static String[] vanillaoverlays = CSArray.caseAll(vanillanames, 0);

	private static int[] gemids = new int[] {CSArray.valueOf(allnames, "Amethyst"), CSArray.valueOf(allnames, "Ruby"), CSArray.valueOf(allnames, "Sapphire"), CSArray.valueOf(allnames, "Topaz"), CSArray.valueOf(allnames, "Spinel"), CSArray.valueOf(allnames, "Opal")};

	public static CustomBlock vanillaSpecialOres1;
	public static CustomBlock vanillaSpecialOres2;
	public static CustomBlock stoneOres1;
	public static CustomBlock stoneOres2;
	public static CustomBlock stoneOres3;
	public static CustomBlock stoneOres4;
	public static CustomBlock stoneOres5;
	public static CustomBlock stoneOres6;
	public static CustomBlock stoneOres7;
	public static CustomBlock stoneOres8;
	public static CustomBlock netherOres1;
	public static CustomBlock netherOres2;
	public static CustomBlock netherOres3;
	public static CustomBlock netherOres4;
	public static CustomBlock netherOres5;
	public static CustomBlock netherOres6;
	public static CustomBlock netherOres7;
	public static CustomBlock netherOres8;
	public static CustomBlock endOres1;
	public static CustomBlock endOres2;
	public static CustomBlock endOres3;
	public static CustomBlock endOres4;
	public static CustomBlock endOres5;
	public static CustomBlock endOres6;
	public static CustomBlock endOres7;
	public static CustomBlock endOres8;
	public static CustomBlock dirtOres1;
	public static CustomBlock dirtOres2;
	public static CustomBlock dirtOres3;
	public static CustomBlock dirtOres4;
	public static CustomBlock dirtOres5;
	public static CustomBlock dirtOres6;
	public static CustomBlock dirtOres7;
	public static CustomBlock dirtOres8;
	public static CustomBlock sandOres1;
	public static CustomBlock sandOres2;
	public static CustomBlock sandOres3;
	public static CustomBlock sandOres4;
	public static CustomBlock sandOres5;
	public static CustomBlock sandOres6;
	public static CustomBlock sandOres7;
	public static CustomBlock sandOres8;
	public static CustomBlock storageBlocks1;
	public static CustomBlock storageBlocks2;
	public static CustomBlock storageBlocks3;
	public static CustomBlock storageBlocks4;
	public static CustomBlock storageBlocks5;
	public static CustomBlock storageBlocks6;
	public static CustomBlock storageBlocks7;
	public static CustomBlock storageBlocks8;

	public static BlockOreCrusher oreCrusher;
	public static BlockOreCrusher oreCrusherActive;

	public static CustomItem vanillaSpecialItems;
	public static CustomItem ingots;
	public static CustomItem dusts;
	public static CustomItem nuggets;
	public static CustomItem gems;

	public static ItemDataSword dataSword;
	public static ItemDataSpade dataSpade;
	public static ItemDataPickaxe dataPickaxe;
	public static ItemDataAxe dataAxe;
	public static ItemDataHoe dataHoe;

	public static EnumToolMaterial adamantite = CSItems.addToolMaterial("Adamantite", 3, 2048, 14F, 12, 20, 0x000000, null, true);
	public static EnumToolMaterial cobalt = CSItems.addToolMaterial("Cobalt", 2, 1536, 10F, 10, 10, 0x000000, null, true);
	public static EnumToolMaterial demonite = CSItems.addToolMaterial("Demonite", 2, 800, 6F, 6, 30, 0x000000, null, true);
	public static EnumToolMaterial mythril = CSItems.addToolMaterial("Mythril", 1, 1024, 8F, 7, 12, 0x000000, null, true);
	public static EnumToolMaterial aluminium = CSItems.addToolMaterial("Aluminium", 2, 512, 8F, 8, 10, 0x000000, null, true);
	public static EnumToolMaterial chrome = CSItems.addToolMaterial("Chrome", 2, 256, 10F, 9, 12, 0x000000, null, true);
	public static EnumToolMaterial copper = CSItems.addToolMaterial("Copper", 1, 128, 4F, 5, 8, 0x000000, null, true);
	public static EnumToolMaterial silver = CSItems.addToolMaterial("Silver", 2, 512, 6F, 6, 16, 0x000000, null, true);
	public static EnumToolMaterial tin = CSItems.addToolMaterial("Tin", 2, 182, 5F, 5, 9, 0x000000, null, true);
	public static EnumToolMaterial titanium = CSItems.addToolMaterial("Titanium", 3, 2048, 16F, 10, 13, 0x000000, null, true);
	public static EnumToolMaterial emerald = CSItems.addToolMaterial("Emerald", 3, 1200, 8F, 10, 17, 0x000000, new ItemStack(Item.emerald), true);
	public static EnumToolMaterial ruby = CSItems.addToolMaterial("Ruby", 3, 1200, 8F, 9, 17, 0x000000, null, true);
	public static EnumToolMaterial sapphire = CSItems.addToolMaterial("Sapphire", 3, 1200, 8F, 9, 17, 0x000000, null, true);

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		vanillaOres_ID = config.getBlock("Special Vanilla Ores ID 1", 1200).getInt();
		vanillaOres_ID2 = config.getBlock("Special Vanilla Ores ID 2", 1201).getInt();
		stoneOres_ID1 = config.getBlock("Stone-Based Ores ID 1", 1202).getInt();
		stoneOres_ID2 = config.getBlock("Stone-Based Ores ID 2", 1203).getInt();
		stoneOres_ID3 = config.getBlock("Stone-Based Ores ID 3", 1204).getInt();
		stoneOres_ID4 = config.getBlock("Stone-Based Ores ID 4", 1205).getInt();
		stoneOres_ID5 = config.getBlock("Stone-Based Ores ID 5", 1206).getInt();
		stoneOres_ID6 = config.getBlock("Stone-Based Ores ID 6", 1207).getInt();
		stoneOres_ID7 = config.getBlock("Stone-Based Ores ID 7", 1208).getInt();
		stoneOres_ID8 = config.getBlock("Stone-Based Ores ID 8", 1209).getInt();
		netherOres_ID1 = config.getBlock("Netherrack-Based Ores ID 1", 1210).getInt();
		netherOres_ID2 = config.getBlock("Netherrack-Based Ores ID 2", 1211).getInt();
		netherOres_ID3 = config.getBlock("Netherrack-Based Ores ID 3", 1212).getInt();
		netherOres_ID4 = config.getBlock("Netherrack-Based Ores ID 4", 1213).getInt();
		netherOres_ID5 = config.getBlock("Netherrack-Based Ores ID 5", 1214).getInt();
		netherOres_ID6 = config.getBlock("Netherrack-Based Ores ID 6", 1215).getInt();
		netherOres_ID7 = config.getBlock("Netherrack-Based Ores ID 7", 1216).getInt();
		netherOres_ID8 = config.getBlock("Netherrack-Based Ores ID 8", 1217).getInt();
		endOres_ID1 = config.getBlock("Endstone-Based Ores ID 1", 1218).getInt();
		endOres_ID2 = config.getBlock("Endstone-Based Ores ID 2", 1219).getInt();
		endOres_ID3 = config.getBlock("Endstone-Based Ores ID 3", 1220).getInt();
		endOres_ID4 = config.getBlock("Endstone-Based Ores ID 4", 1221).getInt();
		endOres_ID5 = config.getBlock("Endstone-Based Ores ID 5", 1222).getInt();
		endOres_ID6 = config.getBlock("Endstone-Based Ores ID 6", 1223).getInt();
		endOres_ID7 = config.getBlock("Endstone-Based Ores ID 7", 1224).getInt();
		endOres_ID8 = config.getBlock("Endstone-Based Ores ID 8", 1225).getInt();
		dirtOres_ID1 = config.getBlock("Dirt-Based Ores ID 1", 1226).getInt();
		dirtOres_ID2 = config.getBlock("Dirt-Based Ores ID 2", 1227).getInt();
		dirtOres_ID3 = config.getBlock("Dirt-Based Ores ID 3", 1228).getInt();
		dirtOres_ID4 = config.getBlock("Dirt-Based Ores ID 4", 1229).getInt();
		dirtOres_ID5 = config.getBlock("Dirt-Based Ores ID 5", 1230).getInt();
		dirtOres_ID6 = config.getBlock("Dirt-Based Ores ID 6", 1231).getInt();
		dirtOres_ID7 = config.getBlock("Dirt-Based Ores ID 7", 1232).getInt();
		dirtOres_ID8 = config.getBlock("Dirt-Based Ores ID 8", 1233).getInt();
		sandOres_ID1 = config.getBlock("Sand-Based Ores ID 1", 1234).getInt();
		sandOres_ID2 = config.getBlock("Sand-Based Ores ID 2", 1235).getInt();
		sandOres_ID3 = config.getBlock("Sand-Based Ores ID 3", 1236).getInt();
		sandOres_ID4 = config.getBlock("Sand-Based Ores ID 4", 1237).getInt();
		sandOres_ID5 = config.getBlock("Sand-Based Ores ID 5", 1238).getInt();
		sandOres_ID6 = config.getBlock("Sand-Based Ores ID 6", 1239).getInt();
		sandOres_ID7 = config.getBlock("Sand-Based Ores ID 7", 1240).getInt();
		sandOres_ID8 = config.getBlock("Sand-Based Ores ID 8", 1241).getInt();
		storageBlocks_ID1 = config.getBlock("Storage Blocks ID 1", 1242).getInt();
		storageBlocks_ID2 = config.getBlock("Storage Blocks ID 2", 1243).getInt();
		storageBlocks_ID3 = config.getBlock("Storage Blocks ID 3", 1244).getInt();
		storageBlocks_ID4 = config.getBlock("Storage Blocks ID 4", 1245).getInt();
		storageBlocks_ID5 = config.getBlock("Storage Blocks ID 5", 1246).getInt();
		storageBlocks_ID6 = config.getBlock("Storage Blocks ID 6", 1247).getInt();
		storageBlocks_ID7 = config.getBlock("Storage Blocks ID 7", 1248).getInt();
		storageBlocks_ID8 = config.getBlock("Storage Blocks ID 8", 1249).getInt();
		oreCrusher_ID = config.getBlock("Ore Crusher (Idle) ID", 1250).getInt();
		oreCrusherActive_ID = config.getBlock("Ore Crusher (Active) ID", 1251).getInt();

		OreCrusher_TEID = config.get("Tile Entity IDs", "Ore Crusher Tile Entity ID", 15).getInt();

		vanillaSpecialItems_ID = config.getItem("Special Vanilla Items ID", 11000).getInt();
		ingots_ID = config.getItem("Ingots ID", 11001).getInt();
		dusts_ID = config.getItem("Dusts ID", 11002).getInt();
		nuggets_ID = config.getItem("Nuggets ID", 11003).getInt();
		gems_ID = config.getItem("Gems ID", 11004).getInt();

		dataSword_ID = config.getItem("Swords ID", 11005).getInt();
		dataSpade_ID = config.getItem("Shovels ID", 11006).getInt();
		dataPickaxe_ID = config.getItem("Pickaxes ID", 11007).getInt();
		dataAxe_ID = config.getItem("Axes ID", 11008).getInt();
		dataHoe_ID = config.getItem("Hoes ID", 11009).getInt();

		config.save();
	}

	@Init
	public void load(FMLInitializationEvent event)
	{	
		CSUtil.log("[MoreMineralsMod] Loading More Minerals Mod");
		CSUtil.log("[MoreMineralsMod] " + allnames.length + " Materials added");
		CSUtil.log(gentypes[CSArray.valueOf(allnames, "%&Gallium")]);
		CSUtil.log(gentypes[CSArray.valueOf(allnames, "%&Germanium")]);
		
		vanillaSpecialItems = (CustomItem) new CustomItem(vanillaSpecialItems_ID, CSArray.combine(CSArray.combine(CSArray.addToAll(vanillanames, "", " Ingot"), CSArray.addToAll(vanillanames, "", " Dust")), CSArray.addToAll(vanillanames, "", " Nugget")), CSArray.combine(CSArray.combine(CSArray.addToAll(vanillaoverlays, "ingot", ""), CSArray.addToAll(vanillaoverlays, "dust", "")), CSArray.addToAll(vanillaoverlays, "nugget", ""))).disableMetadata(3, 4, 13, 17).setUnlocalizedName("MM_VanillaSpecialItems").setCreativeTab(rawMaterialsTab);
		ingots = (CustomItem) new CustomItem(ingots_ID, CSArray.addToAll(allnames, "", " Ingot"), CSArray.addToAll(alloverlays, "ingot", "")).disableMetadata(gemids).setUnlocalizedName("MM_Ingots").setCreativeTab(rawMaterialsTab);
		dusts = (CustomItem) new CustomItem(dusts_ID, CSArray.addToAll(allnames, "", " Dust"), CSArray.addToAll(alloverlays, "dust", "")).setUnlocalizedName("MM_Dusts").setCreativeTab(rawMaterialsTab);
		nuggets = (CustomItem) new CustomItem(nuggets_ID, CSArray.addToAll(allnames, "", " Nugget"), CSArray.addToAll(alloverlays, "nugget", "")).setUnlocalizedName("MM_Nuggets").setCreativeTab(rawMaterialsTab);
		gems = (CustomItem) new CustomItem(gems_ID, gemnames, CSArray.addToAll(gemoverlays, "gem", "")).setUnlocalizedName("MM_Gems").setCreativeTab(rawMaterialsTab);

		dataSword = (ItemDataSword) new ItemDataSword(dataSword_ID, EnumToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Swords");
		dataSpade = (ItemDataSpade) new ItemDataSpade(dataSpade_ID, EnumToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Spades");
		dataPickaxe = (ItemDataPickaxe) new ItemDataPickaxe(dataPickaxe_ID, EnumToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Pickaxes");
		dataAxe = (ItemDataAxe) new ItemDataAxe(dataAxe_ID, EnumToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Axes");
		dataHoe = (ItemDataHoe) new ItemDataHoe(dataHoe_ID, EnumToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Hoes");

		proxy.registerBlockRenderers();
		proxy.registerItemRenderers();

		String[] vanillaNames = CSArray.combine(CSArray.addToAll(vanillanames, "Nether ", " Ore"), CSArray.addToAll(vanillanames, "End ", " Ore"));
		String[] vanillaNames2 = CSArray.combine(CSArray.addToAll(vanillanames, "Dirt-Based ", " Ore"), CSArray.addToAll(vanillanames, "Sand-Based ", " Ore"));
		vanillaSpecialOres1 = (CustomBlock) new CustomBlock(vanillaOres_ID, Material.rock, vanillaNames, CSArray.addToAll(CSArray.combine(vanillaoverlays, vanillaoverlays), "", "overlay"), true, ClientProxy.oreRenderer,
				new CreativeTabs[] {netherOresTab, netherOresTab, netherOresTab, netherOresTab, netherOresTab, netherOresTab, netherOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab})
		.setUnlocalizedName("MM_VanillaSpecialOres").setHardness(2.15F);
		vanillaSpecialOres2 = (CustomBlock) new BlockVanillaSpecialOre(vanillaOres_ID2, Material.ground, vanillaNames2, CSArray.addToAll(CSArray.combine(vanillaoverlays, vanillaoverlays), "", "overlay"), true, ClientProxy.oreRenderer,
				new CreativeTabs[] {dirtOresTab, dirtOresTab, dirtOresTab, dirtOresTab, dirtOresTab, dirtOresTab, dirtOresTab, sandOresTab, sandOresTab, sandOresTab, sandOresTab, sandOresTab, sandOresTab, sandOresTab})
		.setUnlocalizedName("MM_VanillaSpecialOres2").setHardness(1.7F);

		stoneOres1 = (CustomBlock) new CustomBlock(stoneOres_ID1, Material.rock, CSArray.addToAll(names1, "", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres1").setHardness(2.3F);
		stoneOres2 = (CustomBlock) new CustomBlock(stoneOres_ID2, Material.rock, CSArray.addToAll(names2, "", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres2").setHardness(2.3F);
		stoneOres3 = (CustomBlock) new CustomBlock(stoneOres_ID3, Material.rock, CSArray.addToAll(names3, "", " Ore"), CSArray.addToAll(overlays3, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres3").setHardness(2.3F);
		stoneOres4 = (CustomBlock) new CustomBlock(stoneOres_ID4, Material.rock, CSArray.addToAll(names4, "", " Ore"), CSArray.addToAll(overlays4, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres4").setHardness(2.3F);
		stoneOres5 = (CustomBlock) new CustomBlock(stoneOres_ID5, Material.rock, CSArray.addToAll(names5, "", " Ore"), CSArray.addToAll(overlays5, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres5").setHardness(2.3F);
		stoneOres6 = (CustomBlock) new CustomBlock(stoneOres_ID6, Material.rock, CSArray.addToAll(names6, "", " Ore"), CSArray.addToAll(overlays6, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres6").setHardness(2.3F);
		stoneOres7 = (CustomBlock) new CustomBlock(stoneOres_ID7, Material.rock, CSArray.addToAll(names7, "", " Ore"), CSArray.addToAll(overlays7, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres7").setHardness(2.3F);
		stoneOres8 = (CustomBlock) new CustomBlock(stoneOres_ID8, Material.rock, CSArray.addToAll(names8, "", " Ore"), CSArray.addToAll(overlays8, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {stoneOresTab}).setUnlocalizedName("MM_StoneOres8").setHardness(2.3F);

		netherOres1 = (CustomBlock) new CustomBlock(netherOres_ID1, Material.rock, CSArray.addToAll(names1, "Nether ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres1").setHardness(2.1F);
		netherOres2 = (CustomBlock) new CustomBlock(netherOres_ID2, Material.rock, CSArray.addToAll(names2, "Nether ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres2").setHardness(2.1F);
		netherOres3 = (CustomBlock) new CustomBlock(netherOres_ID3, Material.rock, CSArray.addToAll(names3, "Nether ", " Ore"), CSArray.addToAll(overlays3, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres3").setHardness(2.1F);
		netherOres4 = (CustomBlock) new CustomBlock(netherOres_ID4, Material.rock, CSArray.addToAll(names4, "Nether ", " Ore"), CSArray.addToAll(overlays4, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres4").setHardness(2.1F);
		netherOres5 = (CustomBlock) new CustomBlock(netherOres_ID5, Material.rock, CSArray.addToAll(names5, "Nether ", " Ore"), CSArray.addToAll(overlays5, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres5").setHardness(2.1F);
		netherOres6 = (CustomBlock) new CustomBlock(netherOres_ID6, Material.rock, CSArray.addToAll(names6, "Nether ", " Ore"), CSArray.addToAll(overlays6, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres6").setHardness(2.1F);
		netherOres7 = (CustomBlock) new CustomBlock(netherOres_ID7, Material.rock, CSArray.addToAll(names7, "Nether ", " Ore"), CSArray.addToAll(overlays7, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres7").setHardness(2.1F);
		netherOres8 = (CustomBlock) new CustomBlock(netherOres_ID8, Material.rock, CSArray.addToAll(names8, "Nether ", " Ore"), CSArray.addToAll(overlays8, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {netherOresTab}).setUnlocalizedName("MM_NetherOres8").setHardness(2.1F);

		endOres1 = (CustomBlock) new CustomBlock(endOres_ID1, Material.rock, CSArray.addToAll(names1, "End ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres1").setHardness(2.2F);
		endOres2 = (CustomBlock) new CustomBlock(endOres_ID2, Material.rock, CSArray.addToAll(names2, "End ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres2").setHardness(2.2F);
		endOres3 = (CustomBlock) new CustomBlock(endOres_ID3, Material.rock, CSArray.addToAll(names3, "End ", " Ore"), CSArray.addToAll(overlays3, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres3").setHardness(2.2F);
		endOres4 = (CustomBlock) new CustomBlock(endOres_ID4, Material.rock, CSArray.addToAll(names4, "End ", " Ore"), CSArray.addToAll(overlays4, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres4").setHardness(2.2F);
		endOres5 = (CustomBlock) new CustomBlock(endOres_ID5, Material.rock, CSArray.addToAll(names5, "End ", " Ore"), CSArray.addToAll(overlays5, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres5").setHardness(2.2F);
		endOres6 = (CustomBlock) new CustomBlock(endOres_ID6, Material.rock, CSArray.addToAll(names6, "End ", " Ore"), CSArray.addToAll(overlays6, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres6").setHardness(2.2F);
		endOres7 = (CustomBlock) new CustomBlock(endOres_ID7, Material.rock, CSArray.addToAll(names7, "End ", " Ore"), CSArray.addToAll(overlays7, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres7").setHardness(2.2F);
		endOres8 = (CustomBlock) new CustomBlock(endOres_ID8, Material.rock, CSArray.addToAll(names8, "End ", " Ore"), CSArray.addToAll(overlays8, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {endOresTab}).setUnlocalizedName("MM_EndOres8").setHardness(2.2F);

		for (int i = 0; i < gemids.length; i++)
		{
			MoreMineralsHelper.getOreFromMetadata(gemids[i], "stone").setDrops(gemids[i] % 16, new ItemStack(gems, 1, i));
			MoreMineralsHelper.getOreFromMetadata(gemids[i], "nether").setDrops(gemids[i] % 16, new ItemStack(gems, 2, i));
			MoreMineralsHelper.getOreFromMetadata(gemids[i], "end").setDrops(gemids[i] % 16, new ItemStack(gems, 2, i));
		};

		dirtOres1 = (CustomBlock) new BlockDirtOre(dirtOres_ID1, Material.ground, CSArray.addToAll(names1, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres1").setHardness(1.7F);
		dirtOres2 = (CustomBlock) new BlockDirtOre(dirtOres_ID2, Material.ground, CSArray.addToAll(names2, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres2").setHardness(1.7F);
		dirtOres3 = (CustomBlock) new BlockDirtOre(dirtOres_ID3, Material.ground, CSArray.addToAll(names3, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays3, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres3").setHardness(1.7F);
		dirtOres4 = (CustomBlock) new BlockDirtOre(dirtOres_ID4, Material.ground, CSArray.addToAll(names4, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays4, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres4").setHardness(1.7F);
		dirtOres5 = (CustomBlock) new BlockDirtOre(dirtOres_ID5, Material.ground, CSArray.addToAll(names5, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays5, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres5").setHardness(1.7F);
		dirtOres6 = (CustomBlock) new BlockDirtOre(dirtOres_ID6, Material.ground, CSArray.addToAll(names6, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays6, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres6").setHardness(1.7F);
		dirtOres7 = (CustomBlock) new BlockDirtOre(dirtOres_ID7, Material.ground, CSArray.addToAll(names7, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays7, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres7").setHardness(1.7F);
		dirtOres8 = (CustomBlock) new BlockDirtOre(dirtOres_ID8, Material.ground, CSArray.addToAll(names8, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays8, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {dirtOresTab}).setUnlocalizedName("MM_DirtOres8").setHardness(1.7F);

		sandOres1 = (CustomBlock) new BlockSandOre(sandOres_ID1, Material.ground, CSArray.addToAll(names1, "Sand-Based ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres1").setHardness(1.7F);
		sandOres2 = (CustomBlock) new BlockSandOre(sandOres_ID2, Material.ground, CSArray.addToAll(names2, "Sand-Based ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres2").setHardness(1.7F);
		sandOres3 = (CustomBlock) new BlockSandOre(sandOres_ID3, Material.ground, CSArray.addToAll(names3, "Sand-Based ", " Ore"), CSArray.addToAll(overlays3, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres3").setHardness(1.7F);
		sandOres4 = (CustomBlock) new BlockSandOre(sandOres_ID4, Material.ground, CSArray.addToAll(names4, "Sand-Based ", " Ore"), CSArray.addToAll(overlays4, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres4").setHardness(1.7F);
		sandOres5 = (CustomBlock) new BlockSandOre(sandOres_ID5, Material.ground, CSArray.addToAll(names5, "Sand-Based ", " Ore"), CSArray.addToAll(overlays5, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres5").setHardness(1.7F);
		sandOres6 = (CustomBlock) new BlockSandOre(sandOres_ID6, Material.ground, CSArray.addToAll(names6, "Sand-Based ", " Ore"), CSArray.addToAll(overlays6, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres6").setHardness(1.7F);
		sandOres7 = (CustomBlock) new BlockSandOre(sandOres_ID7, Material.ground, CSArray.addToAll(names7, "Sand-Based ", " Ore"), CSArray.addToAll(overlays7, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres7").setHardness(1.7F);
		sandOres8 = (CustomBlock) new BlockSandOre(sandOres_ID8, Material.ground, CSArray.addToAll(names8, "Sand-Based ", " Ore"), CSArray.addToAll(overlays8, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {sandOresTab}).setUnlocalizedName("MM_SandOres8").setHardness(1.7F);

		storageBlocks1 = (CustomBlock) new CustomBlock(storageBlocks_ID1, Material.iron, CSArray.addToAll(names1, "Block of ", ""), CSArray.addToAll(overlays1, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks1").setHardness(2.5F);
		storageBlocks2 = (CustomBlock) new CustomBlock(storageBlocks_ID2, Material.iron, CSArray.addToAll(names2, "Block of ", ""), CSArray.addToAll(overlays2, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks2").setHardness(2.5F);
		storageBlocks3 = (CustomBlock) new CustomBlock(storageBlocks_ID3, Material.iron, CSArray.addToAll(names3, "Block of ", ""), CSArray.addToAll(overlays3, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks3").setHardness(2.5F);
		storageBlocks4 = (CustomBlock) new CustomBlock(storageBlocks_ID4, Material.iron, CSArray.addToAll(names4, "Block of ", ""), CSArray.addToAll(overlays4, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks4").setHardness(2.5F);
		storageBlocks5 = (CustomBlock) new CustomBlock(storageBlocks_ID5, Material.iron, CSArray.addToAll(names5, "Block of ", ""), CSArray.addToAll(overlays5, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks5").setHardness(2.5F);
		storageBlocks6 = (CustomBlock) new CustomBlock(storageBlocks_ID6, Material.iron, CSArray.addToAll(names6, "Block of ", ""), CSArray.addToAll(overlays6, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks6").setHardness(2.5F);
		storageBlocks7 = (CustomBlock) new CustomBlock(storageBlocks_ID7, Material.iron, CSArray.addToAll(names7, "Block of ", ""), CSArray.addToAll(overlays7, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks7").setHardness(2.5F);
		storageBlocks8 = (CustomBlock) new CustomBlock(storageBlocks_ID8, Material.iron, CSArray.addToAll(names8, "Block of ", ""), CSArray.addToAll(overlays8, "", "block"), new CreativeTabs[] {rawMaterialsTab}).setUnlocalizedName("MM_StorageBlocks8").setHardness(2.5F);

		oreCrusher = (BlockOreCrusher) new BlockOreCrusher(oreCrusher_ID, false).setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setCreativeTab(rawMaterialsTab).setUnlocalizedName("MM_OreCrusher");
		oreCrusherActive = (BlockOreCrusher) new BlockOreCrusher(oreCrusherActive_ID, false).setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("MM_OreCrusher");

		Block.oreCoal.setCreativeTab(stoneOresTab);
		Block.oreDiamond.setCreativeTab(stoneOresTab);
		Block.oreEmerald.setCreativeTab(stoneOresTab);
		Block.oreGold.setCreativeTab(stoneOresTab);
		Block.oreIron.setCreativeTab(stoneOresTab);
		Block.oreLapis.setCreativeTab(stoneOresTab);
		Block.oreRedstone.setCreativeTab(stoneOresTab);
		
		registerBlocks();
		addCraftingRecipes();
		addFurnaceRecipes();
		addCrusherRecipes();
		addOreDictionaryEntrys();
		setHarvestLevelsAndHardnessess();

		stoneOresTab.setIconItemStack(new ItemStack(MoreMineralsHelper.getOreFromMetadata(CSArray.valueOf(allnames, "Magnesium"), "stone"), 1, CSArray.valueOf(allnames, "Magnesium") % 16));
		netherOresTab.setIconItemStack(new ItemStack(MoreMineralsHelper.getOreFromMetadata(CSArray.valueOf(allnames, "Uranium"), "nether"), 1, CSArray.valueOf(allnames, "Uranium") % 16));
		endOresTab.setIconItemStack(new ItemStack(MoreMineralsHelper.getOreFromMetadata(CSArray.valueOf(allnames, "Ruby"), "end"), 1, CSArray.valueOf(allnames, "Ruby") % 16));
		dirtOresTab.setIconItemStack(new ItemStack(MoreMineralsHelper.getOreFromMetadata(CSArray.valueOf(allnames, "Iridium"), "dirt"), 1, CSArray.valueOf(allnames, "Iridium") % 16));
		sandOresTab.setIconItemStack(new ItemStack(MoreMineralsHelper.getOreFromMetadata(CSArray.valueOf(allnames, "Beryllium"), "sand"), 1, CSArray.valueOf(allnames, "Beryllium") % 16));
		rawMaterialsTab.setIconItemStack(new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Aluminium")));
		toolsTab.setIconItemStack(ItemDataTool.setToolMaterial(new ItemStack(dataPickaxe), silver));

		GameRegistry.registerTileEntity(TileEntityOreCrusher.class, "OreCrusher");
		GameRegistry.registerWorldGenerator(new MoreMineralsOreGenerator());
		NetworkRegistry.instance().registerGuiHandler(INSTANCE, proxy);

		addLocalizations();
	}

	private void setHarvestLevelsAndHardnessess()
	{
		for (int i = 0; i < splitnames.length; i++)
		{
			for (int j = 0; j < splitnames[i].length; j++)
			{
				int gentype = gentypes[j + (i * 16)];
				int harvestLevel = gentype <= 12 ? 3 : (gentype <= 32 ? 2 : (gentype <= 64 ? 1 : 0));
				MinecraftForge.setBlockHarvestLevel(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "stone"), "pickaxe", harvestLevel);
				MinecraftForge.setBlockHarvestLevel(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "nether"), "pickaxe", harvestLevel > 0 ? harvestLevel - 1 : harvestLevel);
				MinecraftForge.setBlockHarvestLevel(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "end"), "pickaxe", harvestLevel);
				MinecraftForge.setBlockHarvestLevel(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "storage"), "pickaxe", harvestLevel);
				MinecraftForge.setBlockHarvestLevel(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "sand"), i, "shovel", 1);
				MinecraftForge.setBlockHarvestLevel(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "dirt"), i, "shovel", 1);
				
				float stoneHardness = Block.stone.blockHardness + (6.4F / (float)gentype) + (gentype <= 24 ? 0.5F : 0F);
				float netherHardness = Block.netherrack.blockHardness + (6.4F / (float)gentype) + (gentype <= 24 ? 0.6F : 0F);
				float endHardness = Block.whiteStone.blockHardness + (6.4F / (float)gentype) + (gentype <= 24 ? 0.7F : 0F);
				float dirtHardness = Block.dirt.blockHardness + (6.4F / (float)gentype) + (gentype <= 24 ? 0.4F : 0F);
				float sandHardness = Block.sand.blockHardness + (6.4F / (float)gentype) + (gentype <= 24 ? 0.4F : 0F);
				float storageHardness = Block.blockIron.blockHardness + (6.4F / (float)gentype) + (gentype <= 24 ? 0.8F : 0F);
				MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "stone").setHardness(j, stoneHardness);
				MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "nether").setHardness(j, netherHardness);
				MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "end").setHardness(j, endHardness);
				MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "dirt").setHardness(j, dirtHardness);
				MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "sand").setHardness(j, sandHardness);
				MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "storage").setHardness(j, storageHardness);
			}
		}
		for (int i = 0; i < 14; i++)
		{
			int vanillaOreType = i % 7;
			int harvestLevel = 0;
			if (i == 1 || i == 2 || i == 3 || i == 6) //Diamond, Emerald, Gold, Redstone
				harvestLevel = 2; //Iron
			else if (i == 4 || i == 5)
				harvestLevel = 1; //Stone
			MinecraftForge.setBlockHarvestLevel(vanillaSpecialOres1, i, "pickaxe", harvestLevel);
			MinecraftForge.setBlockHarvestLevel(vanillaSpecialOres2, i, "shovel", harvestLevel > 0 ? harvestLevel - 1 : 0);
		}
	}

	public void addLocalizations()
	{
		CSLang.addLocalizationUS("itemGroup.MM_stoneores", "Minerals");
		CSLang.addLocalizationUS("itemGroup.MM_netherores", "Nether Minerals");
		CSLang.addLocalizationUS("itemGroup.MM_endores", "End Minerals");
		CSLang.addLocalizationUS("itemGroup.MM_dirtores", "Dirt-Based Minerals");
		CSLang.addLocalizationUS("itemGroup.MM_sandores", "Sand-Based Minerals");
		CSLang.addLocalizationUS("itemGroup.MM_rawmaterials", "Mineral Materials");
		CSLang.addLocalizationUS("itemGroup.MM_tools", "Mineral Tools");

		CSLang.addLocalizationUS("container.orecrusher", "Ore Crusher");
		CSLang.addLocalizationDE("container.orecrusher", "Erz Crusher");

		ModLoader.addName(oreCrusher, "Ore Crusher");
		ModLoader.addName(oreCrusherActive, "Ore Crusher");
	}

	public void addOreDictionaryEntrys()
	{
		//Type 1 Ores
		for (int i = 0; i < splitnames.length; i++)
		{
			for (int j = 0; j < splitnames[i].length; j++)
			{
				CSCrafting.registerOre("ore" + splitnames[i][j], new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "stone"), 1, j));
				CSCrafting.registerOre("oreNether" + splitnames[i][j], new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "nether"), 1, j));
				CSCrafting.registerOre("oreEnd" + splitnames[i][j], new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "end"), 1, j));
				CSCrafting.registerOre("oreDirt" + splitnames[i][j], new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "dirt"), 1, j));
				CSCrafting.registerOre("oreSand" + splitnames[i][j], new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "sand"), 1, j));
				CSCrafting.registerOre("block" + splitnames[i][j], new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "storage"), 1, j));

				CSCrafting.registerOre("ingot" + allnames[j + (i * 16)], new ItemStack(ingots, 1, j + (i * 16)));
				CSCrafting.registerOre("dust" + allnames[j + (i * 16)], new ItemStack(dusts, 1, j + (i * 16)));
				CSCrafting.registerOre("nugget" + allnames[j + (i * 16)], new ItemStack(nuggets, 1, j + (i * 16)));
			}
		}

		//Gems
		for (int i = 0; i < gemids.length; i++)
		{
			CSCrafting.registerOre("gem" + allnames[gemids[i]], new ItemStack(gems, 1, gemids[i]));
		}

		//Vanilla Special Ores
		for (int i = 0; i < (vanillanames.length * 4); i++)
		{
			if (i < 7) //Nether Ores
			{
				CSCrafting.registerOre("oreNether" + vanillanames[i], new ItemStack(vanillaSpecialOres1, 1, i));
				CSCrafting.registerOre("ingot" + vanillanames[i], new ItemStack(vanillaSpecialItems, 1, i));
			}
			else if (i < 14) //End Ores
			{
				CSCrafting.registerOre("oreEnd" + vanillanames[i - 7], new ItemStack(vanillaSpecialOres1, 1, i));
				CSCrafting.registerOre("dust" + vanillanames[i - 7], new ItemStack(vanillaSpecialItems, 1, i));
			}
			else if (i < 21) //Dirt Ores
			{
				CSCrafting.registerOre("oreDirt" + vanillanames[i - 14], new ItemStack(vanillaSpecialOres2, 1, i - 14));
				CSCrafting.registerOre("nugget" + vanillanames[i - 14], new ItemStack(vanillaSpecialItems, 1, i));
			}
			else if (i < 28) //Sand Ores
				CSCrafting.registerOre("oreSand" + vanillanames[i - 21], new ItemStack(vanillaSpecialOres2, 1, i - 14));
		}
	}

	public void addCraftingRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(oreCrusher, 1, 3), new Object[]{
			"tct",
			"cTc",
			"tct",
			't', new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Tin")),
			'c', new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Chrome")),
			'T', new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Titanium")),
		});

		for (int i = 0; i < 128; i++)
		{
			ItemStack is = (CSArray.contains(gemids, i) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, i)) : new ItemStack(ingots, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(MoreMineralsHelper.getOreFromMetadata(i, "storage"), 1, i % 16),
					is,
					is,
					is,
					is,
					is,
					is,
					is,
					is,
					is);
			GameRegistry.addShapelessRecipe(is,
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i),
					new ItemStack(nuggets, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(nuggets, 9, i), is);
			GameRegistry.addShapelessRecipe(new ItemStack(is.getItem(), 9, is.getItemDamage()), new ItemStack(MoreMineralsHelper.getOreFromMetadata(i, "storage"), 1, i % 16));
		}
		for (int i = 0; i < vanillanames.length; i++)
		{
			Block storageBlock = i == 1 ? Block.blockDiamond : (i == 2 ? Block.blockEmerald : (i == 3 ? Block.blockGold : (i == 4 ? Block.blockIron : (i == 5 ? Block.blockLapis : i == 6 ? Block.blockRedstone : null))));
			if (storageBlock != null)
				GameRegistry.addShapelessRecipe(new ItemStack(storageBlock),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i),
						new ItemStack(vanillaSpecialItems, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 1, i),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14),
					new ItemStack(vanillaSpecialItems, 1, i + 14));
			GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 9, i + 14), new ItemStack(vanillaSpecialItems, 1, i));
		}
		GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 9, 14), new ItemStack(Item.coal));
		GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 9, 15), new ItemStack(Item.diamond));
		GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 9, 16), new ItemStack(Item.emerald));
		GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 9, 18), new ItemStack(Item.ingotIron));
		GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 9, 19), new ItemStack(Item.dyePowder, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(vanillaSpecialItems, 9, 20), new ItemStack(Item.redstone));

		addToolCraftingRecipes();
	}

	public void addToolCraftingRecipes()
	{
		for (int i = 0; i < 5; i++)
		{
			Item tool = i == 0 ? dataSword : (i == 1 ? dataSpade : (i == 2 ? dataPickaxe : (i == 3 ? dataAxe : dataHoe)));

			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), adamantite), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Adamantite")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), cobalt), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Cobalt")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), demonite), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Demonite")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), mythril), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Mythril")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), aluminium), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Aluminium")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), chrome), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Chrome")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), copper), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Copper")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), silver), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Silver")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), tin), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Tin")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), titanium), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Titanium")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), emerald), new ItemStack(vanillaSpecialItems, 1, CSArray.valueOf(vanillanames, "Emerald")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), ruby), new ItemStack(gems, 1, CSArray.valueOf(gemnames, "Ruby")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(tool), sapphire), new ItemStack(gems, 1, CSArray.valueOf(gemnames, "Sapphire")), i);
		}
	}

	public void addFurnaceRecipes()
	{
		for (int i = 0; i < splitnames.length; i++)
		{
			for (int j = 0; j < splitnames[i].length; j++)
			{
				ItemStack is = (CSArray.contains(gemids, (j + (i * 16))) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, j + (i * 16))) : new ItemStack(ingots, 1, j + (i * 16)));
				ItemStack is2 = new ItemStack(is.getItem(), 2, is.getItemDamage());

				CSCrafting.addSmelting(new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "stone"), 1, j), is, 0.1F);
				CSCrafting.addSmelting(new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "nether"), 1, j), is2, 0.2F);
				CSCrafting.addSmelting(new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "end"), 1, j), is2, 0.2F);
				CSCrafting.addSmelting(new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "dirt"), 1, j), new ItemStack(nuggets, 2, j + (i * 16)), 0.01F);
				CSCrafting.addSmelting(new ItemStack(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "sand"), 1, j), new ItemStack(nuggets, 3, j + (i * 16)), 0.015F);

				CSCrafting.addSmelting(new ItemStack(dusts, 1, j + (i * 16)), is, 0.001F);
			}
		}
		for (int i = 0; i < (vanillanames.length * 4); i++)
		{
			if (i < 7) //Nether Ores
			{
				ItemStack is = i == 3 ? new ItemStack(Item.ingotGold, 2) : (i == 4 ? new ItemStack(Item.ingotIron, 2) : new ItemStack(vanillaSpecialItems, 2, i));
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres1, 1, i), is, 0.1F);
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialItems, 1, i + 7), is, 0.1F);
			}
			else if (i < 14) //End Ores
			{
				ItemStack is = i % 7 == 3 ? new ItemStack(Item.ingotGold, 2) : (i % 7 == 4 ? new ItemStack(Item.ingotIron, 2) : new ItemStack(vanillaSpecialItems, 2, i - 7));
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres1, 1, i), new ItemStack(vanillaSpecialItems, 2, i - 7), 0.1F);
			}
			else if (i < 21) //Dirt Ores
			{
				ItemStack is = i % 7 == 3 ? new ItemStack(Item.ingotGold, 2) : (i % 7 == 4 ? new ItemStack(Item.ingotIron, 2) : new ItemStack(vanillaSpecialItems, 2, i - 7));
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres2, 1, i - 14), new ItemStack(vanillaSpecialItems, 2, i), 0.01F);
			}
			else if (i < 28) //Sand Ores
			{
				ItemStack is = i % 7 == 3 ? new ItemStack(Item.goldNugget, 3) : new ItemStack(vanillaSpecialItems, 3, i - 7);
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres2, 1, i - 14), new ItemStack(vanillaSpecialItems, 3, i - 7), 0.015F);
			}
		}
	}

	public void addCrusherRecipes()
	{
		for (int i = 0; i < splitnames.length; i++)
		{
			for (int j = 0; j < splitnames[i].length; j++)
			{
				ItemStack is = (CSArray.contains(gemids, j + (i * 16)) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, j + (i * 16))) : new ItemStack(ingots, 1, j + (i * 16)));

				OreCrusherRecipes.crushing().addCrushing(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "stone").blockID, j, new ItemStack(dusts, 2, j + (i * 16)), 0.1F);
				OreCrusherRecipes.crushing().addCrushing(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "nether").blockID, j, new ItemStack(dusts, 4, j + (i * 16)), 0.2F);
				OreCrusherRecipes.crushing().addCrushing(MoreMineralsHelper.getOreFromMetadata(j + (i * 16), "end").blockID, j, new ItemStack(dusts, 4, j + (i * 16)), 0.2F);

				OreCrusherRecipes.crushing().addCrushing(is.itemID, is.getItemDamage(), new ItemStack(dusts, 1, j + (i * 16)), 0F);
			}
		}
		for (int i = 0; i < vanillanames.length; i++)
		{
			OreCrusherRecipes.crushing().addCrushing(vanillaSpecialItems.itemID, i, new ItemStack(vanillaSpecialItems, 1, i + 7), 0F);

			OreCrusherRecipes.crushing().addCrushing(vanillaSpecialOres1.blockID, i, new ItemStack(vanillaSpecialItems, 4, i + 7), 0.2F);
			OreCrusherRecipes.crushing().addCrushing(vanillaSpecialOres1.blockID, i + 7, new ItemStack(vanillaSpecialItems, 4, i + 7), 0.2F);
		}
		for (int i = 0; i < gemids.length; i++)
		{
			OreCrusherRecipes.crushing().addCrushing(dusts.itemID, gemids[i], new ItemStack(gems, 1, i), 0F);
		}
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Block.oreCoal), new ItemStack(vanillaSpecialItems, 2, 7), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Block.oreDiamond), new ItemStack(vanillaSpecialItems, 2, 8), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Block.oreEmerald), new ItemStack(vanillaSpecialItems, 2, 9), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Block.oreGold), new ItemStack(vanillaSpecialItems, 2, 10), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Block.oreIron), new ItemStack(vanillaSpecialItems, 2, 11), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Block.oreLapis), new ItemStack(vanillaSpecialItems, 2, 12), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Block.oreRedstone), new ItemStack(vanillaSpecialItems, 2, 13), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Item.coal), new ItemStack(vanillaSpecialItems, 1, 7), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Item.diamond), new ItemStack(vanillaSpecialItems, 1, 8), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Item.emerald), new ItemStack(vanillaSpecialItems, 1, 9), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Item.ingotGold), new ItemStack(vanillaSpecialItems, 1, 10), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Item.ingotIron), new ItemStack(vanillaSpecialItems, 1, 11), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Item.dyePowder, 1, 4), new ItemStack(vanillaSpecialItems, 1, 12), 0F);
		OreCrusherRecipes.crushing().addCrushing(new ItemStack(Item.redstone), new ItemStack(vanillaSpecialItems, 9, 13), 0F);
	}

	public void registerBlocks()
	{
		GameRegistry.registerBlock(vanillaSpecialOres1, ItemCustomBlock.class, "MoreMineralsSpecialVanillaOres");
		GameRegistry.registerBlock(vanillaSpecialOres2, ItemCustomBlock.class, "MoreMineralsSpecialVanillaOres2");
		vanillaSpecialOres1.addNames();
		vanillaSpecialOres2.addNames();
		for (int i = 0; i < 8; i++)
		{
			GameRegistry.registerBlock(MoreMineralsHelper.getOreFromMetadata(i * 16, "stone"), ItemCustomBlock.class, "MoreMineralsStoneOres" + i);
			GameRegistry.registerBlock(MoreMineralsHelper.getOreFromMetadata(i * 16, "nether"), ItemCustomBlock.class, "MoreMineralsNetherOres" + i);
			GameRegistry.registerBlock(MoreMineralsHelper.getOreFromMetadata(i * 16, "end"), ItemCustomBlock.class, "MoreMineralsEndOres" + i);
			GameRegistry.registerBlock(MoreMineralsHelper.getOreFromMetadata(i * 16, "dirt"), ItemCustomBlock.class, "MoreMineralsDirtOres" + i);
			GameRegistry.registerBlock(MoreMineralsHelper.getOreFromMetadata(i * 16, "sand"), ItemCustomBlock.class, "MoreMineralsSandOres" + i);
			GameRegistry.registerBlock(MoreMineralsHelper.getOreFromMetadata(i * 16, "storage"), ItemCustomBlock.class, "MoreMineralsStorageBlocks" + i);
			MoreMineralsHelper.getOreFromMetadata(i * 16, "stone").addNames();
			MoreMineralsHelper.getOreFromMetadata(i * 16, "nether").addNames();
			MoreMineralsHelper.getOreFromMetadata(i * 16, "end").addNames();
			MoreMineralsHelper.getOreFromMetadata(i * 16, "dirt").addNames();
			MoreMineralsHelper.getOreFromMetadata(i * 16, "sand").addNames();
			MoreMineralsHelper.getOreFromMetadata(i * 16, "storage").addNames();
		}
		GameRegistry.registerBlock(oreCrusher, ItemBlock.class, "MoreMineralsOreCrusher");
		GameRegistry.registerBlock(oreCrusherActive, ItemBlock.class, "MoreMineralsOreCrusherActive");
	}
}