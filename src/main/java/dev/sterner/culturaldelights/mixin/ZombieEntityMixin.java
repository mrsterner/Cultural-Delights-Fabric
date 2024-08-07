package dev.sterner.culturaldelights.mixin;

import dev.sterner.culturaldelights.common.registry.CDObjects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Zombie.class)
public abstract class ZombieEntityMixin extends Monster {

    protected ZombieEntityMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "wantsToPickUp", at = @At("RETURN"),cancellable = true)
    public void wantsToPickUpInjected(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.is(CDObjects.GLOW_SQUID)) {
            cir.setReturnValue(false);
        }
    }
}