package com.cawfee83.stowcraft;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

/** Existing 27-slot screen, with a non-inventory sample preview and controls above it. */
public final class DisplayCaseScreen extends SatchelScreen {
    private static final int PREVIEW_X = 80, PREVIEW_Y = -27;
    public DisplayCaseScreen(SatchelMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }
    private void send(int action) {
        DisplayCaseNetwork.CHANNEL.sendToServer(new DisplayCaseNetwork.Action(menu.containerId, action));
    }
    @Override protected void init() {
        super.init();
        addRenderableWidget(new Button(leftPos + 16, topPos - 30, 30, 20,
                Component.literal("-15"), b -> send(3)));
        addRenderableWidget(new Button(leftPos + 116, topPos - 30, 30, 20,
                Component.literal("+15"), b -> send(4)));
        addRenderableWidget(new Button(leftPos + 152, topPos - 30, 24, 20,
                Component.literal("R"), b -> send(2)));
    }
    @Override protected void renderBg(PoseStack pose, float partialTick, int mouseX, int mouseY) {
        super.renderBg(pose, partialTick, mouseX, mouseY);
        int x = leftPos + PREVIEW_X, y = topPos + PREVIEW_Y;
        fill(pose, x - 2, y - 2, x + 20, y + 20, 0xff242424);
        fill(pose, x - 1, y - 1, x + 19, y + 19, 0xff8b8b8b);
        fill(pose, x, y, x + 18, y + 18, 0xff373737);
    }
    @Override public void render(PoseStack pose, int mouseX, int mouseY, float partialTick) {
        super.render(pose, mouseX, mouseY, partialTick);
        if (minecraft.level == null) return;
        if (!(minecraft.level.getBlockEntity(menu.pos) instanceof DisplayCaseBlockEntity entity)) return;
        ItemStack stack = entity.getDisplay();
        if (!stack.isEmpty()) {
            itemRenderer.renderAndDecorateItem(stack, leftPos + PREVIEW_X + 1, topPos + PREVIEW_Y + 1);
            if (mouseX >= leftPos + PREVIEW_X && mouseX < leftPos + PREVIEW_X + 18 &&
                    mouseY >= topPos + PREVIEW_Y && mouseY < topPos + PREVIEW_Y + 18) {
                renderTooltip(pose, stack, mouseX, mouseY);
            }
        }
    }
    private int ghostMouseButton = -1;

    @Override protected boolean hasClickedOutside(double mouseX, double mouseY, int left, int top, int button) {
        // The controls above the vanilla chest are part of this screen, not the drop area.
        if (mouseX >= left && mouseX < left + imageWidth &&
                mouseY >= top - 32 && mouseY < top) return false;
        return super.hasClickedOutside(mouseX, mouseY, left, top, button);
    }

    @Override public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == ghostMouseButton) {
            ghostMouseButton = -1;
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override public boolean mouseDragged(double mouseX, double mouseY, int button, double dx, double dy) {
        if (button == ghostMouseButton) return true;
        return super.mouseDragged(mouseX, mouseY, button, dx, dy);
    }

    @Override public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (mouseX >= leftPos + PREVIEW_X && mouseX < leftPos + PREVIEW_X + 18 &&
                mouseY >= topPos + PREVIEW_Y && mouseY < topPos + PREVIEW_Y + 18) {
            ghostMouseButton = button;
            if (button == 1) send(1);
            else if (button == 0) send(0);
            return true;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
}
