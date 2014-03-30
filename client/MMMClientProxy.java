package clashsoft.mods.moreminerals.client;

import java.util.List;

import clashsoft.cslib.minecraft.util.CSResourceHelper;
import clashsoft.mods.moreminerals.chem.PeriodicTable;
import clashsoft.mods.moreminerals.client.render.block.RenderBlockOres;
import clashsoft.mods.moreminerals.common.MMMProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

import net.minecraft.util.ResourceLocation;

public class MMMClientProxy extends MMMProxy
{
	public static int oresRenderType;
	
	@Override
	public void init()
	{
		oresRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBlockOres());
		
		List<String> lines = CSResourceHelper.readAllLines(new ResourceLocation("moreminerals", "elements.txt"));
		PeriodicTable.load(lines);
	}
}
