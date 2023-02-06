package top.goldenweb.goldens_additions.items.armor;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;
import top.goldenweb.goldens_additions.items.AllitemsRegister;
import top.goldenweb.goldens_additions.utils.VoidArmorEquipingUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class VoidArmorItem extends ArmorItem implements IAnimatable {


    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public VoidArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }
    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {

        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle",
                ILoopType.EDefaultLoopTypes.LOOP));
        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }

        List<Item> armorList = new ArrayList<>(4);
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                if (livingEntity.getEquippedStack(slot) != null) {
                    armorList.add(livingEntity.getEquippedStack(slot).getItem());
                }
            }
        }

        boolean isWearingAll = new HashSet<>(armorList).containsAll(Arrays.asList(AllitemsRegister.VOID_BOOTS,
                AllitemsRegister.VOID_LEGGINGS, AllitemsRegister.VOID_CHESTPLATE, AllitemsRegister.VOID_HELMET))||
                new HashSet<>(armorList).containsAll(Arrays.asList(AllitemsRegister.VOID_BOOTS,
                        AllitemsRegister.VOID_LEGGINGS, AllitemsRegister.VOID_CHESTPLATE_GLIDE, AllitemsRegister.VOID_HELMET));

        return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
    }


    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player && VoidArmorEquipingUtil.isWearingVoidHelmet(player)) {
            StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 400, 0);
            LivingEntity user = (LivingEntity) entity;
            user.addStatusEffect(effect);
            if (user.hasStatusEffect(StatusEffects.DARKNESS)) {
                user.removeStatusEffect(StatusEffects.DARKNESS);
            }
            if (user.hasStatusEffect(StatusEffects.BLINDNESS)) {
                user.removeStatusEffect(StatusEffects.BLINDNESS);
            }
        }
      // if (entity instanceof PlayerEntity player && VoidEquip.isWearingVoidChestplate(player)) {}
        if (entity instanceof PlayerEntity player && VoidArmorEquipingUtil.isWearingVoidLeggings(player)) {
            StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1);
            LivingEntity user = (LivingEntity) entity;
            user.addStatusEffect(effect);
        }
        if (entity instanceof PlayerEntity player && VoidArmorEquipingUtil.isWearingVoidBoots(player)) {
            StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SPEED, 400, 1);
            LivingEntity user = (LivingEntity) entity;
            user.addStatusEffect(effect);
            player.fallDistance = 0.0F;
            if(user.hasStatusEffect(StatusEffects.SLOWNESS)){
                user.removeStatusEffect(StatusEffects.SLOWNESS);
            }
        }

    }


    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
       return this.factory;
    }
}
