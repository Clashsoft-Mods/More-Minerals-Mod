package clashsoft.mods.moreminerals.block;

import java.util.Random;

import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.mods.moreminerals.MoreMineralsMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockDirtOre extends CustomBlock implements IBlockOre
{
	public BlockDirtOre(String[] names, String[] iconNames)
	{
		super(Material.ground, names, iconNames, null);
		this.setStepSound(soundTypeGravel);
		this.setCreativeTab(MoreMineralsMod.dirtOresTab);
	}
	
	@Override
	public Block getBlock(int metadata)
	{
		return Blocks.dirt;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return 2 + random.nextInt(2 + fortune);
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return MoreMineralsMod.nuggets;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		if (this == MoreMineralsMod.dirtOres2)
			return metadata + 16;
		else if (this == MoreMineralsMod.dirtOres3)
			return metadata + 32;
		else if (this == MoreMineralsMod.dirtOres4)
			return metadata + 48;
		else if (this == MoreMineralsMod.dirtOres5)
			return metadata + 64;
		else if (this == MoreMineralsMod.dirtOres6)
			return metadata + 80;
		else if (this == MoreMineralsMod.dirtOres7)
			return metadata + 96;
		else if (this == MoreMineralsMod.dirtOres8)
			return metadata + 112;
		return metadata;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
}
