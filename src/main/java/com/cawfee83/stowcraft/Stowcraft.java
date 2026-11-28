
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

    public static final RegistryObject<net.minecraft.sounds.SoundEvent> COFFER_OPEN =
            SOUNDS.register("coffer_open", () -> new net.minecraft.sounds.SoundEvent(new net.minecraft.resources.ResourceLocation(MODID, "coffer_open")));
    public static final RegistryObject<net.minecraft.sounds.SoundEvent> COFFER_CLOSE =
            SOUNDS.register("coffer_close", () -> new net.minecraft.sounds.SoundEvent(new net.minecraft.resources.ResourceLocation(MODID, "coffer_close")));

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

    public static final java.util.List<RegistryObject<Block>> STONE_COFFERS = new java.util.ArrayList<>();
    static {
        STONE_COFFERS.add(STONE_BRICK_COFFER);
        for (String material : new String[]{"deepslate","blackstone","quartz","sandstone"}) {
            String name = material + "_coffer";
            RegistryObject<Block> block = BLOCKS.register(name, () -> new StoneBrickCofferBlock(
                BlockBehaviour.Properties.of(Material.STONE).strength(2.0F, 6.0F).requiresCorrectToolForDrops().sound(net.minecraft.world.level.block.SoundType.STONE).noOcclusion()));
            STONE_COFFERS.add(block);
            ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)) {
                @Override public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                    consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                        private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                        @Override public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                            if (renderer == null) renderer = new StoneBrickCofferItemRenderer();
                            return renderer;
                        }
                    });
                }
            });
        }
    }

    public static final RegistryObject<BlockEntityType<StoneBrickCofferBlockEntity>>
            STONE_BRICK_COFFER_ENTITY =
            BLOCK_ENTITIES.register("stone_brick_coffer",
                    () -> BlockEntityType.Builder.of(
                            StoneBrickCofferBlockEntity::new,
                            STONE_COFFERS.stream().map(RegistryObject::get).toArray(Block[]::new)
                    ).build(null));

    public static final java.util.List<RegistryObject<Block>> LOG_CHESTS = new java.util.ArrayList<>();
    static {
        for (String wood : new String[]{"oak","spruce","birch","jungle","acacia","dark_oak"}) {
            String name = wood + "_log_chest";
            RegistryObject<Block> block = BLOCKS.register(name, () -> new LogChestBlock(
                BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(net.minecraft.world.level.block.SoundType.WOOD).noOcclusion()));
            LOG_CHESTS.add(block);
            ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)) {
                @Override public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                    consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                        private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                        @Override public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                            if (renderer == null) renderer = new LogChestItemRenderer();
                            return renderer;
                        }
                    });
                }
            });
        }
    }
    public static final RegistryObject<BlockEntityType<LogChestBlockEntity>> LOG_CHEST_ENTITY =
        BLOCK_ENTITIES.register("log_chest", () -> BlockEntityType.Builder.of(LogChestBlockEntity::new,
            LOG_CHESTS.stream().map(RegistryObject::get).toArray(Block[]::new)).build(null));

    public static final java.util.List<RegistryObject<Block>> METAL_CHESTS = new java.util.ArrayList<>();
    static {
        for (String wood : new String[]{"iron","copper","gold"}) {
            String name = wood + "_chest";
            RegistryObject<Block> block = BLOCKS.register(name, () -> new MetalChestBlock(
                BlockBehaviour.Properties.of(Material.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops().sound(net.minecraft.world.level.block.SoundType.METAL).noOcclusion()));
            METAL_CHESTS.add(block);
            ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)) {
                @Override public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                    consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                        private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                        @Override public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                            if (renderer == null) renderer = new MetalChestItemRenderer();
                            return renderer;
                        }
                    });
                }
            });
        }
    }
    public static final RegistryObject<BlockEntityType<MetalChestBlockEntity>> METAL_CHEST_ENTITY =
        BLOCK_ENTITIES.register("metal_chest", () -> BlockEntityType.Builder.of(MetalChestBlockEntity::new,
            METAL_CHESTS.stream().map(RegistryObject::get).toArray(Block[]::new)).build(null));


    public static final java.util.List<RegistryObject<Block>> MINERAL_CHESTS = new java.util.ArrayList<>();
    static {
        for (String mineral : new String[]{"redstone", "lapis"}) {
            String name = mineral + "_chest";
            RegistryObject<Block> block = BLOCKS.register(name, () -> new MineralChestBlock(
                    BlockBehaviour.Properties.of(Material.STONE).strength(3.5F, 6.0F)
                            .requiresCorrectToolForDrops().sound(net.minecraft.world.level.block.SoundType.STONE)
                            .noOcclusion()));
            MINERAL_CHESTS.add(block);
            ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)) {
                @Override
                public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                    consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                        private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                        @Override
                        public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                            if (renderer == null) renderer = new MineralChestItemRenderer();
                            return renderer;
                        }
                    });
                }
            });
        }
    }
    public static final RegistryObject<BlockEntityType<MineralChestBlockEntity>> MINERAL_CHEST_ENTITY =
            BLOCK_ENTITIES.register("mineral_chest", () -> BlockEntityType.Builder.of(
                    MineralChestBlockEntity::new,
                    MINERAL_CHESTS.stream().map(RegistryObject::get).toArray(Block[]::new)).build(null));


    public static final java.util.List<RegistryObject<Block>> DISPLAY_CASES = new java.util.ArrayList<>();
    static {
        for (String material : new String[]{"iron","gold","copper","blackstone","diamond","quartz"}) {
            String name = material + "_display_case";
            RegistryObject<Block> block = BLOCKS.register(name, () -> new DisplayCaseBlock(
                    BlockBehaviour.Properties.of(Material.METAL).strength(4.5F,6.0F)
                            .requiresCorrectToolForDrops().sound(net.minecraft.world.level.block.SoundType.GLASS)
                            .noOcclusion()));
            DISPLAY_CASES.add(block);
            ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)) {
                @Override public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                    consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                        private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                        @Override public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                            if (renderer == null) renderer = new DisplayCaseItemRenderer();
                            return renderer;
                        }
                    });
                }
            });
        }
    }
    public static final RegistryObject<BlockEntityType<DisplayCaseBlockEntity>> DISPLAY_CASE_ENTITY =
            BLOCK_ENTITIES.register("display_case", () -> BlockEntityType.Builder.of(
                    DisplayCaseBlockEntity::new,
                    DISPLAY_CASES.stream().map(RegistryObject::get).toArray(Block[]::new)).build(null));


    public static final RegistryObject<Block> FORTRESS_NETHER_BRICK =
            BLOCKS.register("fortress_nether_brick", () -> new FortressChestBlock(
                    BlockBehaviour.Properties.of(Material.STONE)
                            .strength(3.5F, 6.0F).requiresCorrectToolForDrops()
                            .sound(net.minecraft.world.level.block.SoundType.NETHER_BRICKS)
                            .noOcclusion()));

    public static final RegistryObject<Item> FORTRESS_NETHER_BRICK_ITEM =
            ITEMS.register("fortress_nether_brick", () -> new BlockItem(
                    FORTRESS_NETHER_BRICK.get(),
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)) {
                @Override public void initializeClient(
                        java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientItemExtensions> consumer) {
                    consumer.accept(new net.minecraftforge.client.extensions.common.IClientItemExtensions() {
                        private net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer renderer;
                        @Override public net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer getCustomRenderer() {
                            if (renderer == null) renderer = new FortressChestItemRenderer();
                            return renderer;
                        }
                    });
                }
            });

    public static final RegistryObject<BlockEntityType<FortressChestBlockEntity>> FORTRESS_CHEST_ENTITY =
            BLOCK_ENTITIES.register("fortress_chest", () -> BlockEntityType.Builder.of(
                    FortressChestBlockEntity::new, FORTRESS_NETHER_BRICK.get()).build(null));

    public static final DeferredRegister<net.minecraft.world.inventory.MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);
    public static final RegistryObject<net.minecraft.world.inventory.MenuType<SatchelMenu>> SATCHEL_MENU = MENUS.register("satchel", () -> net.minecraftforge.common.extensions.IForgeMenuType.create(SatchelMenu::new));

    public static final RegistryObject<net.minecraft.world.inventory.MenuType<DisplayCaseMenu>> DISPLAY_CASE_MENU = MENUS.register("display_case", () -> net.minecraftforge.common.extensions.IForgeMenuType.create(DisplayCaseMenu::new));

    public Stowcraft(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        SOUNDS.register(modEventBus);
        MENUS.register(modEventBus);
        SatchelNetwork.init();
        DisplayCaseNetwork.init();
    }
}
