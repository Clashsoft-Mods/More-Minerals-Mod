package clashsoft.mods.moreminerals;

import clashsoft.cslib.minecraft.ClashsoftMod;
import clashsoft.cslib.minecraft.block.CSBlocks;
import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.cslib.minecraft.crafting.CSCrafting;
import clashsoft.cslib.minecraft.crafting.RepairDataTools;
import clashsoft.cslib.minecraft.creativetab.CustomCreativeTab;
import clashsoft.cslib.minecraft.item.CSItems;
import clashsoft.cslib.minecraft.item.CSStacks;
import clashsoft.cslib.minecraft.item.CustomItem;
import clashsoft.cslib.minecraft.item.block.ItemCustomBlock;
import clashsoft.cslib.minecraft.item.datatools.*;
import clashsoft.cslib.minecraft.update.CSUpdate;
import clashsoft.cslib.minecraft.util.CSConfig;
import clashsoft.cslib.util.CSArrays;
import clashsoft.cslib.util.CSString;
import clashsoft.mods.moreminerals.block.*;
import clashsoft.mods.moreminerals.common.MMMProxy;
import clashsoft.mods.moreminerals.orecrusher.CrusherRecipes;
import clashsoft.mods.moreminerals.tileentity.TileEntityOreCrusher;
import clashsoft.mods.moreminerals.world.gen.MMMOreGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;

@Mod(modid = MoreMineralsMod.MODID, name = MoreMineralsMod.NAME, version = MoreMineralsMod.VERSION)
public class MoreMineralsMod extends ClashsoftMod
{
	public static final String		MODID			= "moreminerals";
	public static final String		NAME			= "More Minerals Mod";
	public static final String		ACRONYM			= "mmm";
	public static final String		VERSION			= CSUpdate.CURRENT_VERSION + "-1.0.0-dev";
	
	@Instance("MoreMineralsMod")
	public static MoreMineralsMod	INSTANCE;
	
	@SidedProxy(clientSide = "clashsoft.mods.moreminerals.client.MMMClientProxy", serverSide = "clashsoft.mods.moreminerals.common.MMMProxy")
	public static MMMProxy	proxy;
	
	public static CustomCreativeTab	stoneOresTab	= new CustomCreativeTab("stone_ores");
	public static CustomCreativeTab	netherOresTab	= new CustomCreativeTab("nether_ores");
	public static CustomCreativeTab	endOresTab		= new CustomCreativeTab("end_ores");
	public static CustomCreativeTab	dirtOresTab		= new CustomCreativeTab("dirt_ores");
	public static CustomCreativeTab	sandOresTab		= new CustomCreativeTab("sand_ores");
	public static CustomCreativeTab	rawMaterialsTab	= new CustomCreativeTab("materials");
	public static CustomCreativeTab	toolsTab		= new CustomCreativeTab("mineral_tools");
	
	public static int				oreCrusherTEID	= 15;
	
	public static int[]				overworldGen	= new int[] { 32, 32, 0, 0, 0, 28, 13, 0, // Silicon
			0, 0, 0, 0, 0, 12, 32, 16, // Chrome
			24, 0, 0, 32, 64, 0, 0, 0, // Germanium
			0, 0, 0, 0, 0, 0, 0, 16, // Molybdenum
			0, 0, 0, 0, 32, 0, 0, 64, // Tin
			0, 0, 0, 0, 0, 0, 0, 0, // Preasodynmium
			0, 0, 0, 0, 0, 0, 0, 0, // Holmium
			0, 0, 0, 0, 0, 0, 16, 0, // Rhemium
			0, 12, 16, 0, 0, 0, 48, 0, // Bismuth
			0, 0, 0, 0, 0, 0, 0, 24, // Uranium
			0, 0, 12, 14, 20, 16, 24, 24, // Ruby
			24, 24, 16, 16, 0, 0, 0, 0, // -
			0, 0, 0, 0, 0, 0, 0, 0, // -
			0, 0, 0, 0, 0, 0, 0, 0, // -
			0, 0, 0, 0, 0, 0, 0, 0, // -
			0, 0, 0, 0, 0, 0, 0, 0					// -
													};
	public static int[]				netherGen		= overworldGen, endGen = overworldGen, dirtGen = overworldGen, sandGen = overworldGen;
	
	public static int[]				vanillaGen		= new int[] { 128, 16, 32, 32, 64, 32, 16, 128 };
	
