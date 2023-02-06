package top.goldenweb.goldens_additions.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.network.GeckoLibNetwork;
import software.bernie.geckolib3.network.ISyncable;
import software.bernie.geckolib3.util.GeckoLibUtil;
import vazkii.patchouli.api.PatchouliAPI;
import vazkii.patchouli.common.base.PatchouliSounds;
import vazkii.patchouli.common.book.Book;
import vazkii.patchouli.common.book.BookRegistry;

public class CustomBookItem extends Item implements IAnimatable, ISyncable {
    private static final int ANIM_OPEN = 0;

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);


    public CustomBookItem(Settings settings) {
        super(settings);
        GeckoLibNetwork.registerSyncable(this);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(
                new AnimationController<>(this, "controller", 2, this::predicate));
    }



    @Override
    public TypedActionResult<ItemStack> use(@NotNull World world, PlayerEntity user, Hand hand) {


        if(!world.isClient) {
            if (user instanceof ServerPlayerEntity serverPlayer) {

                Book book = BookRegistry.INSTANCE.books.get(Registry.ITEM.getId(this));
                PatchouliAPI.get().openBookGUI(serverPlayer, book.id);
                user.playSound(PatchouliSounds.getSound(book.openSound, PatchouliSounds.BOOK_OPEN), 1,
                        (float) (0.7 + Math.random() * 0.4));
            }

            final int id = GeckoLibUtil.guaranteeIDForStack(user.getStackInHand(hand), (ServerWorld) world);
            GeckoLibNetwork.syncAnimation(user, this, id, ANIM_OPEN);
        }

        return TypedActionResult.success(user.getStackInHand(hand));

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }


    @Override
    public void onAnimationSync(int id, int state) {
        if (state == ANIM_OPEN) {
            @SuppressWarnings("rawtypes")
            final AnimationController controller = GeckoLibUtil.getControllerForID(this.factory, id, "controller");
            if (controller.getAnimationState() == AnimationState.Stopped) {
                controller.markNeedsReload();
                controller.setAnimation(new AnimationBuilder().addAnimation("open", ILoopType.EDefaultLoopTypes.PLAY_ONCE));

            }
        }
    }
}
