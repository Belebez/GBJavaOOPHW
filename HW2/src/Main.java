/*
HW2 :
Доделать задания, которые не успели на семинаре.
Переписать прошлое домашнее задание с использованием принципа инкапсуляции


*** Необязательное задание**
* Написать программу - реализацию книжного шкафа в библиотеке.
* Должны иметь возможность добавлять \ удалять книги.
* Узнать кол-во книг
* При запросе сообщить есть ли такая книга у нас или нет
* Делаем с принципом инкапсуляции. Используем геттеры, сеттеры, конструкторы

 */
public class Main {
    public static void main(String[] args) {
        Cars car1 = new Cars("Спортивная", "Ferrari", 2020, 220000.0, 5.0);
        Cars car11 = new Cars("Спортивная", "Lamborgini", 2019, 230000.0, 4.8);
        Cars car2 = new Cars("Легковая", "Лада", 2022, 5000.0, 2.0);
        Cars car3 = new Cars("Внедорожник", "Land Rover", 2022, 10000.0, 4.6);
        Cars car4 = new Cars("Грузовая", "Volvo", 2020, 150000.0, 6.5);
        Cars car5 = new Cars("Легковая", "Nissan", 2014, 50000, 3.0);

        System.out.println(Cars.getCarsList());

//        Race newRace = new Race();
//        newRace.raceTrack(5000, car1, car11, car3, car5);

//        EqualsCars newEqualsCars = new EqualsCars();
//        newEqualsCars.equalsCar(car1, car11);


    }
}