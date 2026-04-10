package net.pflame.crossfiction;

import net.fabricmc.api.ClientModInitializer;
import net.pflame.crossfiction.event.KeyInputHandler;

public class CrossFictionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
