package clashsoft.mods.moreminerals.client;

import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.client.gui.GuiOreCrusher;
import clashsoft.mods.moreminerals.client.renderer.block.MMMOreRenderer;
import clashsoft.mods.moreminerals.common.MMMProxy;
import clashsoft.mods.moreminerals.tileentity.TileEntityOreCrusher;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MMMClientProxy extends MMMProxy
{
	public static int	oreRenderer;
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == MoreMineralsMod.oreCrusherTEID)
		{
			return new GuiOreCrusher(player.inventory, (TileEntityOreCrusher) world.getTileEntity(x, y, z));
		}
		return null;
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		oreRenderer = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(oreRenderer, new MMMOreRenderer());
	}
	
	@Override
	public boolean isClient()
	{
		return true;
	}
}
