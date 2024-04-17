package net.razek.weapon_forging.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.WeaponBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WeaponForging.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(WeaponBlocks.SAPPHIRE_BLOCK);
        blockWithItem(WeaponBlocks.RAW_SAPPHIRE_BLOCK);


        blockWithItem(WeaponBlocks.SAPPHIRE_ORE);
        blockWithItem(WeaponBlocks.END_STONE_SAPPHIRE_ORE);
        blockWithItem(WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(WeaponBlocks.NETHER_SAPPHIRE_ORE);
    }

    private void blockWithItem (RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
