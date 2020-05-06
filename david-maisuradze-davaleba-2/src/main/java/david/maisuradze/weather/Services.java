package david.maisuradze.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Services {
    public static String get(String urlParam) throws Exception{
        URL url = new URL(urlParam);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        StringBuilder resp = new StringBuilder();
        String output;
        System.out.println("Output from Server :  \n");
        while ((output = br.readLine()) != null) {
            resp.append(output);
        }
        conn.disconnect();
        return resp.toString();
    }
}
