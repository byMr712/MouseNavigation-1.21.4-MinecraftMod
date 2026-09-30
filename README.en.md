> **Language:** [Русский](README.md) · English

# MouseNavigation (Minecraft 1.21.4 Fabric)

![Java 21](https://img.shields.io/badge/Java-21-blue.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.4-blue.svg)
![Fabric](https://img.shields.io/badge/Loader-Fabric-blue.svg)
![ModMenu](https://img.shields.io/badge/ModMenu-Supported-blue.svg)
![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)

**MouseNavigation** is a lightweight, convenient client-side mod for **Minecraft 1.21.4 (Fabric)** that introduces intuitive side mouse button navigation across game interfaces. Mouse 4 acts as "Back", Mouse 5 acts as "Forward", and the Middle Mouse Button (MMB / Scroll Wheel Click) quickly sends chat messages without interfering with regular in-game gameplay.

---

## Purpose & Problem Solved

In modern web browsers and desktop applications, side mouse buttons (Mouse 4 and Mouse 5 / Back and Forward) are the standard for forward and backward navigation. In vanilla Minecraft, however, these buttons are unused in GUI menus, forcing players to reach for `Esc`, `Enter`, arrow keys, or small screen buttons.

**MouseNavigation** fixes this:
- **In any GUI menu (settings, containers, inventories, books, chat)**: side buttons provide quick navigation, and MMB sends chat messages.
- **In-game (when no GUI is open)**: the mod is fully transparent and does not intercept clicks, allowing vanilla keybindings to function untouched.

---

## Features & Actions

1. **Back Button (Mouse Button 4 / XBUTTON1 / Lower Side Button)**:
   - **Screens & Menus (Settings, Chests, Inventory, Pause, World Selection)**: Closes screen or returns to previous menu (equivalent to `Esc`).
   - **Books & Lecterns (`BookScreen`, `LecternScreen`)**: Flips to previous page (`<`).
   - **Recipe Book (`RecipeBookWidget`)**: Cycles to previous recipe page.
   - **Creative Inventory (`CreativeInventoryScreen`)**: Switches to previous item group tab.
   - **Advancements (`AdvancementsScreen`)**: Switches to previous advancement category.
   - **Chat (`ChatScreen`)**: Cycles backward through sent message history (equivalent to `↑`).

2. **Forward Button (Mouse Button 5 / XBUTTON2 / Upper Side Button)**:
   - **Books & Lecterns**: Flips to next page (`>`).
   - **Recipe Book**: Cycles to next recipe page.
   - **Creative Inventory**: Switches to next item group tab.
   - **Advancements**: Switches to next advancement category.
   - **Chat**: Cycles forward through sent message history (equivalent to `↓`).
   - **Screen History**: Re-opens submenus exited via the back button.

3. **Middle Mouse Button (Mouse Button 3 / MMB / Scroll Wheel Click)**:
   - **Chat (`ChatScreen`)**: Instantly sends typed message (equivalent to `Enter`).

4. **ModMenu Integration & Customization**:
   - Offers an in-game configuration screen via **ModMenu** to toggle features individually (books, chat, MMB send, tabs, recipes, menu close), enable sound feedback, or invert mouse buttons.

---

## Behavior Table

| Interface | Back Button (Mouse 4) | Forward Button (Mouse 5) | Middle Button (MMB) |
|---|---|---|---|
| Menus & Containers (Settings, Chests, Crafting Table, Pause) | Close / Back (`Esc`) | Forward in screen history | — |
| Books & Lecterns | Previous page (`<`) | Next page (`>`) | — |
| Recipe Book | Previous page | Next page | — |
| Creative Inventory | Previous tab | Next tab | — |
| Advancements | Previous category | Next category | — |
| Chat | History backward (`↑`) | History forward (`↓`) | Send message (`Enter`) |
| In-Game (GUI closed) | Vanilla player action | Vanilla player action | Vanilla player action |

---

## Configuration (ModMenu)

When **ModMenu** is installed, you can configure:
- **Master Toggle**: Enable/disable mod functionality.
- **Close Menus & Screens**: Back navigation / container closing.
- **Books & Lecterns**: Book page turning.
- **Recipe Book**: Recipe page cycling.
- **Creative Tabs**: Item category switching.
- **Advancements**: Advancement category switching.
- **Chat History**: Sent message browsing.
- **MMB Chat Send**: Send message via mouse wheel click.
- **Sound Feedback**: Play a subtle click sound on navigation.
- **Invert Buttons**: Swap Mouse 4 and Mouse 5 actions.

Configuration is saved in `.minecraft/config/mousenavigation.json`.

---

## Installation

1. Download the latest release from [GitHub Releases](https://github.com/byMr712/MouseNavigation-1.21.4-MinecraftMod/releases).
2. Requires:
   - [Fabric API](https://modrinth.com/mod/fabric-api)
   - [Mod Menu](https://modrinth.com/mod/modmenu) (optional)
3. Place the `.jar` file into your `mods` folder.
4. Launch the game.

---

## Building

1. Requires Java 21 and Fabric Loader for Minecraft 1.21.4.
2. To build the project, run:
   ```bash
   ./gradlew build
   ```
3. The built jar file will be located at `build/libs/MouseNavigation-1.21.4-byMr712.jar`.

---

## Credits & License

- Author: [Mr712](https://github.com/byMr712).
- Distributed under the [Apache License 2.0](LICENSE).
