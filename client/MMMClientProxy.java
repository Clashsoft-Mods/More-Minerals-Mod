package clashsoft.mods.moreminerals.client;

import clashsoft.mods.moreminerals.client.render.block.RenderBlockOres;
import clashsoft.mods.moreminerals.common.MMMProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class MMMClientProxy extends MMMProxy
{
	public static int oresRenderType;
	
	@Override
	public void registerRenderers()
	{
		oresRenderType = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBlockOres());
	}
}
