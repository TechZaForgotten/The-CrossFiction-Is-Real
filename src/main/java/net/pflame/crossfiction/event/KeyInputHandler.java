package net.pflame.crossfiction.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;


public class KeyInputHandler {
    public static final String KEY_CATEGORY_CROSSFICTION = "key.category.cross-fiction.crossfiction";
    public static final String KEY_USE_POWER = "key.category.cross-fiction.use_power";
    static MinecraftClient client = MinecraftClient.getInstance();

    public static KeyBinding powerKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (powerKey.isPressed()) {
                assert minecraftClient.player != null;

                assert client.player != null;
                client.player.sendMessage(Text.literal("Kill Me"));
            }
        });
    }

    public static void register () {
        powerKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_USE_POWER,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KEY_CATEGORY_CROSSFICTION
        ));

        registerKeyInputs();
    }

}
