package top.goldenweb.goldens_additions.utils;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.goldenweb.goldens_additions.items.AllitemsRegister;

public class VoidArmorEquipingUtil {


    public static boolean isWearingVoidHelmet(@NotNull PlayerEntity player)
    {
        ItemStack head = player.getEquippedStack(EquipmentSlot.HEAD);
        return head.getItem() == AllitemsRegister.VOID_HELMET;
    }
    public static boolean isWearingVoidChestplate(@NotNull PlayerEntity player)
    {
        ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
        return chest.getItem() == AllitemsRegister.VOID_CHESTPLATE || chest.getItem() == AllitemsRegister.VOID_CHESTPLATE_GLIDE;
    }
    public static boolean isWearingVoidLeggings(@NotNull PlayerEntity player)
    {
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        return leggings.getItem() == AllitemsRegister.VOID_LEGGINGS;
    }
    public static boolean isWearingVoidBoots(@NotNull PlayerEntity player)
    {
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);
        return boots.getItem() == AllitemsRegister.VOID_BOOTS;
    }
    public static boolean isWearingAll(PlayerEntity player)
    {
        return VoidArmorEquipingUtil.isWearingVoidHelmet(player) && VoidArmorEquipingUtil.isWearingVoidBoots(player) &&
                VoidArmorEquipingUtil.isWearingVoidLeggings(player) && VoidArmorEquipingUtil.isWearingVoidChestplate(player);
    }

}
