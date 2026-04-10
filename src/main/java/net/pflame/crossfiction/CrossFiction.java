package net.pflame.crossfiction;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.pflame.crossfiction.block.ModBlocks;
import net.pflame.crossfiction.item.ModItemGroups;
import net.pflame.crossfiction.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrossFiction implements ModInitializer {
	public static final String MOD_ID = "cross-fiction";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) ->
		{
			if (entity instanceof SheepEntity sheepEntity && !world.isClient) {
				if (playerEntity.getMainHandStack().getItem() == Items.END_ROD) {
					playerEntity.sendMessage(Text.literal("Did you just shove that up its ass?"));
					playerEntity.getMainHandStack().decrement(1);
					sheepEntity.setHealth(0f);
				}
				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		});
	}
}