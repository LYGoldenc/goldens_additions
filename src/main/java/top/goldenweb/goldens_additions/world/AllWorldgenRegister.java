package top.goldenweb.goldens_additions.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;


import java.util.Arrays;

import static top.goldenweb.goldens_additions.config.ConfigRegister.CONFIG;

public class AllWorldgenRegister {

    static int veinSize = CONFIG.veinSize;
    static int perChunk = CONFIG.perChunk;
    static int height = CONFIG.height;
    private static final ConfiguredFeature<?, ?> VOID_ORE_CONFIGURED_FEATURE = new ConfiguredFeature<>
            (Feature.ORE, new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    AllblocksRegister.VOID_ORE.getDefaultState(),
                    veinSize));
    public static PlacedFeature VOID_ORE_PLACED_FRATURE = new PlacedFeature(RegistryEntry.of(VOID_ORE_CONFIGURED_FEATURE),
            Arrays.asList(
                    CountPlacementModifier.of(perChunk),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(height))
            ));

    public static void register(){
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                new Identifier("goldens_additions", "void_ore"), VOID_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("goldens_additions", "void_ore"),
                VOID_ORE_PLACED_FRATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                        new Identifier("goldens_additions", "void_ore")));
    }

}
