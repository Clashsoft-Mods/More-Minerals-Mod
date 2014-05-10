package clashsoft.mods.moreminerals.block;

import java.util.ArrayList;
import java.util.Random;

import clashsoft.mods.moreminerals.MoreMineralsMod;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockVanillaSpecialOre extends BlockSandOre
{
	public BlockVanillaSpecialOre(String[] names, String[] iconNames)
	{
		super(names, iconNames);
		this.setCreativeTabs(tabs);
	}
	
	@Override
	public Block getBlock(int metadata)
	{
		return metadata < 8 ? Blocks.dirt : Blocks.sand;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		int count = this.quantityDropped(metadata, fortune, new Random());
		ItemStack stack = MoreMineralsMod.vanillaDusts[metadata & 7];
		ArrayList<ItemStack> list = new ArrayList(count);
		
		for (int i = 0; i < count; i++)
		{
			list.add(stack.copy());
		}
		
		return list;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return (meta < 8 ? 2 : 3) + random.nextInt(2);
	}
	
	@Override
	protected void tryToFall(World world, int x, int y, int z)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata < 8)
			return;
		super.tryToFall(world, x, y, z);
	}
}