	public static String[]			names			= new String[] { "Lithium", "Beryllium", "%&Boron", "%&Carbon", "%&Sodium", "Magnesium", "Aluminium", "%&Silicon", // -
			"%&Phosphorus", "%&Sulfur", "%&Potassium", "%&Calcium", "%&Scandium", "Titanium", "Vanadium", "Chrome", // -
			"Manganese", "%&Iron", "%&Cobalt", "Nickel", "Copper", "%&Zinc", "%&Gallium", "%&Germanium", // -
			"%&Arsenic", "%&Selenium", "%&Rubidium", "%&Strontium", "%&Yttrium", "%&Zirconium", "%&Niobium", "Molybdenum", // -
			"%&Technetium", "%&Ruthenium", "%&Rhodium", "%&Palladium", "Silver", "%&Cadmium", "%&Indium", "Tin", // -
			"%&Antimony", "%&Tellurium", "%&Iodine", "%&Caesium", "%&Barium", "%&Lanthanum", "%&Cerium", "%&Praseodymium", // -
			"%&Neodynium", "%&Promethium", "%&Samarium", "%&Europium", "%&Gadolinium", "%&Terbium", "%&Dysprosium", "%&Holmium", // -
			"%&Erbium", "%&Thulium", "%&Ytterbium", "%&Lutetium", "%&Hafnium", "%&Tantalum", "Tungsten", "%&Rhenium", // -
			"%&Osmium", "Iridium", "Platinum", "%&Gold", "%&Mercury", "%&Thallium", "Lead", "%&Bismuth", // -
			"%&Polonium", "%&Astatine", "%&Francium", "%&Radium", "%&Actinium", "%&Thorium", "%&Protactinium", "Uranium", // -
			"%&Neptunium", "%&Plutonium", "Adamantite", "Cobalt", "Demonite", "Mythril", "Amethyst", "Ruby", // -
			"Sapphire", "Topaz", "Spinel", "Opal", "%&", "%&", "%&", "%&", // -
			"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&", // -
			"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&", // -
			"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&", // -
			"%&", "%&", "%&", "%&", "%&", "%&", "%&", "%&", };
	public static String[][]		splitnames		= CSArrays.split(names, 16);
	public static String[]			names1			= splitnames[0];
	public static String[]			names2			= splitnames[1];
	public static String[]			names3			= splitnames[2];
	public static String[]			names4			= splitnames[3];
	public static String[]			names5			= splitnames[4];
	public static String[]			names6			= splitnames[5];
	public static String[]			names7			= splitnames[6];
	public static String[]			names8			= splitnames[7];
	public static String[]			gemNames		= new String[] { "Amethyst", "Ruby", "Sapphire", "Topaz", "Spinel", "Opal" };
	public static String[]			vanillaNames	= new String[] { "Coal", "Diamond", "Emerald", "Gold", "Iron", "Lapislazuli", "Redstone", "Quartz" };
	
	public static String[]			alloverlays		= CSString.caseAll(names, 0);
	public static String[]			overlays1		= CSString.caseAll(names1, 0);
	public static String[]			overlays2		= CSString.caseAll(names2, 0);
	public static String[]			overlays3		= CSString.caseAll(names3, 0);
	public static String[]			overlays4		= CSString.caseAll(names4, 0);
	public static String[]			overlays5		= CSString.caseAll(names5, 0);
	public static String[]			overlays6		= CSString.caseAll(names6, 0);
	public static String[]			overlays7		= CSString.caseAll(names7, 0);
	public static String[]			overlays8		= CSString.caseAll(names8, 0);
	public static String[]			gemoverlays		= CSString.caseAll(gemNames, 0);
	public static String[]			vanillaoverlays	= CSString.caseAll(vanillaNames, 0);
	
	private static int[]			gemids			= new int[] { CSArrays.indexOf(names, "Amethyst"), CSArrays.indexOf(names, "Ruby"), CSArrays.indexOf(names, "Sapphire"), CSArrays.indexOf(names, "Topaz"), CSArrays.indexOf(names, "Spinel"), CSArrays.indexOf(names, "Opal") };
	
	public static CustomBlock		vanillaNetherEndOres;
	public static CustomBlock		vanillaDirtSandOres;
	public static CustomBlock		stoneOres1, stoneOres2, stoneOres3, stoneOres4, stoneOres5, stoneOres6, stoneOres7, stoneOres8;
	public static CustomBlock		netherOres1, netherOres2, netherOres3, netherOres4, netherOres5, netherOres6, netherOres7, netherOres8;
	public static CustomBlock		endOres1, endOres2, endOres3, endOres4, endOres5, endOres6, endOres7, endOres8;
	public static CustomBlock		dirtOres1, dirtOres2, dirtOres3, dirtOres4, dirtOres5, dirtOres6, dirtOres7, dirtOres8;
	public static CustomBlock		sandOres1, sandOres2, sandOres3, sandOres4, sandOres5, sandOres6, sandOres7, sandOres8;
	public static CustomBlock		storageBlocks1, storageBlocks2, storageBlocks3, storageBlocks4, storageBlocks5, storageBlocks6, storageBlocks7, storageBlocks8;
	
	public static BlockOreCrusher	oreCrusher;
	public static BlockOreCrusher	oreCrusherActive;
	
	public static CustomItem		vanillaItems;
	public static CustomItem		ingots;
	public static CustomItem		dusts;
	public static CustomItem		nuggets;
	public static CustomItem		gems;
	
	public static ItemDataSword		dataSword;
	public static ItemDataSpade		dataSpade;
	public static ItemDataPickaxe	dataPickaxe;
	public static ItemDataAxe		dataAxe;
	public static ItemDataHoe		dataHoe;
	
	public static ToolMaterial		adamantite, cobalt, demonite, mythril, aluminium, chrome, copper, silver, tin, titanium, emerald, ruby, sapphire;
	
	public static ItemStack[]		vanillaIngots;
	public static ItemStack[]		vanillaDusts;
	public static ItemStack[]		vanillaNuggets;
	
	public MoreMineralsMod()
	{
		super(proxy, MODID, NAME, ACRONYM, VERSION);
		this.hasConfig = true;
	}
	
