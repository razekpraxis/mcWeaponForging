package net.razek.weapon_forging.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.WeaponBlocks;
import net.razek.weapon_forging.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WeaponForging.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(WeaponBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.NEEDS_STONE_TOOL); //List of blocks that need stone or higher tools to mine

        this.tag(BlockTags.NEEDS_IRON_TOOL) //List of blocks that need Iron or higher tools to mine
                .add(WeaponBlocks.SAPPHIRE_BLOCK.get(),
                    WeaponBlocks.SAPPHIRE_ORE.get(),
                    WeaponBlocks.NETHER_SAPPHIRE_ORE.get(),
                    WeaponBlocks.END_STONE_SAPPHIRE_ORE.get(),
                    WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL); //List of blocks that need Gold or higher tools to mine

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL); //List of blocks that need Diamond or higher tools to mine

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL); //List of blocks that need Netherite or higher tools to mine

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE) //List of blocks that require a Pickaxe to mine
                .add(WeaponBlocks.SAPPHIRE_BLOCK.get(),
                        WeaponBlocks.SAPPHIRE_ORE.get(),
                        WeaponBlocks.NETHER_SAPPHIRE_ORE.get(),
                        WeaponBlocks.SOUND_BLOCK.get(),
                        WeaponBlocks.END_STONE_SAPPHIRE_ORE.get(),
                        WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE); //List of blocks that require an Axe to mine

        this.tag(BlockTags.MINEABLE_WITH_HOE); //List of blocks that require a Hoe to mine

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL); //List of blocks that require a Shovel to mine


    }
}
