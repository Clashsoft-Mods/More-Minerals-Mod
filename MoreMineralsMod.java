package clashsoft.mods.moreminerals;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import clashsoft.clashsoftapi.*;
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

	public static CustomCreativeTab minerals = new CustomCreativeTab("moreminerals", null);
	public static CustomCreativeTab tools = new CustomCreativeTab("moreminerals", null);
	
	public static int OreCrusher_TEID = 15;

	public static int vanillaOres_ID = 1200;
	public static int vanillaOres_ID2 = 1201;
	public static int stoneOres_ID = 1202;
	public static int stoneOres_ID2 = 1203;
	public static int stoneOres_ID3 = 1204;
	public static int stoneOres_ID4 = 1205;
	public static int netherOres_ID = 1206;
	public static int netherOres_ID2 = 1207;
	public static int netherOres_ID3 = 1208;
	public static int netherOres_ID4 = 1209;
	public static int endOres_ID = 1210;
	public static int endOres_ID2 = 1211;
	public static int endOres_ID3 = 1212;
	public static int endOres_ID4 = 1213;
	public static int dirtOres_ID = 1214;
	public static int dirtOres_ID2 = 1215;
	public static int dirtOres_ID3 = 1216;
	public static int dirtOres_ID4 = 1217;
	public static int sandOres_ID = 1218;
	public static int sandOres_ID2 = 1219;
	public static int sandOres_ID3 = 1220;
	public static int sandOres_ID4 = 1221;
	public static int storageBlocks_ID = 1222;
	public static int storageBlocks_ID2 = 1223;
	public static int storageBlocks_ID3 = 1224;
	public static int storageBlocks_ID4 = 1225;
	public static int oreCrusher_ID = 1250;
	public static int oreCrusherActive_ID = 1251;
	
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

	public static String[] allnames = new String[]
		{
		"Adamantite", "Cobalt", "Demonite", "Mythril", "Aluminium", "Beryllium", "Chrome", "Copper",
		"Iridium", "Lead", "Lithium", "Magnesium", "Manganese", "Molybdenum", "Nickel", "Silver",
		"Tin", "Titanium", "Tungsten", "Uranium", "Vanadium",
			"Amethyst", "Ruby", "Sapphire", "Topaz", "Spinel", "Opal"
		};
	public static String[] names1 = CSArray.split(allnames, 16)[0];
	public static String[] names2 = CSArray.split(allnames, 16)[1];
	public static String[] gemnames = new String[] {"Amethyst", "Ruby", "Sapphire", "Topaz", "Spinel", "Opal"};
	public static String[] vanillanames = new String[] {"Coal", "Diamond", "Emerald", "Gold", "Iron", "Lapislazuli", "Redstone"};

	public static String[] alloverlays = CSArray.caseAll(allnames, 0);
	public static String[] overlays1 = CSArray.caseAll(names1, 0);
	public static String[] overlays2 = CSArray.caseAll(names2, 0);
	public static String[] gemoverlays = CSArray.caseAll(gemnames, 0);
	public static String[] vanillaoverlays = CSArray.caseAll(vanillanames, 0);
	
	private static int[] gemids = new int[] {CSArray.valueOf(allnames, "Amethyst"), CSArray.valueOf(allnames, "Ruby"), CSArray.valueOf(allnames, "Sapphire"), CSArray.valueOf(allnames, "Topaz"), CSArray.valueOf(allnames, "Spinel"), CSArray.valueOf(allnames, "Opal")};

	public static CustomBlock vanillaSpecialOres;
	public static CustomBlock vanillaSpecialOres2;
	public static CustomBlock stoneOres;
	public static CustomBlock stoneOres2;
	public static CustomBlock netherOres;
	public static CustomBlock netherOres2;
	public static CustomBlock endOres;
	public static CustomBlock endOres2;
	public static CustomBlock dirtOres;
	public static CustomBlock dirtOres2;
	public static CustomBlock sandOres;
	public static CustomBlock sandOres2;
	public static CustomBlock storageBlocks;
	public static CustomBlock storageBlocks2;
	
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

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		vanillaOres_ID = config.getBlock("Special Vanilla Ores ID 1", 1200).getInt();
		vanillaOres_ID2 = config.getBlock("Special Vanilla Ores ID 2", 1201).getInt();
		stoneOres_ID = config.getBlock("Stone-Based Ores ID 1", 1202).getInt();
		stoneOres_ID2 = config.getBlock("Stone-Based Ores ID 2", 1203).getInt();
		stoneOres_ID3 = config.getBlock("Stone-Based Ores ID 3", 1204).getInt();
		stoneOres_ID4 = config.getBlock("Stone-Based Ores ID 4", 1205).getInt();
		netherOres_ID = config.getBlock("Netherrack-Based Ores ID 1", 1206).getInt();
		netherOres_ID2 = config.getBlock("Netherrack-Based Ores ID 2", 1207).getInt();
		netherOres_ID3 = config.getBlock("Netherrack-Based Ores ID 3", 1208).getInt();
		netherOres_ID4 = config.getBlock("Netherrack-Based Ores ID 4", 1209).getInt();
		endOres_ID = config.getBlock("Endstone-Based Ores ID 1", 1210).getInt();
		endOres_ID2 = config.getBlock("Endstone-Based Ores ID 2", 1211).getInt();
		endOres_ID3 = config.getBlock("Endstone-Based Ores ID 3", 1212).getInt();
		endOres_ID4 = config.getBlock("Endstone-Based Ores ID 4", 1213).getInt();
		dirtOres_ID = config.getBlock("Dirt-Based Ores ID 1", 1214).getInt();
		dirtOres_ID2 = config.getBlock("Dirt-Based Ores ID 2", 1215).getInt();
		dirtOres_ID3 = config.getBlock("Dirt-Based Ores ID 3", 1216).getInt();
		dirtOres_ID4 = config.getBlock("Dirt-Based Ores ID 4", 1217).getInt();
		sandOres_ID = config.getBlock("Sand-Based Ores ID 1", 1218).getInt();
		sandOres_ID2 = config.getBlock("Sand-Based Ores ID 2", 1219).getInt();
		sandOres_ID3 = config.getBlock("Sand-Based Ores ID 3", 1220).getInt();
		sandOres_ID4 = config.getBlock("Sand-Based Ores ID 4", 1221).getInt();
		storageBlocks_ID = config.getBlock("Storage Blocks ID 1", 1222).getInt();
		storageBlocks_ID2 = config.getBlock("Storage Blocks 2", 1223).getInt();
		storageBlocks_ID3 = config.getBlock("Storage Blocks 3", 1224).getInt();
		storageBlocks_ID4 = config.getBlock("Storage Blocks 4", 1225).getInt();
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
		vanillaSpecialItems = (CustomItem) new CustomItem(vanillaSpecialItems_ID, CSArray.combine(CSArray.combine(CSArray.addToAll(vanillanames, "", " Ingot"), CSArray.addToAll(vanillanames, "", " Dust")), CSArray.addToAll(vanillanames, "", " Nugget")), CSArray.combine(CSArray.combine(CSArray.addToAll(vanillaoverlays, "ingot", ""), CSArray.addToAll(vanillaoverlays, "dust", "")), CSArray.addToAll(vanillaoverlays, "nugget", ""))).disableMetadata(3, 4, 13, 17).setUnlocalizedName("MM_VanillaSpecialItems").setCreativeTab(minerals);
		ingots = (CustomItem) new CustomItem(ingots_ID, CSArray.addToAll(allnames, "", " Ingot"), CSArray.addToAll(alloverlays, "ingot", "")).disableMetadata(gemids).setUnlocalizedName("MM_Ingots").setCreativeTab(minerals);
		dusts = (CustomItem) new CustomItem(dusts_ID, CSArray.addToAll(allnames, "", " Dust"), CSArray.addToAll(alloverlays, "dust", "")).setUnlocalizedName("MM_Dusts").setCreativeTab(minerals);
		nuggets = (CustomItem) new CustomItem(nuggets_ID, CSArray.addToAll(allnames, "", " Nugget"), CSArray.addToAll(alloverlays, "nugget", "")).setUnlocalizedName("MM_Nuggets").setCreativeTab(minerals);
		gems = (CustomItem) new CustomItem(gems_ID, gemnames, CSArray.addToAll(gemoverlays, "gem", "")).setUnlocalizedName("MM_Gems").setCreativeTab(minerals);
		
		String[] vanillaNames = CSArray.combine(CSArray.addToAll(vanillanames, "Nether ", " Ore"), CSArray.addToAll(vanillanames, "End ", " Ore"));
		String[] vanillaNames2 = CSArray.combine(CSArray.addToAll(vanillanames, "Dirt-Based ", " Ore"), CSArray.addToAll(vanillanames, "Sand-Based ", " Ore"));
		vanillaSpecialOres = (CustomBlock) new CustomBlock(vanillaOres_ID, Material.rock, vanillaNames, CSArray.addToAll(CSArray.combine(vanillaoverlays, vanillaoverlays), "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_VanillaSpecialOres").setHardness(2.15F);
		vanillaSpecialOres2 = (CustomBlock) new BlockVanillaSpecialOre(vanillaOres_ID2, Material.ground, vanillaNames2, CSArray.addToAll(CSArray.combine(vanillaoverlays, vanillaoverlays), "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_VanillaSpecialOres2").setHardness(1.7F);
		
		stoneOres = (CustomBlock) new CustomBlock(stoneOres_ID, Material.rock, CSArray.addToAll(names1, "", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_StoneOres").setHardness(2.3F);
		stoneOres2 = (CustomBlock) new CustomBlock(stoneOres_ID2, Material.rock, CSArray.addToAll(names2, "", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_StoneOres2").setHardness(2.3F);
		
		netherOres = (CustomBlock) new CustomBlock(netherOres_ID, Material.rock, CSArray.addToAll(names1, "Nether ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_NetherOres").setHardness(2.1F);
		netherOres2 = (CustomBlock) new CustomBlock(netherOres_ID2, Material.rock, CSArray.addToAll(names2, "Nether ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_NetherOres2").setHardness(2.1F);
		
		endOres = (CustomBlock) new CustomBlock(endOres_ID, Material.rock, CSArray.addToAll(names1, "End ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_EndOres").setHardness(2.2F);
		endOres2 = (CustomBlock) new CustomBlock(endOres_ID2, Material.rock, CSArray.addToAll(names2, "End ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_EndOres2").setHardness(2.2F);

		for (int i = 0; i < gemids.length; i++)
		{
			stoneOres2.setDrops(gemids[i] - 16, new ItemStack(gems, 1, i));
			netherOres2.setDrops(gemids[i] - 16, new ItemStack(gems, 2, i));
			endOres2.setDrops(gemids[i] - 16, new ItemStack(gems, 2, i));
		};
		
		dirtOres = (CustomBlock) new BlockDirtOre(dirtOres_ID, Material.ground, CSArray.addToAll(names1, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_DirtOres").setHardness(1.7F);
		dirtOres2 = (CustomBlock) new BlockDirtOre(dirtOres_ID2, Material.ground, CSArray.addToAll(names2, "Dirt-Based ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_DirtOres2").setHardness(1.7F);

		sandOres = (CustomBlock) new BlockSandOre(sandOres_ID, Material.ground, CSArray.addToAll(names1, "Sand-Based ", " Ore"), CSArray.addToAll(overlays1, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_SandOres").setHardness(1.7F);
		sandOres2 = (CustomBlock) new BlockSandOre(sandOres_ID2, Material.ground, CSArray.addToAll(names2, "Sand-Based ", " Ore"), CSArray.addToAll(overlays2, "", "overlay"), true, ClientProxy.oreRenderer, new CreativeTabs[] {minerals}).setUnlocalizedName("MM_SandOres2").setHardness(1.7F);

		storageBlocks = (CustomBlock) new CustomBlock(storageBlocks_ID, Material.iron, CSArray.addToAll(names1, "Block of ", ""), CSArray.addToAll(overlays1, "", "block"), new CreativeTabs[] {minerals}).setUnlocalizedName("MM_StorageBlocks").setHardness(2.5F);
		storageBlocks2 = (CustomBlock) new CustomBlock(storageBlocks_ID2, Material.iron, CSArray.addToAll(names2, "Block of ", ""), CSArray.addToAll(overlays2, "", "block"), new CreativeTabs[] {minerals}).setUnlocalizedName("MM_StorageBlocks2").setHardness(2.5F);

		oreCrusher = (BlockOreCrusher) new BlockOreCrusher(oreCrusher_ID, false).setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setCreativeTab(minerals).setUnlocalizedName("MMOreCrusher");
		oreCrusherActive = (BlockOreCrusher) new BlockOreCrusher(oreCrusherActive_ID, false).setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("MMOreCrusher");
		
		dataSword = (ItemDataSword) new ItemDataSword(dataSword_ID, EnumToolMaterial.IRON).setCreativeTab(tools).setUnlocalizedName("MM_Swords");
		dataSpade = (ItemDataSpade) new ItemDataSpade(dataSpade_ID, EnumToolMaterial.IRON).setCreativeTab(tools).setUnlocalizedName("MM_Spades");
		dataPickaxe = (ItemDataPickaxe) new ItemDataPickaxe(dataPickaxe_ID, EnumToolMaterial.IRON).setCreativeTab(tools).setUnlocalizedName("MM_Pickaxes");
		dataAxe = (ItemDataAxe) new ItemDataAxe(dataAxe_ID, EnumToolMaterial.IRON).setCreativeTab(tools).setUnlocalizedName("MM_Axes");
		dataHoe = (ItemDataHoe) new ItemDataHoe(dataHoe_ID, EnumToolMaterial.IRON).setCreativeTab(tools).setUnlocalizedName("MM_Hoes");
		
		registerBlocks();
		addCraftingRecipes();
		addFurnaceRecipes();
		addCrusherRecipes();
		addOreDictionaryEntrys();
		addToolEfficiencys();

		minerals.setIconItemStack(new ItemStack(stoneOres, 1, 3));
		
		proxy.registerRenderers();
		GameRegistry.registerTileEntity(TileEntityOreCrusher.class, "OreCrusher");
		NetworkRegistry.instance().registerGuiHandler(INSTANCE, proxy);
		
		addLocalizations();
	}

	private void addToolEfficiencys()
	{
		for (int i = 0; i < names1.length; i++)
		{
			MinecraftForge.setBlockHarvestLevel(sandOres, i, "shovel", 1);
			MinecraftForge.setBlockHarvestLevel(dirtOres, i, "shovel", 1);
		}
		for (int i = 0; i < names2.length; i++)
		{
			MinecraftForge.setBlockHarvestLevel(sandOres2, i, "shovel", 1);
			MinecraftForge.setBlockHarvestLevel(dirtOres2, i, "shovel", 1);
		}
		for (int i = 0; i < 14; i++)
		{
			int vanillaOreType = i % 7;
			int harvestLevel = 0;
			if (i == 1 || i == 2 || i == 3 || i == 6) //Diamond, Emerald, Gold, Redstone
				harvestLevel = 2; //Iron
			else if (i == 4 || i == 5)
				harvestLevel = 1; //Stone
			MinecraftForge.setBlockHarvestLevel(vanillaSpecialOres, i, "pickaxe", harvestLevel);
			MinecraftForge.setBlockHarvestLevel(vanillaSpecialOres2, i, "shovel", harvestLevel > 0 ? harvestLevel - 1 : 0);
		}
	}

	public void addLocalizations()
	{
		CSLang.addLocalizationUS("itemGroup.moreminerals", "Minerals");
		CSLang.addLocalizationDE("itemGroup.moreminerals", "Mineralien");
		
		CSLang.addLocalizationUS("container.orecrusher", "Ore Crusher");
		CSLang.addLocalizationDE("container.orecrusher", "Erz Crusher");
		
		ModLoader.addName(oreCrusher, "Ore Crusher");
		ModLoader.addName(oreCrusherActive, "Ore Crusher");
	}
	
	
	public void addOreDictionaryEntrys()
	{
		//Type 1 Ores
		for (int i = 0; i < names1.length; i++)
		{
			CSCrafting.registerOre("ore" + names1[i], new ItemStack(stoneOres, 1, i));
			CSCrafting.registerOre("oreNether" + names1[i], new ItemStack(netherOres, 1, i));
			CSCrafting.registerOre("oreEnd" + names1[i], new ItemStack(endOres, 1, i));
			CSCrafting.registerOre("oreDirt" + names1[i], new ItemStack(dirtOres, 1, i));
			CSCrafting.registerOre("oreSand" + names1[i], new ItemStack(sandOres, 1, i));
			
			CSCrafting.registerOre("ingot" + names1[i], new ItemStack(ingots, 1, i));
			CSCrafting.registerOre("dust" + names1[i], new ItemStack(dusts, 1, i));
			CSCrafting.registerOre("nugget" + names1[i], new ItemStack(nuggets, 1, i));
			CSCrafting.registerOre("block" + names1[i], new ItemStack(storageBlocks, 1, i));
		}
		
		//Type 2 Ores
		for (int i = 0; i < names2.length; i++)
		{
			CSCrafting.registerOre("ore" + names2[i], new ItemStack(stoneOres2, 1, i));
			CSCrafting.registerOre("oreNether" + names2[i], new ItemStack(netherOres2, 1, i));
			CSCrafting.registerOre("oreEnd" + names2[i], new ItemStack(endOres2, 1, i));
			CSCrafting.registerOre("oreDirt" + names2[i], new ItemStack(dirtOres2, 1, i));
			CSCrafting.registerOre("oreSand" + names2[i], new ItemStack(sandOres2, 1, i));
			CSCrafting.registerOre("block" + names2[i], new ItemStack(storageBlocks2, 1, i));
			
			CSCrafting.registerOre("ingot" + names2[i], new ItemStack(ingots, 1, i + 16));
			CSCrafting.registerOre("dust" + names2[i], new ItemStack(dusts, 1, i + 16));
			CSCrafting.registerOre("nugget" + names2[i], new ItemStack(nuggets, 1, i + 16));
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
				CSCrafting.registerOre("oreNether" + vanillanames[i], new ItemStack(vanillaSpecialOres, 1, i));
				CSCrafting.registerOre("ingot" + vanillanames[i], new ItemStack(vanillaSpecialItems, 1, i));
			}
			else if (i < 14) //End Ores
			{
				CSCrafting.registerOre("oreEnd" + vanillanames[i - 7], new ItemStack(vanillaSpecialOres, 1, i));
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
		
		for (int i = 0; i < allnames.length; i++)
		{
			ItemStack is = (CSArray.contains(gemids, i) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, i)) : new ItemStack(ingots, 1, i));
			GameRegistry.addShapelessRecipe(new ItemStack(i < 16 ? storageBlocks : storageBlocks2, 1, i < 16 ? i : i - 16),
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
			GameRegistry.addShapelessRecipe(new ItemStack(is.getItem(), 9, is.getItemDamage()), new ItemStack(i < 16 ? storageBlocks : storageBlocks2, 1, i < 16 ? i : i - 16));
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
		CSCrafting.addToolRecipe(ItemDataTool.setToolMaterial(new ItemStack(dataSword), adamantite, "Adamantite"), new ItemStack(ingots, 1, CSArray.valueOf(allnames, "Adamantite")), 0);
	}
	
	public void addFurnaceRecipes()
	{
		for (int i = 0; i < names1.length; i++)
		{
			ItemStack is = (CSArray.contains(gemids, i) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, i)) : new ItemStack(ingots, 1, i));
			
			CSCrafting.addSmelting(new ItemStack(stoneOres, 1, i), new ItemStack(ingots, 1, i), 0.1F);
			CSCrafting.addSmelting(new ItemStack(netherOres, 1, i), new ItemStack(ingots, 2, i), 0.2F);
			CSCrafting.addSmelting(new ItemStack(endOres, 1, i), new ItemStack(ingots, 2, i), 0.2F);
			CSCrafting.addSmelting(new ItemStack(dirtOres, 1, i), new ItemStack(nuggets, 2, i), 0.01F);
			CSCrafting.addSmelting(new ItemStack(sandOres, 1, i), new ItemStack(nuggets, 3, i), 0.015F);
			
			CSCrafting.addSmelting(new ItemStack(dusts, 1, i), is, 0.001F);
		}
		for (int i = 0; i < names2.length; i++)
		{
			ItemStack is = (CSArray.contains(gemids, i + 16) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, i + 16)) : new ItemStack(ingots, 1, i + 16));
			
			CSCrafting.addSmelting(new ItemStack(stoneOres2, 1, i), new ItemStack(ingots, 1, i + 16), 0.1F);
			CSCrafting.addSmelting(new ItemStack(netherOres2, 1, i), new ItemStack(ingots, 2, i + 16), 0.2F);
			CSCrafting.addSmelting(new ItemStack(endOres2, 1, i), new ItemStack(ingots, 2, i + 16), 0.2F);
			CSCrafting.addSmelting(new ItemStack(dirtOres2, 1, i), new ItemStack(nuggets, 2, i + 16), 0.01F);
			CSCrafting.addSmelting(new ItemStack(sandOres2, 1, i), new ItemStack(nuggets, 3, i + 16), 0.015F);
			
			CSCrafting.addSmelting(new ItemStack(dusts, 1, i + 16), is, 0.001F);
		}
		for (int i = 0; i < (vanillanames.length * 4); i++)
		{
			if (i < 7) //Nether Ores
			{
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres, 1, i), new ItemStack(vanillaSpecialItems, 2, i), 0.1F);
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialItems, 1, i + 7), new ItemStack(vanillaSpecialItems, 1, i), 0.1F);
			}
			else if (i < 14) //End Ores
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres, 1, i), new ItemStack(vanillaSpecialItems, 2, i - 7), 0.1F);
			else if (i < 21) //Dirt Ores
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres2, 1, i - 14), new ItemStack(vanillaSpecialItems, 2, i), 0.01F);
			else if (i < 28) //Sand Ores
				CSCrafting.addSmelting(new ItemStack(vanillaSpecialOres2, 1, i - 14), new ItemStack(vanillaSpecialItems, 3, i - 7), 0.015F);
		}
	}
	
	
	public void addCrusherRecipes()
	{
		for (int i = 0; i < names1.length; i++)
		{
			ItemStack is = (CSArray.contains(gemids, i) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, i)) : new ItemStack(ingots, 1, i));
			
			OreCrusherRecipes.crushing().addCrushing(stoneOres.blockID, i, new ItemStack(dusts, 2, i), 0.1F);
			OreCrusherRecipes.crushing().addCrushing(netherOres.blockID, i, new ItemStack(dusts, 4, i), 0.2F);
			OreCrusherRecipes.crushing().addCrushing(endOres.blockID, i, new ItemStack(dusts, 4, i), 0.2F);
			
			OreCrusherRecipes.crushing().addCrushing(is.itemID, is.getItemDamage(), new ItemStack(dusts, 1, i), 0F);
		}
		for (int i = 0; i < names2.length; i++)
		{
			ItemStack is = (CSArray.contains(gemids, i + 16) ? new ItemStack(gems, 1, CSArray.valueOf(gemids, i + 16)) : new ItemStack(ingots, 1, i + 16));
			
			OreCrusherRecipes.crushing().addCrushing(stoneOres2.blockID, i, new ItemStack(dusts, 2, i + 16), 0.1F);
			OreCrusherRecipes.crushing().addCrushing(netherOres2.blockID, i, new ItemStack(dusts, 4, i + 16), 0.2F);
			OreCrusherRecipes.crushing().addCrushing(endOres2.blockID, i, new ItemStack(dusts, 4, i + 16), 0.2F);
			
			OreCrusherRecipes.crushing().addCrushing(is.itemID, is.getItemDamage(), new ItemStack(dusts, 1, i + 16), 0F);
		}
		for (int i = 0; i < vanillanames.length; i++)
		{
			OreCrusherRecipes.crushing().addCrushing(vanillaSpecialItems.itemID, i, new ItemStack(vanillaSpecialItems, 1, i + 7), 0F);
			
			OreCrusherRecipes.crushing().addCrushing(vanillaSpecialOres.blockID, i, new ItemStack(vanillaSpecialItems, 4, i + 7), 0.2F);
			OreCrusherRecipes.crushing().addCrushing(vanillaSpecialOres.blockID, i + 7, new ItemStack(vanillaSpecialItems, 4, i + 7), 0.2F);
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
		GameRegistry.registerBlock(vanillaSpecialOres, ItemCustomBlock.class, "MoreMineralsSpecialVanillaOres");
		GameRegistry.registerBlock(vanillaSpecialOres2, ItemCustomBlock.class, "MoreMineralsSpecialVanillaOres2");
		GameRegistry.registerBlock(stoneOres, ItemCustomBlock.class, "MoreMineralsStoneOres");
		GameRegistry.registerBlock(stoneOres2, ItemCustomBlock.class, "MoreMineralsStoneOres2");
		GameRegistry.registerBlock(netherOres, ItemCustomBlock.class, "MoreMineralsNetherOres");
		GameRegistry.registerBlock(netherOres2, ItemCustomBlock.class, "MoreMineralsNetherOres2");
		GameRegistry.registerBlock(endOres, ItemCustomBlock.class, "MoreMineralsEndOres");
		GameRegistry.registerBlock(endOres2, ItemCustomBlock.class, "MoreMineralsEndOres2");
		GameRegistry.registerBlock(dirtOres, ItemCustomBlock.class, "MoreMineralsDirtOres");
		GameRegistry.registerBlock(dirtOres2, ItemCustomBlock.class, "MoreMineralsDirtOres2");
		GameRegistry.registerBlock(sandOres, ItemCustomBlock.class, "MoreMineralsSandOres");
		GameRegistry.registerBlock(sandOres2, ItemCustomBlock.class, "MoreMineralsSandOres2");
		GameRegistry.registerBlock(storageBlocks, ItemCustomBlock.class, "MoreMineralsStorageBlocks");
		GameRegistry.registerBlock(storageBlocks2, ItemCustomBlock.class, "MoreMineralsStorageBlocks2");
		GameRegistry.registerBlock(oreCrusher, "MoreMineralsOreCrusher");
		GameRegistry.registerBlock(oreCrusher, "MoreMineralsOreCrusherActive");
		vanillaSpecialOres.addNames();
		vanillaSpecialOres2.addNames();
		stoneOres.addNames();
		stoneOres2.addNames();
		netherOres.addNames();
		netherOres2.addNames();
		endOres.addNames();
		endOres2.addNames();
		dirtOres.addNames();
		dirtOres2.addNames();
		sandOres.addNames();
		sandOres2.addNames();
		storageBlocks.addNames();
		storageBlocks2.addNames();
	}
}