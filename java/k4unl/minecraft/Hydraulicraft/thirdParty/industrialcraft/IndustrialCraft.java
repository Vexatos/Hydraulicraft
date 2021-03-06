package k4unl.minecraft.Hydraulicraft.thirdParty.industrialcraft;

import ic2.api.item.Items;
import k4unl.minecraft.Hydraulicraft.blocks.Blocks;
import k4unl.minecraft.Hydraulicraft.lib.config.Names;
import k4unl.minecraft.Hydraulicraft.thirdParty.industrialcraft.blocks.BlockElectricPump;
import k4unl.minecraft.Hydraulicraft.thirdParty.industrialcraft.blocks.BlockHydraulicGenerator;
import k4unl.minecraft.Hydraulicraft.thirdParty.industrialcraft.blocks.HandlerElectricPump;
import k4unl.minecraft.Hydraulicraft.thirdParty.industrialcraft.tileEntities.TileElectricPump;
import k4unl.minecraft.Hydraulicraft.thirdParty.industrialcraft.tileEntities.TileHydraulicGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class IndustrialCraft {
	public static Block blockHydraulicGenerator;
	public static Block blockElectricPump;
	
	public static void init(){
		initBlocks();
		initRecipes();
	}
	
	public static void initBlocks(){
		blockHydraulicGenerator = new BlockHydraulicGenerator();
		blockElectricPump = new BlockElectricPump();
		
		
		GameRegistry.registerBlock(blockHydraulicGenerator, Names.blockHydraulicGenerator.unlocalized);
		GameRegistry.registerBlock(blockElectricPump, HandlerElectricPump.class, Names.blockElectricPump[0].unlocalized);
		
		GameRegistry.registerTileEntity(TileHydraulicGenerator.class, "tileHydraulicGenerator");
		GameRegistry.registerTileEntity(TileElectricPump.class, "tileElectricPump");
		
		
	}
	
	public static void initRecipes(){
		ItemStack generator = Items.getItem("generator");
		ItemStack battery = Items.getItem("reBattery");
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockHydraulicGenerator, 1), true,
				new Object [] {
					"PBP",
					"PGP",
					"WKW",
					'P', Block.thinGlass,
					'G', generator,
					'K', k4unl.minecraft.Hydraulicraft.items.Items.gasket,
					'W', Blocks.hydraulicPressureWall,
					'B', battery
				}));
		
		ItemStack coil = Items.getItem("coil");
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockElectricPump, 1, 0), true,
				new Object [] {
					"L-L",
					"KGC",
					"WWW",
					'G', Block.glass,
					'K', k4unl.minecraft.Hydraulicraft.items.Items.gasket,
					'W', Blocks.hydraulicPressureWall,
					'C', coil,
					'L', "ingotLead"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockElectricPump, 1, 1), true,
				new Object [] {
					"R-R",
					"KGC",
					"WWW",
					'G', Block.glass,
					'K', k4unl.minecraft.Hydraulicraft.items.Items.gasket,
					'W', Blocks.hydraulicPressureWall,
					'C', coil,
					'R', "ingotCopper"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockElectricPump, 1, 2), true,
				new Object [] {
					"R-R",
					"KGC",
					"WWW",
					'G', Block.glass,
					'K', k4unl.minecraft.Hydraulicraft.items.Items.gasket,
					'W', Blocks.hydraulicPressureWall,
					'C', coil,
					'R', "ingotEnrichedCopper"
				}));
	}

	public static void initRenderers() {
				
	}
}
