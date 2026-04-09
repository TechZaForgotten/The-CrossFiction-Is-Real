package net.pflame.crossfiction.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.pflame.crossfiction.block.ModBlocks;
import net.pflame.crossfiction.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CURSED_INGOT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CURSED_STONE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CURSED_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CURSED_INGOT, Models.GENERATED);
    }
}
