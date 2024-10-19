package net.quiltmc.users.cosmo.galactic_curiosities.event;

import com.mojang.blaze3d.platform.InputUtil;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBind;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import org.quiltmc.qsl.lifecycle.api.client.event.ClientTickEvents;

public class KeyInputHandler {
	public static final String KEY_CATAGORY_GALACTIC = "key.catagory.galactic_curiosities.galactic";
	public static final String KEY_MOVE_FORWARD = "key.galactic_curiosities.move_forward";

	public static KeyBind moveforwardkey;

	public static void registerKeyInputs() {
		ClientTickEvents.END.register(client -> {
			if(moveforwardkey.wasPressed()){
				System.out.println("YIPPEEE");
			}
		});
	}

	public static void register() {
			moveforwardkey = KeyBindingHelper.registerKeyBinding(new KeyBind(
				KEY_MOVE_FORWARD,
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_W,
				KEY_CATAGORY_GALACTIC
			));
			registerKeyInputs();
	}
}
