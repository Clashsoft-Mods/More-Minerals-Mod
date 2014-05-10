package clashsoft.mods.moreminerals.block;

import java.util.Random;

import clashsoft.mods.moreminerals.MoreMineralsMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockSandOre extends BlockDirtOre
{
	public BlockSandOre(String[] names, String[] iconNames)
	{
		super(names, iconNames);
		this.setCreativeTab(MoreMineralsMod.sandOresTab);
	}
	
	@Override
	public Block getBlock(int metadata)
	{
		return Blocks.sand;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return 3 + random.nextInt(2 + fortune);
	}
	
	@Override
	public int damageDropped(int par1)
	{
		if (this == MoreMineralsMod.sandOres1)
			return par1;
		else if (this == MoreMineralsMod.sandOres2)
			return par1 + 16;
		else if (this == MoreMineralsMod.sandOres3)
			return par1 + 32;
		else if (this == MoreMineralsMod.sandOres4)
			return par1 + 48;
		else if (this == MoreMineralsMod.sandOres5)
			return par1 + 64;
		else if (this == MoreMineralsMod.sandOres6)
			return par1 + 80;
		else if (this == MoreMineralsMod.sandOres7)
			return par1 + 96;
		else if (this == MoreMineralsMod.sandOres8)
			return par1 + 112;
		return 0;
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
	}
	
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock)
	{
		this.onBlockAdded(world, x, y, z);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		if (!world.isRemote)
		{
			this.tryToFall(world, x, y, z);
		}
	}
	
	protected void tryToFall(World world, int x, int y, int z)
	{
		if (BlockFalling.func_149831_e(world, x, y - 1, z) && y >= 0)
		{
			byte b0 = 32;
			
			if (!BlockFalling.fallInstantly && world.checkChunksExist(x - b0, y - b0, z - b0, x + b0, y + b0, z + b0))
			{
					EntityFallingBlock entity = new EntityFallingBlock(world, x + 0.5F, y + 0.5F, z + 0.5F, this, world.getBlockMetadata(x, y, z));
					world.spawnEntityInWorld(entity);
			}
			else
			{
				world.setBlockToAir(x, y, z);
				
				while (BlockFalling.func_149831_e(world, x, y - 1, z) && y > 0)
				{
					--y;
				}
				
				if (y > 0)
				{
					world.setBlock(x, y, z, this);
				}
			}
		}
	}
	
	@Override
	public int tickRate(World world)
	{
		return 2;
	}
}
