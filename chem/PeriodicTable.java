package clashsoft.mods.moreminerals.chem;

import static clashsoft.mods.moreminerals.chem.ElementClass.*;

public class PeriodicTable
{
	public static final int			SIZE			= 256;
	
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
	
	public static final Element		Hydrogen			= new Element(1, "Hydrogen", "H", "1.00794(7)", NON_METAL, 1, 1);
	public static final Element		Helium				= new Element(2, "Helium", "He", "4.002602(2)", NOBLE_GAS, 1, 18);
	public static final Element		Lithium				= new Element(3, "Lithium", "Li", "6.941(2)", ALKALI_METAL, 2, 1);
	public static final Element		Beryllium			= new Element(4, "Beryllium", "Be", "9.012182(3)", ALKALINE_EARTH_METAL, 2, 2);
	public static final Element		Boron				= new Element(5, "Boron", "B", "10.811(7)", METALLOID, 2, 13);
	public static final Element		Carbon				= new Element(6, "Carbon", "C", "12.0107(8)", NON_METAL, 2, 14);
	public static final Element		Nitrogen			= new Element(7, "Nitrogen", "N", "14.0067(2)", NON_METAL, 2, 15);
	public static final Element		Oxygen				= new Element(8, "Oxygen", "O", "15.9994(3)", NON_METAL, 2, 16);
	public static final Element		Fluorine			= new Element(9, "Fluorine", "F", "18.9984032(5)", HALOGEN, 2, 17);
	public static final Element		Neon				= new Element(10, "Neon", "Ne", "20.1797(6)", NOBLE_GAS, 2, 18);
	public static final Element		Sodium				= new Element(11, "Sodium", "Na", "22.98976928(2)", ALKALI_METAL, 3, 1);
	public static final Element		Magnesium			= new Element(12, "Magnesium", "Mg", "24.3050(6)", ALKALINE_EARTH_METAL, 3, 2);
	public static final Element		Aluminium			= new Element(13, "Aluminium", "Al", "26.9815386(8)", POOR_METAL, 3, 13);
	public static final Element		Silicon				= new Element(14, "Silicon", "Si", "28.0855(3)", METALLOID, 3, 14);
	public static final Element		Phosphorus			= new Element(15, "Phosphorus", "P", "30.973762(2)", NON_METAL, 3, 15);
	public static final Element		Sulfur				= new Element(16, "Sulfur", "S", "32.065(5)", NON_METAL, 3, 16);
	public static final Element		Chlorine			= new Element(17, "Chlorine", "Cl", "35.453(2)", HALOGEN, 3, 17);
	public static final Element		Argon				= new Element(18, "Argon", "Ar", "39.948(1)", NOBLE_GAS, 3, 18);
	public static final Element		Potassium			= new Element(19, "Potassium", "K", "39.0983(1)", ALKALI_METAL, 4, 1);
	public static final Element		Calcium				= new Element(20, "Calcium", "Ca", "40.078(4)", ALKALINE_EARTH_METAL, 4, 2);
	public static final Element		Scandium			= new Element(21, "Scandium", "Sc", "44.955912(6)", TRANSITION_METAL, 4, 3);
	public static final Element		Titanium			= new Element(22, "Titanium", "Ti", "47.867(1)", TRANSITION_METAL, 4, 4);
	public static final Element		Vanadium			= new Element(23, "Vanadium", "V", "50.9415(1)", TRANSITION_METAL, 4, 5);
	public static final Element		Chrome				= new Element(24, "Chrome", "Cr", "51.9961(6)", TRANSITION_METAL, 4, 6);
	public static final Element		Manganese			= new Element(25, "Manganese", "Mn", "54.938045(5)", TRANSITION_METAL, 4, 7);
	public static final Element		Iron				= new Element(26, "Iron", "Fe", "55.845(2)", TRANSITION_METAL, 4, 8);
	public static final Element		Cobalt				= new Element(27, "Cobalt", "Co", "58.933195(5)", TRANSITION_METAL, 4, 9);
	public static final Element		Nickel				= new Element(28, "Nickel", "Ni", "58.6934(4)", TRANSITION_METAL, 4, 10);
	public static final Element		Copper				= new Element(29, "Copper", "Cu", "63.546(3)", TRANSITION_METAL, 4, 11);
	public static final Element		Zinc				= new Element(30, "Zinc", "Zn", "65.38(2)", TRANSITION_METAL, 4, 12);
	public static final Element		Gallium				= new Element(31, "Gallium", "Ga", "69.723(1)", POOR_METAL, 4, 13);
	public static final Element		Germanium			= new Element(32, "Germanium", "Ge", "72.64(1)", METALLOID, 4, 14);
	public static final Element		Arsenic				= new Element(33, "Arsenic", "As", "74.92160(2)", METALLOID, 4, 15);
	public static final Element		Selenium			= new Element(34, "Selenium", "Se", "78.96(3)", NON_METAL, 4, 16);
	public static final Element		Bromine				= new Element(35, "Bromine", "Br", "79.904(1)", HALOGEN, 4, 17);
	public static final Element		Krypton				= new Element(36, "Krypton", "Kr", "83.798(2)", NOBLE_GAS, 4, 18);
	public static final Element		Rubidium			= new Element(37, "Rubidium", "Rb", "85.4678(3)", ALKALI_METAL, 5, 1);
	public static final Element		Strontium			= new Element(38, "Strontium", "Sr", "87.62(1)", ALKALINE_EARTH_METAL, 5, 2);
	public static final Element		Yttrium				= new Element(39, "Yttrium", "Y", "88.90585(2)", TRANSITION_METAL, 5, 3);
	public static final Element		Zirconium			= new Element(40, "Zirconium", "Zr", "91.224(2)", TRANSITION_METAL, 5, 4);
	public static final Element		Niobium				= new Element(41, "Niobium", "Nb", "92.90638(2)", TRANSITION_METAL, 5, 5);
	public static final Element		Molybdenum			= new Element(42, "Molybdenum", "Mo", "95.96(2)", TRANSITION_METAL, 5, 6);
	public static final Element		Technetium			= new Element(43, "Technetium", "Tc", "[98.9063]", TRANSITION_METAL, 5, 7);
	public static final Element		Ruthenium			= new Element(44, "Ruthenium", "Ru", "101.07(2)", TRANSITION_METAL, 5, 8);
	public static final Element		Rhodium				= new Element(45, "Rhodium", "Rh", "102.90550(2)", TRANSITION_METAL, 5, 9);
	public static final Element		Palladium			= new Element(46, "Palladium", "Pd", "106.42(1)", TRANSITION_METAL, 5, 10);
	public static final Element		Silver				= new Element(47, "Silver", "Ag", "107.8682(2)", TRANSITION_METAL, 5, 11);
	public static final Element		Cadmium				= new Element(48, "Cadmium", "Cd", "112.411(8)", TRANSITION_METAL, 5, 12);
	public static final Element		Indium				= new Element(49, "Indium", "In", "114.818(3)", POOR_METAL, 5, 13);
	public static final Element		Tin					= new Element(50, "Tin", "Sn", "118.710(7)", POOR_METAL, 5, 14);
	public static final Element		Antimony			= new Element(51, "Antimony", "Sb", "121.760(1)", METALLOID, 5, 15);
	public static final Element		Tellurium			= new Element(52, "Tellurium", "Te", "127.60(3)", METALLOID, 5, 16);
	public static final Element		Iodine				= new Element(53, "Iodine", "I", "126.90447(3)", HALOGEN, 5, 17);
	public static final Element		Xenon				= new Element(54, "Xenon", "Xe", "131.293(6)", NOBLE_GAS, 5, 18);
	public static final Element		Caesium				= new Element(55, "Caesium", "Cs", "132.9054519(2)", ALKALI_METAL, 6, 1);
	public static final Element		Barium				= new Element(56, "Barium", "Ba", "137.327(7)", ALKALINE_EARTH_METAL, 6, 2);
	public static final Element		Lanthanum			= new Element(57, "Lanthanum", "La", "138.90547(7)", LANTHANIDE, 6, 0);
	public static final Element		Cerium				= new Element(58, "Cerium", "Ce", "140.116(1)", LANTHANIDE, 6, 0);
	public static final Element		Praseodymium		= new Element(59, "Praseodymium", "Pr", "140.90765(2)", LANTHANIDE, 6, 0);
	public static final Element		Neodymium			= new Element(60, "Neodymium", "Nd", "144.242(3)", LANTHANIDE, 6, 0);
	public static final Element		Promethium			= new Element(61, "Promethium", "Pm", "[146.9151]", LANTHANIDE, 6, 0);
	public static final Element		Samarium			= new Element(62, "Samarium", "Sm", "150.36(2)", LANTHANIDE, 6, 0);
	public static final Element		Europium			= new Element(63, "Europium", "Eu", "151.964(1)", LANTHANIDE, 6, 0);
	public static final Element		Gadolinium			= new Element(64, "Gadolinium", "Gd", "157.25(3)", LANTHANIDE, 6, 0);
	public static final Element		Terbium				= new Element(65, "Terbium", "Tb", "158.92535(2)", LANTHANIDE, 6, 0);
	public static final Element		Dysprosium			= new Element(66, "Dysprosium", "Dy", "162.500(1)", LANTHANIDE, 6, 0);
	public static final Element		Holmium				= new Element(67, "Holmium", "Ho", "164.93032(2)", LANTHANIDE, 6, 0);
	public static final Element		Erbium				= new Element(68, "Erbium", "Er", "167.259(3)", LANTHANIDE, 6, 0);
	public static final Element		Thulium				= new Element(69, "Thulium", "Tm", "168.93421(2)", LANTHANIDE, 6, 0);
	public static final Element		Ytterbium			= new Element(70, "Ytterbium", "Yb", "173.054(5)", LANTHANIDE, 6, 0);
	public static final Element		Lutetium			= new Element(71, "Lutetium", "Lu", "174.9668(1)", LANTHANIDE, 6, 3);
	public static final Element		Hafnium				= new Element(72, "Hafnium", "Hf", "178.49(2)", TRANSITION_METAL, 6, 4);
	public static final Element		Tantalum			= new Element(73, "Tantalum", "Ta", "180.9479(1)", TRANSITION_METAL, 6, 5);
	public static final Element		Tungsten			= new Element(74, "Tungsten", "W", "183.84(1)", TRANSITION_METAL, 6, 6);
	public static final Element		Rhenium				= new Element(75, "Rhenium", "Re", "186.207(1)", TRANSITION_METAL, 6, 7);
	public static final Element		Osmium				= new Element(76, "Osmium", "Os", "190.23(3)", TRANSITION_METAL, 6, 8);
	public static final Element		Iridium				= new Element(77, "Iridium", "Ir", "192.217(3)", TRANSITION_METAL, 6, 9);
	public static final Element		Platinum			= new Element(78, "Platinum", "Pt", "195.084(9)", TRANSITION_METAL, 6, 10);
	public static final Element		Gold				= new Element(79, "Gold", "Au", "196.966569(4)", TRANSITION_METAL, 6, 11);
	public static final Element		Mercury				= new Element(80, "Mercury", "Hg", "200.59(2)", TRANSITION_METAL, 6, 12);
	public static final Element		Thallium			= new Element(81, "Thallium", "Tl", "204.3833(2)", POOR_METAL, 6, 13);
	public static final Element		Lead				= new Element(82, "Lead", "Pb", "207.2(1)", POOR_METAL, 6, 14);
	public static final Element		Bismuth				= new Element(83, "Bismuth", "Bi", "208.98040(1)", POOR_METAL, 6, 15);
	public static final Element		Polonium			= new Element(84, "Polonium", "Po", "[208.9824]", METALLOID, 6, 16);
	public static final Element		Astatine			= new Element(85, "Astatine", "At", "[209.9871]", HALOGEN, 6, 17);
	public static final Element		Radon				= new Element(86, "Radon", "Rn", "[222.0176]", NOBLE_GAS, 6, 18);
	public static final Element		Francium			= new Element(87, "Francium", "Fr", "[223.0197]", ALKALI_METAL, 7, 1);
	public static final Element		Radium				= new Element(88, "Radium", "Ra", "[226.0254]", ALKALINE_EARTH_METAL, 7, 2);
	public static final Element		Actinium			= new Element(89, "Actinium", "Ac", "[227.0278]", ACTINIDE, 7, 0);
	public static final Element		Thorium				= new Element(90, "Thorium", "Th", "232.03806(2)", ACTINIDE, 7, 0);
	public static final Element		Protactinium		= new Element(91, "Protactinium", "Pa", "231.03588(2)", ACTINIDE, 7, 0);
	public static final Element		Uranium				= new Element(92, "Uranium", "U", "238.02891(3)", ACTINIDE, 7, 0);
	public static final Element		Neptunium			= new Element(93, "Neptunium", "Np", "[237.0482]", ACTINIDE, 7, 0);
	public static final Element		Plutonium			= new Element(94, "Plutonium", "Pu", "[244.0642]", ACTINIDE, 7, 0);
	public static final Element		Americium			= new Element(95, "Americium", "Am", "[243.0614]", ACTINIDE, 7, 0);
	public static final Element		Curium				= new Element(96, "Curium", "Cm", "[247.0704]", ACTINIDE, 7, 0);
	public static final Element		Berkelium			= new Element(97, "Berkelium", "Bk", "[247.0703]", ACTINIDE, 7, 0);
	public static final Element		Californium			= new Element(98, "Californium", "Cf", "[251.0796]", ACTINIDE, 7, 0);
	public static final Element		Einsteinium			= new Element(99, "Einsteinium", "Es", "[252.0829]", ACTINIDE, 7, 0);
	public static final Element		Fermium				= new Element(100, "Fermium", "Fm", "[257.0951]", ACTINIDE, 7, 0);
	public static final Element		Mendelevium			= new Element(101, "Mendelevium", "Md", "[258.0986]", ACTINIDE, 7, 0);
	public static final Element		Nobelium			= new Element(102, "Nobelium", "No", "[259.1009]", ACTINIDE, 7, 0);
	public static final Element		Lawrencium			= new Element(103, "Lawrencium", "Lr", "[264]", ACTINIDE, 7, 3);
	public static final Element		Rutherfordium		= new Element(104, "Rutherfordium", "Rf", "[265]", TRANSITION_METAL, 7, 4);
	public static final Element		Dubnium				= new Element(105, "Dubnium", "Db", "[268]", TRANSITION_METAL, 7, 5);
	public static final Element		Seaborgium			= new Element(106, "Seaborgium", "Sg", "[272]", TRANSITION_METAL, 7, 6);
	public static final Element		Bohrium				= new Element(107, "Bohrium", "Bh", "[273]", TRANSITION_METAL, 7, 7);
	public static final Element		Hassium				= new Element(108, "Hassium", "Hs", "[276]", TRANSITION_METAL, 7, 8);
	public static final Element		Meitnerium			= new Element(109, "Meitnerium", "Mt", "[279]", TRANSITION_METAL, 7, 9);
	public static final Element		Darmstadtium		= new Element(110, "Darmstadtium", "Ds", "[278]", TRANSITION_METAL, 7, 10);
	public static final Element		Roentgenium			= new Element(111, "Roentgenium", "Rg", "[283]", TRANSITION_METAL, 7, 11);
	public static final Element		Ununbium			= new Element(112, "Ununbium", "Uub", "[285]", TRANSITION_METAL, 7, 12);
	public static final Element		Ununtrium			= new Element(113, "Ununtrium", "Uut", "[287]", POOR_METAL, 7, 13);
	public static final Element		Ununquadium			= new Element(114, "Ununquadium", "Uuq", "[289]", POOR_METAL, 7, 14);
	public static final Element		Ununpentium			= new Element(115, "Ununpentium", "Uup", "[291]", POOR_METAL, 7, 15);
	public static final Element		Ununhexium			= new Element(116, "Ununhexium", "Uuh", "[293]", POOR_METAL, 7, 16);
	public static final Element		Ununseptium			= new Element(117, "Ununseptium", "Uus", "[295]", HALOGEN, 7, 17);
	public static final Element		Ununoctium			= new Element(118, "Ununoctium", "Uuo", "[294]", NOBLE_GAS, 7, 18);
	
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
}