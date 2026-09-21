#!/bin/bash

cd "$(dirname "$0")/.." || exit 1

echo "Compilation du projet..."
mkdir -p bin

find src -name "*.java" > sources.txt
javac -d bin @sources.txt
rm -f sources.txt

if [ $? -eq 0 ]; then
    echo "Compilation réussie !"
else
    echo "Erreur lors de la compilation."
    exit 1
fi