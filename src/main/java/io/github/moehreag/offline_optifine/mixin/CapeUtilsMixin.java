package io.github.moehreag.offline_optifine.mixin;

import io.github.moehreag.offline_optifine.OfflineOF;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.optifine.player.CapeUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CapeUtils.class, remap = false)
public class CapeUtilsMixin {

	@Inject(method = "downloadCape", at = @At("HEAD"), cancellable = true)
	private static void offlineOF$cancelCapeDownload(AbstractClientPlayerEntity player, CallbackInfo ci){
		if(!OfflineOF.allowCapes.get()) {
			ci.cancel();
		}
	}
}
