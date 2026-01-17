#!/bin/bash

# Build script for HomeCrystal mod

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"

cd "$PROJECT_DIR"

echo "Building HomeCrystal..."
mvn clean package -q

echo "Build complete: target/HomeCrystal-1.0-SNAPSHOT.jar"
