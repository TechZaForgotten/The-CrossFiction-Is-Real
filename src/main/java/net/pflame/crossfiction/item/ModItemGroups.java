package net.pflame.crossfiction.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pflame.crossfiction.CrossFiction;
import net.pflame.crossfiction.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CROSS_FICTION_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrossFiction.MOD_ID, "fictional_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CURSED_INGOT))
                    .displayName(Text.translatable("itemgroup.cross-fiction.fictional_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CURSED_STONE);
                        entries.add(ModItems.CURSED_INGOT);
                    }).build());

    public static final ItemGroup CROSS_FICTION_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(CrossFiction.MOD_ID, "fictional_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CURSED_INGOT_BLOCK))
                    .displayName(Text.translatable("itemgroup.cross-fiction.fictional_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.CURSED_INGOT_BLOCK);
                        entries.add(ModBlocks.CURSED_STONE_ORE);
                    }).build());

    public static void registerItemGroups() {
        CrossFiction.LOGGER.info("Registering Item Groups For " + CrossFiction.MOD_ID);
    }
}
