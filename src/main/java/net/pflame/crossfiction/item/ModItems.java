package net.pflame.crossfiction.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pflame.crossfiction.CrossFiction;

public class ModItems {
    public static final Item CURSED_STONE = registerItem("cursed_stone", new Item(new Item.Settings()));
    public static final Item CURSED_INGOT = registerItem("cursed_ingot", new Item(new Item.Settings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CrossFiction.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CrossFiction.LOGGER.info("Registering Mod Items fore " + CrossFiction.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->{

            entries.add(CURSED_STONE);
            entries.add(CURSED_INGOT);
                });


    }
}
