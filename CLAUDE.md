# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build the mod
mvn clean package

# Or use the build script
./scripts/build.sh

# Deploy to Hytale mods folder (macOS)
./scripts/deploy.sh
```

## Architecture

This is a Hytale server mod using Java 25 and Maven. The mod allows players to teleport home using a Home Crystal item.

### Plugin Structure

- **HomeCrystalPlugin** (`src/main/java/.../HomeCrystalPlugin.java`): Main entry point extending `JavaPlugin`. Registers commands and events in `setup()`.
- **Commands**: Extend `AbstractCommand` and are registered via `getCommandRegistry().registerCommand()`
- **Events**: Static handler methods registered via `getEventRegistry().registerGlobal()`

### Hytale API

The Hytale server API is provided as a dependency at `~/.m2/repository/com/hypixel/hytale/HytaleServer-parent/1.0-SNAPSHOT/`. Key base classes:

- `com.hypixel.hytale.server.core.plugin.JavaPlugin` - Plugin base class
- `com.hypixel.hytale.server.core.command.system.AbstractCommand` - Command base class
- `com.hypixel.hytale.server.core.entity.entities.Player` - Player entity
- `com.hypixel.hytale.server.core.Message` - Message creation for player communication

Use `javap -p -cp <jar> <class>` to inspect API classes.

### Command Permissions

Commands require permission groups set in the constructor:
```java
setPermissionGroup(GameMode.Adventure);
setPermissionGroup(GameMode.Creative);
```
