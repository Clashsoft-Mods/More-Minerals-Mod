package clashsoft.mods.moreminerals.block;

import java.util.HashMap;
import java.util.Map;

import clashsoft.mods.moreminerals.chem.Element;
import clashsoft.mods.moreminerals.chem.PeriodicTable;
import clashsoft.mods.moreminerals.client.MMMClientProxy;
import clashsoft.mods.moreminerals.tileentity.TileEntityOres;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOres extends BlockContainer
{
	public Map<String, IIcon>	icons	= new HashMap();
	
	public TileEntityOres temp;
	
	public BlockOres()
	{
		super(Material.rock);
	}
	
	@Override
	public int getRenderType()
	{
		return MMMClientProxy.oresRenderType;
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
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata)
	{
		this.temp = (TileEntityOres) world.getTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		this.temp = (TileEntityOres) world.getTileEntity(x, y, z);
		return this.createStackedBlock(world.getBlockMetadata(x, y, z));
	}
	
	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		ItemStack stack = new ItemStack(this, 1, metadata);
		if (this.temp != null)
		{
			stack.stackTagCompound = new NBTTagCompound();
			this.temp.writeToNBT(stack.stackTagCompound);
		}
		return stack;
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
				String oreName = e.getTextureName(0);
				String blockName = e.getTextureName(1);
				this.icons.put(oreName, iconRegister.registerIcon(oreName));
				this.icons.put(blockName, iconRegister.registerIcon(blockName));
			}
		}
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		Element e = getElements(world, x, y, z)[0];
		int i = world.getBlockMetadata(x, y, z);
		return this.icons.get(e.getTextureName(i & 1));
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityOres();
	}
}
