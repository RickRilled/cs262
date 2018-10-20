package edu.calvin.cs262.ril2.homework02;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {



    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    @SuppressLint("LongLogTag")
    static String getPlayerInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String playerJSONString = null;

        try{
            String url = "https://calvincs262-monopoly.appspot.com/monopoly/v1/player";
            url += (queryString.length() == 0) ? "s/" : "/" + queryString;
            URL requestURL = new URL(url);
            Log.d("edu.calvin.cs262.ril2.homework02.NetworkUtils", url);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }
            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            playerJSONString = buffer.toString();



        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

        return playerJSONString;
    }
}
