package k4unl.minecraft.Hydraulicraft.thirdParty.nei;

import k4unl.minecraft.Hydraulicraft.lib.config.ModInfo;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEIHydraulicraftConfig implements IConfigureNEI{
    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new NEICrusherRecipeManager());
        API.registerUsageHandler(new NEICrusherRecipeManager());
        
        API.registerRecipeHandler(new NEIWasherRecipeManager());
        API.registerUsageHandler(new NEIWasherRecipeManager());
        
        API.registerRecipeHandler(new NEIFrictionIncineratorRecipeManager());
        API.registerUsageHandler(new NEIFrictionIncineratorRecipeManager());
    }

    @Override
    public String getName() {
        return ModInfo.NAME;
    }

    @Override
    public String getVersion() {
        return ModInfo.VERSION;
    }
}
