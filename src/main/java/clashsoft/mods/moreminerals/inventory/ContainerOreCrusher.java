package clashsoft.mods.moreminerals.inventory;

import clashsoft.cslib.minecraft.inventory.SlotOutput;
import clashsoft.mods.moreminerals.orecrusher.CrusherRecipes;
import clashsoft.mods.moreminerals.tileentity.TileEntityOreCrusher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerOreCrusher extends Container
{
	private TileEntityOreCrusher	crusher;
	private int						lastCrushingTime		= 0;
	private int						lastBurnTime		= 0;
	private int						lastMaxBurnTime	= 0;
	
	public ContainerOreCrusher(InventoryPlayer inventory, TileEntityOreCrusher crusher)
	{
		this.crusher = crusher;
		this.addSlotToContainer(new Slot(crusher, 0, 56, 17));
		this.addSlotToContainer(new Slot(crusher, 1, 56, 53));
		this.addSlotToContainer(new SlotOutput(crusher, 2, 116, 35));
		int i;
		
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.crusher.crushingTime);
		crafting.sendProgressBarUpdate(this, 1, this.crusher.burnTime);
		crafting.sendProgressBarUpdate(this, 2, this.crusher.maxBurnTime);
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.lastCrushingTime != this.crusher.crushingTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.crusher.crushingTime);
			}
			
			if (this.lastBurnTime != this.crusher.burnTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.crusher.burnTime);
			}
			
			if (this.lastMaxBurnTime != this.crusher.maxBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 2, this.crusher.maxBurnTime);
			}
		}
		
		this.lastCrushingTime = this.crusher.crushingTime;
		this.lastBurnTime = this.crusher.burnTime;
		this.lastMaxBurnTime = this.crusher.maxBurnTime;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int ID, int time)
	{
		if (ID == 0)
		{
			this.crusher.crushingTime = time;
		}
		
		if (ID == 1)
		{
			this.crusher.burnTime = time;
		}
		
		if (ID == 2)
		{
			this.crusher.maxBurnTime = time;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.crusher.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotID == 2)
			{
				if (!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}
				
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (slotID != 1 && slotID != 0)
			{
				if (CrusherRecipes.instance.getResult(itemstack1) != null)
				{
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
				else if (TileEntityOreCrusher.isItemFuel(itemstack1))
				{
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				}
				else if (slotID >= 3 && slotID < 30)
				{
					if (!this.mergeItemStack(itemstack1, 30, 39, false))
					{
						return null;
					}
				}
				else if (slotID >= 30 && slotID < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}
}