	@Override
	public void readConfig()
	{
		oreCrusherTEID = CSConfig.getTileEntity("Ore Crusher", oreCrusherTEID);
	}
	
	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		vanillaItems = (CustomItem) new CustomItem(CSArrays.concat(CSString.concatAll(vanillaNames, "", " Ingot"), CSString.concatAll(vanillaNames, "", " Dust"), CSString.concatAll(vanillaNames, "", " Nugget")), CSArrays.concat(CSArrays.concat(CSString.concatAll(vanillaoverlays, "ingot", ""), CSString.concatAll(vanillaoverlays, "dust", "")), CSString.concatAll(vanillaoverlays, "nugget", ""))).setMetadataEnabled(false, 3, 4, 13, 17).setUnlocalizedName("MM_VanillaSpecialItems").setCreativeTab(rawMaterialsTab);
		
		vanillaIngots = new ItemStack[] { new ItemStack(vanillaItems, 1, 0), new ItemStack(vanillaItems, 1, 1), new ItemStack(vanillaItems, 1, 2), new ItemStack(Items.gold_ingot), new ItemStack(Items.iron_ingot), new ItemStack(vanillaItems, 1, 5), new ItemStack(vanillaItems, 1, 6), new ItemStack(vanillaItems, 1, 7) };
		vanillaDusts = new ItemStack[] { new ItemStack(vanillaItems, 1, 8), new ItemStack(vanillaItems, 1, 9), new ItemStack(vanillaItems, 1, 10), new ItemStack(vanillaItems, 1, 11), new ItemStack(vanillaItems, 1, 12), new ItemStack(vanillaItems, 1, 13), new ItemStack(Items.redstone), new ItemStack(vanillaItems, 1, 15) };
		vanillaNuggets = new ItemStack[] { new ItemStack(vanillaItems, 1, 16), new ItemStack(vanillaItems, 1, 17), new ItemStack(vanillaItems, 1, 18), new ItemStack(Items.gold_nugget), new ItemStack(vanillaItems, 1, 20), new ItemStack(vanillaItems, 1, 21), new ItemStack(vanillaItems, 1, 22), new ItemStack(vanillaItems, 1, 23) };
		
		ingots = (CustomItem) new CustomItem(CSString.concatAll(names, "", " Ingot"), CSString.concatAll(alloverlays, "ingot", "")).setMetadataEnabled(false, gemids).setUnlocalizedName("MM_Ingots").setCreativeTab(rawMaterialsTab);
		dusts = (CustomItem) new CustomItem(CSString.concatAll(names, "", " Dust"), CSString.concatAll(alloverlays, "dust", "")).setUnlocalizedName("MM_Dusts").setCreativeTab(rawMaterialsTab);
		nuggets = (CustomItem) new CustomItem(CSString.concatAll(names, "", " Nugget"), CSString.concatAll(alloverlays, "nugget", "")).setUnlocalizedName("MM_Nuggets").setCreativeTab(rawMaterialsTab);
		gems = (CustomItem) new CustomItem(gemNames, CSString.concatAll(gemoverlays, "gem", "")).setUnlocalizedName("MM_Gems").setCreativeTab(rawMaterialsTab);
		
