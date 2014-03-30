package clashsoft.mods.moreminerals.world;

import net.minecraft.world.World;

public class SimpleGenCondition implements IGenCondition
{
	private int minY;
	
	public SimpleGenCondition(int minY)
	{
		this.minY = minY;
	}
	
	@Override
	public boolean canGenerate()
	{
		return this.minY != -1;
	}
	
	@Override
	public boolean canGenerateAt(World world, int x, int y, int z)
	{
		return this.minY != -1 && y >= this.minY;
	}
}
