package clashsoft.mods.moreminerals.chem;

import static clashsoft.mods.moreminerals.chem.ElementClass.*;

import java.util.List;

public class PeriodicTable
{
	public static final int			SIZE				= 256;
	
	public static final int			ACTINOIDS			= 15;
	public static final int			ACTINOIDS_LOW		= 89;
	public static final int			ACTINOIDS_HIGH		= 103;
	
	public static final int			LANTHANOIDS			= 15;
	public static final int			LANTHANOIDS_LOW		= 57;
	public static final int			LANTHANOIDS_HIGH	= 71;
	
	public static final int			VANILLA_LOW			= 128;
	
	public static final int			GEMS_LOW			= 144;
	
	public static final int			SPECIAL_LOW			= 192;
	
	/** The elements. */
	private static final Element[]	elements			= new Element[SIZE];
	
	public static final Element		Hydrogen			= new Element(1, "Hydrogen", "H", 1, 1, NON_METAL);
	public static final Element		Helium				= new Element(2, "Helium", "He", 1, 18, NOBLE_GAS);
	public static final Element		Lithium				= new Element(3, "Lithium", "Li", 2, 1, ALKALI_METAL);
	public static final Element		Beryllium			= new Element(4, "Beryllium", "Be", 2, 2, ALKALINE_EARTH_METAL);
	public static final Element		Boron				= new Element(5, "Boron", "B", 2, 13, METALLOID);
	public static final Element		Carbon				= new Element(6, "Carbon", "C", 2, 14, NON_METAL);
	public static final Element		Nitrogen			= new Element(7, "Nitrogen", "N", 2, 15, NON_METAL);
	public static final Element		Oxygen				= new Element(8, "Oxygen", "O", 2, 16, NON_METAL);
	public static final Element		Fluorine			= new Element(9, "Fluorine", "F", 2, 17, HALOGEN);
	public static final Element		Neon				= new Element(10, "Neon", "Ne", 2, 18, NOBLE_GAS);
	public static final Element		Sodium				= new Element(11, "Sodium", "Na", 3, 1, ALKALI_METAL);
	public static final Element		Magnesium			= new Element(12, "Magnesium", "Mg", 3, 2, ALKALINE_EARTH_METAL);
	public static final Element		Aluminium			= new Element(13, "Aluminium", "Al", 3, 13, POOR_METAL);
	public static final Element		Silicon				= new Element(14, "Silicon", "Si", 3, 14, METALLOID);
	public static final Element		Phosphorus			= new Element(15, "Phosphorus", "P", 3, 15, NON_METAL);
	public static final Element		Sulfur				= new Element(16, "Sulfur", "S", 3, 16, NON_METAL);
	public static final Element		Chlorine			= new Element(17, "Chlorine", "Cl", 3, 17, HALOGEN);
	public static final Element		Argon				= new Element(18, "Argon", "Ar", 3, 18, NOBLE_GAS);
	public static final Element		Potassium			= new Element(19, "Potassium", "K", 4, 1, ALKALI_METAL);
	public static final Element		Calcium				= new Element(20, "Calcium", "Ca", 4, 2, ALKALINE_EARTH_METAL);
	public static final Element		Scandium			= new Element(21, "Scandium", "Sc", 4, 3, TRANSITION_METAL);
	public static final Element		Titanium			= new Element(22, "Titanium", "Ti", 4, 4, TRANSITION_METAL);
	public static final Element		Vanadium			= new Element(23, "Vanadium", "V", 4, 5, TRANSITION_METAL);
	public static final Element		Chrome				= new Element(24, "Chrome", "Cr", 4, 6, TRANSITION_METAL);
	public static final Element		Manganese			= new Element(25, "Manganese", "Mn", 4, 7, TRANSITION_METAL);
	public static final Element		Iron				= new Element(26, "Iron", "Fe", 4, 8, TRANSITION_METAL);
	public static final Element		Cobalt				= new Element(27, "Cobalt", "Co", 4, 9, TRANSITION_METAL);
	public static final Element		Nickel				= new Element(28, "Nickel", "Ni", 4, 10, TRANSITION_METAL);
	public static final Element		Copper				= new Element(29, "Copper", "Cu", 4, 11, TRANSITION_METAL);
	public static final Element		Zinc				= new Element(30, "Zinc", "Zn", 4, 12, TRANSITION_METAL);
	public static final Element		Gallium				= new Element(31, "Gallium", "Ga", 4, 13, POOR_METAL);
	public static final Element		Germanium			= new Element(32, "Germanium", "Ge", 4, 14, METALLOID);
	public static final Element		Arsenic				= new Element(33, "Arsenic", "As", 4, 15, METALLOID);
	public static final Element		Selenium			= new Element(34, "Selenium", "Se", 4, 16, NON_METAL);
	public static final Element		Bromine				= new Element(35, "Bromine", "Br", 4, 17, HALOGEN);
	public static final Element		Krypton				= new Element(36, "Krypton", "Kr", 4, 18, NOBLE_GAS);
	public static final Element		Rubidium			= new Element(37, "Rubidium", "Rb", 5, 1, ALKALI_METAL);
	public static final Element		Strontium			= new Element(38, "Strontium", "Sr", 5, 2, ALKALINE_EARTH_METAL);
	public static final Element		Yttrium				= new Element(39, "Yttrium", "Y", 5, 3, TRANSITION_METAL);
	public static final Element		Zirconium			= new Element(40, "Zirconium", "Zr", 5, 4, TRANSITION_METAL);
	public static final Element		Niobium				= new Element(41, "Niobium", "Nb", 5, 5, TRANSITION_METAL);
	public static final Element		Molybdenum			= new Element(42, "Molybdenum", "Mo", 5, 6, TRANSITION_METAL);
	public static final Element		Technetium			= new Element(43, "Technetium", "Tc", 5, 7, TRANSITION_METAL);
	public static final Element		Ruthenium			= new Element(44, "Ruthenium", "Ru", 5, 8, TRANSITION_METAL);
	public static final Element		Rhodium				= new Element(45, "Rhodium", "Rh", 5, 9, TRANSITION_METAL);
	public static final Element		Palladium			= new Element(46, "Palladium", "Pd", 5, 10, TRANSITION_METAL);
	public static final Element		Silver				= new Element(47, "Silver", "Ag", 5, 11, TRANSITION_METAL);
	public static final Element		Cadmium				= new Element(48, "Cadmium", "Cd", 5, 12, TRANSITION_METAL);
	public static final Element		Indium				= new Element(49, "Indium", "In", 5, 13, POOR_METAL);
	public static final Element		Tin					= new Element(50, "Tin", "Sn", 5, 14, POOR_METAL);
	public static final Element		Antimony			= new Element(51, "Antimony", "Sb", 5, 15, METALLOID);
	public static final Element		Tellurium			= new Element(52, "Tellurium", "Te", 5, 16, METALLOID);
	public static final Element		Iodine				= new Element(53, "Iodine", "I", 5, 17, HALOGEN);
	public static final Element		Xenon				= new Element(54, "Xenon", "Xe", 5, 18, NOBLE_GAS);
	public static final Element		Caesium				= new Element(55, "Caesium", "Cs", 6, 1, ALKALI_METAL);
	public static final Element		Barium				= new Element(56, "Barium", "Ba", 6, 2, ALKALINE_EARTH_METAL);
	public static final Element		Lanthanum			= new Element(57, "Lanthanum", "La", 6, 0, LANTHANIDE);
	public static final Element		Cerium				= new Element(58, "Cerium", "Ce", 6, 0, LANTHANIDE);
	public static final Element		Praseodymium		= new Element(59, "Praseodymium", "Pr", 6, 0, LANTHANIDE);
	public static final Element		Neodymium			= new Element(60, "Neodymium", "Nd", 6, 0, LANTHANIDE);
	public static final Element		Promethium			= new Element(61, "Promethium", "Pm", 6, 0, LANTHANIDE);
	public static final Element		Samarium			= new Element(62, "Samarium", "Sm", 6, 0, LANTHANIDE);
	public static final Element		Europium			= new Element(63, "Europium", "Eu", 6, 0, LANTHANIDE);
	public static final Element		Gadolinium			= new Element(64, "Gadolinium", "Gd", 6, 0, LANTHANIDE);
	public static final Element		Terbium				= new Element(65, "Terbium", "Tb", 6, 0, LANTHANIDE);
	public static final Element		Dysprosium			= new Element(66, "Dysprosium", "Dy", 6, 0, LANTHANIDE);
	public static final Element		Holmium				= new Element(67, "Holmium", "Ho", 6, 0, LANTHANIDE);
	public static final Element		Erbium				= new Element(68, "Erbium", "Er", 6, 0, LANTHANIDE);
	public static final Element		Thulium				= new Element(69, "Thulium", "Tm", 6, 0, LANTHANIDE);
	public static final Element		Ytterbium			= new Element(70, "Ytterbium", "Yb", 6, 0, LANTHANIDE);
	public static final Element		Lutetium			= new Element(71, "Lutetium", "Lu", 6, 3, LANTHANIDE);
	public static final Element		Hafnium				= new Element(72, "Hafnium", "Hf", 6, 4, TRANSITION_METAL);
	public static final Element		Tantalum			= new Element(73, "Tantalum", "Ta", 6, 5, TRANSITION_METAL);
	public static final Element		Tungsten			= new Element(74, "Tungsten", "W", 6, 6, TRANSITION_METAL);
	public static final Element		Rhenium				= new Element(75, "Rhenium", "Re", 6, 7, TRANSITION_METAL);
	public static final Element		Osmium				= new Element(76, "Osmium", "Os", 6, 8, TRANSITION_METAL);
	public static final Element		Iridium				= new Element(77, "Iridium", "Ir", 6, 9, TRANSITION_METAL);
	public static final Element		Platinum			= new Element(78, "Platinum", "Pt", 6, 10, TRANSITION_METAL);
	public static final Element		Gold				= new Element(79, "Gold", "Au", 6, 11, TRANSITION_METAL);
	public static final Element		Mercury				= new Element(80, "Mercury", "Hg", 6, 12, TRANSITION_METAL);
	public static final Element		Thallium			= new Element(81, "Thallium", "Tl", 6, 13, POOR_METAL);
	public static final Element		Lead				= new Element(82, "Lead", "Pb", 6, 14, POOR_METAL);
	public static final Element		Bismuth				= new Element(83, "Bismuth", "Bi", 6, 15, POOR_METAL);
	public static final Element		Polonium			= new Element(84, "Polonium", "Po", 6, 16, METALLOID);
	public static final Element		Astatine			= new Element(85, "Astatine", "At", 6, 17, HALOGEN);
	public static final Element		Radon				= new Element(86, "Radon", "Rn", 6, 18, NOBLE_GAS);
	public static final Element		Francium			= new Element(87, "Francium", "Fr", 7, 1, ALKALI_METAL);
	public static final Element		Radium				= new Element(88, "Radium", "Ra", 7, 2, ALKALINE_EARTH_METAL);
	public static final Element		Actinium			= new Element(89, "Actinium", "Ac", 7, 0, ACTINIDE);
	public static final Element		Thorium				= new Element(90, "Thorium", "Th", 7, 0, ACTINIDE);
	public static final Element		Protactinium		= new Element(91, "Protactinium", "Pa", 7, 0, ACTINIDE);
	public static final Element		Uranium				= new Element(92, "Uranium", "U", 7, 0, ACTINIDE);
	public static final Element		Neptunium			= new Element(93, "Neptunium", "Np", 7, 0, ACTINIDE);
	public static final Element		Plutonium			= new Element(94, "Plutonium", "Pu", 7, 0, ACTINIDE);
	public static final Element		Americium			= new Element(95, "Americium", "Am", 7, 0, ACTINIDE);
	public static final Element		Curium				= new Element(96, "Curium", "Cm", 7, 0, ACTINIDE);
	public static final Element		Berkelium			= new Element(97, "Berkelium", "Bk", 7, 0, ACTINIDE);
	public static final Element		Californium			= new Element(98, "Californium", "Cf", 7, 0, ACTINIDE);
	public static final Element		Einsteinium			= new Element(99, "Einsteinium", "Es", 7, 0, ACTINIDE);
	public static final Element		Fermium				= new Element(100, "Fermium", "Fm", 7, 0, ACTINIDE);
	public static final Element		Mendelevium			= new Element(101, "Mendelevium", "Md", 7, 0, ACTINIDE);
	public static final Element		Nobelium			= new Element(102, "Nobelium", "No", 7, 0, ACTINIDE);
	public static final Element		Lawrencium			= new Element(103, "Lawrencium", "Lr", 7, 3, ACTINIDE);
	public static final Element		Rutherfordium		= new Element(104, "Rutherfordium", "Rf", 7, 4, TRANSITION_METAL);
	public static final Element		Dubnium				= new Element(105, "Dubnium", "Db", 7, 5, TRANSITION_METAL);
	public static final Element		Seaborgium			= new Element(106, "Seaborgium", "Sg", 7, 6, TRANSITION_METAL);
	public static final Element		Bohrium				= new Element(107, "Bohrium", "Bh", 7, 7, TRANSITION_METAL);
	public static final Element		Hassium				= new Element(108, "Hassium", "Hs", 7, 8, TRANSITION_METAL);
	public static final Element		Meitnerium			= new Element(109, "Meitnerium", "Mt", 7, 9, TRANSITION_METAL);
	public static final Element		Darmstadtium		= new Element(110, "Darmstadtium", "Ds", 7, 10, TRANSITION_METAL);
	public static final Element		Roentgenium			= new Element(111, "Roentgenium", "Rg", 7, 11, TRANSITION_METAL);
	public static final Element		Ununbium			= new Element(112, "Ununbium", "Uub", 7, 12, TRANSITION_METAL);
	public static final Element		Ununtrium			= new Element(113, "Ununtrium", "Uut", 7, 13, POOR_METAL);
	public static final Element		Ununquadium			= new Element(114, "Ununquadium", "Uuq", 7, 14, POOR_METAL);
	public static final Element		Ununpentium			= new Element(115, "Ununpentium", "Uup", 7, 15, POOR_METAL);
	public static final Element		Ununhexium			= new Element(116, "Ununhexium", "Uuh", 7, 16, POOR_METAL);
	public static final Element		Ununseptium			= new Element(117, "Ununseptium", "Uus", 7, 17, HALOGEN);
	public static final Element		Ununoctium			= new Element(118, "Ununoctium", "Uuo", 7, 18, NOBLE_GAS);
	
