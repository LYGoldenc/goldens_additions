package top.goldenweb.goldens_additions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

import static top.goldenweb.goldens_additions.config.ConfigRegister.CONFIG;

public class ChannelingEX extends Enchantment {

    protected ChannelingEX() {
         super(Rarity.VERY_RARE, EnchantmentTarget.TRIDENT, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return CONFIG.canChannelingEXTrade;
    }
    @Override
    public boolean isTreasure() {
        return CONFIG.canChannelingEXTreasure;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }


    @Override
    protected boolean canAccept(Enchantment other) {

        return super.canAccept(other) && other != Enchantments.CHANNELING && other != Enchantments.RIPTIDE;

    }
}
