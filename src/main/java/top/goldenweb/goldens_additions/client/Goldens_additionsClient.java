package top.goldenweb.goldens_additions.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import top.goldenweb.goldens_additions.client.armor.VoidAemorRenderer;
import top.goldenweb.goldens_additions.client.blockentity.PolymerizationMachineRenderer;
import top.goldenweb.goldens_additions.client.blockitem.PolymerizationMachineItemRenderer;
import top.goldenweb.goldens_additions.client.item.CBookItemRenderer;
import top.goldenweb.goldens_additions.client.tool.*;
import top.goldenweb.goldens_additions.entities.blocks.AllBlockEntities;
import top.goldenweb.goldens_additions.items.AllitemsRegister;
import top.goldenweb.goldens_additions.screen.PolymerizationMachineScreen;
import top.goldenweb.goldens_additions.screen.handler.ScreenHandlerRegister;

@Environment(EnvType.CLIENT)
public class Goldens_additionsClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        GeoArmorRenderer.registerArmorRenderer(new VoidAemorRenderer(), AllitemsRegister.VOID_BOOTS,
                AllitemsRegister.VOID_LEGGINGS, AllitemsRegister.VOID_CHESTPLATE,AllitemsRegister.VOID_CHESTPLATE_GLIDE, AllitemsRegister.VOID_HELMET);
        GeoItemRenderer.registerItemRenderer(AllitemsRegister.VOID_SWORD,new VoidSwordRenderer());
        GeoItemRenderer.registerItemRenderer(AllitemsRegister.VOID_PICKAXE,new VoidPickaxeRenderer());
        GeoItemRenderer.registerItemRenderer(AllitemsRegister.VOID_AXE,new VoidAxeRenderer());
        GeoItemRenderer.registerItemRenderer(AllitemsRegister.VOID_HOE,new VoidHoeRenderer());
        GeoItemRenderer.registerItemRenderer(AllitemsRegister.VOID_SHOVEL,new VoidShovelRenderer());
        GeoItemRenderer.registerItemRenderer(AllitemsRegister.POLYMERIZATION_MACHINE_ITEM,new PolymerizationMachineItemRenderer());
        BlockEntityRendererFactories.register(AllBlockEntities.PLYMERIZATION_MACHINE_ENTITY, PolymerizationMachineRenderer::new);
        HandledScreens.register(ScreenHandlerRegister.POLYMERIZATION_MACHINE_HANDLER_SCREEN_HANDLER, PolymerizationMachineScreen::new);
        GeoItemRenderer.registerItemRenderer(AllitemsRegister.ANCIENT_NOTES,new CBookItemRenderer());


    }
}
