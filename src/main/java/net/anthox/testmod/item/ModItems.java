package net.anthox.testmod.item;

import net.anthox.testmod.Testmod;
import net.anthox.testmod.food.ModFoodComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public class ModItems {
    //Creating the items with final because we dont want them to be changed
    //We create a method to register the items so we dont have to repeat us
    public static final Item PINK_GARNET = registerItem("pink_garnet",
            new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet",
            new Item(new Item.Settings()));
    public static final Item SERRANO = registerItem("serrano",
            new Item(new Item.Settings().food(ModFoodComponents.SERRANO)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Testmod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        Testmod.LOGGER.info("Registering ModItems for " + Testmod.MOD_ID);
        //Items that are in the ingredients tab while being an item
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
        //Items that are in the food and drink tab while being an item
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(SERRANO);
        });

    }
}
