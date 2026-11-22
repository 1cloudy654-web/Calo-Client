# Calo Client — Minecraft 1.21.11

This is a Fabric client-mod starter project with the seven categories and module names from the supplied reference image.

## Build
Requires JDK 21 and internet access for Gradle dependencies.

Linux / Chromebook Linux:
```bash
chmod +x gradlew
./gradlew build
```

Windows:
```bat
gradlew.bat build
```

The output JAR is in `build/libs/`.

## Controls
- Right Shift: open / close the GUI
- ESC: close the GUI
- Click a module row: toggle its visual enabled state
- Type while the GUI is open: filter modules
- Backspace: edit the filter

## Important implementation note
The project currently provides the GUI, module registry, search, and toggle state. Many entries shown in the reference image are server-specific or gameplay automation features and are listed as placeholders until their behavior is implemented and tested. A visible ON state does not mean a placeholder feature is operational.

## Compatibility
Minecraft 1.21.11, Java 21, Fabric Loader / Fabric API. Dependency versions are declared in `gradle.properties`; if Fabric updates its published versions, update those values to matching 1.21.11 releases.
