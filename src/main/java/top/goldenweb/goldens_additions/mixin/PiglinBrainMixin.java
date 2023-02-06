package top.goldenweb.goldens_additions.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import top.goldenweb.goldens_additions.items.AllitemsRegister;

import java.util.Iterator;

@Mixin(PiglinBrain.class)

public abstract class PiglinBrainMixin {
    @Inject(method = "wearsGoldArmor(Lnet/minecraft/entity/LivingEntity;)Z",
            at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"),
            cancellable = true, locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void wearsVoidArmorMixin(LivingEntity entity, CallbackInfoReturnable<Boolean> cir, Iterable<ItemStack> iterable,
                                            Iterator<ItemStack> var2, @NotNull ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (item instanceof ArmorItem && ((ArmorItem) item).getMaterial() == AllitemsRegister.VOID_ARMOR_MATERIAL) {
            cir.setReturnValue(true);
        }
    }
}
