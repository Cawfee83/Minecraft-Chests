package com.cawfee83.stowcraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.resources.ResourceLocation;
public class SatchelScreen extends AbstractContainerScreen<SatchelMenu> {
    private static final ResourceLocation BG=new ResourceLocation("textures/gui/container/generic_54.png");
    private EditBox label;
    public SatchelScreen(SatchelMenu menu, Inventory inv, Component title) {
        super(menu,inv,title);
        imageHeight=195;
        inventoryLabelY=72;
    }
    @Override protected void init(){
        super.init();
        label=new EditBox(font,leftPos+8,topPos+171,112,16,Component.literal("Nameplate"));
        label.setMaxLength(24);
        if(minecraft.level.getBlockEntity(menu.pos) instanceof LeatherSatchelBlockEntity s) label.setValue(s.getLabel());
        label.setFilter(value -> font.width(value) <= Math.max(font.width("Building Blocks"), font.width(label.getValue())));
        addRenderableWidget(label);
        addRenderableWidget(new Button(leftPos+124,topPos+170,44,18,Component.literal("Save"),b->save()));
    }
    private void save(){SatchelNetwork.CHANNEL.sendToServer(new SatchelNetwork.Rename(menu.containerId,label.getValue()));}
    @Override protected void renderBg(PoseStack p,float partial,int x,int y){
        RenderSystem.setShaderTexture(0,BG);
        blit(p,leftPos,topPos,0,0,176,71);
        blit(p,leftPos,topPos+71,0,126,176,95);
        fill(p,leftPos,topPos+166,leftPos+176,topPos+195,0xff000000);
        fill(p,leftPos+1,topPos+166,leftPos+175,topPos+194,0xff555555);
        fill(p,leftPos+2,topPos+166,leftPos+174,topPos+192,0xffc6c6c6);
        fill(p,leftPos+1,topPos+166,leftPos+3,topPos+192,0xffffffff);
        fill(p,leftPos+3,topPos+192,leftPos+173,topPos+194,0xff555555);
    }
    @Override public void render(PoseStack p,int x,int y,float partial){
        renderBackground(p);super.render(p,x,y,partial);renderTooltip(p,x,y);
    }
    @Override public boolean keyPressed(int key,int scan,int mods){
        if(label.isFocused() && key!=256){
            if(key==257 || key==335){save();label.setFocus(false);return true;}
            label.keyPressed(key,scan,mods);return true;
        }
        return super.keyPressed(key,scan,mods);
    }
    @Override public boolean charTyped(char c,int mods){return label.isFocused()?label.charTyped(c,mods):super.charTyped(c,mods);}
    @Override protected void renderLabels(PoseStack p,int x,int y){
        String name=title.getString();
        if(minecraft.level.getBlockEntity(menu.pos) instanceof LeatherSatchelBlockEntity s && !s.getLabel().isEmpty()) name=s.getLabel();
        font.draw(p,name,8,6,0x404040);
        font.draw(p,playerInventoryTitle,8,inventoryLabelY,0x404040);
    }
}
