package top.goldenweb.goldens_additions;


import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;
import top.goldenweb.goldens_additions.config.ConfigRegister;
import top.goldenweb.goldens_additions.effects.AllEffectsRegister;
import top.goldenweb.goldens_additions.enchantments.AllERgister;
import top.goldenweb.goldens_additions.entities.blocks.AllBlockEntities;
import top.goldenweb.goldens_additions.items.AllitemsRegister;
import top.goldenweb.goldens_additions.loot_table.AllLoottableRegister;
import top.goldenweb.goldens_additions.recipe.AllRecipeRegister;
import top.goldenweb.goldens_additions.screen.handler.ScreenHandlerRegister;
import top.goldenweb.goldens_additions.world.AllWorldgenRegister;
import top.goldenweb.goldens_additions.world.dimension.StillGarden;


public class Goldens_additions implements ModInitializer {

    public static final String MOD_ID = "goldens_additions";

    public static final Logger LOGGER = LogUtils.getLogger();
    public static final ItemGroup TAB = FabricItemGroupBuilder.build(new Identifier(MOD_ID,"items"),
            () -> new ItemStack(AllitemsRegister.SUPER_LOLLIPOP));


    @Override
    public void onInitialize() {
        ConfigRegister.register();
        AllblocksRegister.register();
        AllitemsRegister.register();
        AllWorldgenRegister.register();
        StillGarden.register();
        FuelRegistry.INSTANCE.add(AllitemsRegister.BAMBOO_COAL,400);
        FuelRegistry.INSTANCE.add(AllitemsRegister.BAMBOO_COAL_BUNDLE,1600);
        AllLoottableRegister.register();
        AllBlockEntities.register();
        AllERgister.register();
        AllEffectsRegister.register();
        ScreenHandlerRegister.register();
        AllRecipeRegister.register();

    }
}
