package k4unl.minecraft.Hydraulicraft.blocks.storage;

import java.util.ArrayList;

import k4unl.minecraft.Hydraulicraft.Hydraulicraft;
import k4unl.minecraft.Hydraulicraft.TileEntities.storage.TileHydraulicPressureVat;
import k4unl.minecraft.Hydraulicraft.baseClasses.MachineTieredBlock;
import k4unl.minecraft.Hydraulicraft.lib.config.Ids;
import k4unl.minecraft.Hydraulicraft.lib.config.Names;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockHydraulicPressureVat extends MachineTieredBlock {
	
	
	public BlockHydraulicPressureVat() {
		super(Ids.blockHydraulicPressureVat, Names.blockHydraulicPressurevat);
		hasTopIcon = true;
		hasBottomIcon = true;
	}

	
	@Override
	public TileEntity createTileEntity(World world, int metadata){
		TileHydraulicPressureVat pVat = new TileHydraulicPressureVat();
		pVat.setTier(metadata);
		return pVat;
    }
	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		if(player.isSneaking())
			return false;
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if(entity == null || !(entity instanceof TileHydraulicPressureVat)){
			return false;
			
		}
		TileHydraulicPressureVat pump = (TileHydraulicPressureVat) entity;
		player.openGui(Hydraulicraft.instance, Ids.GUIPressureVat.act, world, x, y, z);
		
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack iStack){
		super.onBlockPlacedBy(world, x, y, z, player, iStack);
		TileEntity ent = world.getBlockTileEntity(x, y, z);
		if(ent instanceof TileHydraulicPressureVat){
			if(iStack != null){
				if(iStack.getTagCompound() != null){
					((TileHydraulicPressureVat)ent).newFromNBT(iStack.getTagCompound());
					world.markBlockForUpdate(x, y, z);
				}
			}
		}
	}
	
	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune){
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		//Don't drop anything please..
		return ret;
	}
	/**
     * Returns true if the block is emitting direct/strong redstone power on the specified side. Args: World, X, Y, Z,
     * side. Note that the side is reversed - eg it is 1 (up) when checking the bottom of the block.
     */
    public int isProvidingStrongPower(IBlockAccess w, int x, int y, int z, int side){
        return this.isProvidingWeakPower(w, x, y, z, side);
    }

    /**
     * Returns true if the block is emitting indirect/weak redstone power on the specified side. If isBlockNormalCube
     * returns true, standard redstone propagation rules will apply instead and this will not be called. Args: World, X,
     * Y, Z, side. Note that the side is reversed - eg it is 1 (up) when checking the bottom of the block.
     */
    public int isProvidingWeakPower(IBlockAccess w, int x, int y, int z, int side){
    	TileEntity ent = w.getBlockTileEntity(x, y, z);
		if(ent instanceof TileHydraulicPressureVat){
			TileHydraulicPressureVat p = (TileHydraulicPressureVat) ent;
			return p.getRedstoneLevel();
		}
		return 0;
    }

    public boolean canProvidePower(){
        return true;
    }

	
}
