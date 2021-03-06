package zachsmods.commands;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.init.Items;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent.Action;

public class BlockFillerPositionSelector {
	
	static List<Integer> pos1 = new ArrayList();
	static List<Integer> pos2 = new ArrayList();

	@EventHandler
	public void choosePositions(PlayerInteractEvent event) {
		if (event.getEntityPlayer().getHeldItemMainhand() == null
				|| event.getEntityPlayer().getHeldItemMainhand().getItem() != Items.WOODEN_AXE
				|| !event.getEntityPlayer().capabilities.isCreativeMode) {
			return;
		}
		
		if(event.getResult() == Action.LEFT_CLICK_BLOCK) {
			pos1.clear();
			pos1.add(event.getPos().getX());
			pos1.add(event.getPos().getY());
			pos1.add(event.getPos().getZ());
			event.getEntityPlayer().addChatMessage(new TextComponentString(TextFormatting.GREEN + "Position 1 set to " + event.getPos().getX()
							+ ", " + event.getPos().getY() + ", " + event.getPos().getZ() + "."));
			event.setCanceled(true);
			
		} else if (event.action == Action.RIGHT_CLICK_BLOCK) {
			pos2.clear();
			pos2.add(event.getPos().getX());
			pos2.add(event.getPos().getY());
			pos2.add(event.getPos().getZ());
			event.getEntityPlayer().addChatMessage(new TextComponentString(TextFormatting.GREEN + "Position 2 set to " + event.getPos().getX()
							+ ", " + event.getPos().getY() + ", " + event.getPos().getZ() + "."));
			event.setCanceled(true);
		}
	}
}
