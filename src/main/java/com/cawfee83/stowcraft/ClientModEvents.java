
package com.cawfee83.stowcraft;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = Stowcraft.MODID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void setup(net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent event) {
        event.enqueueWork(() -> net.minecraft.client.gui.screens.MenuScreens.register(Stowcraft.SATCHEL_MENU.get(), SatchelScreen::new));
    }

    @SubscribeEvent
    public static void registerRenderers(
            EntityRenderersEvent.RegisterRenderers event) {

        event.registerBlockEntityRenderer(
                Stowcraft.LEATHER_SATCHEL_ENTITY.get(),
                LeatherSatchelRenderer::new);
        event.registerBlockEntityRenderer(Stowcraft.STONE_BRICK_COFFER_ENTITY.get(), StoneBrickCofferRenderer::new);
        event.registerBlockEntityRenderer(Stowcraft.LOG_CHEST_ENTITY.get(), LogChestRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(
            EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(
                LeatherSatchelModel.LAYER_LOCATION,
                LeatherSatchelModel::createBodyLayer);
        event.registerLayerDefinition(StoneBrickCofferModel.LAYER_LOCATION, StoneBrickCofferModel::createBodyLayer);
        event.registerLayerDefinition(LogChestModel.LAYER_LOCATION, LogChestModel::createBodyLayer);
    }
}