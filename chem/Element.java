package clashsoft.mods.moreminerals.chem;

public class Element
{
	private String			name;
	private String			symbol;
	private String			mass;
	
	private ElementClass	elementClass;
	
	private int				period;
	private int				group;
	
	public Element(String name, String symbol, String mass, ElementClass elementClass, int period, int group)
	{
		this.name = name;
		this.symbol = symbol;
		this.mass = mass;
		this.elementClass = elementClass;
		this.period = period;
		this.group = group;
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
}
