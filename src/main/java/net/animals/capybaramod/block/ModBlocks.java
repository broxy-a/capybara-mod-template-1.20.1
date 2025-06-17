package net.animals.capybaramod.block;

import net.animals.capybaramod.CapybaraMod;
import net.animals.capybaramod.block.custom.SweetPotatoCropBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block BARALEAF_PLANKS = registerBlock("baraleaf_planks",
            new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));


    public static final Block BARALEAF_STAIRS = registerBlock("baraleaf_stairs",
            new StairsBlock(ModBlocks.BARALEAF_PLANKS.getDefaultState(), FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block BARALEAF_SLAB = registerBlock("baraleaf_slab",
            new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));

    public static final Block BARALEAF_BUTTON = registerBlock("baraleaf_button",
            new ButtonBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS), BlockSetType.OAK, 10, true));

    public static final Block BARALEAF_PRESSURE_PLATE = registerBlock("baraleaf_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copy(Blocks.OAK_PLANKS), BlockSetType.OAK));

    public static final Block BARALEAF_FENCE = registerBlock("baraleaf_fence",
            new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS)));
    public static final Block BARALEAF_FENCE_GATE = registerBlock("baraleaf_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS), WoodType.OAK));

    public static final Block BARALEAF_DOOR = registerBlock("baraleaf_door",
            new DoorBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS), BlockSetType.OAK));

    public static final Block BARALEAF_TRAPDOOR = registerBlock("baraleaf_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS), BlockSetType.OAK));

    public static final Block BARALEAF_LOG = registerBlock("baraleaf_log",
            new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG)));

    public static final Block DEEPSLATE_CAPY_ORE = registerBlock("deepslate_capy_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.DEEPSLATE_IRON_ORE)
                    .strength(4.5F, 3.0F)
                    .requiresTool(),
                    UniformIntProvider.create(1, 5)
            ));

    public static final Block CAPY_ORE = registerBlock("capy_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copy(Blocks.IRON_ORE)
                    .strength(3.0F, 3.0F)
                    .requiresTool(),
                    UniformIntProvider.create(1, 5)
            ));

    public static final Block SWEET_POTATO_CROP = Registry.register(Registries.BLOCK, new Identifier(CapybaraMod.MOD_ID, "sweet_potato_crop"),
            new SweetPotatoCropBlock(FabricBlockSettings.copyOf(Blocks.POTATOES)));

    /* public static final Block CAPY_BED = registerBlock("capy_bed",
            new CapybaraBedBlock(FabricBlockSettings.create()
                    .strength(0.4f)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .nonOpaque()
                    .mapColor(MapColor.GREEN)
                    .sounds(BlockSoundGroup.GRASS)

            ));*/


    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CapybaraMod.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(CapybaraMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CapybaraMod.LOGGER.info("Registering mod blocks for " + CapybaraMod.MOD_ID);
    }
}
