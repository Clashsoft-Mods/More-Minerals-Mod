package clashsoft.mods.moreminerals.chem;

public class GemElement extends Element
{
	public static final GemElement Amethyst = new GemElement(144, "Amethyst", "?");
	public static final GemElement Ruby = new GemElement(145, "Ruby", "?");
	public static final GemElement Sapphire = new GemElement(146, "Sapphire", "?");
	public static final GemElement Topaz = new GemElement(147, "Topaz", "?");
	public static final GemElement Spinel = new GemElement(148, "Spinel", "?");
	public static final GemElement Opal = new GemElement(149, "Opal", "?");
	
	public GemElement(int number, String name, String symbol)
	{
		super(PeriodicTable.GEMS_LOW + number, name, symbol,  -1, -1, ElementClass.GEM);
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
