
package com.cawfee83.stowcraft;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Stowcraft.MODID)
public class Stowcraft {

    public static final String MODID = "stowcraft";

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

    public static final DeferredRegister<net.minecraft.sounds.SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);

    public static final RegistryObject<net.minecraft.sounds.SoundEvent> SATCHEL_OPEN =
            SOUNDS.register("satchel_open", () -> new net.minecraft.sounds.SoundEvent(new net.minecraft.resources.ResourceLocation(MODID, "satchel_open")));
    public static final RegistryObject<net.minecraft.sounds.SoundEvent> SATCHEL_CLOSE =
            SOUNDS.register("satchel_close", () -> new net.minecraft.sounds.SoundEvent(new net.minecraft.resources.ResourceLocation(MODID, "satchel_close")));

    public static final RegistryObject<Block> LEATHER_SATCHEL =
            BLOCKS.register("leather_satchel",
                    () -> new LeatherSatchelBlock(
                            BlockBehaviour.Properties.of(Material.WOOD)
                                    .strength(2.0F)
                                    .noOcclusion()));

    public static final RegistryObject<Item> LEATHER_SATCHEL_ITEM =
            ITEMS.register("leather_satchel",
                    () -> new BlockItem(
                            LEATHER_SATCHEL.get(),
                            new Item.Properties()
                                    .tab(CreativeModeTab.TAB_DECORATIONS)) {
                        @Override
                        public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                            consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                                private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                                @Override
                                public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                                    if (renderer == null) renderer = new LeatherSatchelItemRenderer();
                                    return renderer;
                                }
                            });
                        }
                    });

    public static final RegistryObject<BlockEntityType<LeatherSatchelBlockEntity>>
            LEATHER_SATCHEL_ENTITY =
            BLOCK_ENTITIES.register("leather_satchel",
                    () -> BlockEntityType.Builder.of(
                            LeatherSatchelBlockEntity::new,
                            LEATHER_SATCHEL.get()
                    ).build(null));

    public static final RegistryObject<Block> STONE_BRICK_COFFER =
            BLOCKS.register("stone_brick_coffer",
                    () -> new StoneBrickCofferBlock(
                            BlockBehaviour.Properties.of(Material.STONE)
                                    .strength(2.0F, 6.0F).requiresCorrectToolForDrops().sound(net.minecraft.world.level.block.SoundType.STONE)
                                    .noOcclusion()));

    public static final RegistryObject<Item> STONE_BRICK_COFFER_ITEM =
            ITEMS.register("stone_brick_coffer",
                    () -> new BlockItem(
                            STONE_BRICK_COFFER.get(),
                            new Item.Properties()
                                    .tab(CreativeModeTab.TAB_DECORATIONS)) {
                        @Override
                        public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                            consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                                private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                                @Override
                                public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                                    if (renderer == null) renderer = new StoneBrickCofferItemRenderer();
                                    return renderer;
                                }
                            });
                        }
                    });

    public static final RegistryObject<BlockEntityType<StoneBrickCofferBlockEntity>>
            STONE_BRICK_COFFER_ENTITY =
            BLOCK_ENTITIES.register("stone_brick_coffer",
                    () -> BlockEntityType.Builder.of(
                            StoneBrickCofferBlockEntity::new,
                            STONE_BRICK_COFFER.get()
                    ).build(null));

    public static final DeferredRegister<net.minecraft.world.inventory.MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);
    public static final RegistryObject<net.minecraft.world.inventory.MenuType<SatchelMenu>> SATCHEL_MENU = MENUS.register("satchel", () -> net.minecraftforge.common.extensions.IForgeMenuType.create(SatchelMenu::new));

    public Stowcraft(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        SOUNDS.register(modEventBus);
        MENUS.register(modEventBus);
        SatchelNetwork.init();
    }
}
