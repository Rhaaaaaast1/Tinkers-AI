package dev.rhaaaaaast1.tinkersaddition;

import com.mojang.logging.LogUtils;
import dev.rhaaaaaast1.tinkersaddition.tinkers.TinkersIntegration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Tinkersaddition.MODID)
public class Tinkersaddition {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tinkersai";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Tinkersaddition() {
        // Register the commonSetup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Tinkers' Construct is optional: only hook its loot/AI integration when the mod is actually loaded
        if (TinkersIntegration.isLoaded()) {
            TinkersIntegration.register();
            LOGGER.info("Tinkers' Construct detected - mob equipment and ranged attack AI enabled");
        } else {
            LOGGER.info("Tinkers' Construct not installed - mob equipment and ranged attack AI disabled");
        }
    }
}
