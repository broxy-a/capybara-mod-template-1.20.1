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


        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BARALEAF_PLANKS, 4)
                .input(ModBlocks.BARALEAF_LOG)
                .criterion(hasItem(ModBlocks.BARALEAF_LOG), conditionsFromItem(ModBlocks.BARALEAF_LOG))
                .offerTo(exporter, new Identifier("capybaramod","baraleaf_planks"));

        createStairsRecipe(ModBlocks.BARALEAF_STAIRS, Ingredient.ofItems(ModBlocks.BARALEAF_PLANKS))
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_stairs"));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BARALEAF_SLAB, Ingredient.ofItems(ModBlocks.BARALEAF_PLANKS))
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_slab"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BARALEAF_BUTTON, 1)
                .input(ModBlocks.BARALEAF_PLANKS)
                .criterion(hasItem(ModBlocks.BARALEAF_PLANKS), conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_button"));

        createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BARALEAF_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.BARALEAF_PLANKS))
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_pressure_plate"));

        createFenceRecipe(ModBlocks.BARALEAF_FENCE, Ingredient.ofItems(ModBlocks.BARALEAF_PLANKS))
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_fence"));

        createFenceGateRecipe(ModBlocks.BARALEAF_FENCE_GATE, Ingredient.ofItems(ModBlocks.BARALEAF_PLANKS))
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_fence_gate"));

        createDoorRecipe(ModBlocks.BARALEAF_DOOR, Ingredient.ofItems(ModBlocks.BARALEAF_PLANKS))
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_door"));

        createTrapdoorRecipe(ModBlocks.BARALEAF_TRAPDOOR, Ingredient.ofItems(ModBlocks.BARALEAF_PLANKS))
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod","baraleaf_trapdoor"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CAPYBARIUM_PICKAXE, 1)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_pickaxe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CAPYBARIUM_AXE, 1)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_axe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CAPYBARIUM_SHOVEL, 1)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_shovel"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CAPYBARIUM_SWORD, 1)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_sword"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.CAPYBARIUM_HOE, 1)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_hoe"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CAPYBARIUM_HELMET, 1)
                .pattern("XXX")
                .pattern("X#X")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', ModItems.TOKEN)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_helmet"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CAPYBARIUM_CHESTPLATE, 1)
                .pattern("X#X")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', ModItems.TOKEN)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_chestplate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CAPYBARIUM_LEGGINGS, 1)
                .pattern("XXX")
                .pattern("X#X")
                .pattern("X X")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', ModItems.TOKEN)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_leggings"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.CAPYBARIUM_BOOTS, 1)
                .pattern("X#X")
                .pattern("X X")
                .input('X', ModItems.CAPYBARIUM_INGOT)
                .input('#', ModItems.TOKEN)
                .criterion(hasItem(ModItems.CAPYBARIUM_INGOT), conditionsFromItem(ModItems.CAPYBARIUM_INGOT))
                .offerTo(exporter, new Identifier("capybaramod", "capybarium_boots"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.STICK, 4)
                .pattern("X")
                .pattern("X")
                .input('X', ModBlocks.BARALEAF_PLANKS)
                .criterion(hasItem(ModBlocks.BARALEAF_PLANKS), conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_to_stick"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BOWL, 4)
                .pattern("# #")
                .pattern(" # ")
                .input('#', ModBlocks.BARALEAF_PLANKS)
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_to_bowl"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.CHEST)
                .pattern("###")
                .pattern("# #")
                .pattern("###")
                .input('#', ModBlocks.BARALEAF_PLANKS)
                .criterion("has_baraleaf_planks", conditionsFromItem(ModBlocks.BARALEAF_PLANKS))
                .offerTo(exporter, new Identifier("capybaramod", "baraleaf_to_crafting_table"));




    }


}
