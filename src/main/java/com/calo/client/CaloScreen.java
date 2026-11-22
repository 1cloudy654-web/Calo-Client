
package com.calo.client;

import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public final class CaloScreen extends Screen {

    private static final int PANEL = 0xD91B1B32;
    private static final int PANEL_HOVER = 0xE044405D;
    private static final int TEXT = 0xFFF1F0FF;
    private static final int MUTED = 0xFFB9B8CE;

    private String search = "";

    public CaloScreen() {
        super(Text.literal("Calo Client"));
    }

    @Override
    protected void init() {
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        int w = width;
        int h = height;

        ctx.fill(0, 0, w, h, 0x99080716);

        int top = 16;

        ctx.fill(18, top, w - 18, top + 38, PANEL);

        ctx.drawText(
                textRenderer,
                "CALO CLIENT",
                34,
                top + 13,
                TEXT,
                true
        );

        ctx.drawText(
                textRenderer,
                "SEARCH MODULES  " + search,
                w / 2 - 95,
                top + 13,
                MUTED,
                false
        );

        int gap = 10;
        int left = 22;
        int usable = w - 44;
        int columns = 7;
        int colW = (usable - gap * (columns - 1)) / columns;

        int yTop = 76;
        int bottomLimit = h - 64;

        for (int i = 0; i < ModuleCategory.values().length; i++) {
            ModuleCategory cat = ModuleCategory.values()[i];

            int x = left + i * (colW + gap);
            int y = yTop;

            List<CaloModule> modules =
                    ModuleRegistry.byCategory(cat);

            int visible = 0;

            for (CaloModule module : modules) {
                if (module.name.toLowerCase()
                        .contains(search.toLowerCase())) {
                    visible++;
                }
            }

            int panelHeight = Math.min(
                    bottomLimit - yTop,
                    38 + visible * 25
            );

            ctx.fill(
                    x,
                    y,
                    x + colW,
                    y + panelHeight,
                    PANEL
            );

            ctx.drawText(
                    textRenderer,
                    cat.title.toUpperCase(),
                    x + 9,
                    y + 10,
                    TEXT,
                    true
            );

            y += 30;

            for (CaloModule module : modules) {

                if (!module.name.toLowerCase()
                        .contains(search.toLowerCase())) {
                    continue;
                }

                if (y + 21 > bottomLimit) {
                    break;
                }

                boolean hovered =
                        mouseX >= x + 5 &&
                        mouseX <= x + colW - 5 &&
                        mouseY >= y &&
                        mouseY <= y + 21;

                int color = module.isEnabled()
                        ? 0xE05C5575
                        : (hovered ? PANEL_HOVER : 0x00000000);

                if (color != 0) {
                    ctx.fill(
                            x + 5,
                            y,
                            x + colW - 5,
                            y + 21,
                            color
                    );
                }

                ctx.drawText(
                        textRenderer,
                        (module.isEnabled() ? "• " : "  ") + module.name,
                        x + 10,
                        y + 6,
                        module.isEnabled() ? 0xFFFFFFFF : MUTED,
                        false
                );

                y += 25;
            }
        }

        ctx.fill(
                w / 2 - 210,
                h - 38,
                w / 2 + 210,
                h - 12,
                PANEL
        );

        ctx.drawCenteredTextWithShadow(
                textRenderer,
                "CONFIGS     HUD     LAYOUT     SETTINGS",
                w / 2,
                h - 29,
                TEXT
        );

        super.render(ctx, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(Click click, boolean doubled) {

        double mouseX = click.x();
        double mouseY = click.y();
        int button = click.button();

        if (button == 0) {

            int gap = 10;
            int left = 22;
            int usable = width - 44;
            int columns = 7;

            int colW = (usable - gap * (columns - 1)) / columns;

            int yTop = 76;
            int bottomLimit = height - 64;

            for (int i = 0; i < ModuleCategory.values().length; i++) {

                ModuleCategory cat = ModuleCategory.values()[i];

                int x = left + i * (colW + gap);
                int y = yTop + 30;

                for (CaloModule module : ModuleRegistry.byCategory(cat)) {

                    if (!module.name.toLowerCase()
                            .contains(search.toLowerCase())) {
                        continue;
                    }

                    if (y + 21 > bottomLimit) {
                        break;
                    }

                    if (mouseX >= x + 5 &&
                            mouseX <= x + colW - 5 &&
                            mouseY >= y &&
                            mouseY <= y + 21) {

                        module.toggle();
                        return true;
                    }

                    y += 25;
                }
            }
        }

        return super.mouseClicked(click, doubled);
    }

    @Override
    public boolean charTyped(CharInput input) {

        if (input.isValidChar()) {
            search += input.asString();
            return true;
        }

        return super.charTyped(input);
    }

    @Override
    public boolean keyPressed(KeyInput input) {

        int keyCode = input.key();

        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            close();
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_RIGHT_SHIFT) {
            close();
            return true;
        }

        if (keyCode == GLFW.GLFW_KEY_BACKSPACE && !search.isEmpty()) {
            search = search.substring(0, search.length() - 1);
            return true;
        }

        return super.keyPressed(input);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
