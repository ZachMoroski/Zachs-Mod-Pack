package zachsmods.explosions;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BiggerTNTExplosionsv2 {

	int fuse = 4;
	float power = 32.0F;
	
	@SubscribeEvent
	public void SpawnTNTItem(EntityJoinWorldEvent event) {
		if (!(event.getEntity() instanceof EntityTNTPrimed)) {
			return;
		}
		
		Entity entity = event.getEntity();
		EntityItem explosion = new EntityItem(
				event.getWorld(), entity.posX, entity.posY, entity.posZ, new ItemStack(Blocks.TNT));
		explosion.setInfinitePickupDelay();
		explosion.motionX = 0;
		explosion.motionY = 0;
		explosion.motionZ = 0;
		explosion.lifespan = fuse * 20;
		if (!event.getWorld().isRemote) {
			event.getWorld().spawnEntityInWorld(explosion);
		}
	}
	
	@SubscribeEvent
	public void explode(ItemExpireEvent event) {
		if (event.getEntityItem().getEntityItem().getItem() !=
				Item.getItemFromBlock(Blocks.TNT)) {
			return;
		}
		
		Entity entity = event.getEntity();
		event.getEntity().worldObj.createExplosion(entity, entity.posX, entity.posY, entity.posZ, power, true);
	}
}
