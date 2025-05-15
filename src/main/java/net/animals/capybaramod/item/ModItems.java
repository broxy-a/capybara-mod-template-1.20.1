package net.animals.capybaramod.item; // Путь до этого файла

import net.animals.capybaramod.CapybaraMod; // Импорт основоного класса мода
import net.animals.capybaramod.item.custom.CapyFluteItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings; // Импорт класса для настройки предметов (редкость, стакуемость и т.д)
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries; // Импорт класса для управления содержимым вкладок.
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents; // Импорт интерфейса для добавления предметов в вкладки в креативе.
import net.minecraft.item.Item; // Класс для создания предметов
import net.minecraft.item.ItemGroups; // Доступ к дефолтным вкладкам предметов
import net.minecraft.registry.Registries; // Содержит реестры (база данных) всех игровых объектов.
import net.minecraft.registry.Registry; // Класс для регистрации предметов в реестр игры (Базу данных)
import net.minecraft.util.Identifier; // Идентификатор нужны для регистрации предметов.


public class ModItems {

    // Создание двух предметов с базовыми настройками и  регистрацией.
    public static final Item TOKEN = registerItem("token", new Item(new FabricItemSettings()));
    public static final Item TOTEM = registerItem("totem", new Item(new FabricItemSettings()));

    public static final Item CAPY_FLUTE = registerItem("capy_flute", new CapyFluteItem(new FabricItemSettings().maxDamage(66)));

    public static final Item SWEET_POTATO = registerItem("sweet_potato", new Item(new FabricItemSettings().food(ModFoodComponents.SWEET_POTATO)));
    public static final Item BAKED_SWEET_POTATO = registerItem("baked_sweet_potato", new Item(new FabricItemSettings().food(ModFoodComponents.BAKED_SWEET_POTATO)));
    public static final Item GUAVA = registerItem("guava", new Item(new FabricItemSettings().food(ModFoodComponents.GUAVA)));
    public static final Item MAGIC_SALAD = registerItem("magic_salad", new Item(new FabricItemSettings().food(ModFoodComponents.MAGIC_SALAD)));

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
