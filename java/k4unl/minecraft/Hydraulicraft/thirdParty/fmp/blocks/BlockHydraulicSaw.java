package k4unl.minecraft.Hydraulicraft.thirdParty.fmp.blocks;

import k4unl.minecraft.Hydraulicraft.Hydraulicraft;
import k4unl.minecraft.Hydraulicraft.baseClasses.MachineBlockContainer;
import k4unl.minecraft.Hydraulicraft.lib.config.Ids;
import k4unl.minecraft.Hydraulicraft.lib.config.Names;
import k4unl.minecraft.Hydraulicraft.thirdParty.fmp.tileEntities.TileHydraulicSaw;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHydraulicSaw extends MachineBlockContainer {

	public BlockHydraulicSaw() {
		super(Ids.blockHydraulicSaw, Names.blockHydraulicSaw);
		this.hasFrontIcon = true;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileHydraulicSaw();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
		if(player.isSneaking())
			return false;
		
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		if(entity == null || !(entity instanceof TileHydraulicSaw)){
			return false;
			
		}
		TileHydraulicSaw pump = (TileHydraulicSaw) entity;
		player.openGui(Hydraulicraft.instance, Ids.GUISaw.act, world, x, y, z);
		
		return true;
	}

}
