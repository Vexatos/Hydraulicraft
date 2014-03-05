package k4unl.minecraft.Hydraulicraft.api;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraftforge.common.ForgeDirection;

/**
 * DO NOT IMPLEMENT THIS INTERFACE!
 * @author K-4U
 */
public interface IBaseClass {
	/**
	 * Forward this function to the Base class
	 * @param tagCompound
	 */
	public void readFromNBT(NBTTagCompound tagCompound);
	
	/**
	 * Forward this function to the Base class
	 * @param tagCompound
	 */
	public void writeToNBT(NBTTagCompound tagCompound);
	
	/**
	 * Forward this function to the Base class
	 * @param net
	 * @param packet
	 */
	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet);
	
	/**
	 * Forward this function to the Base class
	 * @return
	 */
	public Packet getDescriptionPacket();

	/**
	 * Gets the ammount of fluid stored
	 * @param from
	 * @return the ammount of fluid stored
	 */
	public int getStored(ForgeDirection from);

	/**
	 * Sets the amount of fluid stored 
	 * @param maxStorage
	 * @param isOil
	 */
	public void setStored(int maxStorage, boolean isOil);
	
	/**
	 * 
	 * @return if Oil is stored in the tank.
	 */
	public boolean isOilStored();
	
	/**
	 * Sets if oil is stored or not
	 * @param b
	 */
	public void setIsOilStored(boolean b);
	
	/**
	 * 
	 * @return if the block has a redstone signal powering it.
	 */
	public boolean getRedstonePowered();

	/**
	 * Function to drop an item stack into the world.
	 * @param inputInventory
	 */
	public void dropItemStackInWorld(ItemStack inputInventory);
	
	
	public List<IHydraulicMachine> getConnectedBlocks(
			List<IHydraulicMachine> mainList);
	
	/**
	 * Sets the fluid in the entire network.
	 * @param fluidInSystem
	 */
	public void setFluidInSystem(int fluidInSystem);

	/**
	 * Sets the amount of fluid the entire network can handle.
	 * @param totalFluidCapacity
	 */
	public void setTotalFluidCapacity(int totalFluidCapacity);

	/**
	 * Gets the fluid in the entire network.
	 * @return
	 */
	public int getFluidInSystem();
	
	/**
	 * Gets the amount of fluid the entire network can handle.
	 * @return
	 */
	public int getTotalFluidCapacity();

	/**
	 * Forward this function the the Base class
	 */
	public void updateEntity();
	
	/**
	 * Checks if the block is redstone powered. Does not return anything.
	 */
	public void checkRedstonePower();
	
	/**
	 * Triggers a world.markBlockForUpdate()
	 */
	public void updateBlock();
	
	/**
	 * When the TE is validated.
	 */
	public void validate();

	public void updateNetworkOnNextTick(float oldPressure);
}
