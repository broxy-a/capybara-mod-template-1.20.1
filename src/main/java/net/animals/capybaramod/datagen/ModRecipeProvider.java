package net.animals.capybaramod.datagen;

import net.animals.capybaramod.block.ModBlocks;
import net.animals.capybaramod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    // Список CAPY_SMELTABLES и FOOD_SMELTABLES — правильно для плавки.
    private static final List<ItemConvertible> CAPY_SMELTABLES = List.of(ModItems.RAW_CAPYBARIUM,
            ModBlocks.CAPY_ORE, ModBlocks.DEEPSLATE_CAPY_ORE);
    private static final List<ItemConvertible> FOOD_SMELTABLES = List.of(ModItems.SWEET_POTATO);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        // Плавка руды
        offerSmelting(exporter, CAPY_SMELTABLES, RecipeCategory.MISC, ModItems.CAPYBARIUM_INGOT, 0.7f, 200, "capybarium_ingot");
        offerBlasting(exporter, CAPY_SMELTABLES, RecipeCategory.MISC, ModItems.CAPYBARIUM_INGOT, 0.7f, 100, "capybarium_ingot");

        // Плавка еды
        offerSmelting(exporter, FOOD_SMELTABLES, RecipeCategory.FOOD    , ModItems.BAKED_SWEET_POTATO, 0.35f, 200, "baked_sweet_potato");

        // Плавка еды в коптильне
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.SWEET_POTATO),
                RecipeCategory.FOOD,
                ModItems.BAKED_SWEET_POTATO,
                0.35f, 100)
                .criterion("has_sweet_potato", conditionsFromItem(ModItems.SWEET_POTATO)).
                offerTo(exporter, new Identifier("capybaramod", "baked_sweet_potato_smoker"));

        // Бесформенный крафт кровати
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CAPY_BED, 1)
                .input(Ingredient.fromTag(ItemTags.WOOL))
                .input(Items.HAY_BLOCK)
                .input(Ingredient.fromTag(ItemTags.LEAVES))
                .criterion("has_wool", conditionsFromTag(ItemTags.WOOL)) // Что нужно что бы рецепт появился в книге
                .offerTo(exporter, new Identifier("capybaramod", "capy_bed"));


        // Форменный крафт флейты
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CAPY_FLUTE, 1)
                .pattern("X")
                .pattern("#")
                .pattern("X")
                .input('#', ModItems.TOKEN)
                .input('X', Items.BAMBOO)
                .criterion(hasItem(ModItems.TOKEN), conditionsFromItem(ModItems.TOKEN))
                .offerTo(exporter, new Identifier("capybaramod", "capy_flute"));

        // Крафт Салата
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MAGIC_SALAD, 1)
                .pattern("APY")
                .pattern(" C ")
                .input('C', Items.BOWL)
                .input('P', ModItems.TOTEM)
                .input('A', ModItems.GUAVA)
                .input('Y', ModItems.BAKED_SWEET_POTATO)
                .criterion(hasItem(ModItems.TOTEM), conditionsFromItem(ModItems.TOTEM))
                .offerTo(exporter, new Identifier("capybaramod", "magic_salad"));

        // Крафт Тотема
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TOTEM, 1)
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .input('#', Items.GOLD_NUGGET)
                .input('X', ModItems.TOKEN)
                .criterion(hasItem(ModItems.TOKEN), conditionsFromItem(ModItems.TOKEN))
                .offerTo(exporter, new Identifier("capybaramod", "totem"));
    }


}
