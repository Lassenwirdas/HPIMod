package hpi.mod.item;

import hpi.mod.HPIMod;
import hpi.mod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


public class ModItems {
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }
    public static final RegistryKey<Item> SUSPICIOUS_SUBSTANCE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HPIMod.MOD_ID, "suspicious_substance"));
    public static final RegistryKey<Item> HPI_BADGE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HPIMod.MOD_ID, "hpi_badge"));

    public static final Item SUSPICIOUS_SUBSTANCE = register(
            new Item(new Item.Settings().registryKey(SUSPICIOUS_SUBSTANCE_KEY)),
            SUSPICIOUS_SUBSTANCE_KEY
    );
    public static final Item HPI_BADGE = register(
            new Item(new Item.Settings().registryKey(HPI_BADGE_KEY)),
            HPI_BADGE_KEY
    );

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) ->
                        itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE)
                );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) ->
                        itemGroup.add(ModItems.HPI_BADGE)
                );

    }
}
