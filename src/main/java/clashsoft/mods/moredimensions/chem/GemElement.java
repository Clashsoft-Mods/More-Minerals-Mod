package clashsoft.mods.moreminerals.chem;

public class GemElement extends Element
{	
	public GemElement(int number, String name, String symbol)
	{
		super(number, name, symbol, -1, -1, ElementClass.GEM);
	}
	
	@Override
	public String getTextureName(int var)
	{
		if (var == 0)
		{
			return "moreminerals:gem_overlay";
		}
		else if (var == 1)
		{
			return "moreminerals:gem_block";
		}
		else if (var == 2)
		{
			return "moreminerals:gem";
		}
		else if (var == 3)
		{
			return "moreminerals:gem_nugget";
		}
		else if (var == 4)
		{
			return "moreminerals:dust";
		}
		return "";
	}
}
