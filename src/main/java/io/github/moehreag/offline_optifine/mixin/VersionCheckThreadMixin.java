package io.github.moehreag.offline_optifine.mixin;

import net.optifine.VersionCheckThread;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(VersionCheckThread.class)
public class VersionCheckThreadMixin {

	@Inject(method = "run", at = @At("HEAD"), cancellable = true, remap = false)
	private void offlineOF$noVersionCheck(CallbackInfo ci){
		ci.cancel();
	}
}
