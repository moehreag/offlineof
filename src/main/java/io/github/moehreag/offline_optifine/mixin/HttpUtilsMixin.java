package io.github.moehreag.offline_optifine.mixin;

import java.util.Map;

import net.optifine.http.HttpUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(HttpUtils.class)
public class HttpUtilsMixin {

	@Inject(method = "get", at = @At("HEAD"), cancellable = true, remap = false)
	private static void offlineOF$cancelGet(String urlStr, CallbackInfoReturnable<byte[]> cir){
		cir.setReturnValue(new byte[0]);
	}

	@Inject(method = "post", at = @At("HEAD"), cancellable = true, remap = false)
	private static void offlineOF$cancelPost(String urlStr, Map<Object, Object> headers, byte[] content, CallbackInfoReturnable<String> cir){
		cir.setReturnValue("");
	}
}
