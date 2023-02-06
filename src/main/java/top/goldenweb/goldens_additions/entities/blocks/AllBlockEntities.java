package top.goldenweb.goldens_additions.entities.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import top.goldenweb.goldens_additions.Goldens_additions;
import top.goldenweb.goldens_additions.blocks.AllblocksRegister;

public class AllBlockEntities {
    public static  final BlockEntityType<PolymerizationMachineEntity> PLYMERIZATION_MACHINE_ENTITY =
            FabricBlockEntityTypeBuilder.create(PolymerizationMachineEntity::new, AllblocksRegister.POLYMERIZATION_MACHINE).build();


    public static void register() {

                 Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Goldens_additions.MOD_ID,
                         "polymerization_machine_entity"),PLYMERIZATION_MACHINE_ENTITY);
    }
}
