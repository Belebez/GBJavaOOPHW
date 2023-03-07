package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModelAcc = new AccuweatherModel();
//    private WeatherModel weatherModelYandex = new YandexWeatherModel();

    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.ONE_DAY);
        variants.put(2, Period.FIVE_DAYS);
    }

    public void getWeather(String serviceWeather, String command, String city) throws IOException {
        Integer userIntegerInput = Integer.parseInt(command);
        switch (serviceWeather) {
            case "1":
                switch (variants.get(userIntegerInput)) {
                    case ONE_DAY:
                        weatherModelAcc.getWeather(city, Period.ONE_DAY);
                        break;
                    case FIVE_DAYS:
                        weatherModelAcc.getWeather(city, Period.FIVE_DAYS);
                        break;
                }
            case "2":
                System.out.println("Пока в стадии разработки...");
//                switch (variants.get(command)) {
//                    case ONE_DAY:
//                        weatherModelYandex.getWeather(city, Period.ONE_DAY);
//                        break;
//                    case FIVE_DAYS:
//                        weatherModelYandex.getWeather(city, Period.FIVE_DAYS);
//                        break;
//                }
        }
    }
}
