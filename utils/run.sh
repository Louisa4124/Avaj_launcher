#!/bin/bash

cd "$(dirname "$0")/.." || exit 1

SCENARIO="${1:-scenario.txt}"

if [ ! -f "$SCENARIO" ]; then
    echo "Erreur : Fichier '$SCENARIO' introuvable."
    exit 1
fi

if [ ! -d "bin" ]; then
    echo "Erreur : Le dossier bin/ n'existe pas. Lance d'abord ./utils/build.sh"
    exit 1
fi

echo "Lancement de la simulation avec $SCENARIO..."
java -cp bin Main "$SCENARIO"