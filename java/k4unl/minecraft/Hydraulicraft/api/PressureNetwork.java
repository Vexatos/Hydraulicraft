package k4unl.minecraft.Hydraulicraft.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;

public class PressureNetwork implements IPressureNetwork{
	private float pressure = 0;
	
	private List<IHydraulicMachine> machines;
	private int randomNumber = 0;
	
	public PressureNetwork(float beginPressure, IHydraulicMachine machine){
		randomNumber = new Random().nextInt();
		machines = new ArrayList<IHydraulicMachine>();
		machines.add(machine);
		pressure = beginPressure;
	}
	
	public int getRandomNumber(){
		return randomNumber;
	}
	
	public void addMachine(IHydraulicMachine machine){
		if(!machines.contains(machine)){
			float oPressure = pressure * machines.size();
			machines.add(machine);
			pressure = oPressure / machines.size();
		}
	}
	
	public void removeMachine(IHydraulicMachine machine){
		if(machines.contains(machine)){
			machines.remove(machine);
		}
	}
	
	public float getPressure(){
		return pressure;
	}
	
	public void setPressure(float newPressure){
		pressure = newPressure;
	}
	
	public List<IHydraulicMachine> getMachines(){
		return machines;
	}
	
	public void mergeNetwork(IPressureNetwork toMerge){
		float newPressure = ((pressure - toMerge.getPressure()) / 2) + toMerge.getPressure();
		setPressure(newPressure);
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		tagCompound.setFloat("pressure", pressure);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		pressure = tagCompound.getFloat("pressure");
	}
}