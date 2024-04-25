package net.razek.weapon_forging.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.WeaponBlocks;

import java.util.Locale;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WeaponForging.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        cubeBottomUp(WeaponBlocks.WEAPON_FORGE, "weapon_forge", modLoc("block/weapon_forge_side"), modLoc("block/weapon_forge_bottom"), modLoc("block/weapon_forge_top"));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    // takes in the block, the name of the block's root name (i.e. weapon_forge), and then the resource location (string defined by modLoc) of the side, bottom, and top textures
    private void cubeBottomUp(RegistryObject<Block> blockRegistryObject, String name, ResourceLocation textureSide, ResourceLocation textureBottom, ResourceLocation textureUp) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeBottomTop(name, textureSide, textureBottom, textureUp));
    }

}