package clashsoft.mods.moreminerals.client;

import java.util.List;

import clashsoft.cslib.minecraft.util.CSResourceHelper;
import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.chem.PeriodicTable;
import clashsoft.mods.moreminerals.client.render.block.RenderItemOres;
import clashsoft.mods.moreminerals.client.render.block.RenderBlockOres;
import clashsoft.mods.moreminerals.common.MMMProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class MMMClientProxy extends MMMProxy
{
	public static int	oresRenderType;
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		oresRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBlockOres());
		
		List<String> lines = CSResourceHelper.readAllLines(new ResourceLocation("moreminerals", "elements.txt"));
		PeriodicTable.load(lines);
		
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MoreMineralsMod.ores), new RenderItemOres());
	}
	
	@Override
	public boolean isClient()
	{
		return true;
	}
}
