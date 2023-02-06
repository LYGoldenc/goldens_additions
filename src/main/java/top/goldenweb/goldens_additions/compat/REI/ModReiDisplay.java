package top.goldenweb.goldens_additions.compat.REI;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import top.goldenweb.goldens_additions.recipe.PolymerizationRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ModReiDisplay extends BasicDisplay {


    private final EntryIngredient carrier;
    private final int time;

    public ModReiDisplay(PolymerizationRecipe recipe){
        super(EntryIngredients.ofIngredients(recipe.getIngredients()),
                Collections.singletonList(EntryIngredients.of(recipe.getOutput())),
                Optional.ofNullable(recipe.getId()));
        carrier = EntryIngredients.of(recipe.getCarrier());
        time = recipe.getTime();
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        List<EntryIngredient> inputEntryList = new ArrayList<>(super.getInputEntries());
        inputEntryList.add(getCarrier());

        return ImmutableList.copyOf(inputEntryList);
    }

    public List<EntryIngredient> getIngredientEntries() {
        return super.getInputEntries();
    }


    public EntryIngredient getCarrier() {
        return carrier;
    }

    public int getTime() {
        return time;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ModReiPlugin.POLYMERIZING;
    }
}
