package net.anthox.testmod.block;

import net.anthox.testmod.Testmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //Initialize the modded blocks, BlockSoundGroup.AMETHYST allows to have the sound of the ametyst
    //while being mined, strength is for how long we are going to have to break it
    //AbstractBlock is so we cant call the block himself ? ( a vérifier )

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
    new Block(AbstractBlock.Settings.create().strength(4f).
            requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(3f).
                    requiresTool().sounds(BlockSoundGroup.STONE)));


    //Registries methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Testmod.MOD_ID,name),block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Testmod.MOD_ID, name),
                new BlockItem(block,new Item.Settings()));
    }
    public static void registerModBlock() {
        Testmod.LOGGER.info("Registering mod blocks for : " + Testmod.MOD_ID);


        //Add the block to the building blocks tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARNET_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(RAW_PINK_GARNET_BLOCK);
        });
        }


}
