package net.animals.capybaramod.item;

import net.animals.capybaramod.CapybaraMod;
import net.animals.capybaramod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup; // Класс для создания пользовательской вкладки в креативном инвентаре с помощью Fabric API.
import net.minecraft.item.ItemGroup; // Стандартная вкладка в креативном меню
import net.minecraft.item.ItemStack; // Стек предметов, нужен для значка вкладки.
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text; // Тектс (например для json файлов)
import net.minecraft.util.Identifier;

public class ModItemGroup {
    /*  Registry.register(Registries.ITEM_GROUP, new Identifier(CapybaraMod.MOD_ID, "token") - регистрация новой вкладки с ID "capybaramod:token" в реестр
    * FabricItemGroup.builder() - билдер для создания вкладки.
    * .displayName(Text.translatable("itemgroup.token")) - название вкладки с ключом для перевода json
    * .icon(() -> new ItemStack(ModItems.)) - иконка вкладки
    *  entries((displayContext, entries) -> { - добавление предметов
     */

    public static final ItemGroup CAPYBARA_ITEMS = Registry.register(Registries.ITEM_GROUP, new Identifier(CapybaraMod.MOD_ID, "token"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.token"))
                    .icon(() -> new ItemStack(ModItems.TOKEN)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TOKEN);
                        entries.add(ModItems.TOTEM);
                        entries.add(ModItems.CAPY_FLUTE);

                        entries.add(ModBlocks.CAPY_BED);

                        entries.add(ModItems.SWEET_POTATO);
                        entries.add(ModItems.BAKED_SWEET_POTATO);
                        entries.add(ModItems.GUAVA);
                        entries.add(ModItems.MAGIC_SALAD);

                        entries.add(ModBlocks.CAPY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CAPY_ORE);
                        entries.add(ModItems.RAW_CAPYBARIUM);
                        entries.add(ModItems.CAPYBARIUM_INGOT);


                    }).build());
// Метод который вызывается при инициализации мода
    public static void registerItemsGroup() {
        CapybaraMod.LOGGER.info("Registering mod item group for " + CapybaraMod.MOD_ID);
    }
}
