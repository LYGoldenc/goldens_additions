package top.goldenweb.goldens_additions.utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class inventoryUtil {


    public static boolean hasItemInInventory(PlayerEntity player, Item item)
    {
        PlayerInventory inv = player.getInventory();
        int size = inv.size();

        for (int slot = 0; slot < size; slot++)
        {
            ItemStack stack = inv.getStack(slot);

            if (stack.getItem() == item)
            {
                return true;
            }
        }

        return false;
    }

    public static ItemStack getItemStackInInventory(PlayerEntity player, Item item)
    {
        PlayerInventory inv = player.getInventory();
        int size = inv.size();

        for (int slot = 0; slot < size; slot++)
        {
            ItemStack stack = inv.getStack(slot);

            if (stack.getItem() == item)
            {
                return stack;
            }
        }

        return ItemStack.EMPTY;
    }
}
