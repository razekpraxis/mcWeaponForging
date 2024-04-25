package net.razek.weapon_forging.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.custom.ForgeBlock;
import net.razek.weapon_forging.item.WeaponItems;

import java.util.function.Supplier;

public class WeaponBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WeaponForging.MOD_ID);


    // List of blocks

    public static final RegistryObject<Block> WEAPON_FORGE = registerBlock("weapon_forge",
            () -> new ForgeBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICK_SLAB)));



    // End list of blocks



    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return WeaponItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
