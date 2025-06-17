package net.animals.capybaramod.util;

import net.animals.capybaramod.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.IdentityHashMap;

public class ModLootTableModify {
    private static final Identifier JUNGLE_CHEST = new Identifier("minecraft", "chests/jungle_temple");


    public static void modify () {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, identifier, builder, lootTableSource) ->  {
            if (JUNGLE_CHEST.equals(identifier)) {
                LootPool.Builder poolBuilderOne = LootPool.builder() // Создание генерации лута
                        .rolls(ConstantLootNumberProvider.create(1)) // Количество попыток, каждый раз при генерации этого лута, выполняется 1 попытка чтобы получить этот предмет
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Шанс выпадения
                        .with(ItemEntry.builder(ModItems.CAPYBARIUM_INGOT)) // Сам предмет
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build()); // Количество штук
                builder.pool(poolBuilderOne.build());


                LootPool.Builder poolBuilderTwo = LootPool.builder() // Создание генерации лута
                        .rolls(ConstantLootNumberProvider.create(1)) // Количество попыток, каждый раз при генерации этого лута, выполняется 1 попытка чтобы получить этот предмет
                        .conditionally(RandomChanceLootCondition.builder(0.35f)) // Шанс выпадения
                        .with(ItemEntry.builder(ModItems.TOKEN)) // Сам предмет
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 4.0f)).build()); // Количество штук
                builder.pool(poolBuilderTwo.build());
            }
        });
    }
}
