package clashsoft.mods.moreminerals.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clashsoft.cslib.minecraft.lang.I18n;
import clashsoft.mods.moreminerals.MoreMineralsMod;
import clashsoft.mods.moreminerals.chem.Element;
import clashsoft.mods.moreminerals.chem.PeriodicTable;
import clashsoft.mods.moreminerals.tileentity.TileEntityOres;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemBlockOres extends ItemBlock
{
	public Map<NBTTagCompound, TileEntityOres>	cache	= new HashMap();
	
	public ItemBlockOres(Block block)
	{
		super(block);
	}
	
	@Override
	public IIcon getIconIndex(ItemStack stack)
	{
		Element element = ItemMaterials.getFirstElement(stack);
		if (element != null)
		{
			String s = element.getTextureName(stack.getItemDamage());
			return MoreMineralsMod.ores.icons.get(s);
		}
		return null;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		Element[] elements = ItemMaterials.getElements(stack);
		if (elements != null)
		{
			StringBuilder builder = new StringBuilder(elements.length << 4);
			Block block = this.getBlock(stack);
			ItemMaterials.joinElementNames(elements, builder);
			
			if (block == Blocks.stone)
			{
				return I18n.getStringParams("tile.ores.stone.name", builder.toString());
			}
			
			return I18n.getStringParams("tile.ores.name", block.getLocalizedName(), builder.toString());
		}
		return super.getItemStackDisplayName(stack);
	}
	
	@Override
	public int getColorFromItemStack(ItemStack stack, int pass)
	{
		Element[] elements = ItemMaterials.getElements(stack);
		return PeriodicTable.calcColor(elements, stack.getItemDamage());
	}
	
	public Block getBlock(ItemStack stack)
	{
		if (stack != null && stack.stackTagCompound != null)
		{
			int id = stack.stackTagCompound.getInteger("Block");
			return Block.getBlockById(id);
		}
		return Blocks.stone;
	}
	
	public TileEntityOres getTileEntity(ItemStack stack)
	{
		if (stack != null && stack.stackTagCompound != null)
		{
			TileEntityOres ores = new TileEntityOres();
			ores.readFromNBT(stack.stackTagCompound);
			return ores;
		}
		return null;
	}
	
	public static ItemStack setBlock(ItemStack stack, Block block)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
		}
		stack.stackTagCompound.setInteger("Block", Block.getIdFromBlock(block));
		return stack;
	}
	
	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
	{
		if (!world.setBlock(x, y, z, this.field_150939_a, metadata, 3))
		{
			return false;
		}
		
		TileEntityOres tileEntity = getTileEntity(stack);
		
		world.setTileEntity(x, y, z, tileEntity);
		
		if (world.getBlock(x, y, z) == this.field_150939_a)
		{
			this.field_150939_a.onBlockPlacedBy(world, x, y, z, player, stack);
			this.field_150939_a.onPostBlockPlaced(world, x, y, z, metadata);
		}
		
		return true;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (Block block : MoreMineralsMod.baseBlocks)
		{
			for (Element e : PeriodicTable.getElements())
			{
				if (e != null && e.isAvailable(block))
				{
					ItemStack stack = new ItemStack(this, 1, 0);
					ItemMaterials.setElement(stack, e);
					setBlock(stack, block);
					list.add(stack);
				}
			}
		}
	}
}
