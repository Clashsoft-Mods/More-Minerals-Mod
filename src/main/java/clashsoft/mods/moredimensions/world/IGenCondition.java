package clashsoft.mods.moreminerals.world;

import net.minecraft.world.World;

public interface IGenCondition
{
	public boolean canGenerate();
	
	public boolean canGenerateAt(World world, int x, int y, int z);
}
