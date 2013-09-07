package clashsoft.mods.moreminerals;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public static int	oreRenderer;
	
	@Override
	public void registerBlockRenderers()
	{
		oreRenderer = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(oreRenderer, new MoreMineralsOreRenderer());
	}
	
	@Override
	public void registerItemRenderers()
	{
	}
}
