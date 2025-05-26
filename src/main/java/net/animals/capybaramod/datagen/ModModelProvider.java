package net.animals.capybaramod.datagen;

import net.animals.capybaramod.block.ModBlocks;
import net.animals.capybaramod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CAPY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CAPY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CAPY_BED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.TOKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAPY_FLUTE, Models.GENERATED);

        itemModelGenerator.register(ModItems.SWEET_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAKED_SWEET_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GUAVA, Models.GENERATED);
        itemModelGenerator.register(ModItems.MAGIC_SALAD, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_CAPYBARIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAPYBARIUM_INGOT, Models.GENERATED);
    }
}
