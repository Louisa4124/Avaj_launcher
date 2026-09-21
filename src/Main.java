import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // 1. Vérification qu'un argument (le fichier texte) a bien été fourni
        if (args.length < 1) {
            System.err.println("Erreur : Aucun fichier de scénario fourni.");
            System.err.println("Usage : java Main <chemin_du_fichier>");
            return;
        }

        String filename = args[0];

        // Initialisation du Logger vers simulation.txt
        Logger.init("simulation.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // 2. Lecture du nombre de répétitions (première ligne)
            String line = reader.readLine();
            if (line == null) {
                System.err.println("Erreur : Le fichier est vide.");
                Logger.close();
                return;
            }

            int simulationCycles = Integer.parseInt(line.trim());
            if (simulationCycles <= 0) {
                System.err.println("Erreur : Le nombre de simulations doit être un entier positif.");
                Logger.close();
                return;
            }

            // 3. Initialisation de la tour météo
            WeatherTower weatherTower = new WeatherTower();

            // 4. Lecture et création des aéronefs
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();

                // Ignorer les lignes vides
                if (line.isEmpty()) {
                    continue;
                }

                // Découpage de la ligne : TYPE NOM LONGITUDE LATITUDE HAUTEUR
                String[] parts = line.split("\\s+");
                if (parts.length != 5) {
                    System.err.println("Erreur ligne " + lineNumber + " : Format invalide. Attendu : TYPE NOM LONGITUDE LATITUDE HAUTEUR");
                    Logger.close();
                    return;
                }

                String type = parts[0];
                String name = parts[1];
                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);

                if (longitude < 0 || latitude < 0 || height < 0) {
                    System.err.println("Erreur ligne " + lineNumber + " : Les coordonnées doivent être des entiers positifs.");
                    Logger.close();
                    return;
                }

                // Création et enregistrement de l'aéronef
                Coordinates coordinates = new Coordinates(longitude, latitude, height);
                Flyable flyable = AircraftFactory.getInstance().newAircraft(
                        type,
                        name,
                        coordinates
                );

                if (flyable != null) {
                    flyable.registerTower(weatherTower);
                }
            }

            // 5. Exécution de la simulation
            for (int i = 0; i < simulationCycles; i++) {
                weatherTower.changeWeather();
            }

        } catch (NumberFormatException e) {
            System.err.println("Erreur de format numérique dans le fichier : " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erreur d'accès/lecture du fichier : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur lors de l'exécution : " + e.getMessage());
        } finally {
            // Fermeture obligatoire du flux d'écriture
            Logger.close();
        }

        System.out.println("Simulation terminée ! Fichier simulation.txt généré.");
    }
}