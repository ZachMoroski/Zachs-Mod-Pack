package zachsmods.registers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import zachsmods.goodiefoodies.TomatoCrop;

public class ModCrops {

	public static TomatoCrop tomatoCrop;

	public static void createCrops() {
		
		GameRegistry.registerBlock(tomatoCrop = new TomatoCrop("tomatoCrop"), "tomatoCrop");
		
	}
}
