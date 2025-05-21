package net.animals.capybaramod.block;

import net.animals.capybaramod.CapybaraMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

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

    public static final Block CAPY_BED = registerBlock("capy_bed",
            new CapybaraBedBlock(FabricBlockSettings.create()
                    .strength(0.4f)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .nonOpaque()
                    .mapColor(MapColor.GREEN)
                    .sounds(BlockSoundGroup.GRASS)

            ));


    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CapybaraMod.MOD_ID, name), block);
    }

    private static Item registerBlockItems(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CapybaraMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CapybaraMod.LOGGER.info("Registering mod blocks for " + CapybaraMod.MOD_ID);
    }
}
