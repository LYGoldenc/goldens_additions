package top.goldenweb.goldens_additions.items.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import top.goldenweb.goldens_additions.items.AllitemsRegister;


public class VoidArmorMaterial implements ArmorMaterial {


    private static final int[] PROTECTION_AMOUNT = new int[] {4, 5, 7, 3};
    private static final int[] DURABILITY = new int[]{50,70,80,60};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return DURABILITY[slot.getEntitySlotId()]*30;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_AMOUNT[slot.getEntitySlotId()]*2;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AllitemsRegister.REFINING_VOID_MIXTURE);
    }

    @Override
    public String getName() {
        return "void_armor";
    }

    @Override
    public float getToughness() {
        return 4f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2f;
    }
}
