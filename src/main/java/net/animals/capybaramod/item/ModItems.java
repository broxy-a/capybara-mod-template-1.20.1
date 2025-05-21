package net.animals.capybaramod.item; // Путь до этого файла

import net.animals.capybaramod.CapybaraMod; // Импорт основоного класса мода
import net.animals.capybaramod.item.custom.CapyFluteItem;
import net.animals.capybaramod.item.tooltip.TooltipItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings; // Импорт класса для настройки предметов (редкость, стакуемость и т.д)
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries; // Импорт класса для управления содержимым вкладок.
import net.minecraft.item.Item; // Класс для создания предметов
import net.minecraft.registry.Registries; // Содержит реестры (база данных) всех игровых объектов.
import net.minecraft.registry.Registry; // Класс для регистрации предметов в реестр игры (Базу данных)
import net.minecraft.util.Identifier; // Идентификатор нужны для регистрации предметов.


public class ModItems {

    // Создание двух предметов с базовыми настройками и  регистрацией.
    public static final Item TOKEN = registerItem("token", new Item(new FabricItemSettings()));
    public static final Item TOTEM = registerItem("totem", new Item(new FabricItemSettings()));

    public static final Item CAPY_FLUTE = registerItem("capy_flute", new CapyFluteItem(new FabricItemSettings().maxDamage(66)));


    public static final Item SWEET_POTATO = registerItem("sweet_potato",
            new TooltipItem((new FabricItemSettings().food(ModFoodComponents.SWEET_POTATO)), "item.capybaramod.sweet_potato.tooltip"));

    public static final Item BAKED_SWEET_POTATO = registerItem("baked_sweet_potato",
            new TooltipItem((new FabricItemSettings().food(ModFoodComponents.BAKED_SWEET_POTATO)), "item.capybaramod.baked_sweet_potato.tooltip"));

    public static final Item GUAVA = registerItem("guava",
            new TooltipItem((new FabricItemSettings().food(ModFoodComponents.GUAVA)), "item.capybaramod.guava.tooltip"));

    public static final Item MAGIC_SALAD = registerItem("magic_salad",
            new TooltipItem((new FabricItemSettings().food(ModFoodComponents.MAGIC_SALAD)),  "item.capybaramod.magic_salad.tooltip"));

    public static final Item RAW_CAPYBARIUM = registerItem("raw_capybarium", new Item(new FabricItemSettings()));

    public static final Item CAPYBARIUM_INGOT = registerItem("capybarium_ingot", new Item(new FabricItemSettings()));

    // Метод для добавления премдетов во вкладку креативе
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(TOKEN);
        entries.add(TOTEM);
        entries.add(CAPY_FLUTE);
    }

    // Метод для регистрации предметов в игровом реестре.
   private static Item registerItem(String name, Item item) {
       return Registry.register(Registries.ITEM, new Identifier(CapybaraMod.MOD_ID, name), item);
   }

   // Метод вызываемый при инициализации мода.
   public static void registerModItems() {
       CapybaraMod.LOGGER.info("Registering mod items for " + CapybaraMod.MOD_ID);


   }
}
