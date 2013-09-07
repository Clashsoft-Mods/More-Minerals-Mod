package clashsoft.mods.moreminerals.block;

import java.util.List;
import java.util.Random;

import clashsoft.clashsoftapi.CustomBlock;
import clashsoft.mods.moreminerals.MoreMineralsMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockVanillaSpecialOre extends CustomBlock
{
	/** Do blocks fall instantly to where they stop or do they fall over time */
	public static boolean	fallInstantly	= false;
	
	public BlockVanillaSpecialOre(int par1, Material par2Material, String[] par3, String[] par4, boolean par5, int par6, CreativeTabs[] par7)
	{
		super(par1, par2Material, par3, par4, par5, par6, par7);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return MoreMineralsMod.vanillaSpecialItems.itemID;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return (meta < 7 ? 2 : 3) + random.nextInt(2);
	}
	
	@Override
	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	public int damageDropped(int par1)
	{
		return par1 < 7 ? par1 + 14 : par1 + 7;
	}
	
	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}
	
	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor blockID
	 */
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			this.tryToFall(par1World, par2, par3, par4);
		}
	}
	
	/**
	 * If there is space to fall below will start this block falling
	 */
	private void tryToFall(World par1World, int par2, int par3, int par4)
	{
		if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0 && par1World.getBlockMetadata(par2, par3, par4) >= 7)
		{
			byte b0 = 32;
			
			if (!fallInstantly && par1World.checkChunksExist(par2 - b0, par3 - b0, par4 - b0, par2 + b0, par3 + b0, par4 + b0))
			{
				if (!par1World.isRemote)
				{
					EntityFallingSand entityfallingsand = new EntityFallingSand(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F, this.blockID, par1World.getBlockMetadata(par2, par3, par4));
					this.onStartFalling(entityfallingsand);
					par1World.spawnEntityInWorld(entityfallingsand);
				}
			}
			else
			{
				par1World.setBlockToAir(par2, par3, par4);
				
				while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0)
				{
					--par3;
				}
				
				if (par3 > 0)
				{
					par1World.setBlock(par2, par3, par4, this.blockID);
				}
			}
		}
	}
	
	/**
	 * Called when the falling block entity for this block is created
	 */
	protected void onStartFalling(EntityFallingSand par1EntityFallingSand)
	{
	}
	
	/**
	 * How many world ticks before ticking
	 */
	@Override
	public int tickRate(World par1World)
	{
		return 2;
	}
	
	/**
	 * Checks to see if the sand can fall into the block below it
	 */
	public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
	{
		int l = par0World.getBlockId(par1, par2, par3);
		
		if (l == 0)
		{
			return true;
		}
		else if (l == Block.fire.blockID)
		{
			return true;
		}
		else
		{
			Material material = Block.blocksList[l].blockMaterial;
			return material == Material.water ? true : material == Material.lava;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems)
	{
		for (int i = 0; i < 14; i++)
		{
			if (i < 7 && tab == MoreMineralsMod.dirtOresTab)
			{
				subItems.add(new ItemStack(this, 1, i));
			}
			else if (i < 14 && i >= 7 && tab == MoreMineralsMod.sandOresTab)
			{
				subItems.add(new ItemStack(this, 1, i));
			}
		}
	}
}
