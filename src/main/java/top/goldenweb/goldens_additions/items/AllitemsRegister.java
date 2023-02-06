package top.goldenweb.goldens_additions.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;
import top.goldenweb.goldens_additions.effects.AllEffectsRegister;
import top.goldenweb.goldens_additions.items.armor.VoidArmorItem;
import top.goldenweb.goldens_additions.items.armor.VoidArmorMaterial;
import top.goldenweb.goldens_additions.items.tools.*;
import top.goldenweb.goldens_additions.utils.GlideChestplateUtil;

import static top.goldenweb.goldens_additions.Goldens_additions.MOD_ID;
import static top.goldenweb.goldens_additions.Goldens_additions.TAB;

public class AllitemsRegister{


    public static final Item SUPER_LOLLIPOP = new Item(new Item.Settings().group(TAB)
            .food(ModFoodComponents.SUPER_LOLLIPOP));
    public static final FunctionalItems IRON_APPLE = new FunctionalItems(new Item.Settings().group(TAB)
            .food(ModFoodComponents.IRON_APPLE));
    public static final Item BAMBOO_BUNDLE = new Item(new Item.Settings().group(TAB));
    public static final Item BAMBOO_COAL = new Item(new Item.Settings().group(TAB));
    public static final Item BAMBOO_COAL_BUNDLE = new Item(new Item.Settings().group(TAB));
    public static final Item STILL_GEM = new Item(new Item.Settings().group(TAB).maxCount(16).rarity(Rarity.RARE));
    public static final VoidMixtureItem VOID_MIXTURE = new VoidMixtureItem(new Item.Settings().group(TAB).rarity(Rarity.RARE));

    public static final Item REFINING_VOID_MIXTURE = new Item(new Item.Settings().group(TAB).fireproof().rarity(Rarity.EPIC));
    public static final Item CHARGED_GUN_POWDER = new ChargedPowderItem(new Item.Settings().group(TAB).fireproof().rarity(Rarity.UNCOMMON));
    public static final Item UNIDENTIFIED_SUBSTANCE = new Item(new Item.Settings().group(TAB).fireproof().rarity(Rarity.UNCOMMON));
    public static final  Item WAEDEN_TREASURE_BAG = new TreasureItem(new Item.Settings().group(TAB).rarity(Rarity.UNCOMMON).maxCount(1));

    public static final  Item SCULK_PEARL = new Item(new Item.Settings().group(TAB).rarity(Rarity.UNCOMMON).fireproof().maxCount(16));

    public static final  Item ENCHANTED_GOLD_INGOT = new GlintItem(new Item.Settings().group(TAB).rarity(Rarity.UNCOMMON).fireproof());
    public static final Item ANCIENT_NOTES = new CustomBookItem(new Item.Settings().group(TAB).fireproof().maxCount(1));





    public static final Item POLYMERIZATION_MACHINE_ITEM =new PolymerizationMachineBlockItem(AllblocksRegister.POLYMERIZATION_MACHINE,
            new FabricItemSettings().group(TAB).fireproof());








    public static final ArmorMaterial VOID_ARMOR_MATERIAL = new VoidArmorMaterial();

    public static final Item VOID_HELMET = new VoidArmorItem(VOID_ARMOR_MATERIAL, EquipmentSlot.HEAD,
            new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));
    public static final Item VOID_CHESTPLATE = new VoidArmorItem(VOID_ARMOR_MATERIAL, EquipmentSlot.CHEST,
            new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));
    public static final Item VOID_CHESTPLATE_GLIDE = new GlideChestplateUtil(VOID_ARMOR_MATERIAL, EquipmentSlot.CHEST,
            new Item.Settings().fireproof().rarity(Rarity.EPIC));
    public static final Item VOID_LEGGINGS = new VoidArmorItem(VOID_ARMOR_MATERIAL, EquipmentSlot.LEGS,
            new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));
    public static final Item VOID_BOOTS = new VoidArmorItem(VOID_ARMOR_MATERIAL, EquipmentSlot.FEET,
            new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));

    public static final SwordItem VOID_SWORD =new VoidSwordItem(new VoidToolMaterial(),13,2-4f,
            new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));
    public static final PickaxeItem VOID_PICKAXE  = new VoidPickaxeItem(new VoidToolMaterial(),8,
            -2.7F,new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));
    public static final AxeItem VOID_AXE  = new VoidAxeItem(new VoidToolMaterial(),15,
            -3.0F,new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));

    public static final HoeItem VOID_HOE  = new VoidHoeItem(new VoidToolMaterial(),2,
            2F,new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC).maxDamage(-1));
    public static final ShovelItem VOID_SHOVEL  = new VoidShovelItem(new VoidToolMaterial(),8.5f,
            -3F,new Item.Settings().fireproof().group(TAB).rarity(Rarity.EPIC));

    public static final Potion SELLINGSOUL = new Potion(new StatusEffectInstance(AllEffectsRegister.SELL_SOUL));



    public static void register(){
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"super_lollipop"),
                SUPER_LOLLIPOP);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"iron_apple"),
                IRON_APPLE);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"still_gem"),
                STILL_GEM);

        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"bamboo_coal")
                ,BAMBOO_COAL);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"bamboo_bundle")
                ,BAMBOO_BUNDLE);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"bamboo_coal_bundle")
                ,BAMBOO_COAL_BUNDLE);

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "portal_frame"),
                new BlockItem(AllblocksRegister.PORTAL_FRAME, new FabricItemSettings().group(TAB)));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_ore"),
                new BlockItem(AllblocksRegister.VOID_ORE, new FabricItemSettings().group(TAB)));

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "polymerization_machine"),POLYMERIZATION_MACHINE_ITEM);


        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"eroded_ender_pear")
                ,VOID_MIXTURE);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"refining_void_mixture")
                ,REFINING_VOID_MIXTURE);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"charged_gun_powder")
                ,CHARGED_GUN_POWDER);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"unidentified_substance")
                ,UNIDENTIFIED_SUBSTANCE);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"warden_treasure_bag")
                ,WAEDEN_TREASURE_BAG);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"sculk_pearl")
                ,SCULK_PEARL);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"enchanted_gold_ingot")
                ,ENCHANTED_GOLD_INGOT);
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"ancient_notes")
                ,ANCIENT_NOTES);





        Registry.register(Registry.POTION,new Identifier(MOD_ID,"sellingsoul"),SELLINGSOUL);


        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_crown"), VOID_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_chestplate"), VOID_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_chestplate_glide"), VOID_CHESTPLATE_GLIDE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_leggings"), VOID_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_boots"), VOID_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_sword"), VOID_SWORD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_pickaxe"), VOID_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_axe"), VOID_AXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_hoe"), VOID_HOE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "void_shovel"), VOID_SHOVEL);
    }

}
