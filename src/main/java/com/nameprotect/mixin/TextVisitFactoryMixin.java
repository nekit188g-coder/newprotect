package com.nameprotect.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TextVisitFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Весь текст (чат, табліст, неймтеги, GUI) проходить через TextVisitFactory.visitFormatted.
 * Тут підміняємо нік гравця на фейковий — суто візуально, на клієнті.
 */
@Mixin(TextVisitFactory.class)
public class TextVisitFactoryMixin {

    private static final String FAKE_NAME = "PULSE - DODGE 10%";

    @ModifyVariable(
            method = "visitFormatted(Ljava/lang/String;ILnet/minecraft/text/Style;Lnet/minecraft/text/Style;Lnet/minecraft/text/CharacterVisitor;)Z",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private static String nameprotect$replaceName(String text) {
        if (text == null || text.isEmpty()) return text;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client == null || client.getSession() == null) return text;
        String real = client.getSession().getUsername();
        if (real == null || real.isEmpty() || !text.contains(real)) return text;
        return text.replace(real, FAKE_NAME);
    }
}
