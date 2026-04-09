package net.pflame.crossfiction.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.pflame.crossfiction.block.ModBlocks;
import net.pflame.crossfiction.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> CURSED_INGOT_SMELTABLES = List.of(ModItems.CURSED_STONE, ModBlocks.CURSED_STONE_ORE);

        offerSmelting(exporter, CURSED_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.CURSED_INGOT, 0.5f, 200, "cursed_ingot");
        offerBlasting(exporter, CURSED_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.CURSED_INGOT, 0.25f, 100, "cursed_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.CURSED_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_INGOT_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CURSED_STONE_ORE)
                .pattern("CCC")
                .pattern("CSC")
                .pattern("CCC")
                .input('C', Blocks.COBBLED_DEEPSLATE)
                .input('S', ModItems.CURSED_STONE)
                .criterion(hasItem(ModItems.CURSED_STONE), conditionsFromItem(ModItems.CURSED_STONE))
                .offerTo(exporter);
    }
}
