import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static PrintWriter writer;

    public static void init(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier log : " + e.getMessage());
        }
    }

    public static void log(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }

    public static void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}