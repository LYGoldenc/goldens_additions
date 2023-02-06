package top.goldenweb.goldens_additions.items.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import top.goldenweb.goldens_additions.items.AllitemsRegister;

public class VoidToolMaterial implements ToolMaterial {

    public static final VoidToolMaterial VOID_TOOL_MATERIAL = new VoidToolMaterial();

    @Override
    public int getDurability() {
        return 3000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 16f;
    }

    @Override
    public float getAttackDamage() {
        return -1;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 24;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AllitemsRegister.REFINING_VOID_MIXTURE);
    }
}
