package com.dexclint;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class DexClintClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(DexClintClient::renderHud);
    }

    private static void renderHud(DrawContext context, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        context.drawText(client.textRenderer, Text.literal("DEX CLINT"),
                8, 8, 0xFFFFFF, true);
        context.drawText(client.textRenderer,
                Text.literal("FPS: " + client.getCurrentFps()),
                8, 20, 0xD0D0D0, true);
    }
}
