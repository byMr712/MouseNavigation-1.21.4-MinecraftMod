package com.mr712.mousenavigation.gui;

import com.mr712.mousenavigation.config.MouseNavigationConfig;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class MouseNavigationConfigScreen extends Screen {
    private final Screen parent;
    private final MouseNavigationConfig tempConfig;

    public MouseNavigationConfigScreen(Screen parent) {
        super(Text.translatable("mousenavigation.config.title"));
        this.parent = parent;
        this.tempConfig = MouseNavigationConfig.getInstance().copy();
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int startY = 36;
        int rowHeight = 24;
        int btnWidth = 310;
        int btnHeight = 20;

        // Option 1: Master Enable
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY, btnWidth, btnHeight,
                "mousenavigation.config.enabled",
                tempConfig.enabled,
                () -> tempConfig.enabled = !tempConfig.enabled,
                null
        ));

        // Option 2: Screen Back
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight, btnWidth, btnHeight,
                "mousenavigation.config.screen_back",
                tempConfig.enableScreenBack,
                () -> tempConfig.enableScreenBack = !tempConfig.enableScreenBack,
                "mousenavigation.config.screen_back.tooltip"
        ));

        // Option 3: Screen Forward
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 2, btnWidth, btnHeight,
                "mousenavigation.config.screen_forward",
                tempConfig.enableScreenForward,
                () -> tempConfig.enableScreenForward = !tempConfig.enableScreenForward,
                "mousenavigation.config.screen_forward.tooltip"
        ));

        // Option 4: Books & Lecterns
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 3, btnWidth, btnHeight,
                "mousenavigation.config.books",
                tempConfig.enableBooks,
                () -> tempConfig.enableBooks = !tempConfig.enableBooks,
                "mousenavigation.config.books.tooltip"
        ));

        // Option 5: Recipe Book
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 4, btnWidth, btnHeight,
                "mousenavigation.config.recipe_book",
                tempConfig.enableRecipeBook,
                () -> tempConfig.enableRecipeBook = !tempConfig.enableRecipeBook,
                "mousenavigation.config.recipe_book.tooltip"
        ));

        // Option 6: Creative Tabs
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 5, btnWidth, btnHeight,
                "mousenavigation.config.creative_tabs",
                tempConfig.enableCreativeTabs,
                () -> tempConfig.enableCreativeTabs = !tempConfig.enableCreativeTabs,
                "mousenavigation.config.creative_tabs.tooltip"
        ));

        // Option 7: Advancements
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 6, btnWidth, btnHeight,
                "mousenavigation.config.advancements",
                tempConfig.enableAdvancements,
                () -> tempConfig.enableAdvancements = !tempConfig.enableAdvancements,
                "mousenavigation.config.advancements.tooltip"
        ));

        // Option 8: Chat History
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 7, btnWidth, btnHeight,
                "mousenavigation.config.chat_history",
                tempConfig.enableChatHistory,
                () -> tempConfig.enableChatHistory = !tempConfig.enableChatHistory,
                "mousenavigation.config.chat_history.tooltip"
        ));

        // Option 9: Click Sound Effect
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 8, btnWidth, btnHeight,
                "mousenavigation.config.sound",
                tempConfig.enableSound,
                () -> tempConfig.enableSound = !tempConfig.enableSound,
                "mousenavigation.config.sound.tooltip"
        ));

        // Option 10: Invert Buttons
        addDrawableChild(createToggleOption(
                centerX - (btnWidth / 2), startY + rowHeight * 9, btnWidth, btnHeight,
                "mousenavigation.config.invert",
                tempConfig.invertButtons,
                () -> tempConfig.invertButtons = !tempConfig.invertButtons,
                "mousenavigation.config.invert.tooltip"
        ));

        // Bottom Controls
        int bottomY = this.height - 28;
        addDrawableChild(ButtonWidget.builder(Text.translatable("mousenavigation.config.reset"), btn -> {
            tempConfig.resetToDefaults();
            clearAndInit();
        }).dimensions(centerX - 155, bottomY, 100, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("mousenavigation.config.save"), btn -> {
            MouseNavigationConfig current = MouseNavigationConfig.getInstance();
            current.enabled = tempConfig.enabled;
            current.enableScreenBack = tempConfig.enableScreenBack;
            current.enableScreenForward = tempConfig.enableScreenForward;
            current.enableBooks = tempConfig.enableBooks;
            current.enableRecipeBook = tempConfig.enableRecipeBook;
            current.enableCreativeTabs = tempConfig.enableCreativeTabs;
            current.enableAdvancements = tempConfig.enableAdvancements;
            current.enableChatHistory = tempConfig.enableChatHistory;
            current.enableSound = tempConfig.enableSound;
            current.invertButtons = tempConfig.invertButtons;
            current.save();
            this.close();
        }).dimensions(centerX - 50, bottomY, 100, 20).build());

        addDrawableChild(ButtonWidget.builder(Text.translatable("mousenavigation.config.cancel"), btn -> this.close())
                .dimensions(centerX + 55, bottomY, 100, 20).build());
    }

    private ButtonWidget createToggleOption(int x, int y, int width, int height, String key, boolean state, Runnable onToggle, String tooltipKey) {
        MutableText label = Text.translatable(key).append(": ");
        if (state) {
            label.append(Text.translatable("mousenavigation.config.state.on").formatted(Formatting.GREEN, Formatting.BOLD));
        } else {
            label.append(Text.translatable("mousenavigation.config.state.off").formatted(Formatting.RED, Formatting.BOLD));
        }

        ButtonWidget.Builder builder = ButtonWidget.builder(label, btn -> {
            onToggle.run();
            clearAndInit();
        }).dimensions(x, y, width, height);

        if (tooltipKey != null) {
            builder.tooltip(Tooltip.of(Text.translatable(tooltipKey)));
        }

        return builder.build();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 14, 0xFFFFFF);
    }

    @Override
    public void close() {
        if (this.client != null) {
            this.client.setScreen(this.parent);
        }
    }
}
