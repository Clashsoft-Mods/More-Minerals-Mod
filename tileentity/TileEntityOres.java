package clashsoft.mods.moreminerals.tileentity;

import clashsoft.mods.moreminerals.chem.Element;
import clashsoft.mods.moreminerals.chem.PeriodicTable;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityOres extends TileEntity
{
	public Block		block;
	public Element[]	elements;
	
	public TileEntityOres()
	{
		this.elements = new Element[] { PeriodicTable.get(29) };
	}
	
	public Element[] getElements()
	{
		return this.elements;
	}
	
	public Block getBlock()
	{
		return this.block;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setIntArray("Elements", PeriodicTable.toNums(this.elements));
		nbt.setInteger("Block", Block.getIdFromBlock(this.block));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		this.elements = PeriodicTable.toElements(nbt.getIntArray("Elements"));
		this.block = Block.getBlockById(nbt.getInteger("Block"));
	}
}
