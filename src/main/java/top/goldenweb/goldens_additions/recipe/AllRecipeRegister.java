package top.goldenweb.goldens_additions.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import top.goldenweb.goldens_additions.Goldens_additions;

public class AllRecipeRegister {

    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(Goldens_additions.MOD_ID, PolymerizationSerializer.ID),
                PolymerizationSerializer.POLYMERIZATION_SERIALIZER);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(Goldens_additions.MOD_ID, PolymerizationRecipe.Type.ID),
                PolymerizationRecipe.Type.POLYMERIZATION_RECIPE);
    }
}
