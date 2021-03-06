package k4unl.minecraft.Hydraulicraft.thirdParty;

import k4unl.minecraft.Hydraulicraft.lib.Log;
import k4unl.minecraft.Hydraulicraft.thirdParty.buildcraft.Buildcraft;
import k4unl.minecraft.Hydraulicraft.thirdParty.extraUtilities.ExtraUtilities;
import k4unl.minecraft.Hydraulicraft.thirdParty.fmp.FMP;
import k4unl.minecraft.Hydraulicraft.thirdParty.industrialcraft.IndustrialCraft;
import k4unl.minecraft.Hydraulicraft.thirdParty.pneumaticraft.Pneumaticraft;
import k4unl.minecraft.Hydraulicraft.thirdParty.thermalExpansion.ThermalExpansion;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;

public class ThirdParty{

    public static void init(){
    	FMLInterModComms.sendMessage("Waila", "register", "k4unl.minecraft.Hydraulicraft.thirdParty.WailaProvider.callbackRegister");

        if(Loader.isModLoaded("PneumaticCraft")) {
            Log.info("Pneumaticraft found! Initializing Pneumaticraft support!");
            Pneumaticraft.init();
        }
        if(Loader.isModLoaded("ExtraUtilities")){
    		Log.info("ExtraUtilities found! Initializing ExtraUtilities support!");
    		
        }
        
        if(Loader.isModLoaded("BuildCraft|Core")){
        	Log.info("Buildcraft found! Initializing Buildcraft support!");
        	Buildcraft.init();
        }
        
        if(Loader.isModLoaded("ThermalExpansion")){
        	Log.info("Thermal Expansion found! Initializing Thermal Expansion support!");
        	ThermalExpansion.init();
        }
        
        if(Loader.isModLoaded("IC2")){
        	Log.info("Industrialcraft found! Initializing Industrialcraft support!");
        	IndustrialCraft.init();
        }
        
        if(Loader.isModLoaded("ForgeMicroblock")){
        	Log.info("Forge Microblock found! Initializing FMP support!");
        	FMP.init();
        }
        
    }
    
    public static void postInit(){
    	if(Loader.isModLoaded("ExtraUtilities")){
    		Log.info("ExtraUtilities found! Initializing ExtraUtilities support!");
    		ExtraUtilities.init();
        }
    	
    	if(Loader.isModLoaded("ThermalExpansion")){
        	Log.info("Thermal Expansion found! Initializing Thermal Expansion support!");
        	ThermalExpansion.postInit();
        }
    	if(Loader.isModLoaded("ForgeMicroblock")){
        	Log.info("Forge Microblock found! Initializing FMP support!");
        	FMP.initRecipes();
        }
    }
    

}
