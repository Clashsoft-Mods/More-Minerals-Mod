package clashsoft.mods.moreminerals.chem;

public enum ElementClass
{
	NON_METAL("Non-metal"), NOBLE_GAS("Noble Gas"), ALKALI_METAL("Alkali Metal"), ALKALINE_EARTH_METAL("Alkaline Earth Metal"), METALLOID("Metalloid"), HALOGEN("Halogen"), TRANSITION_METAL("Transitional Metal"), POOR_METAL("Poor Metal"), LANTHANIDE("Lanthanide"), ACTINIDE("Actinide");
	
	private String	name;
	
	ElementClass(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
}
