package clashsoft.mods.moreminerals.world.gen;

import java.util.Random;

import clashsoft.cslib.util.CSRandom;
import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.block.OreHelper;
import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class MMMOreGenerator implements IWorldGenerator
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
		// More Minerals Stone, Dirt and Sand Ores
		for (int i = 0; i < MoreMineralsMod.overworldGen.length; i++)
		{
			Block stone = OreHelper.getOreFromMetadata(i, "stone");
			Block dirt = OreHelper.getOreFromMetadata(i, "dirt");
			Block sand = OreHelper.getOreFromMetadata(i, "sand");
			int meta = i % 16;
			
			int stoneBase = MoreMineralsMod.overworldGen[i]; // height
			if (stoneBase > 0)
			{
				int amountPerChunk = stoneBase / 2;
				int amountPerVeign = (int) (MathHelper.sqrt_double(stoneBase) * 1.5D);
				WorldGenMinable worldGen = (new WorldGenMinable(stone, meta, amountPerVeign, Blocks.stone));
				
				for (int j = 0; j < amountPerChunk; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(stoneBase);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					worldGen.generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
			
			int dirtBase = MoreMineralsMod.dirtGen[i];
			if (dirtBase >= 42)
			{
				int amountPerChunk = dirtBase / 2;
				int amountPerVeign = (int) (MathHelper.sqrt_double(dirtBase) * 1.5D);
				WorldGenMinable worldGen = (new WorldGenMinable(dirt, meta, amountPerVeign / 2, Blocks.dirt));
				
				for (int j = 0; j < amountPerChunk; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(dirtBase);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					worldGen.generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
			
			int sandBase = MoreMineralsMod.sandGen[i];
			if (sandBase >= 36)
			{
				int amountPerChunk = sandBase / 2;
				int amountPerVeign = (int) (MathHelper.sqrt_double(sandBase) * 1.5D);
				WorldGenMinable worldGen = (new WorldGenMinable(sand, meta, amountPerVeign / 3, Blocks.sand));
				
				for (int j = 0; j < amountPerChunk; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(sandBase);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					worldGen.generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
		}
		
		// Vanilla Dirt + Sand Ores
		for (int i = 0; i < MoreMineralsMod.vanillaGen.length; i++)
		{
			int base = MoreMineralsMod.vanillaGen[i];
			if (base > 0)
			{
				int maxHeight = base; // height
				int amountPerChunk = base / 2;
				int amountPerVeign = (int) (MathHelper.sqrt_double(base) * 1.5D);
				int meta = i;
				
				WorldGenMinable worldGen;
				if (maxHeight >= 48)
					worldGen = (new WorldGenMinable(MoreMineralsMod.vanillaDirtSandOres, meta + 7, amountPerVeign / 3, Blocks.sand));
				else
					worldGen = (new WorldGenMinable(MoreMineralsMod.vanillaDirtSandOres, meta, amountPerVeign / 2, Blocks.dirt));
				
				for (int j = 0; j < amountPerChunk / 4; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = CSRandom.nextInt(random, 48, 80);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					worldGen.generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
		}
	}
	
	public void generateNether(World world, int chunkX, int chunkZ, Random random)
	{
		for (int i = 0; i < MoreMineralsMod.netherGen.length; i++)
		{
			int base = MoreMineralsMod.netherGen[i];
			if (base > 0)
			{
				int maxHeight = base / 2 + 4; // height
				int amountPerChunk = base / 3;
				int amountPerVeign = (int) (MathHelper.sqrt_double(base) * 1.75D);
				Block block = OreHelper.getOreFromMetadata(i, "nether");
				int meta = i % 16;
				
				for (int k = 0; k < amountPerChunk; k++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeight);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(block, meta, amountPerVeign, Blocks.netherrack)).generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
		}
		
		// Vanilla Nether Ores
		for (int i = 0; i < MoreMineralsMod.vanillaGen.length; i++)
		{
			int base = MoreMineralsMod.vanillaGen[i];
			if (base > 0)
			{
				int maxHeight = base / 2 + 4; // height
				int amountPerChunk = base / 3;
				int amountPerVeign = (int) (MathHelper.sqrt_double(base) * 1.8D);
				int meta = i;
				
				for (int k = 0; k < amountPerChunk; k++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeight > 128 ? 128 : maxHeight);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(MoreMineralsMod.vanillaNetherEndOres, meta, amountPerVeign, Blocks.netherrack)).generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
		}
	}
	
	public void generateEnd(World world, int chunkX, int chunkZ, Random random)
	{
		// More Minerals End Ores
		for (int i = 0; i < MoreMineralsMod.endGen.length; i++)
		{
			int base = MoreMineralsMod.endGen[i];
			if (base > 0 && base <= 32)
			{
				int maxHeight = base * 2 + 5; // height
				int amountPerChunk = base / 2;
				int amountPerVeign = (int) (MathHelper.sqrt_double(base) * 0.8D);
				Block block = OreHelper.getOreFromMetadata(i, "end");
				int meta = i < 16 ? i : i - 16;
				
				for (int k = 0; k < amountPerChunk; k++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeight > 128 ? 128 : maxHeight);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(block, meta, amountPerVeign, Blocks.end_stone)).generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
		}
		
		// Vanilla End Ores
		for (int i = 0; i < MoreMineralsMod.vanillaGen.length; i++)
		{
			int base = MoreMineralsMod.vanillaGen[i];
			if (base > 0 && base <= 32)
			{
				int maxHeight = base * 2 + 20; // height
				int amountPerChunk = base / 2;
				int amountPerVeign = (int) (MathHelper.sqrt_double(base));
				int meta = i + 7;
				
				for (int j = 0; j < amountPerChunk; j++)
				{
					int randPosX = chunkX * 16 + random.nextInt(16);
					int randPosY = random.nextInt(maxHeight > 128 ? 128 : maxHeight);
					int randPosZ = chunkZ * 16 + random.nextInt(16);
					(new WorldGenMinable(MoreMineralsMod.vanillaNetherEndOres, meta, amountPerVeign, Blocks.end_stone)).generate(world, random, randPosX, randPosY, randPosZ);
				}
			}
		}
	}
}
