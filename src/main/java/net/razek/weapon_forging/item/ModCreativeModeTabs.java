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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WeaponItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.weapon_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        // Items
                        pOutput.accept(WeaponItems.SAPPHIRE.get());
                        pOutput.accept(WeaponItems.RAW_SAPPHIRE.get());
                        pOutput.accept(Items.DIAMOND);
                        pOutput.accept(WeaponItems.METAL_DETECTOR.get());
                        pOutput.accept(WeaponItems.STRAWBERRY.get());
                        pOutput.accept(WeaponItems.PINE_CONE.get());

                        // Blocks
                        pOutput.accept(WeaponBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(WeaponBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(WeaponBlocks.END_STONE_SAPPHIRE_ORE.get());
                        pOutput.accept(WeaponBlocks.SOUND_BLOCK.get());

                        pOutput.accept(WeaponBlocks.SAPPHIRE_DOOR.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_SLAB.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_STAIRS.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_TRAPDOOR.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_BUTTON.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_WALL.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_FENCE.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_FENCE_GATE.get());
                        pOutput.accept(WeaponBlocks.SAPPHIRE_PRESSURE_PLATE.get());

                        pOutput.accept(WeaponBlocks.WEAPON_FORGE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
