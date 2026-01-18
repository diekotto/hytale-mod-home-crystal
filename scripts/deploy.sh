#!/bin/bash

# Deploy script for HomeCrystal mod
# Copies the built JAR to the Hytale mods directory

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

cd "$PROJECT_DIR"

echo "Building HomeCrystal..."
mvn clean package -q

echo "Build complete: target/HomeCrystal-1.0-SNAPSHOT.jar"

JAR_NAME="HomeCrystal-1.0-SNAPSHOT.jar"
SOURCE_JAR="$PROJECT_DIR/target/$JAR_NAME"
MODS_DIR="$HOME/Library/Application Support/Hytale/UserData/Mods"

# Check if the JAR exists
if [ ! -f "$SOURCE_JAR" ]; then
    echo "Error: $JAR_NAME not found in target directory."
    echo "Run 'mvn package' first to build the mod."
    exit 1
fi

# Create mods directory if it doesn't exist
mkdir -p "$MODS_DIR"

# Copy the JAR to the mods directory
cp "$SOURCE_JAR" "$MODS_DIR/$JAR_NAME"

echo "Deployed $JAR_NAME to $MODS_DIR"
