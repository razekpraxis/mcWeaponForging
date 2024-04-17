package net.razek.weapon_forging.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;
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
        simpleItem(WeaponItems.STRAWBERRY);
        simpleItem(WeaponItems.PINE_CONE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(WeaponForging.MOD_ID, "item/" + item.getId().getPath()));
    }
}
