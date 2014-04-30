package clashsoft.mods.moreminerals.common;

import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.client.gui.GuiOreCrusher;
import clashsoft.mods.moreminerals.inventory.ContainerOreCrusher;
import clashsoft.mods.moreminerals.tileentity.TileEntityOreCrusher;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;

public class MMMCommonProxy implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == MoreMineralsMod.oreCrusherTEID)
		{
			return new ContainerOreCrusher(player.inventory, (TileEntityOreCrusher) world.getTileEntity(x, y, z));
		}
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == MoreMineralsMod.oreCrusherTEID)
		{
			return new GuiOreCrusher(player.inventory, (TileEntityOreCrusher) world.getTileEntity(x, y, z));
		}
		return null;
	}
	
	public void registerItemRenderers()
	{
	}
	
	public void registerBlockRenderers()
	{
	}
}
