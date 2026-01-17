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

## License

MIT License - see [LICENSE](LICENSE) for details.
