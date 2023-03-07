package org.example;

import java.io.IOException;

public interface WeatherModel {

    public default void getWeather(String selectedCity, Period period) throws IOException {
    }
}
