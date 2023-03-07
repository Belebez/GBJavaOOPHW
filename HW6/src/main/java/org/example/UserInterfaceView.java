package org.example;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nСервис для получения погоды.\n" +
                    "1. Сервис Accuweather\n" +
                    "2. Сервис Yandex.Погода\n" +
                    "\n" +
                    "0. Выход.\n" +
                    "\n" +
                    "Введите пункт меню --> ");
            String serviceWeather = scanner.next();

            if (serviceWeather.equals("0")) break;

            System.out.print("\n1. Для получения погоды на сегодня\n" +
                    "2. Для прогноза на 5 дней\n" +
                    "\n" +
                    "Введите пункт меню --> ");
            String command = scanner.next();

            System.out.print("\nВведите название города --> ");
            String city = scanner.next();

            //TODO* сделать метод валидации пользовательского ввода

            try {
                controller.getWeather(serviceWeather, command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        UserInterfaceView ui = new UserInterfaceView();
//        ui.runInterface();
//    }
}
