package clashsoft.mods.moreminerals.chem;

public class SpecialElement extends Element
{
	public static final SpecialElement Vibranium = new SpecialElement(0, "Vibranium", "Vb", ElementClass.METALLOID);
	public static final SpecialElement Adamantite = new SpecialElement(1, "Adamantite", "VbFe", ElementClass.METALLOID);
	public static final SpecialElement Cobalt = new SpecialElement(2, "Cobalt", "?", ElementClass.METALLOID);
	public static final SpecialElement Mythril = new SpecialElement(3, "Mythril", "?", ElementClass.METALLOID);
	public static final SpecialElement Demonite = new SpecialElement(4, "Demonite", "?", ElementClass.METALLOID);
	
	public SpecialElement(int number, String name, String symbol, ElementClass elementClass)
	{
		super(PeriodicTable.SPECIAL_LOW + number, name, symbol, -1, -1, elementClass);
	}
}
