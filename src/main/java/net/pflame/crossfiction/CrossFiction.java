package net.pflame.crossfiction;

import net.fabricmc.api.ModInitializer;

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
	}
}