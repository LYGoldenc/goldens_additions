package top.goldenweb.goldens_additions.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import top.goldenweb.goldens_additions.utils.inventoryUtil;

import static top.goldenweb.goldens_additions.config.ConfigRegister.CONFIG;

public class ChargedPowderItem extends Item {
    public ChargedPowderItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.getItemCooldownManager().set(this, 20*CONFIG.chargedGunPowderColldown);
        double r = Math.random();
        double r1 = Math.random();

        if (!world.isClient) {

            BlockPos blockPos =  user.getBlockPos();
            LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
            assert lightningEntity != null;
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
            world.spawnEntity(lightningEntity);
            if(!user.isCreative()){
            user.getStackInHand(hand).decrement(1);
            }
            if(inventoryUtil.hasItemInInventory(user,AllitemsRegister.VOID_MIXTURE)){
                inventoryUtil.getItemStackInInventory(user, AllitemsRegister.VOID_MIXTURE).decrement(1);
                if(r >0.7d) {
                    user.getInventory().offerOrDrop(new ItemStack(Items.ENDER_PEARL, 1));
                }
                if(r1>0.3d) {
                    user.getInventory().offerOrDrop(new ItemStack(AllitemsRegister.UNIDENTIFIED_SUBSTANCE, 1));
                }
            }
        }
        return super.use(world, user, hand);
    }

}
