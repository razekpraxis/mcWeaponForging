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
        blockWithItem(WeaponBlocks.SAPPHIRE_BLOCK);
        blockWithItem(WeaponBlocks.RAW_SAPPHIRE_BLOCK);

        blockWithItem(WeaponBlocks.SAPPHIRE_ORE);
        blockWithItem(WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(WeaponBlocks.END_STONE_SAPPHIRE_ORE);
        blockWithItem(WeaponBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(WeaponBlocks.SOUND_BLOCK);

        cubeBottomUp(WeaponBlocks.WEAPON_FORGE, "weapon_forge", modLoc("block/weapon_forge_side"), modLoc("block/weapon_forge_bottom"), modLoc("block/weapon_forge_top"));

        stairsBlock(((StairBlock) WeaponBlocks.SAPPHIRE_STAIRS.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get())); //stairs
        slabBlock(((SlabBlock) WeaponBlocks.SAPPHIRE_SLAB.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get())); //slabs
        buttonBlock(((ButtonBlock) WeaponBlocks.SAPPHIRE_BUTTON.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get())); //button
        pressurePlateBlock(((PressurePlateBlock) WeaponBlocks.SAPPHIRE_PRESSURE_PLATE.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get())); //pressure plate
        fenceBlock(((FenceBlock) WeaponBlocks.SAPPHIRE_FENCE.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get())); //fence
        fenceGateBlock(((FenceGateBlock) WeaponBlocks.SAPPHIRE_FENCE_GATE.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get())); //fence gate
        wallBlock(((WallBlock) WeaponBlocks.SAPPHIRE_WALL.get()), blockTexture(WeaponBlocks.SAPPHIRE_BLOCK.get())); //wall
        doorBlockWithRenderType(((DoorBlock) WeaponBlocks.SAPPHIRE_DOOR.get()), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout"); //door
        trapdoorBlockWithRenderType(((TrapDoorBlock) WeaponBlocks.SAPPHIRE_TRAPDOOR.get()), modLoc("block/sapphire_door_bottom"), true, "cutout"); //trapdoor

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    // takes in the block, the name of the block's root name (i.e. weapon_forge), and then the resource location (string defined by modLoc) of the side, bottom, and top textures
    private void cubeBottomUp(RegistryObject<Block> blockRegistryObject, String name, ResourceLocation textureSide, ResourceLocation textureBottom, ResourceLocation textureUp) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeBottomTop(name, textureSide, textureBottom, textureUp));
    }

}