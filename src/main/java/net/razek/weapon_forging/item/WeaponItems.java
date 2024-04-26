package net.razek.weapon_forging.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.item.guns.GunItem;
import net.razek.weapon_forging.item.guns.RifleItem;

public class WeaponItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WeaponForging.MOD_ID);


    // List of items


    public static final RegistryObject<Item> GUN = ITEMS.register("gun",
            () -> new GunItem(new Item.Properties()));

    public static final RegistryObject<Item> RIFLE = ITEMS.register("rifle",
            () -> new RifleItem(new Item.Properties()));





    // End list of items

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
