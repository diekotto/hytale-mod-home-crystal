#!/bin/bash

# Initialize a new custom item for the Hytale mod
# Usage: ./scripts/init-item.sh <item_id>

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

if [ -z "$1" ]; then
    echo "Usage: $0 <item_id>"
    echo "Example: $0 MagicWand"
    exit 1
fi

ITEM_ID="$1"

# Define directories
BASE_DIR="$PROJECT_DIR/src/main/resources"
ITEMS_DIR="$BASE_DIR/Server/Item/Items"
ICONS_DIR="$BASE_DIR/Icons/ItemsGenerated"
RESOURCES_DIR="$BASE_DIR/Resources/$ITEM_ID"

# Create directories
mkdir -p "$ITEMS_DIR"
mkdir -p "$ICONS_DIR"
mkdir -p "$RESOURCES_DIR"

# Create the item JSON file
cat > "$ITEMS_DIR/$ITEM_ID.json" << EOF
{
  "TranslationProperties": {
    "Name": "$ITEM_ID",
    "Description": "$ITEM_ID Description"
  },
  "Id": "$ITEM_ID",
  "Icon": "Icons/ItemsGenerated/${ITEM_ID}_icon.png",
  "Model": "Resources/$ITEM_ID/model.blockymodel",
  "Texture": "Resources/$ITEM_ID/model_texture.png",
  "Quality": "Common",
  "MaxStack": 1,
  "Categories": [
    "Items.Custom"
  ]
}
EOF

# Create .gitkeep files for asset directories
touch "$ICONS_DIR/.gitkeep"
touch "$RESOURCES_DIR/.gitkeep"

echo "Created custom item: $ITEM_ID"
echo "  - $ITEMS_DIR/$ITEM_ID.json"
echo "  - $ICONS_DIR/.gitkeep"
echo "  - $RESOURCES_DIR/.gitkeep"
