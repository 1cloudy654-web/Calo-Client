package com.calo.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ModuleRegistry {
    private static final List<CaloModule> MODULES = new ArrayList<>();
    static {
        add(ModuleCategory.VISUALS, "Custom Crosshair", "Custom crosshair overlay");
        add(ModuleCategory.VISUALS, "Motion Blur", "Visual motion effect");
        add(ModuleCategory.VISUALS, "Sky", "Sky visual settings");
        add(ModuleCategory.VISUALS, "Clear View", "Clear visual settings");
        add(ModuleCategory.VISUALS, "Fullbright", "Increase world brightness");
        add(ModuleCategory.VISUALS, "Capes", "Cape display settings");
        add(ModuleCategory.VISUALS, "Glass", "Glass visual settings");
        add(ModuleCategory.VISUALS, "Freelook", "Camera look settings");
        add(ModuleCategory.VISUALS, "Freecam", "Detached camera preview");
        add(ModuleCategory.VISUALS, "Zoom", "Zoom camera");
        add(ModuleCategory.VISUALS, "Weather Notifier", "Weather notification");
        add(ModuleCategory.VISUALS, "Swing Animations", "Hand animation settings");
        add(ModuleCategory.VISUALS, "Hand Aura", "Hand visual effect");
        add(ModuleCategory.VISUALS, "Aspect", "Aspect ratio settings");
        add(ModuleCategory.VISUALS, "Custom Glint", "Item glint settings");
        add(ModuleCategory.VISUALS, "Armor Trim Hider", "Hide armor trim visuals");
        add(ModuleCategory.VISUALS, "Block Overlay", "Block overlay settings");
        add(ModuleCategory.VISUALS, "Custom Models", "Custom model settings");
        add(ModuleCategory.VISUALS, "CsPickaxe", "Pickaxe visual settings");
        add(ModuleCategory.VISUALS, "Custom Accessories", "Accessory visuals");
        add(ModuleCategory.VISUALS, "Custom Skin", "Skin display settings");
        add(ModuleCategory.VISUALS, "Skin Change", "Skin selection");
        add(ModuleCategory.VISUALS, "Name Tags", "Name tag display");
        add(ModuleCategory.VISUALS, "Target HUD", "Target information HUD");
        add(ModuleCategory.VISUALS, "Custom Totems", "Totem visual settings");
        add(ModuleCategory.VISUALS, "Step Tiles", "Tile overlay");
        add(ModuleCategory.VISUALS, "Jump Circles", "Jump visual effect");

        add(ModuleCategory.AC_OFF, "Fly Speed", "Movement speed setting");
        add(ModuleCategory.AC_OFF, "Boatfly", "Boat movement experiment");
        add(ModuleCategory.AC_OFF, "Fly", "Flight module (requires implementation)");
        add(ModuleCategory.AC_OFF, "Speed", "Movement speed module");
        add(ModuleCategory.AC_OFF, "Sprint", "Automatic sprint");
        add(ModuleCategory.AC_OFF, "Jesus", "Water movement experiment");
        add(ModuleCategory.AC_OFF, "Spider", "Climbing experiment");
        add(ModuleCategory.AC_OFF, "Elytra Fly", "Elytra movement settings");
        add(ModuleCategory.AC_OFF, "Elytra Swap", "Elytra swap helper");
        add(ModuleCategory.AC_OFF, "Boat Noclip", "Boat collision experiment");
        add(ModuleCategory.AC_OFF, "Entity Control", "Entity control settings");
        add(ModuleCategory.AC_OFF, "Entity Speed", "Entity speed settings");
        add(ModuleCategory.AC_OFF, "Auto Walk", "Automatic forward movement");
        add(ModuleCategory.AC_OFF, "Auto Jump", "Automatic jump");
        add(ModuleCategory.AC_OFF, "Click TP", "Teleport helper (server dependent)");
        add(ModuleCategory.AC_OFF, "Sneak", "Toggle sneak");
        add(ModuleCategory.AC_OFF, "No Jump Delay", "Jump timing setting");
        add(ModuleCategory.AC_OFF, "Trident Boost", "Trident movement helper");
        add(ModuleCategory.AC_OFF, "Kill Aura", "Combat automation placeholder");
        add(ModuleCategory.AC_OFF, "Criticals", "Combat timing placeholder");
        add(ModuleCategory.AC_OFF, "Velocity", "Knockback setting placeholder");
        add(ModuleCategory.AC_OFF, "No Fall", "Fall damage placeholder");
        add(ModuleCategory.AC_OFF, "Reach", "Reach setting placeholder");
        add(ModuleCategory.AC_OFF, "Speed Mine", "Mining speed placeholder");

        String[] base = {"SusChunks","ChunkFinder","Amethyst Bypass","Chunk Scanner","Suspicious ESP","Tunnel Hole ESP","Bedrock Void ESP","Light Finder","Seed Chunk Finder","Spawner Beam","Player ESP","Player Xray","Block ESP","Storage ESP","Block Notifier","Tracers","Light Debug","Home Meta","Render Distance Toggle","BlockEntity ESP","Motion Scanner","Activity Inspector"};
        for (String s : base) add(ModuleCategory.BASE_FINDING, s, "Base-finding utility; implementation depends on game data");

        String[] combat = {"Anti Trap","Auto Totem","Auto Inv Totem","Anchor Macro","Auto Crystal","Auto Hit Crystal","Auto Double Hand","Aim Assist","Trigger Bot","Hitbox","Auto Clicker","Shield Breaker","Auto Jump Reset","Auto Eat","Auto Firework","Auto Respawn","Fast Use","Key Pearl"};
        for (String s : combat) add(ModuleCategory.COMBAT, s, "Combat utility placeholder");

        String[] donut = {"Auction Sniper","Auto Sell","Auto Shop","Auto Tool","RTP Method","Relog Method","Auto Reconnect","Auto Log","Fake Stats","Fake Pay","Staff Live","Netherite Finder","Panic Order/Pay","Home Reset","Key Homesetter","Auto Mine","Anti Vanish"};
        for (String s : donut) add(ModuleCategory.DONUT, s, "Server-specific utility; requires compatible server/API");

        String[] client = {"Themes","Click GUI","Color Sync","HUD","Inventory HUD","Main Menu","Creamy Keys","Animated Typing","Media Hider","Spotify Player","FPS Booster","Region Map","Hotkeys","Coord Snapper","Custom Inventory","Anti Cheat"};
        for (String s : client) add(ModuleCategory.CLIENT, s, "Client interface setting");

        add(ModuleCategory.CONFIG, "Configs", "Configuration profiles");
    }
    private static void add(ModuleCategory c, String n, String d) { MODULES.add(new CaloModule(n, c, d)); }
    public static List<CaloModule> all() { return Collections.unmodifiableList(MODULES); }
    public static List<CaloModule> byCategory(ModuleCategory c) {
        return MODULES.stream().filter(m -> m.category == c).toList();
    }
}
