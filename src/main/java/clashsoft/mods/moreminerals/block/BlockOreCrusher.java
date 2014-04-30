package clashsoft.mods.moreminerals.block;

import java.util.Random;

import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.tileentity.TileEntityOreCrusher;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockOreCrusher extends BlockContainer
{
	private final Random	random	= new Random();
	private final boolean	active;
	private static boolean	keepInventory;
	
	private IIcon			topIcon;
	private IIcon			fronIcon;
	
	public BlockOreCrusher(boolean paramBoolean)
	{
		super(Material.rock);
		this.setHardness(2.0F);
		this.setStepSound(Block.soundTypeMetal);
		this.active = paramBoolean;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return Item.getItemFromBlock(MoreMineralsMod.oreCrusher);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setBlockDirection(world, x, y, z);
	}
	
	private void setBlockDirection(World world, int x, int y, int z)
	{
		if (world.isRemote)
		{
			return;
		}
		
		Block block1 = world.getBlock(x, y, z - 1);
		Block block2 = world.getBlock(x, y, z + 1);
		Block block3 = world.getBlock(x - 1, y, z);
		Block block4 = world.getBlock(x + 1, y, z);
		
		int i = 3;
		if ((block1.func_149730_j()) && (!(block2.func_149730_j())))
			i = 3;
		if ((block2.func_149730_j()) && (!(block1.func_149730_j())))
			i = 2;
		if ((block3.func_149730_j()) && (!(block4.func_149730_j())))
			i = 5;
		if ((block4.func_149730_j()) && (!(block3.func_149730_j())))
			i = 4;
		world.setBlockMetadataWithNotify(x, y, z, i, 2);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 1)
			return this.topIcon;
		if (side == 0)
			return this.topIcon;
		
		if (side != metadata)
			return this.blockIcon;
		return this.fronIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("orecrusher_side");
		this.fronIcon = iconRegister.registerIcon((this.active) ? "orecrusher_front_active" : "orefrusher_front");
		this.topIcon = iconRegister.registerIcon("orecrusher_top");
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, MoreMineralsMod.INSTANCE, MoreMineralsMod.oreCrusherTEID, world, x, y, z);
		}
		return true;
	}
	
	public static void updateBlockState(boolean active, World world, int x, int y, int z)
	{
		int i = world.getBlockMetadata(x, y, z);
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		
		keepInventory = true;
		if (active)
			world.setBlock(x, y, z, MoreMineralsMod.oreCrusherActive);
		else
			world.setBlock(x, y, z, MoreMineralsMod.oreCrusher);
		keepInventory = false;
		
		world.setBlockMetadataWithNotify(x, y, z, i, 2);
		
		if (tileEntity != null)
		{
			tileEntity.validate();
			world.setTileEntity(x, y, z, tileEntity);
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int paramInt)
	{
		return new TileEntityOreCrusher();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
	{
		int i = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 0x3;
		
		if (i == 0)
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		if (i == 1)
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		if (i == 2)
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		if (i == 3)
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		
		if (stack.hasDisplayName())
			((TileEntityOreCrusher) world.getTileEntity(x, y, z)).setInvName(stack.getDisplayName());
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		if (!(keepInventory))
		{
			TileEntityOreCrusher tileEntity = (TileEntityOreCrusher) world.getTileEntity(x, y, z);
			if (tileEntity != null)
			{
				for (int i = 0; i < tileEntity.getSizeInventory(); ++i)
				{
					ItemStack localItemStack = tileEntity.getStackInSlot(i);
					if (localItemStack != null)
					{
						float f1 = this.random.nextFloat() * 0.8F + 0.1F;
						float f2 = this.random.nextFloat() * 0.8F + 0.1F;
						float f3 = this.random.nextFloat() * 0.8F + 0.1F;
						
						while (localItemStack.stackSize > 0)
						{
							int j = this.random.nextInt(21) + 10;
							if (j > localItemStack.stackSize)
								j = localItemStack.stackSize;
							localItemStack.stackSize -= j;
							
							EntityItem localEntityItem = new EntityItem(world, x + f1, y + f2, z + f3, new ItemStack(localItemStack.getItem(), j, localItemStack.getItemDamage()));
							
							if (localItemStack.hasTagCompound())
							{
								localEntityItem.getEntityItem().setTagCompound((NBTTagCompound) localItemStack.getTagCompound().copy());
							}
							
							float f4 = 0.05F;
							localEntityItem.motionX = ((float) this.random.nextGaussian() * f4);
							localEntityItem.motionY = ((float) this.random.nextGaussian() * f4 + 0.2F);
							localEntityItem.motionZ = ((float) this.random.nextGaussian() * f4);
							world.spawnEntityInWorld(localEntityItem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, metadata);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random)
	{
		if (!(this.active))
			return;
		
		int i = world.getBlockMetadata(x, y, z);
		
		float f1 = x + 0.5F;
		float f2 = y + 0.0F + random.nextFloat() * 6.0F / 16.0F;
		float f3 = z + 0.5F;
		float f4 = 0.52F;
		float f5 = random.nextFloat() * 0.6F - 0.3F;
		
		if (i == 4)
		{
			world.spawnParticle("smoke", f1 - f4, f2, f3 + f5, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", f1 - f4, f2, f3 + f5, 0.0D, 0.0D, 0.0D);
		}
		else if (i == 5)
		{
			world.spawnParticle("smoke", f1 + f4, f2, f3 + f5, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", f1 + f4, f2, f3 + f5, 0.0D, 0.0D, 0.0D);
		}
		else if (i == 2)
		{
			world.spawnParticle("smoke", f1 + f5, f2, f3 - f4, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", f1 + f5, f2, f3 - f4, 0.0D, 0.0D, 0.0D);
		}
		else if (i == 3)
		{
			world.spawnParticle("smoke", f1 + f5, f2, f3 + f4, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("flame", f1 + f5, f2, f3 + f4, 0.0D, 0.0D, 0.0D);
		}
	}
	
	@Override
	public boolean hasComparatorInputOverride()
	{
		return true;
	}
	
	@Override
	public int getComparatorInputOverride(World world, int x, int y, int z, int side)
	{
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int paramInt1, int paramInt2, int paramInt3)
	{
		return Item.getItemFromBlock(MoreMineralsMod.oreCrusher);
	}
}