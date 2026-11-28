package com.cawfee83.stowcraft.compat;

import com.cawfee83.stowcraft.DisplayCaseScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.handlers.IGhostIngredientHandler;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import java.util.List;

/** Loaded by JEI only; no common Stowcraft code references this class. */
@JeiPlugin
public final class StowcraftJeiPlugin implements IModPlugin {
    @Override public ResourceLocation getPluginUid() {
        return new ResourceLocation("stowcraft", "display_cases");
    }
    @Override public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addGhostIngredientHandler(DisplayCaseScreen.class, new IGhostIngredientHandler<DisplayCaseScreen>() {
            @Override public <I> List<Target<I>> getTargets(DisplayCaseScreen screen, I ingredient, boolean doStart) {
                if (!(ingredient instanceof ItemStack stack) || stack.isEmpty()) return List.of();
                return List.of(new Target<I>() {
                    @Override public Rect2i getArea() { return screen.ghostArea(); }
                    @Override public void accept(I dropped) {
                        if (dropped instanceof ItemStack item) screen.acceptGhost(item);
                    }
                });
            }
            @Override public void onComplete() {}
        });
    }
}
