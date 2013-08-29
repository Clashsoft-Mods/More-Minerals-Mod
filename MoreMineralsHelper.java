package clashsoft.mods.moreminerals;

import clashsoft.clashsoftapi.CustomBlock;

public class MoreMineralsHelper
{
	public static CustomBlock getOreFromMetadata(int meta, String blockType)
	{
		if (blockType == "stone")
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
		if (blockType == "nether")
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
		if (blockType == "end")
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
		if (blockType == "dirt")
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
		if (blockType == "sand")
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
		if (blockType == "storage")
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
	
	/**
	 * Refers to the actual id integer field, not just getOreFromMetadata(meta,
	 * blockType).blockID
	 * 
	 * @param meta
	 * @param blockType
	 * @return
	 */
	public static int getIDFromMetadata(int meta, String blockType)
	{
		if (blockType == "stone")
		{
			if (meta < 16)
				return MoreMineralsMod.stoneOres_ID1;
			if (meta < 32)
				return MoreMineralsMod.stoneOres_ID2;
			if (meta < 48)
				return MoreMineralsMod.stoneOres_ID3;
			if (meta < 64)
				return MoreMineralsMod.stoneOres_ID4;
			if (meta < 80)
				return MoreMineralsMod.stoneOres_ID5;
			if (meta < 96)
				return MoreMineralsMod.stoneOres_ID6;
			if (meta < 112)
				return MoreMineralsMod.stoneOres_ID7;
			if (meta < 128)
				return MoreMineralsMod.stoneOres_ID8;
		}
		if (blockType == "nether")
		{
			if (meta < 16)
				return MoreMineralsMod.netherOres_ID1;
			if (meta < 32)
				return MoreMineralsMod.netherOres_ID2;
			if (meta < 48)
				return MoreMineralsMod.netherOres_ID3;
			if (meta < 64)
				return MoreMineralsMod.netherOres_ID4;
			if (meta < 80)
				return MoreMineralsMod.netherOres_ID5;
			if (meta < 96)
				return MoreMineralsMod.netherOres_ID6;
			if (meta < 112)
				return MoreMineralsMod.netherOres_ID7;
			if (meta < 128)
				return MoreMineralsMod.netherOres_ID8;
		}
		if (blockType == "end")
		{
			if (meta < 16)
				return MoreMineralsMod.endOres_ID1;
			if (meta < 32)
				return MoreMineralsMod.endOres_ID2;
			if (meta < 48)
				return MoreMineralsMod.endOres_ID3;
			if (meta < 64)
				return MoreMineralsMod.endOres_ID4;
			if (meta < 80)
				return MoreMineralsMod.endOres_ID5;
			if (meta < 96)
				return MoreMineralsMod.endOres_ID6;
			if (meta < 112)
				return MoreMineralsMod.endOres_ID7;
			if (meta < 128)
				return MoreMineralsMod.endOres_ID8;
		}
		if (blockType == "dirt")
		{
			if (meta < 16)
				return MoreMineralsMod.dirtOres_ID1;
			if (meta < 32)
				return MoreMineralsMod.dirtOres_ID2;
			if (meta < 48)
				return MoreMineralsMod.dirtOres_ID3;
			if (meta < 64)
				return MoreMineralsMod.dirtOres_ID4;
			if (meta < 80)
				return MoreMineralsMod.dirtOres_ID5;
			if (meta < 96)
				return MoreMineralsMod.dirtOres_ID6;
			if (meta < 112)
				return MoreMineralsMod.dirtOres_ID7;
			if (meta < 128)
				return MoreMineralsMod.dirtOres_ID8;
		}
		if (blockType == "sand")
		{
			if (meta < 16)
				return MoreMineralsMod.sandOres_ID1;
			if (meta < 32)
				return MoreMineralsMod.sandOres_ID2;
			if (meta < 48)
				return MoreMineralsMod.sandOres_ID3;
			if (meta < 64)
				return MoreMineralsMod.sandOres_ID4;
			if (meta < 80)
				return MoreMineralsMod.sandOres_ID5;
			if (meta < 96)
				return MoreMineralsMod.sandOres_ID6;
			if (meta < 112)
				return MoreMineralsMod.sandOres_ID7;
			if (meta < 128)
				return MoreMineralsMod.sandOres_ID8;
		}
		if (blockType == "storage")
		{
			if (meta < 16)
				return MoreMineralsMod.storageBlocks_ID1;
			if (meta < 32)
				return MoreMineralsMod.storageBlocks_ID2;
			if (meta < 48)
				return MoreMineralsMod.storageBlocks_ID3;
			if (meta < 64)
				return MoreMineralsMod.storageBlocks_ID4;
			if (meta < 80)
				return MoreMineralsMod.storageBlocks_ID5;
			if (meta < 96)
				return MoreMineralsMod.storageBlocks_ID6;
			if (meta < 112)
				return MoreMineralsMod.storageBlocks_ID7;
			if (meta < 128)
				return MoreMineralsMod.storageBlocks_ID8;
		}
		return 0;
	}
	
	public static boolean isOreType(int blockID, String blockType)
	{
		if (blockType == "stone")
			return blockID == MoreMineralsMod.stoneOres_ID1 || blockID == MoreMineralsMod.stoneOres_ID2 || blockID == MoreMineralsMod.stoneOres_ID3 || blockID == MoreMineralsMod.stoneOres_ID4 || blockID == MoreMineralsMod.stoneOres_ID5 || blockID == MoreMineralsMod.stoneOres_ID6 || blockID == MoreMineralsMod.stoneOres_ID7 || blockID == MoreMineralsMod.stoneOres_ID8;
		if (blockType == "nether")
			return blockID == MoreMineralsMod.netherOres_ID1 || blockID == MoreMineralsMod.netherOres_ID2 || blockID == MoreMineralsMod.netherOres_ID3 || blockID == MoreMineralsMod.netherOres_ID4 || blockID == MoreMineralsMod.netherOres_ID5 || blockID == MoreMineralsMod.netherOres_ID6 || blockID == MoreMineralsMod.netherOres_ID7 || blockID == MoreMineralsMod.netherOres_ID8;
		if (blockType == "end")
			return blockID == MoreMineralsMod.endOres_ID1 || blockID == MoreMineralsMod.endOres_ID2 || blockID == MoreMineralsMod.endOres_ID3 || blockID == MoreMineralsMod.endOres_ID4 || blockID == MoreMineralsMod.endOres_ID5 || blockID == MoreMineralsMod.endOres_ID6 || blockID == MoreMineralsMod.endOres_ID7 || blockID == MoreMineralsMod.endOres_ID8;
		if (blockType == "dirt")
			return blockID == MoreMineralsMod.dirtOres_ID1 || blockID == MoreMineralsMod.dirtOres_ID2 || blockID == MoreMineralsMod.dirtOres_ID3 || blockID == MoreMineralsMod.dirtOres_ID4 || blockID == MoreMineralsMod.dirtOres_ID5 || blockID == MoreMineralsMod.dirtOres_ID6 || blockID == MoreMineralsMod.dirtOres_ID7 || blockID == MoreMineralsMod.dirtOres_ID8;
		if (blockType == "sand")
			return blockID == MoreMineralsMod.sandOres_ID1 || blockID == MoreMineralsMod.sandOres_ID2 || blockID == MoreMineralsMod.sandOres_ID3 || blockID == MoreMineralsMod.sandOres_ID4 || blockID == MoreMineralsMod.sandOres_ID5 || blockID == MoreMineralsMod.sandOres_ID6 || blockID == MoreMineralsMod.sandOres_ID7 || blockID == MoreMineralsMod.sandOres_ID8;
		if (blockType == "storage")
			return blockID == MoreMineralsMod.storageBlocks_ID1 || blockID == MoreMineralsMod.storageBlocks_ID2 || blockID == MoreMineralsMod.storageBlocks_ID3 || blockID == MoreMineralsMod.storageBlocks_ID4 || blockID == MoreMineralsMod.storageBlocks_ID5 || blockID == MoreMineralsMod.storageBlocks_ID6 || blockID == MoreMineralsMod.storageBlocks_ID7 || blockID == MoreMineralsMod.storageBlocks_ID8;
		return false;
	}
}
