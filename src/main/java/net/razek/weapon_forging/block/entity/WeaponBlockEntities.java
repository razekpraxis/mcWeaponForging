package net.razek.weapon_forging.block.entity;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.WeaponBlocks;

public class WeaponBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WeaponForging.MOD_ID);

    public static final RegistryObject<BlockEntityType<WeaponForgeEntity>> WEAPON_FORGE =
            BLOCK_ENTITIES.register("weapon_forge", ()->
                    BlockEntityType.Builder.of(WeaponForgeEntity::new,
                            WeaponBlocks.WEAPON_FORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
