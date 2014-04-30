package clashsoft.mods.moreminerals.orecrusher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clashsoft.cslib.minecraft.crafting.ExperienceRecipeManager;
import clashsoft.cslib.minecraft.crafting.SimpleRecipeManager;
import clashsoft.cslib.minecraft.item.CSStacks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CrusherRecipes extends ExperienceRecipeManager
{
	public static final CrusherRecipes	instance	= new CrusherRecipes();
	
	private CrusherRecipes()
	{
	}
	
	public static void addCrusherRecipe(Block block, ItemStack output, float exp)
	{
		instance.addRecipe(block, output, exp);
	}
	
	public static void addCrusherRecipe(Item item, ItemStack output, float exp)
	{
		instance.addRecipe(item, output, exp);
	}
	
	public static void addCrusherRecipe(ItemStack input, ItemStack output, float exp)
	{
		instance.addRecipe(input, output, exp);
	}
}