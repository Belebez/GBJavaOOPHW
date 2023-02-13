/*
Доработайте программу в свободном стиле.
Можно сравнить 2 автомобиля между собой
Или пусть авто заедет за фруктами :-)
Добавьте несколько произвольных методов и свойств

ДОП: Сделать гонки:
- задаём растояние
- едут до финиша.
Сказать кто победит.

 */


import java.util.Random;

public class Cars {
    String typeCar;
    String model;
    int year;
    double price;
    double power;
    private int speed;
    private boolean startCar;

    public Cars(String type, String model, int year, double price, double power) {
        this.typeCar = type;
        this.model = model;
        this.year = year;
        this.price = price;
        this.power = power;
    }

    public void race(int distance, Cars car2, Cars car3, Cars car4) {

        double quarterDis = distance / 4;
        int quarterDis1 = distance / 4;
        double midSpeedCar1 = 0.0;
        double midSpeedCar2 = 0.0;
        double midSpeedCar3 = 0.0;
        double midSpeedCar4 = 0.0;
        double fTimeDis1 = 0.0;
        double fTimeDis2 = 0.0;
        double fTimeDis3 = 0.0;
        double fTimeDis4 = 0.0;
        int count = 0;

        while (quarterDis1 <= distance) {
            Random rand = new Random();
            this.speed = rand.nextInt(230) + 50;
            car2.speed = rand.nextInt(230) + 50;
            car3.speed = rand.nextInt(230) + 50;
            car4.speed = rand.nextInt(230) + 50;
            midSpeedCar1 += this.speed;
            midSpeedCar2 += car2.speed;
            midSpeedCar3 += car3.speed;
            midSpeedCar4 += car4.speed;
            double timeDis1 = quarterDis / this.speed;
            double timeDis2 = quarterDis / car2.speed;
            double timeDis3 = quarterDis / car3.speed;
            double timeDis4 = quarterDis / car4.speed;
            fTimeDis1 += timeDis1;
            fTimeDis2 += timeDis2;
            fTimeDis3 += timeDis3;
            fTimeDis4 += timeDis4;

            if (count != 3) {
                System.out.printf("Показания времени после %s метров, пройденного отрезка:\n" +
                                "1. Машина на первой полосе - %.2f\n" +
                                "2. Машина на второй полосе - %.2f\n" +
                                "3. Машина на третьей полосе - %.2f\n" +
                                "4. Машина на четвертой полосе - %.2f\n",
                        quarterDis1, timeDis1, timeDis2, timeDis3, timeDis4);
            } else {
                midSpeedCar1 /= 4;
                midSpeedCar2 /= 4;
                midSpeedCar3 /= 4;
                midSpeedCar4 /= 4;
                System.out.printf("Итоговое время за дистанцую в %s метров:\n" +
                                "1. Машина на первой полосе - %.2f\n" +
                                "2. Машина на второй полосе - %.2f\n" +
                                "3. Машина на третьей полосе - %.2f\n" +
                                "4. Машина на четвертой полосе - %.2f\n",
                        distance, fTimeDis1, fTimeDis2, fTimeDis3, fTimeDis4);

                if ((fTimeDis1 < fTimeDis2)&&(fTimeDis1 < fTimeDis3)&&(fTimeDis1 < fTimeDis4)) {
                    System.out.printf("Победителем заезда стал первый участник, на машине %s, со средней скоростью %.2f км/ч", this.model, midSpeedCar1);
                } else if ((fTimeDis2 < fTimeDis1)&&(fTimeDis2 < fTimeDis3)&&(fTimeDis2 < fTimeDis4)) {
                    System.out.printf("Победителем заезда стал второй участник, на машине %s, со средней скоростью %.2f км/ч", car2.model, midSpeedCar2);
                } else if ((fTimeDis3 < fTimeDis1)&&(fTimeDis3 < fTimeDis2)&&(fTimeDis3 < fTimeDis4)) {
                    System.out.printf("Победителем заезда стал третий участник, на машине %s, со средней скоростью %.2f км/ч", car3.model, midSpeedCar3);
                } else {
                    System.out.printf("Победителем заезда стал четвертый участник, на машине %s, со средней скоростью %.2f км/ч", car4.model, midSpeedCar4);
                }
            }
            count++;
            quarterDis1 += quarterDis;
        }
    }

