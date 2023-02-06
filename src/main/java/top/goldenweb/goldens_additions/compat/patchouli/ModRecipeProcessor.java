package top.goldenweb.goldens_additions.compat.patchouli;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import top.goldenweb.goldens_additions.recipe.PolymerizationRecipe;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

public class ModRecipeProcessor  implements IComponentProcessor {

    private PolymerizationRecipe recipe;
    private String text;

    @Override
    public void setup(@NotNull IVariableProvider variables) {
        String recipeId = variables.get("recipe").asString();
        assert MinecraftClient.getInstance().world != null;
        recipe = (PolymerizationRecipe) MinecraftClient.getInstance().world.getRecipeManager()
                .get(new Identifier(recipeId))
                .orElseThrow(() -> new IllegalArgumentException("Unkown recipe: " + recipeId));

        if (variables.has("text")) text = variables.get("text").asString();
    }

    @Override
    public IVariable process(@NotNull String key) {
        if (key.startsWith("inputs")) {
            int index = Integer.parseInt(key.substring(6));
            Ingredient ingredient = recipe.getIngredients().get(index);
            ItemStack[] stacks = ingredient.getMatchingStacks();
            return IVariable.from(stacks);
        } else if (key.equals("time")) {
            return IVariable.from(Text.of(recipe.getTime() / 20 + "s"));
        } else if (key.equals("output")) {
            return IVariable.from(new ItemStack[]{recipe.getOutput()});
        } else if (key.equals("title")) {
            return IVariable.from(recipe.getOutput().getName());
        } else if (key.equals("text")) {
            return IVariable.from(Text.of(text));
        } else if (key.equals("carrier")){
            return IVariable.from(new ItemStack[]{recipe.getCarrier()});
        }else {
            return null;
        }
    }
}
