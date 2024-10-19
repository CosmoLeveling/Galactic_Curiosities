package net.quiltmc.users.cosmo.galactic_curiosities.mixin;

import net.quiltmc.users.cosmo.galactic_curiosities.GalacticCuriosities;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @Inject(method = "init", at = @At("TAIL"))
    public void onInit(CallbackInfo ci) {
        GalacticCuriosities.LOGGER.info("This line is printed by an example mod mixin!");
    }
}