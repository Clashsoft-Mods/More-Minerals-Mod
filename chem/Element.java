package clashsoft.mods.moreminerals.chem;

import static clashsoft.mods.moreminerals.chem.ElementClass.SPECIAL;

import java.util.Arrays;

import clashsoft.cslib.util.CSString;
import clashsoft.cslib.util.CSUtil;
import clashsoft.mods.moreminerals.world.GenCondition;
import clashsoft.mods.moreminerals.world.IGenCondition;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class Element
{
	private int				number;
	private String			name;
	private String			symbol;
	
	private IGenCondition	genCondition;
	private ElementClass	elementClass;
	private int				period;
	private int				group;
	private int[]			colors;
	
	public Element(int number, String name, String symbol, int period, int group, ElementClass elementClass)
	{
		PeriodicTable.set(number, this);
		
		this.number = number;
		this.name = name;
		this.symbol = symbol;
		this.elementClass = elementClass;
		this.period = period;
		this.group = group;
	}
	
	public static Element parse(String line)
	{
		if (line.startsWith("#"))
			return null;
		
		int pos = line.indexOf(':');
		if (pos == -1)
			return null;
		
		String name = "";
		String symbol = "";
		int period = -1;
		int group = -1;
		ElementClass elementClass = SPECIAL;
		int[] colors = null;
		IGenCondition gc = null;
		
		String numberS = line.substring(0, pos);
		String argsS = line.substring(pos + 1);
		
		int number = Integer.parseInt(numberS);
		String[] args = argsS.split(";");
		
		for (int i = 0; i < args.length; i++)
		{
			String arg = args[i];
			if (i == 0)
			{
				int oPos = arg.indexOf('(');
				int cPos = arg.indexOf(')');
				if (oPos > 0 && cPos > 0)
				{
					name = arg.substring(0, oPos);
					symbol = arg.substring(oPos + 1, cPos);
				}
				else
				{
					name = arg;
					symbol = CSString.getAcronym(arg);
				}
			}
			else if (i == 1)
			{
				try
				{
					arg = arg.substring(1, arg.length() - 1);
					int cPos = arg.indexOf(',');
					String periodS = arg.substring(0, cPos);
					String groupS = arg.substring(cPos + 1);
					period = Integer.parseInt(periodS);
					group = Integer.parseInt(groupS);
				}
				catch (Exception ignored)
				{
				}
			}
			else if (i == 2)
			{
				elementClass = ElementClass.parse(arg);
			}
			else if (i == 3)
			{
				try
				{
					arg = arg.substring(1, arg.length() - 1);
					String[] colorsS = arg.split(",");
					int len = colorsS.length;
					colors = new int[len];
					for (int j = 0; j < len; j++)
					{
						colors[j] = CSUtil.tryParse(colorsS[j], 16, -1);
					}
				}
				catch (Exception ignored)
				{
				}
			}
			else if (i == 4)
			{
				gc = GenCondition.parse(arg);
			}
		}
		
		Element element;
		if (number >= PeriodicTable.VANILLA_LOW && number < PeriodicTable.VANILLA_HIGH)
		{
			element = new VanillaElement(number, name, symbol);
		}
		else if (number >= PeriodicTable.GEMS_LOW && number < PeriodicTable.GEMS_HIGH)
		{
			element = new GemElement(number, name, symbol);
		}
		else if (number >= PeriodicTable.SPECIAL_LOW)
		{
			element = new SpecialElement(number, name, symbol, elementClass);
		}
		else
		{
			element = new Element(number, name, symbol, period, group, elementClass);
		}
		
		return element.setColors(colors).setGenCondition(gc);
	}
	
	public Element setGenCondition(IGenCondition gc)
	{
		this.genCondition = gc;
		return this;
	}
	
	public Element setColors(int... colors)
	{
		this.colors = colors;
		return this;
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
	
	public boolean canGenerateAt(World world, int x, int y, int z)
	{
		return this.genCondition != null && this.genCondition.canGenerateAt(world, x, y, z);
	}
	
	public int getColor(int var)
	{
		if (this.colors == null)
			return 0xFFFFFF;
		else if (this.colors.length == 1) // All colors
			return this.colors[0];
		else if (this.colors.length == 2) // Ore Color, Item Color // Usually
											// this one
			if (var == 0 || var == 2)
				return this.colors[0];
			else
				return this.colors[1];
		else if (this.colors.length == 3) // Ore Color, Block Color, Item Color
			if (var < 3)
				return this.colors[var];
			else
				return this.colors[2];
		else if (var < this.colors.length) // Ore Color, Block Color, Ingot
											// Color, Nugget Color, Dust
											// Color
			return this.colors[var];
		return 0xFFFFFF;
	}
	
	public boolean isAvailable(Block block)
	{
		return this.genCondition == null || this.genCondition.canGenerate();
	}
	
	public boolean isTextureOverlay(int var)
	{
		return var == 0 || var == 1;
	}
	
	public String getTextureName(int var)
	{
		if (var == 0)
		{
			return "moreminerals:ore_overlay";
		}
		else if (var == 1)
		{
			return "moreminerals:ore_block";
		}
		else if (var == 2)
		{
			return "moreminerals:ingot";
		}
		else if (var == 3)
		{
			return "moreminerals:nugget";
		}
		else if (var == 4)
		{
			return "moreminerals:dust";
		}
		return "";
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Element [number=").append(this.number);
		builder.append(", name=").append(this.name);
		builder.append(", symbol=").append(this.symbol);
		builder.append(", elementClass=").append(this.elementClass);
		builder.append(", period=").append(this.period);
		builder.append(", group=").append(this.group);
		builder.append(", colors=").append(Arrays.toString(this.colors));
		builder.append("]");
		return builder.toString();
	}
	
	public static boolean canCombine(Element e1, Element e2)
	{
		return e1.getElementClass().isMetal() && e2.getElementClass().isMetal();
	}
}
