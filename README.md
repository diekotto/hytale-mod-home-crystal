# HomeCrystal

A Hytale mod that allows players to use a custom item to instantly teleport back home.

## Features

- Use a Home Crystal item to instantly return to your home location
- Simple and lightweight mod

## Requirements

- Java 25+
- Maven
- Hytale with mod support

## Building

```bash
mvn clean package
```

This will create `HomeCrystal-1.0-SNAPSHOT.jar` in the `target/` directory.

## Installation

### Automatic (macOS)

Run the deploy script to copy the mod to your Hytale mods folder:

```bash
./scripts/deploy.sh
```

### Manual

Copy `target/HomeCrystal-1.0-SNAPSHOT.jar` to:

- **macOS**: `~/Library/Application Support/Hytale/UserData/Mods/`

## Development

### Hytale API Reference

The Hytale server API is located at:

```
~/.m2/repository/com/hypixel/hytale/HytaleServer-parent/1.0-SNAPSHOT/HytaleServer-parent-1.0-SNAPSHOT.jar
```

Key classes (use `javap -p -cp <jar> <class>` to inspect):

| Class                                                                 | Description                      |
| --------------------------------------------------------------------- | -------------------------------- |
| `com.hypixel.hytale.server.core.plugin.JavaPlugin`                    | Base class for plugins           |
| `com.hypixel.hytale.server.core.command.system.AbstractCommand`       | Base class for commands          |
| `com.hypixel.hytale.server.core.entity.entities.Player`               | Player entity                    |
| `com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent` | Player ready event               |
| `com.hypixel.hytale.protocol.GameMode`                                | Game modes (Adventure, Creative) |

### Command Permissions

Commands require permission groups to be set in the constructor:

```java
setPermissionGroup(GameMode.Adventure);
setPermissionGroup(GameMode.Creative);
```

## License

MIT License - see [LICENSE](LICENSE) for details.
