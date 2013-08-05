package clashsoft.mods.moreminerals.orecrusher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.item.ItemStack;

public class OreCrusherRecipes
{
    private static final OreCrusherRecipes crushingBase = new OreCrusherRecipes();

    /** The list of smelting results. */
    private Map crushingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaCrushingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final OreCrusherRecipes crushing()
    {
        return crushingBase;
    }

    /**
     * Adds a smelting recipe.
     */
    public void addCrushing(int par1, ItemStack par2ItemStack, float par3)
    {
        this.crushingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getCrushingResult(int par1)
    {
        return (ItemStack)this.crushingList.get(Integer.valueOf(par1));
    }

    public Map getCrushingList()
    {
        return this.crushingList;
    }

    @Deprecated //In favor of ItemStack sensitive version
    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /**
     * A metadata sensitive version of adding a furnace recipe.
     */
    public void addCrushing(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaCrushingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemID, metadata), experience);
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getCrushingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaCrushingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null)
        {
            return ret;
        }
        return (ItemStack)crushingList.get(Integer.valueOf(item.itemID));
    }

    /**
     * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
     */
    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaCrushingList;
    }

	public void addCrushing(ItemStack input, ItemStack output, float exp)
	{
		addCrushing(input.itemID, input.getItemDamage(), output, exp);
	}
}