    public void roadFruit() {
        if (typeCar.equalsIgnoreCase("Грузовая")) {
            System.out.printf("%s\nОтлично, перевёзем сразу всю партию товара.\n", typeCar);
        } else if (typeCar.equalsIgnoreCase("Внедорожник")) {
            System.out.printf("%s\nНеплохо, но всё-таки, лучше на грузовой приезжай, всё равно много не уместить.\n", typeCar);
        } else if (typeCar.equalsIgnoreCase("Легковая")) {
            System.out.printf("Друг, y тебя '%s' машина, ты больше потратишь на перевезку партии, нужно что-то побольше.\n", typeCar);
        }
        else if (typeCar.equalsIgnoreCase("Спортивная")) {
            System.out.print("Едь гоняй!!! Это тачка для трека)))\n");
        } else {
            System.out.print("Не пойму...   что у тебя за тачка)))\n");
        }
    }

    public void equalsCar(Cars car2) {
        if (typeCar.equalsIgnoreCase(car2.typeCar)) {
            System.out.print("Их можно сравнить по параметрам, они одного типа.\n");

            if (year > car2.year) {
                System.out.printf("У %s год выпуска %d, т.е она новее %s с годом выпуска %d\n", model, year, car2.model, car2.year);
            } else {
                System.out.printf("У %s год выпуска %d, т.е она новее %s с годом выпуска %d\n", car2.model, car2.year, model, year);
            }
            if (price < car2.price) {
                System.out.print(model + " стоит меньше " + car2.model + " на " + (car2.price - price) + " euro" + "\n");
            } else {
                System.out.print(car2.model + " стоит меньше " + model + " на " + (price - car2.price) + " euro" + "\n");
            }
            if (power > car2.power) {
                System.out.print("Двигатель " + model + " мощнее двигателя " + car2.model + " " + power + "l против" + car2.power + "l" + "\n");
            } else {
                System.out.print("Двигатель " + car2.model + " мощнее двигателя " + model + " " + car2.power + "l против " + power + "l" + "\n");
            }

        } else if ((typeCar.equalsIgnoreCase("Спортивная"))&(car2.typeCar.equalsIgnoreCase("Легковая"))) {
            System.out.println("Неравный бой..хоть они примерно одного класса.\n");
        } else if ((typeCar.equalsIgnoreCase("Спортивная"))&(car2.typeCar.equalsIgnoreCase("Внедорожник"))) {
            System.out.println("Одна хороша на треке, другая на бездорожье\nИх лучше не сравнивать.\n");
        } else {
            System.out.println("Это разные вида машины...  их нельзя сравнить.\n");
        }
    }



    public void powerOn(){
        if (!startCar){
            this.startCar = true;
            System.out.println("Машина завелась");
        } else {
            System.out.println("Машина уже заведена");
        }
    }

    public void powerOff() {
        if (startCar){
            this.startCar = false;
            System.out.println("Машина заглохла");
        } else {
            System.out.println("Машина не раотает");
        }

    }

    public void roadDrive(String s) {
        if (!startCar){
            System.out.print("Aвто не заведено. И мы не можем ехать\n");
        } else {
            System.out.printf("Мы на %s едем в %s\n", model, s);
        }
    }

    public String toString() {
        return "\nИнформация по машине:\n" +
                "1. Вид автомобиля = " + typeCar + "\n" +
                "2. Марка автомобиля = " + model + "\n" +
                "3. Год выпуска = " + year + "\n" +
                "4. Стоимость = " + price + " euro\n" +
                "5. Объём двигателя = " + power + " liters\n";
    }
}

