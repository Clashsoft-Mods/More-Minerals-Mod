package clashsoft.mods.moreminerals.block;

import clashsoft.cslib.minecraft.block.CustomBlock;
import clashsoft.mods.moreminerals.MoreMineralsMod;

import net.minecraft.block.Block;

public class OreHelper
{
	public static CustomBlock getOreFromMetadata(int meta, String blockType)
	{
		if ("stone".equalsIgnoreCase(blockType))
		{
			if (meta < 16)
				return MoreMineralsMod.stoneOres1;
			if (meta < 32)
				return MoreMineralsMod.stoneOres2;
			if (meta < 48)
				return MoreMineralsMod.stoneOres3;
			if (meta < 64)
				return MoreMineralsMod.stoneOres4;
			if (meta < 80)
				return MoreMineralsMod.stoneOres5;
			if (meta < 96)
				return MoreMineralsMod.stoneOres6;
			if (meta < 112)
				return MoreMineralsMod.stoneOres7;
			if (meta < 128)
				return MoreMineralsMod.stoneOres8;
		}
		if ("nether".equalsIgnoreCase(blockType))
		{
			if (meta < 16)
				return MoreMineralsMod.netherOres1;
			if (meta < 32)
				return MoreMineralsMod.netherOres2;
			if (meta < 48)
				return MoreMineralsMod.netherOres3;
			if (meta < 64)
				return MoreMineralsMod.netherOres4;
			if (meta < 80)
				return MoreMineralsMod.netherOres5;
			if (meta < 96)
				return MoreMineralsMod.netherOres6;
			if (meta < 112)
				return MoreMineralsMod.netherOres7;
			if (meta < 128)
				return MoreMineralsMod.netherOres8;
		}
		if ("end".equalsIgnoreCase(blockType))
		{
			if (meta < 16)
				return MoreMineralsMod.endOres1;
			if (meta < 32)
				return MoreMineralsMod.endOres2;
			if (meta < 48)
				return MoreMineralsMod.endOres3;
			if (meta < 64)
				return MoreMineralsMod.endOres4;
			if (meta < 80)
				return MoreMineralsMod.endOres5;
			if (meta < 96)
				return MoreMineralsMod.endOres6;
			if (meta < 112)
				return MoreMineralsMod.endOres7;
			if (meta < 128)
				return MoreMineralsMod.endOres8;
		}
		if ("dirt".equalsIgnoreCase(blockType))
		{
			if (meta < 16)
				return MoreMineralsMod.dirtOres1;
			if (meta < 32)
				return MoreMineralsMod.dirtOres2;
			if (meta < 48)
				return MoreMineralsMod.dirtOres3;
			if (meta < 64)
				return MoreMineralsMod.dirtOres4;
			if (meta < 80)
				return MoreMineralsMod.dirtOres5;
			if (meta < 96)
				return MoreMineralsMod.dirtOres6;
			if (meta < 112)
				return MoreMineralsMod.dirtOres7;
			if (meta < 128)
				return MoreMineralsMod.dirtOres8;
		}
		if ("sand".equalsIgnoreCase(blockType))
		{
			if (meta < 16)
				return MoreMineralsMod.sandOres1;
			if (meta < 32)
				return MoreMineralsMod.sandOres2;
			if (meta < 48)
				return MoreMineralsMod.sandOres3;
			if (meta < 64)
				return MoreMineralsMod.sandOres4;
			if (meta < 80)
				return MoreMineralsMod.sandOres5;
			if (meta < 96)
				return MoreMineralsMod.sandOres6;
			if (meta < 112)
				return MoreMineralsMod.sandOres7;
			if (meta < 128)
				return MoreMineralsMod.sandOres8;
		}
		if ("storage".equalsIgnoreCase(blockType))
		{
			if (meta < 16)
				return MoreMineralsMod.storageBlocks1;
			if (meta < 32)
				return MoreMineralsMod.storageBlocks2;
			if (meta < 48)
				return MoreMineralsMod.storageBlocks3;
			if (meta < 64)
				return MoreMineralsMod.storageBlocks4;
			if (meta < 80)
				return MoreMineralsMod.storageBlocks5;
			if (meta < 96)
				return MoreMineralsMod.storageBlocks6;
			if (meta < 112)
				return MoreMineralsMod.storageBlocks7;
			if (meta < 128)
				return MoreMineralsMod.storageBlocks8;
		}
		return null;
	}
	
	
	
	public static boolean isOreType(Block block, String blockType)
	{
		if ("stone".equalsIgnoreCase(blockType))
			return block == MoreMineralsMod.stoneOres1 || block == MoreMineralsMod.stoneOres2 || block == MoreMineralsMod.stoneOres3 || block == MoreMineralsMod.stoneOres4 || block == MoreMineralsMod.stoneOres5 || block == MoreMineralsMod.stoneOres6 || block == MoreMineralsMod.stoneOres7 || block == MoreMineralsMod.stoneOres8;
		else if ("nether".equalsIgnoreCase(blockType))
			return block == MoreMineralsMod.netherOres1 || block == MoreMineralsMod.netherOres2 || block == MoreMineralsMod.netherOres3 || block == MoreMineralsMod.netherOres4 || block == MoreMineralsMod.netherOres5 || block == MoreMineralsMod.netherOres6 || block == MoreMineralsMod.netherOres7 || block == MoreMineralsMod.netherOres8;
		else if ("end".equalsIgnoreCase(blockType))
			return block == MoreMineralsMod.endOres1 || block == MoreMineralsMod.endOres2 || block == MoreMineralsMod.endOres3 || block == MoreMineralsMod.endOres4 || block == MoreMineralsMod.endOres5 || block == MoreMineralsMod.endOres6 || block == MoreMineralsMod.endOres7 || block == MoreMineralsMod.endOres8;
		else if ("dirt".equalsIgnoreCase(blockType))
			return block == MoreMineralsMod.dirtOres1 || block == MoreMineralsMod.dirtOres2 || block == MoreMineralsMod.dirtOres3 || block == MoreMineralsMod.dirtOres4 || block == MoreMineralsMod.dirtOres5 || block == MoreMineralsMod.dirtOres6 || block == MoreMineralsMod.dirtOres7 || block == MoreMineralsMod.dirtOres8;
		else if ("sand".equalsIgnoreCase(blockType))
			return block == MoreMineralsMod.sandOres1 || block == MoreMineralsMod.sandOres2 || block == MoreMineralsMod.sandOres3 || block == MoreMineralsMod.sandOres4 || block == MoreMineralsMod.sandOres5 || block == MoreMineralsMod.sandOres6 || block == MoreMineralsMod.sandOres7 || block == MoreMineralsMod.sandOres8;
		else if ("storage".equalsIgnoreCase(blockType))
			return block == MoreMineralsMod.storageBlocks1 || block == MoreMineralsMod.storageBlocks2 || block == MoreMineralsMod.storageBlocks3 || block == MoreMineralsMod.storageBlocks4 || block == MoreMineralsMod.storageBlocks5 || block == MoreMineralsMod.storageBlocks6 || block == MoreMineralsMod.storageBlocks7 || block == MoreMineralsMod.storageBlocks8;
		return false;
	}
}
