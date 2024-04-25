package net.razek.weapon_forging.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class WeaponFoods {

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(3).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.2f).build();
}
