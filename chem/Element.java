package clashsoft.mods.moreminerals.chem;

public class Element
{
	private int				number;
	
	private String			name;
	private String			symbol;
	private String			mass;
	
	private ElementClass	elementClass;
	
	private int				period;
	private int				group;
	
	public Element(int number, String name, String symbol, String mass, ElementClass elementClass, int period, int group)
	{
		PeriodicTable.set(number, this);
		
		this.number = number;
		this.name = name;
		this.symbol = symbol;
		this.mass = mass;
		this.elementClass = elementClass;
		this.period = period;
		this.group = group;
	}
	
	public int getNumber()
	{
		return this.number;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getSymbol()
	{
		return this.symbol;
	}
	
	public String getMass()
	{
		return this.mass;
	}
	
	public ElementClass getElementClass()
	{
		return this.elementClass;
	}
	
	public int getGroup()
	{
		return this.group;
	}
	
	public int getPeriod()
	{
		return this.period;
	}
	
	public float getHardness()
	{
		return /* this.hardness */1F;
	}
	
	public int getGenDepth()
	{
		return /* this.genDepth */32;
	}
	
	public int getColor()
	{
		return /* this.color */0xFFFFFF;
	}
	
	public int getOreColor()
	{
		return this.getColor();
	}
	
	public boolean isAvailable()
	{
		return this.getGenDepth() > 0;
	}
	
	public boolean isTextureOverlay(int var)
	{
		return var == 0 || var == 1;
	}
	
	public String getTextureName(int var)
	{
		if (var == 0)
		{
			return "ore_overlay";
		}
		else if (var == 1)
		{
			return "ore_block";
		}
		else if (var == 2)
		{
			return "ingot";
		}
		else if (var == 3)
		{
			return "nugget";
		}
		else if (var == 4)
		{
			return "dust";
		}
		return "";
	}
	
	public static boolean canCombine(Element e1, Element e2)
	{
		return e1.getElementClass().isMetal() && e2.getElementClass().isMetal();
	}
}
