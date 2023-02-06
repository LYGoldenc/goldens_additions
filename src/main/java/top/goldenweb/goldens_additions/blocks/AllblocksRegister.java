package top.goldenweb.goldens_additions.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AllblocksRegister {
    public static final Block PORTAL_FRAME = new Block(FabricBlockSettings.of(Material.STONE)
            .strength(15.0f,20f)
            .sounds(BlockSoundGroup.STONE));
    public static final Block VOID_ORE = new Block(FabricBlockSettings.of(Material.STONE)
            .strength(20.0f,50f).requiresTool()
            .sounds(BlockSoundGroup.STONE));

    public static final Block POLYMERIZATION_MACHINE = new PolymerizationMachine(FabricBlockSettings.of(Material.STONE).nonOpaque()
            .strength(5.0f,5f)
            .sounds(BlockSoundGroup.DEEPSLATE));



    public static void register(){
        Registry.register(Registry.BLOCK, new Identifier("goldens_additions", "portal_frame"),
                PORTAL_FRAME);
        Registry.register(Registry.BLOCK, new Identifier("goldens_additions", "void_ore"),
                VOID_ORE);
        Registry.register(Registry.BLOCK, new Identifier("goldens_additions", "polymerization_machine"),
                POLYMERIZATION_MACHINE);

    }
}
