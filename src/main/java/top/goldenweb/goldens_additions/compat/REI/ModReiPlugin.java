package top.goldenweb.goldens_additions.compat.REI;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;
import top.goldenweb.goldens_additions.recipe.PolymerizationRecipe;


public class ModReiPlugin implements REIClientPlugin {
    public ModReiPlugin(){}
    public static final CategoryIdentifier<ModReiDisplay> POLYMERIZING = CategoryIdentifier.of(Goldens_additions.MOD_ID,"polymerizing");



    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ModReiCategory());
        registry.addWorkstations(POLYMERIZING, EntryStacks.of(AllblocksRegister.POLYMERIZATION_MACHINE));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(PolymerizationRecipe.class,ModReiDisplay::new);
    }
}
