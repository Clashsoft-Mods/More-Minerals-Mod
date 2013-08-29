package clashsoft.mods.moreminerals;

import clashsoft.clashsoftapi.util.CSItemRenderer;

import net.minecraftforge.client.MinecraftForgeClient;

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
		MinecraftForgeClient.registerItemRenderer(MoreMineralsMod.dataSword.itemID, CSItemRenderer.instance);
		MinecraftForgeClient.registerItemRenderer(MoreMineralsMod.dataSpade.itemID, CSItemRenderer.instance);
		MinecraftForgeClient.registerItemRenderer(MoreMineralsMod.dataPickaxe.itemID, CSItemRenderer.instance);
		MinecraftForgeClient.registerItemRenderer(MoreMineralsMod.dataAxe.itemID, CSItemRenderer.instance);
		MinecraftForgeClient.registerItemRenderer(MoreMineralsMod.dataHoe.itemID, CSItemRenderer.instance);
	}
}
