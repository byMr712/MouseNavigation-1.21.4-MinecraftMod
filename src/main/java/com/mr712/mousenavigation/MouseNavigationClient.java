package com.mr712.mousenavigation;

import com.mr712.mousenavigation.config.MouseNavigationConfig;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MouseNavigationClient implements ClientModInitializer {
    public static final String MOD_ID = "mousenavigation";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        MouseNavigationConfig.getInstance();
        LOGGER.info("MouseNavigation initialized successfully!");
    }
}