	public static Element[] getElements()
	{
		return elements;
	}
	
	public static Element get(int number)
	{
		return elements[number];
	}
	
	protected static void set(int number, Element element)
	{
		if (number >= 0 && number < 256)
			elements[number] = element;
	}
	
	public static int[] toNums(Element[] e)
	{
		int len = e.length;
		int[] nums = new int[len];
		for (int i = 0; i < len; i++)
		{
			nums[i] = e[i].getNumber();
		}
		return nums;
	}
	
	public static Element[] toElements(int[] nums)
	{
		int len = nums.length;
		Element[] elements = new Element[len];
		for (int i = 0; i < len; i++)
		{
			elements[i] = PeriodicTable.get(nums[i]);
		}
		return elements;
	}
	
	public static void load(List<String> lines)
	{
		lines.isEmpty();
		for (String line : lines)
		{
			if (!line.isEmpty() && line.charAt(0) != '#')
			{
				System.out.println(Element.parse(line));
			}
		}
		System.out.println("");
	}
	
	public static int calcColor(Element[] elements, int var)
	{
		int len = elements.length;
		int r = 0;
		int g = 0;
		int b = 0;
		
		for (Element e : elements)
		{
			int i = e.getColor(var);
			r += (i >> 16) & 255;
			g += (i >> 8) & 255;
			b += (i >> 0) & 255;
		}
		r /= len;
		g /= len;
		b /= len;
		
		return ((r & 255) << 16) | ((g & 255) << 8) | ((b & 255) << 0);
	}
}