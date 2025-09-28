package com.hyperlinkclientvrxpatch.mixin;

import com.sakurafuld.hyperdaimc.api.mixin.MixinLevelTickEvent;
import com.sakurafuld.hyperdaimc.content.hyper.vrx.VRXHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = VRXHandler.class, remap = false)
public class VRXHandlerMixin {
    @Inject(method = "creation(Lcom/sakurafuld/hyperdaimc/api/mixin/MixinLevelTickEvent;)V", at = @At(value = "INVOKE", target = "Ljava/lang/Runnable;run()V"), cancellable = true)
    @Shadow static
    private void creationMixin(MixinLevelTickEvent event, CallbackInfo ci) {
        if(event.getLevel().isClientSide()) {
            ci.cancel();
        }
    }
}
