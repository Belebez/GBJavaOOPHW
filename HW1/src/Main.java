/*
Добавил следующие методы по ДЗ:

    1. car1.race(distance, Car1, Car2, Car3) - метод эмуляции гонок, задаём дистанцию и передаём еще 3 обекта Cars
    2. roadFruit() - метод поездки за фруктами, добавил к объекту тип авто, на что метод и реагирует, если заехать на грузовой то отлично)
    3. car1.equalsCar(Cars car2) - метод который сравнивает машины, если они одного типа.

 */
 */
public class Main {
    public static void main(String[] args) {
        Cars car1 = new Cars("Спортивная", "Ferrari", 2020, 220000.0, 5.0);
        Cars car11 = new Cars("Спортивная", "Lamborgini", 2019, 230000.0, 4.8);
        Cars car2 = new Cars("Легковая", "Лада", 2022, 5000.0, 2.0);
        Cars car3 = new Cars("Внедорожник", "Land Rover", 2022, 10000.0, 4.6);
        Cars car4 = new Cars("Грузовая", "Volvo", 2020, 150000.0, 6.5);
        car1.race(5000, car11, car2, car4);
//        car4.roadFruit();
//        car1.equalsCar(Cars car11);

    }
}