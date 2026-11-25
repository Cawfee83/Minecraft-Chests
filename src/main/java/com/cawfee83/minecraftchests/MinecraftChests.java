
package com.cawfee83.minecraftchests;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MinecraftChests.MODID)
public class MinecraftChests {

    public static final String MODID = "minecraftchests";

    public MinecraftChests(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
    }
}