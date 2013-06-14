package clashsoft.mods.moreminerals;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import clashsoft.clashsoftapi.CustomBlock;

public class BlockDirtOre extends CustomBlock
{
	public BlockDirtOre(int par1, Material par2Material, String[] par3, String[] par4, boolean par5, int par6, CreativeTabs[] par7)
	{
		super(par1, par2Material, par3, par4, par5, par6, par7);
	}
	
    @Override
	public int quantityDropped(int meta, int fortune, Random random)
    {
    	return 2 + random.nextInt(2);
    }

    @Override
	public int idDropped(int par1, Random par2Random, int par3)
    {
    	return MoreMineralsMod.nuggets.itemID;
    }
    
    @Override
    public int damageDropped(int par1)
    {
    	if (this.blockID == MoreMineralsMod.dirtOres_ID)
    		return par1;
    	else if (this.blockID == MoreMineralsMod.dirtOres_ID2)
    		return par1 + 16;
    	else if (this.blockID == MoreMineralsMod.dirtOres_ID3)
    		return par1 + 32;
    	else if (this.blockID == MoreMineralsMod.dirtOres_ID4)
    		return par1 + 48;
    	return 0;
    }
    
    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World par1World, int par2, int par3, int par4)
    {
        return par1World.getBlockMetadata(par2, par3, par4);
    }

}
