package clashsoft.mods.moreminerals;

import clashsoft.mods.moreminerals.orecrusher.ContainerOreCrusher;
import clashsoft.mods.moreminerals.orecrusher.GuiOreCrusher;
import clashsoft.mods.moreminerals.orecrusher.TileEntityOreCrusher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te instanceof TileEntityOreCrusher || ID == MoreMineralsMod.OreCrusher_TEID)
		{
			return new ContainerOreCrusher(player.inventory, (TileEntityOreCrusher) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == MoreMineralsMod.OreCrusher_TEID)
		{
			return new GuiOreCrusher(player.inventory, (TileEntityOreCrusher) world.getBlockTileEntity(x, y, z));
		}
		return null;
	}
	
	public void registerItemRenderers() {}
	public void registerBlockRenderers() {}
}
