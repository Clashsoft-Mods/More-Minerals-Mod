package clashsoft.mods.moreminerals.chem;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class VanillaElement extends Element
{
	public static final String[]	VANILLA_ORES	= { "coal", "diamond", "redstone", "lapis", "emerald", "quartz" };
	
	public VanillaElement(int number, String name, String symbol)
	{
		super(number, name, symbol, -1, -1, ElementClass.VANILLA);
	}
	
	@Override
	public boolean isTextureOverlay(int var)
	{
		return false;
	}
	
	@Override
	public boolean isAvailable(Block block)
	{
		return block != Blocks.stone;
	}
	
	@Override
	public String getTextureName(int var)
	{
		int index = this.getNumber() - PeriodicTable.VANILLA_LOW;
		if (var == 0)
		{
			return "moreminerals:" + VANILLA_ORES[index] + "_overlay";
		}
		else
		{
			return VANILLA_ORES[index] + "_block";
		}
	}
}
