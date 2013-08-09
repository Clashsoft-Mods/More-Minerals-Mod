package clashsoft.mods.moreminerals;

import java.util.Random;

import clashsoft.clashsoftapi.util.CSRandom;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MoreMineralsOreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (world.provider.isSurfaceWorld())
			generateSurface(world, chunkX, chunkZ, random);
		else if (world.provider instanceof WorldProviderEnd)
			generateEnd(world, chunkX, chunkZ, random);
		else if (world.provider.isHellWorld)
			generateNether(world, chunkX, chunkZ, random);
	}

	public void generateSurface(World world, int chunkX, int chunkZ, Random random)
	{
		//More Minerals Stone, Dirt and Sand Ores
		for (int i = 0; i < MoreMineralsMod.overworldGen.length; i++)
		{
			int stoneID = MoreMineralsHelper.getOreFromMetadata(i, "stone").blockID;
			int dirtID = MoreMineralsHelper.getOreFromMetadata(i, "dirt").blockID;
			int sandID = MoreMineralsHelper.getOreFromMetadata(i, "sand").blockID;
			int meta = i % 16;
			
			int maxHeightStone = MoreMineralsMod.overworldGen[i]; //height
			if (maxHeightStone > 0 && !MoreMineralsMod.allnames[i].contains("%&"))
			{
				int amountPerChunk = (int)(MoreMineralsMod.overworldGen[i] / 2);
				int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.overworldGen[i]) * 1.5D);
				for(int j = 0; j < amountPerChunk; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeightStone);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(stoneID, meta, amountPerVeign, Block.stone.blockID)).generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
			int maxHeightDirt = MoreMineralsMod.dirtGen[i];
			if (maxHeightDirt >= 42 && !MoreMineralsMod.allnames[i].contains("%&"))
			{
				int amountPerChunk = (int)(MoreMineralsMod.dirtGen[i] / 2);
				int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.dirtGen[i]) * 1.5D);
				for (int j = 0; j < amountPerChunk / 4; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeightDirt);
					int randPosY2 = CSRandom.nextInt(random, 48, 80); //Sand wont generate lower than that.
					int randPosY3 = CSRandom.nextInt(random, 5, 128);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(dirtID, meta, amountPerVeign / 2, Block.dirt.blockID)).generate(world, random, randPosX, randPosY3, randPosZ);
				}
			}
			int maxHeightSand = MoreMineralsMod.sandGen[i];
			if (maxHeightSand >= 36 && !MoreMineralsMod.allnames[i].contains("%&"))
			{
				int amountPerChunk = (int)(MoreMineralsMod.sandGen[i] / 2);
				int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.sandGen[i]) * 1.5D);
				for (int j = 0; j < amountPerChunk / 4; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeightSand);
					int randPosY2 = CSRandom.nextInt(random, 48, 80); //Sand wont generate lower than that.
					int randPosY3 = CSRandom.nextInt(random, 5, 128);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(sandID, meta, amountPerVeign / 3, Block.sand.blockID)).generate(world, random, randPosX, randPosY2, randPosZ);
				}
			}
		}

		//Vanilla Dirt + Sand Ores
		for (int i = 0; i < MoreMineralsMod.vanillaGen.length; i++)
		{
			int maxHeight = MoreMineralsMod.vanillaGen[i]; //height
			int amountPerChunk = (int)(MoreMineralsMod.vanillaGen[i] / 2);
			int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.vanillaGen[i]) * 1.5D);
			int blockID = MoreMineralsMod.vanillaSpecialOres2.blockID;
			int meta = i;

			for(int j = 0; j < amountPerChunk / 4; j++)
			{
				int randPosX = chunkX * 16 + random.nextInt(16);
				int randPosY = random.nextInt(maxHeight);
				int randPosY2 = CSRandom.nextInt(random, 48, 80); //Sand wont generate lower than that.
				int randPosZ = chunkZ * 16 + random.nextInt(16);
				if (maxHeight >= 32) //Only common ores generate as dirt and sand ores.
					(new WorldGenMinable(blockID, meta + 7, amountPerVeign / 3, Block.sand.blockID)).generate(world, random, randPosX, randPosY2, randPosZ);

				if (maxHeight >= 36)
					(new WorldGenMinable(blockID, meta, amountPerVeign / 2, Block.dirt.blockID)).generate(world, random, randPosX, randPosY, randPosZ);
			}
		}
	}

	public void generateNether(World world, int chunkX, int chunkZ, Random random)
	{
		for (int i = 0; i < MoreMineralsMod.netherGen.length; i++)
		{
			if (MoreMineralsMod.netherGen[i] > 0 && !MoreMineralsMod.allnames[i].contains("%&"))
			{
			int maxHeight = MoreMineralsMod.netherGen[i] / 2 + 4; //height
			int amountPerChunk = (int)(MoreMineralsMod.netherGen[i] / 3);
			int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.netherGen[i]) * 1.75D);
			int netheroreID = MoreMineralsHelper.getOreFromMetadata(i, "nether").blockID;
			int meta = i % 16;

			for(int j = 0; j < amountPerChunk; j++)
			{
				int randPosX = chunkX * 16 + random.nextInt(16);
				int randPosY = random.nextInt(maxHeight > 128 ? 128 : maxHeight);
				int randPosZ = chunkZ * 16 + random.nextInt(16);
				(new WorldGenMinable(netheroreID, meta, amountPerVeign, Block.netherrack.blockID)).generate(world, random, randPosX, randPosY, randPosZ);	
			}
			}
		}

		//Vanilla Nether Ores
		for (int i = 0; i < MoreMineralsMod.vanillaGen.length; i++)
		{
			int maxHeight = MoreMineralsMod.vanillaGen[i] / 2 + 4; //height
			int amountPerChunk = (int)(MoreMineralsMod.vanillaGen[i] / 3);
			int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.vanillaGen[i]) * 1.8D);
			int blockID = MoreMineralsMod.vanillaSpecialOres1.blockID;
			int meta = i;

			for(int j = 0; j < amountPerChunk; j++)
			{
				int randPosX = chunkX * 16 + random.nextInt(16);
				int randPosY = random.nextInt(maxHeight > 128 ? 128 : maxHeight);
				int randPosZ = chunkZ * 16 + random.nextInt(16);
				(new WorldGenMinable(blockID, meta, amountPerVeign, Block.netherrack.blockID)).generate(world, random, randPosX, randPosY, randPosZ);	
			}
		}
	}

	public void generateEnd(World world, int chunkX, int chunkZ, Random random)
	{
		//More Minerals End Ores
		for (int i = 0; i < MoreMineralsMod.endGen.length; i++)
		{
			if (MoreMineralsMod.endGen[i] > 0 && !MoreMineralsMod.allnames[i].contains("%&") && MoreMineralsMod.endGen[i] <= 32)
			{
				int maxHeight = MoreMineralsMod.endGen[i] * 2 + 5; //height
				int amountPerChunk = (int)(MoreMineralsMod.endGen[i] / 2);
				int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.endGen[i]) * 0.8D);
				int endoreID = MoreMineralsHelper.getOreFromMetadata(i, "end").blockID;
				int meta = i < 16 ? i : i - 16;

				for(int j = 0; j < amountPerChunk; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeight > 128 ? 128 : maxHeight);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(endoreID, meta, amountPerVeign, Block.whiteStone.blockID)).generate(world, random, randPosX, randPosY, randPosZ);	
				}
			}
		}

		//Vanilla End Ores
		for (int i = 0; i < MoreMineralsMod.vanillaGen.length; i++)
		{
			if (MoreMineralsMod.vanillaGen[i] <= 32)
			{
				int maxHeight = MoreMineralsMod.vanillaGen[i] * 2 + 20; //height
				int amountPerChunk = (int)(MoreMineralsMod.vanillaGen[i] / 2);
				int amountPerVeign = (int)(MathHelper.sqrt_double(MoreMineralsMod.vanillaGen[i]));
				int blockID = MoreMineralsMod.vanillaSpecialOres1.blockID;
				int meta = i + 7;

				for(int j = 0; j < amountPerChunk; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeight > 128 ? 128 : maxHeight);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(blockID, meta, amountPerVeign, Block.whiteStone.blockID)).generate(world, random, randPosX, randPosY, randPosZ);	
				}
			}
		}
	}
}
