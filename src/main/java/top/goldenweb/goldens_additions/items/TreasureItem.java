package top.goldenweb.goldens_additions.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.*;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import top.goldenweb.goldens_additions.Goldens_additions;

import java.util.ArrayList;
import java.util.List;

public class TreasureItem extends Item {
    private final Identifier treasure;

    public TreasureItem(Settings settings) {
        super(settings);
        treasure = new Identifier(Goldens_additions.MOD_ID,"chests/warden_treasure");
    }
    public TreasureItem(Settings settings,Identifier treasure) {
        super(settings);
        this.treasure = treasure;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient){
            openBag((ServerWorld) world,treasure,user.getPos()).forEach(itemStack -> {
                ItemScatterer.spawn(world,user.getX(),user.getY(),user.getZ(),itemStack);
            });
        }
        if(!user.isCreative()){
            user.getStackInHand(hand).decrement(1);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private List<ItemStack> openBag (ServerWorld serverWorld, Identifier identifier, Vec3d vec3d) {
        List<ItemStack> list = null;
        if (serverWorld != null && !serverWorld.isClient) {
            LootTable lootTable = serverWorld.getServer().getLootManager().getTable(identifier);
            LootContext.Builder builder = new LootContext.Builder(serverWorld).random(serverWorld.random).parameter(LootContextParameters.ORIGIN, vec3d);
            List<ItemStack> stacks = lootTable.generateLoot(builder.build(LootContextTypes.CHEST));
            list = new ArrayList<>(stacks);
        }
        return list;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
