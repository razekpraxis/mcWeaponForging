package net.razek.weapon_forging.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.razek.weapon_forging.WeaponForging;

public class WeaponSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WeaponForging.MOD_ID);

    public static final RegistryObject<SoundEvent> BEGIN_CRAFT = registerSoundEvents("begin_craft");
    public static final RegistryObject<SoundEvent> COMPLETE_CRAFT = registerSoundEvents("complete_craft");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () ->SoundEvent.createVariableRangeEvent(new ResourceLocation(WeaponForging.MOD_ID, name)));
    }



    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
