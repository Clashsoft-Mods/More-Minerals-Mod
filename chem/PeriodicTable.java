package clashsoft.mods.moreminerals.chem;

import static clashsoft.mods.moreminerals.chem.ElementClass.*;

public class PeriodicTable
{
	public static final int			ELEMENTS				= 118;
	public static final int			CLASSES					= 10;
	
	public static final int			ACTINOIDS				= 15;
	public static final int			ACTINOIDS_LOW			= 89;
	public static final int			ACTINOIDS_HIGH			= 103;
	
	public static final int			LANTHANOIDS				= 15;
	public static final int			LANTHANOIDS_LOW			= 57;
	public static final int			LANTHANOIDS_HIGH		= 71;
	
	/** The elements. */
	/** The symbols. */
	public static final Element[]	elements				= new Element[] {
			new Element("Hydrogen", "H", "1.00794(7)", NON_METAL, 1, 1),
			new Element("Helium", "He", "4.002602(2)", NOBLE_GAS, 1, 18),
			new Element("Lithium", "Li", "6.941(2)", ALKALI_METAL, 2, 1),
			new Element("Beryllium", "Be", "9.012182(3)", ALKALINE_EARTH_METAL, 2, 2),
			new Element("Boron", "B", "10.811(7)", METALLOID, 2, 13),
			new Element("Carbon", "C", "12.0107(8)", NON_METAL, 2, 14),
			new Element("Nitrogen", "N", "14.0067(2)", NON_METAL, 2, 15),
			new Element("Oxygen", "O", "15.9994(3)", NON_METAL, 2, 16),
			new Element("Fluorine", "F", "18.9984032(5)", HALOGEN, 2, 17),
			new Element("Neon", "Ne", "20.1797(6)", NOBLE_GAS, 2, 18),
			new Element("Sodium", "Na", "22.98976928(2)", ALKALI_METAL, 3, 1),
			new Element("Magnesium", "Mg", "24.3050(6)", ALKALINE_EARTH_METAL, 3, 2),
			new Element("Aluminium", "Al", "26.9815386(8)", POOR_METAL, 3, 13),
			new Element("Silicon", "Si", "28.0855(3)", METALLOID, 3, 14),
			new Element("Phosphorus", "P", "30.973762(2)", NON_METAL, 3, 15),
			new Element("Sulfur", "S", "32.065(5)", NON_METAL, 3, 16),
			new Element("Chlorine", "Cl", "35.453(2)", HALOGEN, 3, 17),
			new Element("Argon", "Ar", "39.948(1)", NOBLE_GAS, 3, 18),
			new Element("Potassium", "K", "39.0983(1)", ALKALI_METAL, 4, 1),
			new Element("Calcium", "Ca", "40.078(4)", ALKALINE_EARTH_METAL, 4, 2),
			new Element("Scandium", "Sc", "44.955912(6)", TRANSITION_METAL, 4, 3),
			new Element("Titanium", "Ti", "47.867(1)", TRANSITION_METAL, 4, 4),
			new Element("Vanadium", "V", "50.9415(1)", TRANSITION_METAL, 4, 5),
			new Element("Chrome", "Cr", "51.9961(6)", TRANSITION_METAL, 4, 6),
			new Element("Manganese", "Mn", "54.938045(5)", TRANSITION_METAL, 4, 7),
			new Element("Iron", "Fe", "55.845(2)", TRANSITION_METAL, 4, 8),
			new Element("Cobalt", "Co", "58.933195(5)", TRANSITION_METAL, 4, 9),
			new Element("Nickel", "Ni", "58.6934(4)", TRANSITION_METAL, 4, 10),
			new Element("Copper", "Cu", "63.546(3)", TRANSITION_METAL, 4, 11),
			new Element("Zinc", "Zn", "65.38(2)", TRANSITION_METAL, 4, 12),
			new Element("Gallium", "Ga", "69.723(1)", POOR_METAL, 4, 13),
			new Element("Germanium", "Ge", "72.64(1)", METALLOID, 4, 14),
			new Element("Arsenic", "As", "74.92160(2)", METALLOID, 4, 15),
			new Element("Selenium", "Se", "78.96(3)", NON_METAL, 4, 16),
			new Element("Bromine", "Br", "79.904(1)", HALOGEN, 4, 17),
			new Element("Krypton", "Kr", "83.798(2)", NOBLE_GAS, 4, 18),
			new Element("Rubidium", "Rb", "85.4678(3)", ALKALI_METAL, 5, 1),
			new Element("Strontium", "Sr", "87.62(1)", ALKALINE_EARTH_METAL, 5, 2),
			new Element("Yttrium", "Y", "88.90585(2)", TRANSITION_METAL, 5, 3),
			new Element("Zirconium", "Zr", "91.224(2)", TRANSITION_METAL, 5, 4),
			new Element("Niobium", "Nb", "92.90638(2)", TRANSITION_METAL, 5, 5),
			new Element("Molybdenum", "Mo", "95.96(2)", TRANSITION_METAL, 5, 6),
			new Element("Technetium", "Tc", "[98.9063]", TRANSITION_METAL, 5, 7),
			new Element("Ruthenium", "Ru", "101.07(2)", TRANSITION_METAL, 5, 8),
			new Element("Rhodium", "Rh", "102.90550(2)", TRANSITION_METAL, 5, 9),
			new Element("Palladium", "Pd", "106.42(1)", TRANSITION_METAL, 5, 10),
			new Element("Silver", "Ag", "107.8682(2)", TRANSITION_METAL, 5, 11),
			new Element("Cadmium", "Cd", "112.411(8)", TRANSITION_METAL, 5, 12),
			new Element("Indium", "In", "114.818(3)", POOR_METAL, 5, 13),
			new Element("Tin", "Sn", "118.710(7)", POOR_METAL, 5, 14),
			new Element("Antimony", "Sb", "121.760(1)", METALLOID, 5, 15),
			new Element("Tellurium", "Te", "127.60(3)", METALLOID, 5, 16),
			new Element("Iodine", "I", "126.90447(3)", HALOGEN, 5, 17),
			new Element("Xenon", "Xe", "131.293(6)", NOBLE_GAS, 5, 18),
			new Element("Caesium", "Cs", "132.9054519(2)", ALKALI_METAL, 6, 1),
			new Element("Barium", "Ba", "137.327(7)", ALKALINE_EARTH_METAL, 6, 2),
			new Element("Lanthanum", "La", "138.90547(7)", LANTHANIDE, 6, 0),
			new Element("Cerium", "Ce", "140.116(1)", LANTHANIDE, 6, 0),
			new Element("Praseodymium", "Pr", "140.90765(2)", LANTHANIDE, 6, 0),
			new Element("Neodymium", "Nd", "144.242(3)", LANTHANIDE, 6, 0),
			new Element("Promethium", "Pm", "[146.9151]", LANTHANIDE, 6, 0),
			new Element("Samarium", "Sm", "150.36(2)", LANTHANIDE, 6, 0),
			new Element("Europium", "Eu", "151.964(1)", LANTHANIDE, 6, 0),
			new Element("Gadolinium", "Gd", "157.25(3)", LANTHANIDE, 6, 0),
			new Element("Terbium", "Tb", "158.92535(2)", LANTHANIDE, 6, 0),
			new Element("Dysprosium", "Dy", "162.500(1)", LANTHANIDE, 6, 0),
			new Element("Holmium", "Ho", "164.93032(2)", LANTHANIDE, 6, 0),
			new Element("Erbium", "Er", "167.259(3)", LANTHANIDE, 6, 0),
			new Element("Thulium", "Tm", "168.93421(2)", LANTHANIDE, 6, 0),
			new Element("Ytterbium", "Yb", "173.054(5)", LANTHANIDE, 6, 0),
			new Element("Lutetium", "Lu", "174.9668(1)", LANTHANIDE, 6, 3),
			new Element("Hafnium", "Hf", "178.49(2)", TRANSITION_METAL, 6, 4),
			new Element("Tantalum", "Ta", "180.9479(1)", TRANSITION_METAL, 6, 5),
			new Element("Tungsten", "W", "183.84(1)", TRANSITION_METAL, 6, 6),
			new Element("Rhenium", "Re", "186.207(1)", TRANSITION_METAL, 6, 7),
			new Element("Osmium", "Os", "190.23(3)", TRANSITION_METAL, 6, 8),
			new Element("Iridium", "Ir", "192.217(3)", TRANSITION_METAL, 6, 9),
			new Element("Platinum", "Pt", "195.084(9)", TRANSITION_METAL, 6, 10),
			new Element("Gold", "Au", "196.966569(4)", TRANSITION_METAL, 6, 11),
			new Element("Mercury", "Hg", "200.59(2)", TRANSITION_METAL, 6, 12),
			new Element("Thallium", "Tl", "204.3833(2)", POOR_METAL, 6, 13),
			new Element("Lead", "Pb", "207.2(1)", POOR_METAL, 6, 14),
			new Element("Bismuth", "Bi", "208.98040(1)", POOR_METAL, 6, 15),
			new Element("Polonium", "Po", "[208.9824]", METALLOID, 6, 16),
			new Element("Astatine", "At", "[209.9871]", HALOGEN, 6, 17),
			new Element("Radon", "Rn", "[222.0176]", NOBLE_GAS, 6, 18),
			new Element("Francium", "Fr", "[223.0197]", ALKALI_METAL, 7, 1),
			new Element("Radium", "Ra", "[226.0254]", ALKALINE_EARTH_METAL, 7, 2),
			new Element("Actinium", "Ac", "[227.0278]", ACTINIDE, 7, 0),
			new Element("Thorium", "Th", "232.03806(2)", ACTINIDE, 7, 0),
			new Element("Protactinium", "Pa", "231.03588(2)", ACTINIDE, 7, 0),
			new Element("Uranium", "U", "238.02891(3)", ACTINIDE, 7, 0),
			new Element("Neptunium", "Np", "[237.0482]", ACTINIDE, 7, 0),
			new Element("Plutonium", "Pu", "[244.0642]", ACTINIDE, 7, 0),
			new Element("Americium", "Am", "[243.0614]", ACTINIDE, 7, 0),
			new Element("Curium", "Cm", "[247.0704]", ACTINIDE, 7, 0),
			new Element("Berkelium", "Bk", "[247.0703]", ACTINIDE, 7, 0),
			new Element("Californium", "Cf", "[251.0796]", ACTINIDE, 7, 0),
			new Element("Einsteinium", "Es", "[252.0829]", ACTINIDE, 7, 0),
			new Element("Fermium", "Fm", "[257.0951]", ACTINIDE, 7, 0),
			new Element("Mendelevium", "Md", "[258.0986]", ACTINIDE, 7, 0),
			new Element("Nobelium", "No", "[259.1009]", ACTINIDE, 7, 0),
			new Element("Lawrencium", "Lr", "[264]", ACTINIDE, 7, 3),
			new Element("Rutherfordium", "Rf", "[265]", TRANSITION_METAL, 7, 4),
			new Element("Dubnium", "Db", "[268]", TRANSITION_METAL, 7, 5),
			new Element("Seaborgium", "Sg", "[272]", TRANSITION_METAL, 7, 6),
			new Element("Bohrium", "Bh", "[273]", TRANSITION_METAL, 7, 7),
			new Element("Hassium", "Hs", "[276]", TRANSITION_METAL, 7, 8),
			new Element("Meitnerium", "Mt", "[279]", TRANSITION_METAL, 7, 9),
			new Element("Darmstadtium", "Ds", "[278]", TRANSITION_METAL, 7, 10),
			new Element("Roentgenium", "Rg", "[283]", TRANSITION_METAL, 7, 11),
			new Element("Ununbium", "Uub", "[285]", TRANSITION_METAL, 7, 12),
			new Element("Ununtrium", "Uut", "[287]", POOR_METAL, 7, 13),
			new Element("Ununquadium", "Uuq", "[289]", POOR_METAL, 7, 14),
			new Element("Ununpentium", "Uup", "[291]", POOR_METAL, 7, 15),
			new Element("Ununhexium", "Uuh", "[293]", POOR_METAL, 7, 16),
			new Element("Ununseptium", "Uus", "[295]", HALOGEN, 7, 17),
			new Element("Ununoctium", "Uuo", "[294]", NOBLE_GAS, 7, 18) };
	
	public static boolean isActinoid(int no)
	{
		if (no <= ACTINOIDS_HIGH && no >= ACTINOIDS_LOW)
			return true;
		return false;
	}
	
	public static boolean isLanthanoid(int no)
	{
		if (no <= LANTHANOIDS_HIGH && no >= LANTHANOIDS_LOW)
			return true;
		return false;
	}
}