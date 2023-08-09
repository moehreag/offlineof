package io.github.moehreag.offline_optifine;

import java.util.Collections;
import java.util.List;

import io.github.axolotlclient.AxolotlClientConfig.AxolotlClientConfigManager;
import io.github.axolotlclient.AxolotlClientConfig.common.ConfigHolder;
import io.github.axolotlclient.AxolotlClientConfig.options.BooleanOption;
import io.github.axolotlclient.AxolotlClientConfig.options.OptionCategory;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OfflineOF implements ClientModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("Offline Optifine");
	public static final String MODID = "offline-of";
	private final OptionCategory category = new OptionCategory(MODID);

	public static final BooleanOption allowCapes = new BooleanOption("allow_capes", false);

	@Override
	public void onInitializeClient() {
		LOGGER.info("Optifine is now restricted in its networking capabilities!");

		category.add(allowCapes);

		AxolotlClientConfigManager.getInstance().registerConfig(MODID, new ConfigHolder() {
			@Override
			public List<io.github.axolotlclient.AxolotlClientConfig.common.options.OptionCategory> getCategories() {
				return Collections.singletonList(category);
			}
		});
	}
}
