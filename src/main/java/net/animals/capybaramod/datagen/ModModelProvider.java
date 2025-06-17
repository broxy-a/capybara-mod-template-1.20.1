package net.animals.capybaramod.datagen;

import net.animals.capybaramod.block.ModBlocks;
import net.animals.capybaramod.block.custom.SweetPotatoCropBlock;
import net.animals.capybaramod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool baraleafPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BARALEAF_PLANKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CAPY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CAPY_ORE);
        blockStateModelGenerator.registerLog(ModBlocks.BARALEAF_LOG).log(ModBlocks.BARALEAF_LOG);

        baraleafPool.stairs(ModBlocks.BARALEAF_STAIRS);
        baraleafPool.slab(ModBlocks.BARALEAF_SLAB);
        baraleafPool.button(ModBlocks.BARALEAF_BUTTON);
        baraleafPool.pressurePlate(ModBlocks.BARALEAF_PRESSURE_PLATE);
        baraleafPool.fence(ModBlocks.BARALEAF_FENCE);
        baraleafPool.fenceGate(ModBlocks.BARALEAF_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.BARALEAF_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BARALEAF_TRAPDOOR);

        blockStateModelGenerator.registerCrop(ModBlocks.SWEET_POTATO_CROP, SweetPotatoCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);

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

        itemModelGenerator.register(ModItems.CAPYBARIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CAPYBARIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CAPYBARIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CAPYBARIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CAPYBARIUM_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem)ModItems.CAPYBARIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem)ModItems.CAPYBARIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem)ModItems.CAPYBARIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem)ModItems.CAPYBARIUM_BOOTS));


    }
}
