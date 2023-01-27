import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class CurrencyTracker {

    public static void main(String[] args) throws IOException {

        // Currency codes for which exchange rates are to be tracked
        String[] currencies = {"USD", "EUR", "GBP", "JPY"};

        while (true) {
            // Loop through the currencies
            for (String currency : currencies) {
                // Get the exchange rate for the currency
                double exchangeRate = getExchangeRate(currency);
                System.out.println(currency + ": " + exchangeRate);
            }
            // Sleep for 1 minute before checking the exchange rates again
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static double getExchangeRate(String currencyCode) throws IOException {
        // Open a connection to the exchange rate API
        URL url = new URL("https://api.exchangeratesapi.io/latest?base=" + currencyCode);
        URLConnection connection = url.openConnection();

        // Get the exchange rate as a double
        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        String response = scanner.nextLine();
        int index = response.indexOf("") + 6;
        String rate = response.substring(index, index + 6);
        double exchangeRate = Double.parseDouble(rate);
        scanner.close();
        return exchangeRate;
    }
}