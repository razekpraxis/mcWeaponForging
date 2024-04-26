package net.razek.weapon_forging;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.razek.weapon_forging.block.WeaponBlocks;
import net.razek.weapon_forging.block.entity.WeaponBlockEntities;
import net.razek.weapon_forging.item.ModCreativeModeTabs;
import net.razek.weapon_forging.item.WeaponItems;
import net.razek.weapon_forging.screen.WeaponForgeScreen;
import net.razek.weapon_forging.screen.WeaponMenuTypes;
import net.razek.weapon_forging.sound.WeaponSounds;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WeaponForging.MOD_ID)
public class WeaponForging
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "weapon_forging";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public WeaponForging()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        WeaponItems.register(modEventBus);
        WeaponBlocks.register(modEventBus);
        WeaponSounds.register(modEventBus);

        WeaponBlockEntities.register(modEventBus);
        WeaponMenuTypes.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){
                MenuScreens.register(WeaponMenuTypes.WEAPON_FORGE_MENU.get(), WeaponForgeScreen::new);
                }
    }
}
