package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class YandexWeatherModel implements WeatherModel{
    // GET https://api.weather.yandex.ru/v2/informers?lat=55.75396&lon=37.620393
    //
    //X-Yandex-API-Key:

    //https://geocode-maps.yandex.ru/1.x/?apikey=ваш API-ключ&format=json&geocode=Тверская+6

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }



    @Override
    public void getWeather(String selectedCity, Period period) {

    }

}
