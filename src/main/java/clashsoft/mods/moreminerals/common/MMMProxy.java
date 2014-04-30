package clashsoft.mods.moreminerals.common;

import clashsoft.cslib.minecraft.common.BaseProxy;
import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.inventory.ContainerOreCrusher;
import clashsoft.mods.moreminerals.tileentity.TileEntityOreCrusher;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MMMProxy extends BaseProxy
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
}
