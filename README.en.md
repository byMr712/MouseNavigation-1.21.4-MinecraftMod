> **Language:** [Русский](README.md) · English

# MouseNavigation (Minecraft 1.21.4 Fabric)

**MouseNavigation** is a lightweight and intuitive client-side quality-of-life mod for **Minecraft 1.21.4 (Fabric)** that brings standard mouse side-button navigation to Minecraft user interfaces. With MouseNavigation, the lower side button (Mouse 4) acts as "Back" and the upper side button (Mouse 5) acts as "Forward", allowing you to seamlessly flip book pages, cycle inventory tabs, browse recipe books, and close menus without affecting in-game controls.

---

## 🎯 Primary Purpose

In modern operating systems and web browsers, mouse side buttons (Mouse 4 and Mouse 5 / Back and Forward) are universal standards for back/forward navigation. However, vanilla Minecraft interfaces ignore these buttons, forcing players to constantly reach for `Esc`, keyboard arrow keys, or click small on-screen arrow widgets.

**MouseNavigation** fixes this:
- **In GUI screens (menus, containers, inventories, books, chat)**: mouse navigation buttons provide instant back and forward actions.
- **In-game (when no screen is open)**: the mod is completely transparent and **does not intercept clicks**; mouse buttons perform whatever action you configured in vanilla Minecraft keybindings.

---

## 🛠️ Features & Behavior

1. **Back Button (Mouse Button 4 / XBUTTON1 / Lower Side Button)**:
   - **Screens and Menus (Settings, chests, crafting tables, pause menu, world select, etc.)**: instantly closes the current screen or returns to the previous menu (equivalent to `Esc` / Back / Done button).
   - **Books & Lecterns (`BookScreen`, `LecternScreen`)**: flips to the previous page (`<`).
   - **Recipe Book (`RecipeBookWidget`)**: switches to the previous recipe page.
   - **Creative Inventory (`CreativeInventoryScreen`)**: switches to the previous item group tab.
   - **Advancements Screen (`AdvancementsScreen`)**: switches to the previous advancement tab.
   - **Chat Screen (`ChatScreen`)**: cycles backward through previously sent chat message history (equivalent to `↑` arrow).

2. **Forward Button (Mouse Button 5 / XBUTTON2 / Upper Side Button)**:
   - **Books & Lecterns**: flips to the next page (`>`).
   - **Recipe Book**: switches to the next recipe page.
   - **Creative Inventory**: switches to the next item group tab.
   - **Advancements Screen**: switches to the next advancement tab.
   - **Chat Screen**: cycles forward through chat message history (equivalent to `↓` arrow).
   - **Screen History Navigation**: returns forward to child screens if you navigated back from them.

3. **ModMenu Integration & Customization**:
   - Includes a built-in config screen accessible via **ModMenu**. Each navigation feature (books, chat, tabs, recipes, screen close) can be individually toggled, along with sound feedback and button swapping.

---

## 🎮 Behavior Matrix

| Interface | Back Button (Mouse 4) | Forward Button (Mouse 5) |
|---|---|---|
| **Standard Menus & Containers** (Settings, chests, crafting, pause) | Close / Back (`Esc`) | Forward through screen history |
| **Books & Lecterns** | Previous page (`<`) | Next page (`>`) |
| **Recipe Book** | Previous recipe page | Next recipe page |
| **Creative Inventory** | Previous tab | Next tab |
| **Advancements Screen** | Previous category | Next category |
| **Chat** | Previous message history (`↑`) | Next message history (`↓`) |
| **In-game (No Screen Open)** | Vanilla player action | Vanilla player action |

---

## ⚙️ Configuration (ModMenu)

When **ModMenu** is installed, you can customize:
- **Master Toggle**: enable/disable the mod.
- **Screen & Menu Back**: close menus and containers.
- **Books & Lecterns**: turn pages in written books and lecterns.
- **Recipe Book**: cycle recipe book pages.
- **Creative Tabs**: switch creative inventory tabs.
- **Advancements**: switch advancement categories.
- **Chat History**: cycle previously sent messages.
- **Sound Feedback**: play a subtle click sound upon navigating.
- **Invert Buttons**: swap Mouse 4 and Mouse 5.

Config file location: `.minecraft/config/mousenavigation.json`.

---

## 📦 Build

```bash
gradlew build
```

Output: `build/libs/MouseNavigation-1.21.4-byMr712.jar`.

## 🚀 Installation

1. Install **Fabric Loader** (0.16.0+) and **Fabric API** for 1.21.4.
2. Place `MouseNavigation-1.21.4-byMr712.jar` into your `mods/` folder.
3. *(Optional)* Install **ModMenu** for easy in-game configuration.
4. Launch Minecraft.

---

## 📄 License

Licensed under **Apache License 2.0**.
