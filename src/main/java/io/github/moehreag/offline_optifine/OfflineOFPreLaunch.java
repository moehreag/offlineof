package io.github.moehreag.offline_optifine;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.spongepowered.asm.mixin.Mixins;

public class OfflineOFPreLaunch implements PreLaunchEntrypoint {
	@Override
	public void onPreLaunch() {
		Mixins.addConfiguration("offlineof.mixins.json");
	}
}
