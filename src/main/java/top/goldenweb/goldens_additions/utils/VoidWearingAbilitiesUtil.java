package top.goldenweb.goldens_additions.utils;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

import static top.goldenweb.goldens_additions.utils.VoidArmorEquipingUtil.isWearingVoidChestplate;
import static top.goldenweb.goldens_additions.utils.VoidArmorEquipingUtil.isWearingVoidHelmet;

public class VoidWearingAbilitiesUtil {


    public static boolean canDamageByHeatSource (PlayerEntity player, DamageSource source)
    {
        if(source == DamageSource.HOT_FLOOR || source == DamageSource.IN_FIRE || source == DamageSource.ON_FIRE ||
                source == DamageSource.LAVA )
        {
            return !isWearingVoidChestplate(player);
        }
        return true;
    }
    public static boolean canDamageByDrawning (PlayerEntity player, DamageSource source) {
        if (source == DamageSource.DROWN) {
            return !isWearingVoidHelmet(player);
        }
        return true;
    }

    public static boolean cannotSellToEvil(PlayerEntity player){
        return isWearingVoidChestplate(player);
    }
}