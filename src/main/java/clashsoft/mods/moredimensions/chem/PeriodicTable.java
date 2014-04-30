package clashsoft.mods.moreminerals.chem;

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
	public static final int			VANILLA_HIGH		= 144;
	
	public static final int			GEMS_LOW			= 144;
	public static final int			GEMS_HIGH			= 192;
	
	public static final int			SPECIAL_LOW			= 192;
	
	/** The elements. */
	private static final Element[]	elements			= new Element[SIZE];
	
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
	}
	
	public static int calcColor(Element[] elements, int var)
	{
		if (elements == null)
		{
			return 0xFFFFFF;
		}
		
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