package top.goldenweb.goldens_additions.recipe;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;

import java.util.ArrayList;
import java.util.List;

public class PolymerizationRecipe implements Recipe<SimpleInventory> {

    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> inputs;
    private final ItemStack carrier;
    private final int time;



    public PolymerizationRecipe(Identifier id, ItemStack output, DefaultedList<Ingredient> inputs, ItemStack carrier, int time) {
        this.id = id;
        this.output = output;
        this.inputs = inputs;
        this.carrier = carrier;
        this.time = time;

    }

    public int getTime() {
        return time;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        List<ItemStack> testList = new ArrayList<>();

        for (int i = 0; i < inventory.size(); i++) {
            testList.add(inventory.getStack(i));
        }

        return carrier.getItem()==inventory.getStack(4).getItem()&&inputs.stream().allMatch(ingredient -> {
            for (int i = 0; i < testList.size(); i++) {
                if (ingredient.test(testList.get(i))) {
                    testList.remove(i);
                    return true;
                }
            }
            return false;
        });
    }


    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    public ItemStack getCarrier() {
        return this.carrier;
    }

    @Override
    public Identifier getId() {
        return this.id;
    }
    @Environment(EnvType.CLIENT)
    @Override
    public ItemStack createIcon() {
        return new ItemStack(AllblocksRegister.POLYMERIZATION_MACHINE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return PolymerizationSerializer.POLYMERIZATION_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.POLYMERIZATION_RECIPE;
    }
    public static class Type implements RecipeType<PolymerizationRecipe> {
        private Type() { }
        public static final Type POLYMERIZATION_RECIPE = new Type();
        public static final String ID = "polymerizing";
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        return inputs;
    }

    @Override
    public boolean isIgnoredInRecipeBook() {
        return true;
    }
}

