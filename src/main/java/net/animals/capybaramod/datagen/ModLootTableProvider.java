package net.animals.capybaramod.datagen;

import net.animals.capybaramod.block.ModBlocks;
import net.animals.capybaramod.block.custom.SweetPotatoCropBlock;
import net.animals.capybaramod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CAPY_ORE, oreDrops(ModBlocks.CAPY_ORE, ModItems.RAW_CAPYBARIUM)); // Выпадение необработанного ресурса с блока
        addDrop(ModBlocks.DEEPSLATE_CAPY_ORE, oreDrops(ModBlocks.DEEPSLATE_CAPY_ORE, ModItems.RAW_CAPYBARIUM));
        addDrop(ModBlocks.BARALEAF_LOG);
        addDrop(ModBlocks.BARALEAF_PLANKS);

        addDrop(ModBlocks.BARALEAF_STAIRS);
        addDrop(ModBlocks.BARALEAF_BUTTON);
        addDrop(ModBlocks.BARALEAF_PRESSURE_PLATE);
        addDrop(ModBlocks.BARALEAF_FENCE);
        addDrop(ModBlocks.BARALEAF_FENCE_GATE);
        addDrop(ModBlocks.BARALEAF_TRAPDOOR);

        addDrop(ModBlocks.BARALEAF_SLAB, slabDrops(ModBlocks.BARALEAF_SLAB));
        addDrop(ModBlocks.BARALEAF_DOOR, doorDrops(ModBlocks.BARALEAF_DOOR));







        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.SWEET_POTATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(SweetPotatoCropBlock.AGE_POTATO, 7));
        addDrop(ModBlocks.SWEET_POTATO_CROP, LootTable.builder() // Создание таблицы выпадений
                .pool(LootPool.builder() // Создание пула лута(одна попытка выпадения, всегда проверяется при ломании блока)
                        .rolls(ConstantLootNumberProvider.create(1))  // Одна попытка
                        .conditionally(builder.build())  // Применение нашего условия, только при полном созревании
                        .with(ItemEntry.builder(ModItems.SWEET_POTATO) // Добавления самого лута
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))
                        )
                )
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(builder.build())
                        .with(ItemEntry.builder(ModItems.SWEET_POTATO_SEEDS)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f, 3.0f)))
                        )
        )
        );

    }

}
