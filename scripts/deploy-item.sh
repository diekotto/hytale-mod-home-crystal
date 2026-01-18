#!/bin/bash

# Deploy a custom item to the Hytale Assets.zip
# Usage: ./scripts/deploy-item.sh <item_id>

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

if [ -z "$1" ]; then
    echo "Usage: $0 <item_id>"
    echo "Example: $0 MagicWand"
    exit 1
fi

ITEM_ID="$1"

# Source directories
BASE_DIR="$PROJECT_DIR/src/main/resources"
ITEM_JSON="$BASE_DIR/Server/Item/Items/$ITEM_ID.json"
ITEM_ICON="$BASE_DIR/Icons/ItemsGenerated/${ITEM_ID}_icon.png"
ITEM_MODEL="$BASE_DIR/Resources/$ITEM_ID/model.blockymodel"
ITEM_TEXTURE="$BASE_DIR/Resources/$ITEM_ID/model_texture.png"

# Hytale Assets location
HYTALE_DIR="$HOME/Library/Application Support/Hytale/install/release/package/game/latest"
ASSETS_ZIP="$HYTALE_DIR/Assets.zip"
ASSETS_FOLDER="$HYTALE_DIR/Assets"

# Check if item JSON exists
if [ ! -f "$ITEM_JSON" ]; then
    echo "Error: Item JSON not found at $ITEM_JSON"
    echo "Run './scripts/init-item.sh $ITEM_ID' first."
    exit 1
fi

# Check if Assets.zip exists
if [ ! -f "$ASSETS_ZIP" ]; then
    echo "Error: Assets.zip not found at $ASSETS_ZIP"
    exit 1
fi

echo "Deploying item: $ITEM_ID"

# Unzip Assets.zip
echo "Extracting Assets.zip..."
unzip -q -o "$ASSETS_ZIP" -d "$ASSETS_FOLDER"

# Create target directories
mkdir -p "$ASSETS_FOLDER/Server/Item/Items"
mkdir -p "$ASSETS_FOLDER/Icons/ItemsGenerated"
mkdir -p "$ASSETS_FOLDER/Resources/$ITEM_ID"

# Copy item files
echo "Copying item files..."
cp "$ITEM_JSON" "$ASSETS_FOLDER/Server/Item/Items/"

[ -f "$ITEM_ICON" ] && cp "$ITEM_ICON" "$ASSETS_FOLDER/Icons/ItemsGenerated/"
[ -f "$ITEM_MODEL" ] && cp "$ITEM_MODEL" "$ASSETS_FOLDER/Resources/$ITEM_ID/"
[ -f "$ITEM_TEXTURE" ] && cp "$ITEM_TEXTURE" "$ASSETS_FOLDER/Resources/$ITEM_ID/"

# Re-zip Assets
echo "Re-creating Assets.zip..."
cd "$ASSETS_FOLDER"
zip -q -r "$ASSETS_ZIP" .
cd - > /dev/null

# Clean up extracted folder
rm -rf "$ASSETS_FOLDER"

echo "Deployed $ITEM_ID to Assets.zip"
