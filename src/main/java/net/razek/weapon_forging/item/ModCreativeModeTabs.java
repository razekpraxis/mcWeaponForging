package net.razek.weapon_forging.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.WeaponBlocks;

import java.awt.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WeaponForging.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WEAPON_TAB = CREATIVE_MODE_TABS.register("weapon_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WeaponBlocks.WEAPON_FORGE.get()))
                    .title(Component.translatable("creativetab.weapon_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Items


                        // Blocks


                        pOutput.accept(WeaponBlocks.WEAPON_FORGE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
