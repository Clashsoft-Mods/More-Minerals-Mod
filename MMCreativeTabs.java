package clashsoft.mods.moreminerals;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MMCreativeTabs extends CreativeTabs
{
	private ItemStack	icon;
	
	public MMCreativeTabs(String label)
	{
		super(label);
	}
	
	public MMCreativeTabs setIconItemStack(ItemStack stack)
	{
		this.icon = stack;
		return this;
	}
	
	/**
	 * Get the ItemStack that will be rendered to the tab.
	 */
	@Override
	public ItemStack getIconItemStack()
	{
		return icon;
	}
}
