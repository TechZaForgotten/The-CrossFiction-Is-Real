package net.pflame.crossfiction.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.pflame.crossfiction.block.ModBlocks;
import net.pflame.crossfiction.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CURSED_INGOT_BLOCK);
        addDrop(ModBlocks.CURSED_STONE_ORE, oreDrops(ModBlocks.CURSED_STONE_ORE, ModItems.CURSED_STONE));
    }
}
