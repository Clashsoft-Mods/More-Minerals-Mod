package clashsoft.mods.moreminerals.client;

import clashsoft.mods.moreminerals.client.renderer.block.MMMOreRenderer;
import clashsoft.mods.moreminerals.common.MMMCommonProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class MMMClientProxy extends MMMCommonProxy
{
	public static int	oreRenderer;
	
	@Override
	public void registerBlockRenderers()
	{
		oreRenderer = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(oreRenderer, new MMMOreRenderer());
	}
	
	@Override
	public void registerItemRenderers()
	{
	}
}
