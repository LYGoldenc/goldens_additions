package top.goldenweb.goldens_additions.utils;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.NotNull;
import top.goldenweb.goldens_additions.items.armor.VoidArmorItem;
import static top.goldenweb.goldens_additions.config.ConfigRegister.CONFIG;

public class GlideChestplateUtil extends VoidArmorItem implements FabricElytraItem {

    public GlideChestplateUtil(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }
@Override
    public void doVanillaElytraTick(@NotNull LivingEntity entity, ItemStack chestStack) {
        if (CONFIG.ElytraInArmorConsumeDurability) {
            int nextRoll = entity.getRoll() + 1;
            if (!entity.world.isClient && nextRoll % 10 == 0) {
                if ((nextRoll / 10) % 2 == 0) {
                    chestStack.damage(1, entity, p -> p.sendEquipmentBreakStatus(EquipmentSlot.CHEST));
                }
            }
        }
        entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
    }
}
