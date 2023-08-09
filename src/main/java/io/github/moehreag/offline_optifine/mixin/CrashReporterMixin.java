package io.github.moehreag.offline_optifine.mixin;

import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import net.optifine.CrashReporter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(CrashReporter.class)
public class CrashReporterMixin {

	@Inject(method = "onCrashReport", at = @At("HEAD"), cancellable = true, remap = false)
	private static void offlineOF$killCrashReporting(CrashReport report, CrashReportSection section, CallbackInfo ci){
		ci.cancel();
	}
}
