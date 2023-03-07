package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class AccuweatherModel implements WeatherModel {

    //https://geocode-maps.yandex.ru/1.x/?format=json&apikey=ваш API-ключ&geocode=Москва
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "xmPddqrfpAlizRrKLh096qcAkyaEfp2H";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String METRIC = "metric";
    private static final String TRUE = "true";


    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(String selectedCity, Period period) throws IOException {

        switch (period) {
            case ONE_DAY:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC, TRUE)
                        .addQueryParameter("language", "ru-ru")
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl1)
                        .build();

                Response oneDayForecastResponse1 = okHttpClient.newCall(request).execute();
                String weatherResponse1 = oneDayForecastResponse1.body().string();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

                String[] commentWeather = objectMapper.readTree(weatherResponse1).get("Headline").get("Text").asText().split(": ");
                String dateDay = objectMapper.readTree(weatherResponse1).get("DailyForecasts").get(0)
                        .get("Date")
                        .asText()
                        .substring(0, 10);
                double tempMinDay = objectMapper.readTree(weatherResponse1).get("DailyForecasts").get(0).get("Temperature")
                        .get("Minimum")
                        .get("Value")
                        .asDouble();
                double tempMaxDay = objectMapper.readTree(weatherResponse1).get("DailyForecasts").get(0).get("Temperature")
                        .get("Maximum")
                        .get("Value")
                        .asDouble();
                String dayDayWeather = objectMapper.readTree(weatherResponse1).get("DailyForecasts").get(0).get("Day")
                        .get("IconPhrase")
                        .asText();
                String nightDayWeather = objectMapper.readTree(weatherResponse1).get("DailyForecasts").get(0).get("Night")
                        .get("IconPhrase")
                        .asText();
                System.out.print("\nГород: " + selectedCity + "\n" +
                        "Дата : " + dateDay + "\n" +
                        "Минимальная температура: " + tempMinDay + "°C\n" +
                        "Максимальная температура: " + tempMaxDay + "°C\n" +
                        "Днём: " + dayDayWeather + ", вечером: " + nightDayWeather + "\n" +
                        "Прогноз: " + commentWeather[1] + "\n");
                break;

            case FIVE_DAYS:
                HttpUrl httpUrl5 = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(METRIC, TRUE)
                        .addQueryParameter("language", "ru-ru")
                        .build();

                Request request5 = new Request.Builder()
                        .url(httpUrl5)
                        .build();

                Response oneDayForecastResponse5 = okHttpClient.newCall(request5).execute();
                String weatherResponse5 = oneDayForecastResponse5.body().string();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

                System.out.print("\nГород: " + selectedCity + "\n" +
                        "Прогноз на 5 дней: " + "\n" +
                        "------------------------------------------");
                for (int i = 0; i < 5; i++) {
                    String dateDay5 = objectMapper.readTree(weatherResponse5).get("DailyForecasts").get(i)
                            .get("Date")
                            .asText()
                            .substring(0, 10);
                    double tempMinDay5 = objectMapper.readTree(weatherResponse5).get("DailyForecasts").get(i).get("Temperature")
                            .get("Minimum")
                            .get("Value")
                            .asDouble();
                    double tempMaxDay5 = objectMapper.readTree(weatherResponse5).get("DailyForecasts").get(i).get("Temperature")
                            .get("Maximum")
                            .get("Value")
                            .asDouble();
                    String dayDayWeather5 = objectMapper.readTree(weatherResponse5).get("DailyForecasts").get(i).get("Day")
                            .get("IconPhrase")
                            .asText();
                    String nightDayWeather5 = objectMapper.readTree(weatherResponse5).get("DailyForecasts").get(i).get("Night")
                            .get("IconPhrase")
                            .asText();
                    System.out.print("\nДата : " + dateDay5 + "\n" +
                            "Минимальная температура: " + tempMinDay5 + "°C\n" +
                            "Максимальная температура: " + tempMaxDay5 + "°C\n" +
                            "Днём: " + dayDayWeather5 + ", вечером: " + nightDayWeather5 + "\n" +
                            "------------------------------------------");
                }
                break;
        }
    }

    private String detectCityKey (String selectedCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responceString = response.body().string();

        String cityKey = objectMapper.readTree(responceString).get(0).at("/Key").asText();

        return cityKey;
    }


}
