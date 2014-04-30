package clashsoft.mods.moreminerals.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.mods.moreminerals.MoreMineralsMod;

public class BlockNetherOre extends CustomBlock implements IBlockOre
{
	public BlockNetherOre(String[] names, String[] iconNames)
	{
		super(Material.rock, names, iconNames, null);
		this.setCreativeTab(MoreMineralsMod.netherOresTab);
	}
	
	@Override
	public Block getBlock(int metadata)
	{
		return Blocks.netherrack;
	}
}
