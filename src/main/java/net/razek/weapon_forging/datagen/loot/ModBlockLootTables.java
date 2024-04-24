package net.razek.weapon_forging.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.block.WeaponBlocks;
import net.razek.weapon_forging.item.WeaponItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return WeaponBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator; // iterates over all known blocks in WeaponBlocks
    }

    @Override
    protected void generate() {
        // blocks that will only always drop themselves
        this.dropSelf(WeaponBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(WeaponBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(WeaponBlocks.SOUND_BLOCK.get());
        this.dropSelf(WeaponBlocks.SAPPHIRE_FENCE.get());
        this.dropSelf(WeaponBlocks.SAPPHIRE_FENCE_GATE.get());
        this.dropSelf(WeaponBlocks.SAPPHIRE_WALL.get());
        this.dropSelf(WeaponBlocks.SAPPHIRE_BUTTON.get());
        this.dropSelf(WeaponBlocks.SAPPHIRE_TRAPDOOR.get());
        this.dropSelf(WeaponBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.dropSelf(WeaponBlocks.SAPPHIRE_STAIRS.get());

        // blocks that drop things other than themselves
        this.add(WeaponBlocks.SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(WeaponBlocks.SAPPHIRE_ORE.get(), WeaponItems.RAW_SAPPHIRE.get()));

        this.add(WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), WeaponItems.RAW_SAPPHIRE.get()));

        this.add(WeaponBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(WeaponBlocks.NETHER_SAPPHIRE_ORE.get(), WeaponItems.RAW_SAPPHIRE.get()));

        this.add(WeaponBlocks.END_STONE_SAPPHIRE_ORE.get(),
                block -> createCopperLikeOreDrops(WeaponBlocks.END_STONE_SAPPHIRE_ORE.get(), WeaponItems.RAW_SAPPHIRE.get()));

        this.add(WeaponBlocks.SAPPHIRE_SLAB.get(),
                block -> createSlabItemTable(WeaponBlocks.SAPPHIRE_SLAB.get()));

        this.add(WeaponBlocks.SAPPHIRE_DOOR.get(),
                block -> createDoorTable(WeaponBlocks.SAPPHIRE_DOOR.get()));
    }


    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                    LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

}
