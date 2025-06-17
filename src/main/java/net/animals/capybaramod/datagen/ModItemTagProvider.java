package net.animals.capybaramod.datagen;

import net.animals.capybaramod.block.ModBlocks;
import net.animals.capybaramod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        // Значит что могу кастомизировать броню с помощью руд
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.CAPYBARIUM_HELMET, ModItems.CAPYBARIUM_CHESTPLATE, ModItems.CAPYBARIUM_LEGGINGS, ModItems.CAPYBARIUM_BOOTS);
    }
}
