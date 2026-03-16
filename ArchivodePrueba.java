import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ArchivodePrueba {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java ArchivodePrueba <URL>");
            System.exit(1);
        }

        String urlString = args[0];
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Status OK: Servicio disponible en " + urlString);
                System.exit(0);
            } else {
                System.out.println("Status FAIL: Código de respuesta " + responseCode + " para " + urlString);
                System.exit(1);
            }
        } catch (IOException e) {
            System.out.println("Status FAIL: No se pudo conectar a " + urlString + " - " + e.getMessage());
            System.exit(1);
        }
    }
}