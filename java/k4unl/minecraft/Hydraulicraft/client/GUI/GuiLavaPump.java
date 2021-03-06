package k4unl.minecraft.Hydraulicraft.client.GUI;

import java.text.DecimalFormat;

import k4unl.minecraft.Hydraulicraft.Hydraulicraft;
import k4unl.minecraft.Hydraulicraft.TileEntities.generator.TileHydraulicLavaPump;
import k4unl.minecraft.Hydraulicraft.baseClasses.MachineGUI;
import k4unl.minecraft.Hydraulicraft.containers.ContainerEmpty;
import k4unl.minecraft.Hydraulicraft.lib.Localization;
import k4unl.minecraft.Hydraulicraft.lib.config.ModInfo;
import k4unl.minecraft.Hydraulicraft.lib.config.Names;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidTankInfo;

public class GuiLavaPump extends MachineGUI {
	private static ResourceLocation resLoc = new ResourceLocation(ModInfo.LID,"textures/gui/lavapump.png");
	TileHydraulicLavaPump pump;
	
	
	public GuiLavaPump(InventoryPlayer invPlayer, TileHydraulicLavaPump _pump) {
		super(_pump, new ContainerEmpty(invPlayer), resLoc);
		pump = _pump;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		drawHorizontalAlignedString(7, 3, xSize - 14, Localization.getLocalizedName(Names.blockHydraulicLavaPump[pump.getTier()].unlocalized), true);
		
		//Get lava level:
		FluidTankInfo[] tankInfo = pump.getTankInfo(ForgeDirection.UP);
		if(tankInfo[0].fluid != null){
			drawVerticalProgressBarWithTexture(124, 16, 54, 16, tankInfo[0].fluid.amount, tankInfo[0].capacity, tankInfo[0].fluid.getFluid().getIcon(), FluidRegistry.LAVA.getLocalizedName(), "mB");
		}else{
			drawVerticalProgressBar(124, 16, 56, 18, 0, tankInfo[0].capacity, 0x00000000, FluidRegistry.LAVA.getLocalizedName(), "mB");
		}
		
		int startY = 17;
		int step = (int)(Hydraulicraft.smallGuiFont.getLineHeight() / 3.2F);
		
		String generating = (new DecimalFormat("#.##")).format(pump.getGenerating(ForgeDirection.UP));
		drawSmallerString(61, startY + (step * 0), EnumChatFormatting.GREEN + "Generating:", false);
		drawSmallerString(65, startY + (step * 1), EnumChatFormatting.GREEN + "" + generating + " mBar/t", false);
		drawSmallerString(61, startY + (step * 2), EnumChatFormatting.GREEN + "Max:", false);
		drawSmallerString(65, startY + (step * 3), EnumChatFormatting.GREEN + "" + pump.getMaxGenerating(ForgeDirection.UP) + " mBar/t", false);
		drawSmallerString(61, startY + (step * 4), EnumChatFormatting.GREEN + "Using:", false);
		drawSmallerString(65, startY + (step * 5), EnumChatFormatting.GREEN + "" + (int)(pump.getLavaUsage()) + " mB/t", false);
		
		
		drawFluidAndPressure();
		
	}
}
