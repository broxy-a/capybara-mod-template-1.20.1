package net.animals.capybaramod.item;

import net.animals.capybaramod.CapybaraMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CapyItems {
    public static final Item CAPYBED = registerItem("bed", new Item(new FabricItemSettings()));

    private static void addToItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(CAPYBED);
    }


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(CapybaraMod.MOD_ID, name), item);
    }

    public static void registerCapyItems() {
        CapybaraMod.LOGGER.info("Registering Capy items for " + CapybaraMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(CapyItems::addToItemsToIngredientItemGroup);
    }
}
