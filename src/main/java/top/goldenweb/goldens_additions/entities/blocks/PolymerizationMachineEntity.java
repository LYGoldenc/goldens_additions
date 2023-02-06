package top.goldenweb.goldens_additions.entities.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;
import top.goldenweb.goldens_additions.recipe.PolymerizationRecipe;
import top.goldenweb.goldens_additions.screen.handler.PolymerizationMachineScreenHandler;

import java.util.Objects;
import java.util.Optional;

public class PolymerizationMachineEntity extends BlockEntity implements ImplementedInventory, IAnimatable , NamedScreenHandlerFactory {



    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(6, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;

    private int progress;

    private int maxProgress;






    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
    public PolymerizationMachineEntity(BlockPos pos, BlockState state) {
        super(AllBlockEntities.PLYMERIZATION_MACHINE_ENTITY, pos, state);
        
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> PolymerizationMachineEntity.this.progress;
                    case 1 -> PolymerizationMachineEntity.this.maxProgress;
                    default -> 0;
                };
            }
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> PolymerizationMachineEntity.this.progress = value;
                    case 1 -> PolymerizationMachineEntity.this.maxProgress = value;
                }
            }

            public int size() {
                return 2;
            }
        };
    }


    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, items);
        nbt.putInt("progress",progress);


    }


    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, items);
        super.readNbt(nbt);
        progress = nbt.getInt("progress");

    }
    private void resetProgress() {
        this.progress = 0;
    }



    private static void craftItem(PolymerizationMachineEntity entity) {

        SimpleInventory simpleInventory = new SimpleInventory(6);

        for (int i =0;i<entity.size();i++){
            simpleInventory.setStack(i,entity.getStack(i));
        }
        Optional<PolymerizationRecipe> match1 = Objects.requireNonNull(entity.getWorld()).getRecipeManager()
                .getFirstMatch(PolymerizationRecipe.Type.POLYMERIZATION_RECIPE,simpleInventory,entity.getWorld());
        if(match1.isPresent()) {
            int count = match1.get().getOutput().getCount();

            if (hasRecipe(entity)) {
                entity.removeStack(0, 1);
                entity.removeStack(1, 1);
                entity.removeStack(2, 1);
                entity.removeStack(3, 1);
                entity.removeStack(4, 1);
                entity.setStack(5, new ItemStack(match1.get().getOutput().getItem(), entity.getStack(5).getCount() + count));

                entity.resetProgress();
            }
        }

    }


    public static int an = 0;
    public static void onTick(World world, BlockPos pos, BlockState state, PolymerizationMachineEntity entity) {

        SimpleInventory simpleInventory = new SimpleInventory(6);
        for (int i =0;i<entity.size();i++){
            simpleInventory.setStack(i,entity.getStack(i));
        }
        Optional<PolymerizationRecipe> recipe = Objects.requireNonNull(entity.getWorld()).getRecipeManager()
                .getFirstMatch(PolymerizationRecipe.Type.POLYMERIZATION_RECIPE,simpleInventory,entity.getWorld());


            if (world.isClient()) {
                return;
            }
                if (hasRecipe(entity)&&recipe.isPresent()) {
                    entity.maxProgress = recipe.get().getTime();

                    an++;
                    entity.progress++;
                    markDirty(world, pos, state);

                    if (entity.progress == entity.maxProgress) {
                        craftItem(entity);
                    }
                } else {
                    entity.resetProgress();
                    an = 0;
                    markDirty(world, pos, state);
                }


    }

    private static boolean hasRecipe(PolymerizationMachineEntity entity) {

        SimpleInventory simpleInventory = new SimpleInventory(6);
        for (int i =0;i<entity.size();i++){
            simpleInventory.setStack(i,entity.getStack(i));
        }
        Optional<PolymerizationRecipe> match = Objects.requireNonNull(entity.getWorld()).getRecipeManager()
                .getFirstMatch(PolymerizationRecipe.Type.POLYMERIZATION_RECIPE,simpleInventory,entity.getWorld());

        return match.isPresent() && canIseryOutputSlot(simpleInventory,match.get().getOutput().getItem())
                && canOutPut(simpleInventory);
    }
    private  static  boolean canIseryOutputSlot(SimpleInventory simpleInventory, Item output){
        return simpleInventory.getStack(5).getItem()== output || simpleInventory.getStack(6).isEmpty();
    }

    private static boolean canOutPut(SimpleInventory simpleInventory){
        return simpleInventory.getStack(5).getMaxCount()>simpleInventory.getStack(5).getCount();

    }


    public PlayState predicate(AnimationEvent<PolymerizationMachineEntity> event) {
        if(an>0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("polymerization_machine_a.model.new",
                    ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(
                new AnimationController<>(this, "controller", 0, this::predicate));

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(" ");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new PolymerizationMachineScreenHandler(syncId,inv,this,this.propertyDelegate);
    }
}
