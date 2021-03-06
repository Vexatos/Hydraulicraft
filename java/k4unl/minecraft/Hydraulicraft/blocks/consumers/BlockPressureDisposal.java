package k4unl.minecraft.Hydraulicraft.blocks.consumers;

import k4unl.minecraft.Hydraulicraft.TileEntities.consumers.TilePressureDisposal;
import k4unl.minecraft.Hydraulicraft.baseClasses.MachineBlockContainer;
import k4unl.minecraft.Hydraulicraft.lib.config.Ids;
import k4unl.minecraft.Hydraulicraft.lib.config.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPressureDisposal extends MachineBlockContainer {

	public BlockPressureDisposal() {
		super(Ids.blockPressureDisposal, Names.blockPressureDisposal);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return new TilePressureDisposal();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int par6, float par7, float par8, float par9) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean canConnectRedstone(IBlockAccess iba, int i, int j, int k, int dir){
		return true;
    }
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y,
				int z, int blockId) {
		super.onNeighborBlockChange(world, x, y, z, blockId);
		
		TileEntity tile = world.getBlockTileEntity(x, y, z);
		if(tile instanceof TilePressureDisposal){
			((TilePressureDisposal)tile).checkRedstonePower();			
		}
	}

}
