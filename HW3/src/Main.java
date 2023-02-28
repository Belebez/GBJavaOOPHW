/*
Создать иерархию родительский и дочернии классы для Транспорта
Например Транспорт - > Автомобиль - > Автобус
Транспорт - > Автомобиль - > Легковой
Используем наследование, инкапсуляцию
 */


public class Main {
    public static void main(String[] args) {
        Transport bus1 = new Bus();
        Transport train1 = new PassengerTrain();
        Transport bus2 = new Bus();
        Transport train2 = new PassengerTrain();
        System.out.println(bus1);
        System.out.println(train1);
        System.out.println(bus2);
        System.out.println(train2);

    }
}