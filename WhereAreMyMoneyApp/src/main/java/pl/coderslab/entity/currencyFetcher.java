package pl.coderslab.entity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

public class currencyFetcher {

    static double fetchCurrencyRateToUSD(String fromCur) throws IOException, JSONException {

        String apiKey = "bdc7864fed8efc9c0c05";
        String GET_URL = "https://free.currconv.com/api/v7/convert?q=" + fromCur + "_USD&compact=ultra&apiKey=" + apiKey;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject obj = new JSONObject(response.toString());
            String key = fromCur + "_USD";
            Double exchangeRate = obj.getDouble(key);

            return exchangeRate;
        }
        return 0;


    }
    private static  double  fetchYearAgoValue(String fromCur) throws IOException, JSONException {

        String apiKey = "bdc7864fed8efc9c0c05";
        String GET_URL = "https://free.currconv.com/api/v7/convert?q=" + fromCur + "_USD&compact=ultra&date=" + fetchYearAgoDate() + "&apiKey=" + apiKey ;

        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }in.close();

            JSONObject obj = new JSONObject(response.toString());
            String change  = String.valueOf(obj).substring(25, 30);

            return Double.parseDouble(change);
        }
        return 0;
    }
    public static double fetchYearChange(String symbol) throws IOException, JSONException {
        return ((fetchCurrencyRateToUSD(symbol)/fetchYearAgoValue(symbol))-1)*100;
    }
    static String fetchYearAgoDate() throws IOException {

        LocalDate todaysDate = LocalDate.now();
        LocalDate yearAgoDate = todaysDate.minusDays(365);

        return String.valueOf(yearAgoDate);
    }


}



