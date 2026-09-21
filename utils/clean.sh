#!/bin/bash

cd "$(dirname "$0")/.." || exit 1

echo "Nettoyage du projet..."
rm -rf bin/
rm -f simulation.txt sources.txt
echo "Projet nettoyé !"