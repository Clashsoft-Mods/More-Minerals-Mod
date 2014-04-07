package clashsoft.mods.moreminerals.world;

import java.util.HashSet;
import java.util.Set;

import clashsoft.cslib.util.CSUtil;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class GenCondition implements IGenCondition
{
	public static final IGenCondition	NEVER	= new IGenCondition()
												{
													@Override
													public boolean canGenerateAt(World world, int x, int y, int z)
													{
														return false;
													}
													
													@Override
													public boolean canGenerate()
													{
														return false;
													}
												};
	
	private int							yMin	= -1;
	private int							yMax	= -1;
	private Set<BiomeGenBase>			includedBiomes;
	private Set<BiomeGenBase>			excludedBiomes;
	
	public static IGenCondition parse(String string)
	{
		if (string.charAt(0) == '{')
		{
			if (string.equals("{}"))
			{
				return NEVER;
			}
			
			GenCondition gc = new GenCondition();
			String[] args = string.substring(1, string.length() - 1).split("&");
			
			for (String arg : args)
			{
				if (arg.startsWith("h<"))
				{
					gc.yMax = CSUtil.tryParse(arg.substring(2), -1);
				}
				else if (arg.startsWith("h>"))
				{
					gc.yMin = CSUtil.tryParse(arg.substring(2), -1);
				}
				else if (arg.startsWith("b="))
				{
					gc.addRequiredBiome(parseBiome(arg.substring(2)));
				}
				else if (arg.startsWith("b!="))
				{
					gc.addExcludedBiome(parseBiome(arg.substring(3)));
				}
			}
		}
		
		try
		{
			int i = Integer.parseInt(string);
			return new SimpleGenCondition(i);
		}
		catch (NumberFormatException ex)
		{
			return NEVER;
		}
	}
	
	public static BiomeGenBase parseBiome(String name)
	{
		for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray())
		{
			if (name.equalsIgnoreCase(biome.biomeName))
			{
				return biome;
			}
		}
		return null;
	}
	
	public GenCondition()
	{
	}
	
	public void addRequiredBiome(BiomeGenBase biome)
	{
		if (biome != null)
		{
			if (this.includedBiomes == null)
				this.includedBiomes = new HashSet();
			this.includedBiomes.add(biome);
		}
	}
	
	public void addExcludedBiome(BiomeGenBase biome)
	{
		if (biome != null)
		{
			if (this.excludedBiomes == null)
				this.excludedBiomes = new HashSet();
			this.excludedBiomes.add(biome);
		}
	}
	
	@Override
	public boolean canGenerate()
	{
		return this.yMax != -1;
	}
	
	@Override
	public boolean canGenerateAt(World world, int x, int y, int z)
	{
		if (this.yMax == -1)
			return false;
		if (y > this.yMax)
			return false;
		if (this.yMin != -1 && y < this.yMin)
			return false;
		
		BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
		
		if (this.excludedBiomes != null && this.excludedBiomes.contains(biome))
			return false;
		if (this.includedBiomes != null && !this.includedBiomes.contains(biome))
			return false;
		return true;
	}
}
