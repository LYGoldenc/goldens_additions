package top.goldenweb.goldens_additions.loot_table;


import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.predicate.NbtPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.util.Identifier;
import top.goldenweb.goldens_additions.enchantments.AllERgister;
import top.goldenweb.goldens_additions.items.AllitemsRegister;

public class AllLoottableRegister{

    public static final Identifier BARTERING_ID =
            new Identifier(LootTables.PIGLIN_BARTERING_GAMEPLAY
                    .getNamespace(),LootTables.PIGLIN_BARTERING_GAMEPLAY.getPath());
    public static final Identifier WARDEN_ID = new Identifier("minecraft","entities/warden");
    public static final Identifier CREEPER_ID = new Identifier("minecraft","entities/creeper");
    public static final Identifier ELDER_GUARD_ID = new Identifier("minecraft","entities/elder_guardian");





    public static void register() {

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (BARTERING_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f))
                        .with(ItemEntry.builder(AllitemsRegister.STILL_GEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 2f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(AllitemsRegister.WAEDEN_TREASURE_BAG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build())
                        .conditionally(KilledByPlayerLootCondition.builder().build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putBoolean("powered",true);
            if(CREEPER_ID.equals(id)){
                LootPool.Builder poolBulider = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(AllitemsRegister.CHARGED_GUN_POWDER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0f,2f)).build())
                        .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS,
                                EntityPredicate.Builder.create().nbt(new NbtPredicate(nbtCompound)).build()).build());
                tableBuilder.pool(poolBulider.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            SetEnchantmentsLootFunction.Builder enchantmentBuilder = new SetEnchantmentsLootFunction.Builder()
                    .enchantment(AllERgister.CHANNELINGEX,ConstantLootNumberProvider.create(1f));
            if(ELDER_GUARD_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(Items.ENCHANTED_BOOK))
                        .apply(enchantmentBuilder)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f,1f)).build())
                        .conditionally(KilledByPlayerLootCondition.builder().build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

    }


}



