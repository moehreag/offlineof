package io.github.moehreag.offline_optifine;

import io.github.axolotlclient.AxolotlClientConfig.AxolotlClientConfigManager;
import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

public class OfflineOFModmenu implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return screen -> AxolotlClientConfigManager.getInstance().getConfigScreen(OfflineOF.MODID, screen);
	}
}