		dataSword = (ItemDataSword) new ItemDataSword(ToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Swords");
		dataSpade = (ItemDataSpade) new ItemDataSpade(ToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Spades");
		dataPickaxe = (ItemDataPickaxe) new ItemDataPickaxe(ToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Pickaxes");
		dataAxe = (ItemDataAxe) new ItemDataAxe(ToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Axes");
		dataHoe = (ItemDataHoe) new ItemDataHoe(ToolMaterial.IRON).setCreativeTab(toolsTab).setUnlocalizedName("MM_Hoes");
		
		String[] vanillaNames1 = CSArrays.concat(CSString.concatAll(vanillaNames, "Nether ", " Ore"), CSString.concatAll(vanillaNames, "End ", " Ore"));
		String[] vanillaNames2 = CSArrays.concat(CSString.concatAll(vanillaNames, "Dirt-Based ", " Ore"), CSString.concatAll(vanillaNames, "Sand-Based ", " Ore"));
		vanillaNetherEndOres = (CustomBlock) new CustomBlock(Material.rock, vanillaNames1, CSString.concatAll(CSArrays.concat(vanillaoverlays, vanillaoverlays), "", "overlay"), new CreativeTabs[] { netherOresTab, netherOresTab, netherOresTab, netherOresTab, netherOresTab, netherOresTab, netherOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab, endOresTab }).setBlockName("MM_VanillaSpecialOres").setHardness(2.15F);
		vanillaDirtSandOres = (CustomBlock) new BlockVanillaSpecialOre(vanillaNames2, CSString.concatAll(CSArrays.concat(vanillaoverlays, vanillaoverlays), "", "overlay")).setBlockName("MM_VanillaSpecialOres2").setHardness(1.7F);
		
		stoneOres1 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names1, "", " Ore"), CSString.concatAll(overlays1, "", "overlay")).setHardness(2.3F);
		stoneOres2 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names2, "", " Ore"), CSString.concatAll(overlays2, "", "overlay")).setHardness(2.3F);
		stoneOres3 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names3, "", " Ore"), CSString.concatAll(overlays3, "", "overlay")).setHardness(2.3F);
		stoneOres4 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names4, "", " Ore"), CSString.concatAll(overlays4, "", "overlay")).setHardness(2.3F);
		stoneOres5 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names5, "", " Ore"), CSString.concatAll(overlays5, "", "overlay")).setHardness(2.3F);
		stoneOres6 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names6, "", " Ore"), CSString.concatAll(overlays6, "", "overlay")).setHardness(2.3F);
		stoneOres7 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names7, "", " Ore"), CSString.concatAll(overlays7, "", "overlay")).setHardness(2.3F);
		stoneOres8 = (CustomBlock) new BlockStoneOre(CSString.concatAll(names8, "", " Ore"), CSString.concatAll(overlays8, "", "overlay")).setHardness(2.3F);
		
		netherOres1 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names1, "Nether ", " Ore"), CSString.concatAll(overlays1, "", "overlay")).setHardness(2.1F);
		netherOres2 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names2, "Nether ", " Ore"), CSString.concatAll(overlays2, "", "overlay")).setHardness(2.1F);
		netherOres3 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names3, "Nether ", " Ore"), CSString.concatAll(overlays3, "", "overlay")).setHardness(2.1F);
		netherOres4 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names4, "Nether ", " Ore"), CSString.concatAll(overlays4, "", "overlay")).setHardness(2.1F);
		netherOres5 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names5, "Nether ", " Ore"), CSString.concatAll(overlays5, "", "overlay")).setHardness(2.1F);
		netherOres6 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names6, "Nether ", " Ore"), CSString.concatAll(overlays6, "", "overlay")).setHardness(2.1F);
		netherOres7 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names7, "Nether ", " Ore"), CSString.concatAll(overlays7, "", "overlay")).setHardness(2.1F);
		netherOres8 = (CustomBlock) new BlockNetherOre(CSString.concatAll(names8, "Nether ", " Ore"), CSString.concatAll(overlays8, "", "overlay")).setHardness(2.1F);
		
		endOres1 = (CustomBlock) new BlockEndOre(CSString.concatAll(names1, "End ", " Ore"), CSString.concatAll(overlays1, "", "overlay")).setHardness(2.2F);
		endOres2 = (CustomBlock) new BlockEndOre(CSString.concatAll(names2, "End ", " Ore"), CSString.concatAll(overlays2, "", "overlay")).setHardness(2.2F);
		endOres3 = (CustomBlock) new BlockEndOre(CSString.concatAll(names3, "End ", " Ore"), CSString.concatAll(overlays3, "", "overlay")).setHardness(2.2F);
		endOres4 = (CustomBlock) new BlockEndOre(CSString.concatAll(names4, "End ", " Ore"), CSString.concatAll(overlays4, "", "overlay")).setHardness(2.2F);
		endOres5 = (CustomBlock) new BlockEndOre(CSString.concatAll(names5, "End ", " Ore"), CSString.concatAll(overlays5, "", "overlay")).setHardness(2.2F);
		endOres6 = (CustomBlock) new BlockEndOre(CSString.concatAll(names6, "End ", " Ore"), CSString.concatAll(overlays6, "", "overlay")).setHardness(2.2F);
		endOres7 = (CustomBlock) new BlockEndOre(CSString.concatAll(names7, "End ", " Ore"), CSString.concatAll(overlays7, "", "overlay")).setHardness(2.2F);
		endOres8 = (CustomBlock) new BlockEndOre(CSString.concatAll(names8, "End ", " Ore"), CSString.concatAll(overlays8, "", "overlay")).setHardness(2.2F);
		
		dirtOres1 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names1, "Dirt-Based ", " Ore"), CSString.concatAll(overlays1, "", "overlay")).setHardness(1.7F);
		dirtOres2 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names2, "Dirt-Based ", " Ore"), CSString.concatAll(overlays2, "", "overlay")).setHardness(1.7F);
		dirtOres3 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names3, "Dirt-Based ", " Ore"), CSString.concatAll(overlays3, "", "overlay")).setHardness(1.7F);
		dirtOres4 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names4, "Dirt-Based ", " Ore"), CSString.concatAll(overlays4, "", "overlay")).setHardness(1.7F);
		dirtOres5 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names5, "Dirt-Based ", " Ore"), CSString.concatAll(overlays5, "", "overlay")).setHardness(1.7F);
		dirtOres6 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names6, "Dirt-Based ", " Ore"), CSString.concatAll(overlays6, "", "overlay")).setHardness(1.7F);
		dirtOres7 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names7, "Dirt-Based ", " Ore"), CSString.concatAll(overlays7, "", "overlay")).setHardness(1.7F);
		dirtOres8 = (CustomBlock) new BlockDirtOre(CSString.concatAll(names8, "Dirt-Based ", " Ore"), CSString.concatAll(overlays8, "", "overlay")).setHardness(1.7F);
		
		sandOres1 = (CustomBlock) new BlockSandOre(CSString.concatAll(names1, "Sand-Based ", " Ore"), CSString.concatAll(overlays1, "", "overlay")).setHardness(1.7F);
		sandOres2 = (CustomBlock) new BlockSandOre(CSString.concatAll(names2, "Sand-Based ", " Ore"), CSString.concatAll(overlays2, "", "overlay")).setHardness(1.7F);
		sandOres3 = (CustomBlock) new BlockSandOre(CSString.concatAll(names3, "Sand-Based ", " Ore"), CSString.concatAll(overlays3, "", "overlay")).setHardness(1.7F);
		sandOres4 = (CustomBlock) new BlockSandOre(CSString.concatAll(names4, "Sand-Based ", " Ore"), CSString.concatAll(overlays4, "", "overlay")).setHardness(1.7F);
		sandOres5 = (CustomBlock) new BlockSandOre(CSString.concatAll(names5, "Sand-Based ", " Ore"), CSString.concatAll(overlays5, "", "overlay")).setHardness(1.7F);
		sandOres6 = (CustomBlock) new BlockSandOre(CSString.concatAll(names6, "Sand-Based ", " Ore"), CSString.concatAll(overlays6, "", "overlay")).setHardness(1.7F);
		sandOres7 = (CustomBlock) new BlockSandOre(CSString.concatAll(names7, "Sand-Based ", " Ore"), CSString.concatAll(overlays7, "", "overlay")).setHardness(1.7F);
		sandOres8 = (CustomBlock) new BlockSandOre(CSString.concatAll(names8, "Sand-Based ", " Ore"), CSString.concatAll(overlays8, "", "overlay")).setHardness(1.7F);
		
		storageBlocks1 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names1, "Block of ", ""), CSString.concatAll(overlays1, "", "block"), null).setHardness(2.5F);
		storageBlocks2 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names2, "Block of ", ""), CSString.concatAll(overlays2, "", "block"), null).setHardness(2.5F);
		storageBlocks3 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names3, "Block of ", ""), CSString.concatAll(overlays3, "", "block"), null).setHardness(2.5F);
		storageBlocks4 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names4, "Block of ", ""), CSString.concatAll(overlays4, "", "block"), null).setHardness(2.5F);
		storageBlocks5 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names5, "Block of ", ""), CSString.concatAll(overlays5, "", "block"), null).setHardness(2.5F);
		storageBlocks6 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names6, "Block of ", ""), CSString.concatAll(overlays6, "", "block"), null).setHardness(2.5F);
		storageBlocks7 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names7, "Block of ", ""), CSString.concatAll(overlays7, "", "block"), null).setHardness(2.5F);
		storageBlocks8 = (CustomBlock) new CustomBlock(Material.iron, CSString.concatAll(names8, "Block of ", ""), CSString.concatAll(overlays8, "", "block"), null).setHardness(2.5F);
		
		oreCrusher = (BlockOreCrusher) new BlockOreCrusher(false).setCreativeTab(rawMaterialsTab);
		oreCrusherActive = (BlockOreCrusher) new BlockOreCrusher(true);
	}
	
	@Override
	@EventHandler
	public void init(FMLInitializationEvent event)
	{	
		setupToolMaterials(new DataToolSet(dataSword, dataSpade, dataPickaxe, dataAxe, dataHoe));
		
		for (int i = 0; i < gemids.length; i++)
		{
			OreHelper.getOreFromMetadata(gemids[i], "stone").setDrops(gemids[i] % 16, new ItemStack(gems, 1, i));
			OreHelper.getOreFromMetadata(gemids[i], "nether").setDrops(gemids[i] % 16, new ItemStack(gems, 2, i));
			OreHelper.getOreFromMetadata(gemids[i], "end").setDrops(gemids[i] % 16, new ItemStack(gems, 2, i));
		}
		
		Blocks.coal_ore.setCreativeTab(stoneOresTab);
		Blocks.diamond_ore.setCreativeTab(stoneOresTab);
		Blocks.emerald_ore.setCreativeTab(stoneOresTab);
		Blocks.gold_ore.setCreativeTab(stoneOresTab);
		Blocks.iron_ore.setCreativeTab(stoneOresTab);
		Blocks.lapis_ore.setCreativeTab(stoneOresTab);
		Blocks.redstone_ore.setCreativeTab(stoneOresTab);
		
		Blocks.quartz_ore.setCreativeTab(netherOresTab);
		
		registerBlocks();
		addCraftingRecipes();
		addFurnaceRecipes();
		addCrusherRecipes();
		addOreDictionaryEntrys();
		setBlockInfo();
		
		int magnesiumID = CSArrays.indexOf(names, "Magnesium");
		int uraniumID = CSArrays.indexOf(names, "Uranium");
		int rubyID = CSArrays.indexOf(names, "Ruby");
		int iridiumID = CSArrays.indexOf(names, "Iridium");
		int berylliumID = CSArrays.indexOf(names, "Beryllium");
		int aluminiumID = CSArrays.indexOf(names, "Aluminium");
		stoneOresTab.setIconItemStack(new ItemStack(OreHelper.getOreFromMetadata(magnesiumID, "stone"), 1, magnesiumID % 16));
		netherOresTab.setIconItemStack(new ItemStack(OreHelper.getOreFromMetadata(uraniumID, "nether"), 1, uraniumID % 16));
		endOresTab.setIconItemStack(new ItemStack(OreHelper.getOreFromMetadata(rubyID, "end"), 1, rubyID % 16));
		dirtOresTab.setIconItemStack(new ItemStack(OreHelper.getOreFromMetadata(iridiumID, "dirt"), 1, iridiumID % 16));
		sandOresTab.setIconItemStack(new ItemStack(OreHelper.getOreFromMetadata(berylliumID, "sand"), 1, berylliumID % 16));
		rawMaterialsTab.setIconItemStack(new ItemStack(ingots, 1, aluminiumID));
		toolsTab.setIconItemStack(ItemDataTool.setToolMaterial(new ItemStack(dataPickaxe), silver));
		
		GameRegistry.registerTileEntity(TileEntityOreCrusher.class, "OreCrusher");
		GameRegistry.registerWorldGenerator(new MMMOreGenerator(), 1);
	}
	
	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}
	
	private void setupToolMaterials(DataToolSet dataToolSet)
	{
		adamantite = CSItems.addToolMaterial("Adamantite", 3, 2048, 14F, 4F, 20, 0x000000, null, dataToolSet);
		cobalt = CSItems.addToolMaterial("Cobalt", 2, 1536, 10F, 3.2F, 10, 0x000000, null, dataToolSet);
		demonite = CSItems.addToolMaterial("Demonite", 2, 800, 6F, 3.0F, 30, 0x000000, null, dataToolSet);
		mythril = CSItems.addToolMaterial("Mythril", 1, 1024, 8F, 3.1F, 12, 0x000000, null, dataToolSet);
		aluminium = CSItems.addToolMaterial("Aluminium", 2, 512, 8F, 2.2F, 10, 0x000000, null, dataToolSet);
		chrome = CSItems.addToolMaterial("Chrome", 2, 256, 10F, 2.7F, 12, 0x000000, null, dataToolSet);
		copper = CSItems.addToolMaterial("Copper", 1, 128, 4F, 1.8F, 8, 0x000000, null, dataToolSet);
		silver = CSItems.addToolMaterial("Silver", 2, 512, 6F, 2.3F, 16, 0x000000, null, dataToolSet);
		tin = CSItems.addToolMaterial("Tin", 2, 182, 5F, 1.75F, 9, 0x000000, null, dataToolSet);
		titanium = CSItems.addToolMaterial("Titanium", 3, 2048, 16F, 2.9F, 13, 0x000000, null, dataToolSet);
		emerald = CSItems.addToolMaterial("Emerald", 3, 1200, 8F, 2.95F, 17, 0x000000, new ItemStack(Items.emerald), dataToolSet);
		ruby = CSItems.addToolMaterial("Ruby", 3, 1200, 8F, 2.4F, 17, 0x000000, null, dataToolSet);
		sapphire = CSItems.addToolMaterial("Sapphire", 3, 1200, 8F, 2.4F, 17, 0x000000, null, dataToolSet);
	}
	
	private void setBlockInfo()
	{
		float stoneBase = Blocks.stone.getBlockHardness(null, 0, 0, 0);
		float netherBase = Blocks.netherrack.getBlockHardness(null, 0, 0, 0);
		float endBase = Blocks.end_stone.getBlockHardness(null, 0, 0, 0);
		float dirtBase = Blocks.dirt.getBlockHardness(null, 0, 0, 0);
		float sandBase = Blocks.sand.getBlockHardness(null, 0, 0, 0);
		float storageBase = Blocks.iron_block.getBlockHardness(null, 0, 0, 0);
		
		for (int i = 0; i < names.length; i++)
		{
			int j = i & 15;
			int gentype = overworldGen[i];
			int level = gentype <= 12 ? 3 : (gentype <= 32 ? 2 : (gentype <= 64 ? 1 : 0));
			float f = 6.4F / gentype;
			boolean rare = gentype <= 24;
			
			float stoneHardness = stoneBase + f + (rare ? 0.5F : 0F);
			float netherHardness = netherBase + f + (rare ? 0.6F : 0F);
			float endHardness = endBase + f + (rare ? 0.7F : 0F);
			float dirtHardness = dirtBase + f + (rare ? 0.4F : 0F);
			float sandHardness = sandBase + f + (rare ? 0.4F : 0F);
			float storageHardness = storageBase + f + (rare ? 0.8F : 0F);
			
			OreHelper.getOreFromMetadata(i, "stone").setHardness(j, stoneHardness).setHarvestLevel("pickaxe", level, j);
			OreHelper.getOreFromMetadata(i, "nether").setHardness(j, netherHardness).setHarvestLevel("pickaxe", level, j);
			OreHelper.getOreFromMetadata(i, "end").setHardness(j, endHardness).setHarvestLevel("pickaxe", level, j);
			OreHelper.getOreFromMetadata(i, "storage").setHardness(j, storageHardness).setHarvestLevel("pickaxe", level, j);
			OreHelper.getOreFromMetadata(i, "dirt").setHardness(j, dirtHardness).setHarvestLevel("shovel", 1, j);
			OreHelper.getOreFromMetadata(i, "sand").setHardness(j, sandHardness).setHarvestLevel("pickaxe", 1, j);
		}
		for (int i = 0; i < vanillaNames.length; i++)
		{
			int level = 2;
			if (i == 0)
				level = 0;
			else if (i == 4 || i == 5)
				level = 1;
			vanillaNetherEndOres.setHarvestLevel("pickaxe", level, i);
			vanillaNetherEndOres.setHarvestLevel("pickaxe", level, i + 8);
			vanillaDirtSandOres.setHarvestLevel("shovel", level, i);
			vanillaDirtSandOres.setHarvestLevel("shovel", level, i + 8);
		}
	}
	
	public void addOreDictionaryEntrys()
	{
		for (int i = 0; i < names.length; i++)
		{
			int j = i & 15;
			String s = names[i];
			CSCrafting.registerOre("ore" + s, new ItemStack(OreHelper.getOreFromMetadata(i, "stone"), 1, j));
			CSCrafting.registerOre("oreNether" + s, new ItemStack(OreHelper.getOreFromMetadata(i, "nether"), 1, j));
			CSCrafting.registerOre("oreEnd" + s, new ItemStack(OreHelper.getOreFromMetadata(i, "end"), 1, j));
			CSCrafting.registerOre("oreDirt" + s, new ItemStack(OreHelper.getOreFromMetadata(i, "dirt"), 1, j));
			CSCrafting.registerOre("oreSand" + s, new ItemStack(OreHelper.getOreFromMetadata(i, "sand"), 1, j));
			CSCrafting.registerOre("block" + s, new ItemStack(OreHelper.getOreFromMetadata(i, "storage"), 1, j));
			
			CSCrafting.registerOre("ingot" + s, new ItemStack(ingots, 1, i));
			CSCrafting.registerOre("dust" + s, new ItemStack(dusts, 1, i));
			CSCrafting.registerOre("nugget" + s, new ItemStack(nuggets, 1, i));
		}
		
		for (int i = 0; i < gemids.length; i++)
		{
			int gemid = gemids[i];
			CSCrafting.registerOre("gem" + names[gemid], new ItemStack(gems, 1, gemid));
		}
		
		for (int i = 0; i < vanillaNames.length; i++)
		{
			CSCrafting.registerOre("oreNether" + vanillaNames[i], new ItemStack(vanillaNetherEndOres, 1, i));
			CSCrafting.registerOre("oreEnd" + vanillaNames[i], new ItemStack(vanillaNetherEndOres, 1, i + 8));
			CSCrafting.registerOre("oreDirt" + vanillaNames[i], new ItemStack(vanillaDirtSandOres, 1, i));
			CSCrafting.registerOre("oreSand" + vanillaNames[i], new ItemStack(vanillaDirtSandOres, 1, i + 8));
			
			CSCrafting.registerOre("ingot" + vanillaNames[i], vanillaIngots[i]);
			CSCrafting.registerOre("dust" + vanillaNames[i], vanillaDusts[i]);
			CSCrafting.registerOre("nugget" + vanillaNames[i], vanillaNuggets[i]);
		}
	}
	
	public void addCraftingRecipes()
	{
		GameRegistry.addRecipe(new RepairDataTools());
		
		GameRegistry.addShapedRecipe(new ItemStack(oreCrusher, 1, 3), new Object[] { "tct", "cTc", "tct", 't', new ItemStack(ingots, 1, CSArrays.indexOf(names, "Tin")), 'c', new ItemStack(ingots, 1, CSArrays.indexOf(names, "Chrome")), 'T', new ItemStack(ingots, 1, CSArrays.indexOf(names, "Titanium")), });
		
		for (int i = 0; i < names.length; i++)
		{
			
		}
		for (int i = 0; i < vanillaNames.length; i++)
		{
			
		}
		
		this.addToolCraftingRecipes();
	}
	
	public void addToolCraftingRecipes()
	{
		Item[] tools = new Item[] { dataSword, dataSpade, dataPickaxe, dataAxe, dataHoe };
		for (int i = 0; i < tools.length; i++)
		{
			ItemStack toolStack = new ItemStack(tools[i]);
			
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, adamantite), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Adamantite")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, cobalt), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Cobalt")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, demonite), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Demonite")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, mythril), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Mythril")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, aluminium), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Aluminium")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, chrome), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Chrome")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, copper), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Copper")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, silver), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Silver")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, tin), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Tin")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, titanium), new ItemStack(ingots, 1, CSArrays.indexOf(names, "Titanium")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, emerald), new ItemStack(Items.emerald), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, ruby), new ItemStack(gems, 1, CSArrays.indexOf(gemNames, "Ruby")), i);
			CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(toolStack, sapphire), new ItemStack(gems, 1, CSArrays.indexOf(gemNames, "Sapphire")), i);
		}
	}
	
	public void addFurnaceRecipes()
	{
		for (int i = 0; i < names.length; i++)
		{
			int j = i & 15;
			int gemIndex = CSArrays.indexOf(gemids, i);
			ItemStack is = gemIndex != -1 ? new ItemStack(gems, 1, gemIndex) : new ItemStack(ingots, 1, i);
			ItemStack is2 = is.copy();
			
			CSCrafting.addFurnaceRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "stone"), 1, j), is, 0.1F);
			is2.stackSize = 2;
			CSCrafting.addFurnaceRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "nether"), 1, j), is2, 0.2F);
			is2.stackSize = 3;
			CSCrafting.addFurnaceRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "end"), 1, j), is2, 0.2F);
			
			CSCrafting.addFurnaceRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "dirt"), 1, j), new ItemStack(nuggets, 2, i), 0.01F);
			CSCrafting.addFurnaceRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "sand"), 1, j), new ItemStack(nuggets, 3, i), 0.015F);
			
			CSCrafting.addFurnaceRecipe(new ItemStack(dusts, 1, i), is, 0.001F);
		}
		
		for (int i = 0; i < vanillaNames.length; i++)
		{
			CSCrafting.addFurnaceRecipe(vanillaDusts[i], vanillaIngots[i], 0.1F);
			
			ItemStack is = vanillaIngots[i].copy();
			is.stackSize = 2;
			CSCrafting.addFurnaceRecipe(new ItemStack(vanillaNetherEndOres, 1, i), is, 0.1F);
			CSCrafting.addFurnaceRecipe(new ItemStack(vanillaNetherEndOres, 1, i + 7), is, 0.1F);
			
			is = vanillaNuggets[i].copy();
			is.stackSize = 2;
			CSCrafting.addFurnaceRecipe(new ItemStack(vanillaDirtSandOres, 1, i), is, 0.01F);
			is.stackSize = 3;
			CSCrafting.addFurnaceRecipe(new ItemStack(vanillaDirtSandOres, 1, i + 7), is, 0.015F);
		}
	}
	
	public void addCrusherRecipes()
	{
		for (int i = 0; i < names.length; i++)
		{
			int j = i & 15;
			int gemIndex = CSArrays.indexOf(gemids, i);
			
			CrusherRecipes.addCrusherRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "stone"), 1, j), new ItemStack(dusts, 2, i), 0.1F);
			CrusherRecipes.addCrusherRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "nether"), 1, j), new ItemStack(dusts, 3, i), 0.2F);
			CrusherRecipes.addCrusherRecipe(new ItemStack(OreHelper.getOreFromMetadata(i, "end"), 1, j), new ItemStack(dusts, 4, i), 0.3F);
			
			ItemStack stack = gemIndex != -1 ? new ItemStack(gems, 1, gemIndex) : new ItemStack(ingots, 1, i);
			CrusherRecipes.addCrusherRecipe(stack, new ItemStack(dusts, 1, i), 0F);
		}
		
		for (int i = 0; i < vanillaNames.length; i++)
		{
			ItemStack stack = vanillaDusts[i].copy();
			CrusherRecipes.addCrusherRecipe(vanillaIngots[i], stack, 0F);
			
			stack.stackSize = 3;
			CrusherRecipes.addCrusherRecipe(new ItemStack(vanillaNetherEndOres, 1, i), stack, 0.2F);
			stack.stackSize = 4;
			CrusherRecipes.addCrusherRecipe(new ItemStack(vanillaNetherEndOres, 1, i + 7), stack, 0.3F);
		}
		
		for (int i = 0; i < gemids.length; i++)
		{
			CrusherRecipes.addCrusherRecipe(new ItemStack(gems, 1, i), new ItemStack(dusts, 1, gemids[i]), 0F);
		}
		
		CrusherRecipes.addCrusherRecipe(Blocks.coal_ore, new ItemStack(vanillaItems, 2, 8), 0F);
		CrusherRecipes.addCrusherRecipe(Blocks.diamond_ore, new ItemStack(vanillaItems, 2, 9), 0F);
		CrusherRecipes.addCrusherRecipe(Blocks.emerald_ore, new ItemStack(vanillaItems, 2, 10), 0F);
		CrusherRecipes.addCrusherRecipe(Blocks.gold_ore, new ItemStack(vanillaItems, 2, 11), 0F);
		CrusherRecipes.addCrusherRecipe(Blocks.iron_ore, new ItemStack(vanillaItems, 2, 12), 0F);
		CrusherRecipes.addCrusherRecipe(Blocks.lapis_ore, new ItemStack(vanillaItems, 2, 13), 0F);
		CrusherRecipes.addCrusherRecipe(Blocks.redstone_ore, new ItemStack(Items.redstone, 2), 0F);
		CrusherRecipes.addCrusherRecipe(Blocks.quartz_ore, new ItemStack(vanillaItems, 2, 15), 0F);
		
		CrusherRecipes.addCrusherRecipe(CSStacks.coal, vanillaDusts[0], 0F);
		CrusherRecipes.addCrusherRecipe(CSStacks.diamond, vanillaDusts[1], 0F);
		CrusherRecipes.addCrusherRecipe(CSStacks.emerald, vanillaDusts[2], 0F);
		CrusherRecipes.addCrusherRecipe(CSStacks.gold_ingot, vanillaDusts[3], 0F);
		CrusherRecipes.addCrusherRecipe(CSStacks.iron_ingot, vanillaDusts[4], 0F);
		CrusherRecipes.addCrusherRecipe(CSStacks.lapis_lazuli, vanillaDusts[5], 0F);
		CrusherRecipes.addCrusherRecipe(CSStacks.quartz, vanillaDusts[7], 0F);
	}
	
	public void registerBlocks()
	{
		CSBlocks.addBlock(vanillaNetherEndOres, ItemCustomBlock.class, "vanilla_nether_end_ores");
		CSBlocks.addBlock(vanillaDirtSandOres, ItemCustomBlock.class, "vanilla_dirt_sand_ores");
		for (int i = 0; i < 8; i++)
		{
			int j = i * 16;
			CSBlocks.addBlock(OreHelper.getOreFromMetadata(j, "stone"), ItemCustomBlock.class, "stone_ores_" + i);
			CSBlocks.addBlock(OreHelper.getOreFromMetadata(j, "nether"), ItemCustomBlock.class, "nether_ores_" + i);
			CSBlocks.addBlock(OreHelper.getOreFromMetadata(j, "end"), ItemCustomBlock.class, "end_ores_" + i);
			CSBlocks.addBlock(OreHelper.getOreFromMetadata(j, "dirt"), ItemCustomBlock.class, "dirt_ores_" + i);
			CSBlocks.addBlock(OreHelper.getOreFromMetadata(j, "sand"), ItemCustomBlock.class, "sand_ores_" + i);
			CSBlocks.addBlock(OreHelper.getOreFromMetadata(j, "storage"), ItemCustomBlock.class, "storage_blocks_" + i);
		}
		CSBlocks.addBlock(oreCrusher, "ore_crusher");
		CSBlocks.addBlock(oreCrusherActive, "ore_crusher_active");
	}
}