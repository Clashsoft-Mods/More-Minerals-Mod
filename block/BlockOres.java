package clashsoft.mods.moreminerals.block;

import clashsoft.mods.moreminerals.chem.Element;
import clashsoft.mods.moreminerals.chem.PeriodicTable;
import clashsoft.mods.moreminerals.tileentity.TileEntityOres;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOres extends BlockContainer
{
	public IIcon[]	oreIcons	= new IIcon[PeriodicTable.SIZE];
	public IIcon[]	blockIcons	= new IIcon[PeriodicTable.SIZE];
	
	public BlockOres()
	{
		super(Material.rock);
	}
	
	public static Element[] getElements(IBlockAccess world, int x, int y, int z)
	{
		TileEntityOres te = (TileEntityOres) world.getTileEntity(x, y, z);
		return te.getElements();
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
	{
		Element[] elements = getElements(world, x, y, z);
		float max = 0F;
		for (Element e : elements)
		{
			float f = e.getHardness();
			if (f > max)
				max = f;
		}
		return max;
	}
	
	@Override
	public int colorMultiplier(IBlockAccess world, int x, int y, int z)
	{
		Element[] elements = getElements(world, x, y, z);
		return PeriodicTable.calcColor(elements, world.getBlockMetadata(x, y, z));
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		for (int i = 1; i < PeriodicTable.SIZE; i++)
		{
			Element e = PeriodicTable.get(i);
			if (e != null)
			{
				oreIcons[i] = iconRegister.registerIcon(e.getTextureName(0));
				blockIcons[i] = iconRegister.registerIcon(e.getTextureName(1));
			}
		}
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		Element e = getElements(world, x, y, z)[0];
		int i = world.getBlockMetadata(x, y, z);
		if (i == 0)
			return this.oreIcons[e.getNumber()];
		return this.blockIcons[e.getNumber()];
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityOres();
	}
}
