package net.razek.weapon_forging.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.razek.weapon_forging.WeaponForging;
import net.razek.weapon_forging.block.WeaponBlocks;
import net.razek.weapon_forging.item.WeaponItems;

import java.util.Iterator;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(WeaponItems.RAW_SAPPHIRE.get(),
            WeaponBlocks.SAPPHIRE_ORE.get(),
            WeaponBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            WeaponBlocks.NETHER_SAPPHIRE_ORE.get(),
            WeaponBlocks.END_STONE_SAPPHIRE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreSmelting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, (ItemLike) WeaponItems.SAPPHIRE.get(), 0.25F, 200, "sapphire");
        oreBlasting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, (ItemLike) WeaponItems.SAPPHIRE.get(), 0.25F, 100, "sapphire");

        // shaped recipe for sapphire block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WeaponBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', WeaponItems.SAPPHIRE.get())
                .unlockedBy(getHasName(WeaponItems.SAPPHIRE.get()), has(WeaponItems.SAPPHIRE.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WeaponBlocks.WEAPON_FORGE.get())
                        .pattern("ADA")
                        .pattern("DAD")
                        .pattern("ADA")
                        .define('D', Items.DIAMOND)
                        .define('A', Items.DIRT)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(recipeOutput);

        // Shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, WeaponItems.SAPPHIRE.get(), 9)
                .requires(WeaponBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(WeaponBlocks.SAPPHIRE_BLOCK.get()), has(WeaponBlocks.SAPPHIRE_BLOCK.get()))
                .save(recipeOutput);
    }


    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, WeaponForging.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
