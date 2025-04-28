package net.animals.capybaramod.block;

import net.animals.capybaramod.CapybaraMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

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
