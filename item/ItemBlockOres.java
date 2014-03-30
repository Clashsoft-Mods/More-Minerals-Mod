package clashsoft.mods.moreminerals.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOres extends ItemBlock
{
	public ItemBlockOres(Block block)
	{
		super(block);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return "";
	}
}
