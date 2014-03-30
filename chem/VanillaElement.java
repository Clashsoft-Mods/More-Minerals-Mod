package clashsoft.mods.moreminerals.chem;

public class VanillaElement extends Element
{
	public static final VanillaElement Coal = new VanillaElement(0, "Coal", "C2", "2*C");
	public static final VanillaElement Diamond = new VanillaElement(1, "Diamond", "C128", "128*C");
	public static final VanillaElement Redstone = new VanillaElement(2, "Redstone", "?", "");
	public static final VanillaElement Lapislazuli = new VanillaElement(3, "Lapis Lazuli", "?", "").setIconName("lapis");
	public static final VanillaElement Emerald = new VanillaElement(4, "Emerald", "?", "");
	public static final VanillaElement Quartz = new VanillaElement(5, "Quartz", "SiO2", "");
	
	private String iconName;
	
	public VanillaElement(int number, String name, String symbol, String mass)
	{
		super(PeriodicTable.VANILLA_LOW + number, name, symbol, mass, ElementClass.SPECIAL, -1, -1);
		this.iconName = name.toLowerCase();
	}
	
	private VanillaElement setIconName(String iconName)
	{
		this.iconName = iconName;
		return this;
	}
	
	@Override
	public boolean isTextureOverlay(int var)
	{
		return false;
	}
	
	@Override
	public String getTextureName(int var)
	{
			if (var == 0)
				return this.iconName + "_ore";
			else if (var == 1)
				return this.iconName + "_block";
		return super.getTextureName(var);
	}
}
