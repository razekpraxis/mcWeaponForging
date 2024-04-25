package net.razek.weapon_forging.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.WeaponBlocks;
import net.razek.weapon_forging.item.WeaponItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WeaponForging.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(WeaponItems.SAPPHIRE);
        simpleItem(WeaponItems.RAW_SAPPHIRE);

        simpleItem(WeaponItems.METAL_DETECTOR);
        simpleItem(WeaponItems.PINE_CONE);
        simpleItem(WeaponItems.STRAWBERRY);

        simpleBlockItem(WeaponBlocks.SAPPHIRE_DOOR);

        fenceItem(WeaponBlocks.SAPPHIRE_FENCE, WeaponBlocks.SAPPHIRE_BLOCK);
        buttonItem(WeaponBlocks.SAPPHIRE_BUTTON, WeaponBlocks.SAPPHIRE_BLOCK);
        wallItem(WeaponBlocks.SAPPHIRE_WALL, WeaponBlocks.SAPPHIRE_BLOCK);

        evenSimplerBlockItem(WeaponBlocks.SAPPHIRE_STAIRS);
        evenSimplerBlockItem(WeaponBlocks.SAPPHIRE_SLAB);
        evenSimplerBlockItem(WeaponBlocks.SAPPHIRE_PRESSURE_PLATE);
        evenSimplerBlockItem(WeaponBlocks.SAPPHIRE_FENCE_GATE);

        trapdoorItem(WeaponBlocks.SAPPHIRE_TRAPDOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(WeaponForging.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(WeaponForging.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(WeaponForging.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(WeaponForging.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(WeaponForging.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(WeaponForging.MOD_ID,"item/" + item.getId().getPath()));
    }
}


