package top.goldenweb.goldens_additions.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.goldenweb.goldens_additions.items.AllitemsRegister;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {
    @Inject(at=@At("HEAD"),method = "registerDefaults")
    private static void registerDefaults(CallbackInfo ci){
        BrewingRecipeRegistryMixin.registerPotionRecipe(Potions.AWKWARD, Items.ENCHANTED_GOLDEN_APPLE,
                AllitemsRegister.SELLINGSOUL);
    }
    @Invoker("registerPotionRecipe")
    public static void registerPotionRecipe(Potion input, Item item,Potion output) {

    }
}
