package clashsoft.mods.moreminerals.tileentity;

import clashsoft.cslib.minecraft.tileentity.TileEntityInventory;
import clashsoft.cslib.util.CSArrays;
import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.block.BlockOreCrusher;
import clashsoft.mods.moreminerals.orecrusher.CrusherRecipes;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityOreCrusher extends TileEntityInventory implements ISidedInventory
{
	private static final int[]	inputSlotsTop	= new int[] { 0 };
	private static final int[]	outputSlots		= new int[] { 2, 1 };
	private static final int[]	inputSlots		= new int[] { 1 };
	
	public int					burnTime		= 0;
	public int					maxBurnTime		= 0;
	
	public int					crushingTime	= 0;
	private String				inventoryName;
	
	@Override
	public int getSizeInventory()
	{
		return 3;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.burnTime = nbt.getShort("BurnTime");
		this.crushingTime = nbt.getShort("CrushingTime");
		this.maxBurnTime = getItemBurnTime(this.itemStacks[1]);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setShort("BurnTime", (short) this.burnTime);
		nbt.setShort("CrushingTime", (short) this.crushingTime);
	}
	
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@SideOnly(Side.CLIENT)
	public int getProgressScaled(int scalar)
	{
		return this.crushingTime * scalar / 200;
	}
	
	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int scalar)
	{
		if (this.maxBurnTime == 0)
		{
			this.maxBurnTime = 200;
		}
		
		return this.burnTime * scalar / this.maxBurnTime;
	}
	
	public boolean isBurning()
	{
		return this.burnTime > 0;
	}
	
	@Override
	public void updateEntity()
	{
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;
		
		if (this.burnTime > 0)
		{
			--this.burnTime;
		}
		
		if (!this.worldObj.isRemote)
		{
			if (this.burnTime == 0 && this.canCrush())
			{
				this.maxBurnTime = this.burnTime = getItemBurnTime(this.itemStacks[1]);
				
				if (this.burnTime > 0)
				{
					flag1 = true;
					
					if (this.itemStacks[1] != null)
					{
						--this.itemStacks[1].stackSize;
						
						if (this.itemStacks[1].stackSize == 0)
						{
							this.itemStacks[1] = this.itemStacks[1].getItem().getContainerItem(this.itemStacks[1]);
						}
					}
				}
			}
			
			if (this.isBurning() && this.canCrush())
			{
				++this.crushingTime;
				
				if (this.crushingTime == 200)
				{
					this.crushingTime = 0;
					this.crushItem();
					flag1 = true;
				}
			}
			else
			{
				this.crushingTime = 0;
			}
			
			if (flag != this.burnTime > 0)
			{
				flag1 = true;
				BlockOreCrusher.updateBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		
		if (flag1)
		{
			this.markDirty();
		}
	}
	
	private boolean canCrush()
	{
		if (this.itemStacks[0] == null)
		{
			return false;
		}
		else
		{
			ItemStack itemstack = CrusherRecipes.instance.getResult(this.itemStacks[0]);
			if (itemstack == null)
				return false;
			if (this.itemStacks[2] == null)
				return true;
			if (!this.itemStacks[2].isItemEqual(itemstack))
				return false;
			int result = itemStacks[2].stackSize + itemstack.stackSize;
			return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
		}
	}
	
	public void crushItem()
	{
		if (this.canCrush())
		{
			ItemStack itemstack = CrusherRecipes.instance.getResult(this.itemStacks[0]);
			
			if (this.itemStacks[2] == null)
			{
				this.itemStacks[2] = itemstack.copy();
			}
			else if (this.itemStacks[2].isItemEqual(itemstack))
			{
				itemStacks[2].stackSize += itemstack.stackSize;
			}
			
			--this.itemStacks[0].stackSize;
			
			if (this.itemStacks[0].stackSize <= 0)
			{
				this.itemStacks[0] = null;
			}
		}
	}
	
	public static int getItemBurnTime(ItemStack stack)
	{
		if (stack != null)
		{
			Item item = stack.getItem();
			int metadata = stack.getItemDamage();
			
			boolean isMagnesiumMetadata = metadata == CSArrays.indexOf(MoreMineralsMod.allnames, "Magnesium");
			
			if ((item == MoreMineralsMod.ingots || item == MoreMineralsMod.dusts) && isMagnesiumMetadata)
				return 1800;
			else if (item == MoreMineralsMod.nuggets && isMagnesiumMetadata)
				return 200;
		}
		return 0;
	}
	
	public static boolean isItemFuel(ItemStack stack)
	{
		return getItemBurnTime(stack) > 0;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack)
	{
		return slot == 2 ? false : (slot == 1 ? isItemFuel(stack) : true);
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int side)
	{
		return side == 0 ? outputSlots : (side == 1 ? inputSlotsTop : inputSlots);
	}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side)
	{
		return this.isItemValidForSlot(side, stack);
	}
	
	@Override
	public boolean canExtractItem(int slot, ItemStack par2ItemStack, int side)
	{
		return side != 0 || slot != 1;
	}
}
