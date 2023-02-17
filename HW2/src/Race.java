import java.util.Random;

public class Race {

//    ArrayList<Cars> carsList = new ArrayList<>(Cars.getCarsList());  // нужно продумать как использовать массив

    public void raceTrack(int distance, Cars car1, Cars car2, Cars car3, Cars car4) {

        // создадим 2 переменные, которая равна 1/4 заданной дистанции. Одна будет меняться в цикле,
        // другая нужна постоянной, для определения прохождения участка пути за отрезок.
        double quarterDis = distance / 4;
        double quarterDis1 = distance / 4;

        // переменные для расчёта  средней скорости на всё участке дистанции
        double midSpeedCar1 = 0.0;
        double midSpeedCar2 = 0.0;
        double midSpeedCar3 = 0.0;
        double midSpeedCar4 = 0.0;

        // переменные для подсчёта затраченного времени на всю дитанцию и определения победителя
        double fTimeDis1 = 0.0;
        double fTimeDis2 = 0.0;
        double fTimeDis3 = 0.0;
        double fTimeDis4 = 0.0;

        // переменная для подсчёта, какой отрезок проходят машины
        int count = 0;

        while (quarterDis1 <= distance) {
            Random rand = new Random();

            //установим скорость машинам на участке, минимальную сделаем 50 км/ч
//            for (Cars car: carsList) {
//                car.setSpeed(rand.nextInt(230) + 50);
//            }
            //  здесь можно заменить с помощью цикла, но как быть в дальнейшем....  как обращаться к нужному объекту..
            // если, например, мы используем не весь лист...   и все равно, Car car1 = carsList.get(i), придется применять
            // т.е. возвращаемся к прежнему формату...

            car1.setSpeed(rand.nextInt(230) + 50);
            car2.setSpeed(rand.nextInt(230) + 50);
            car3.setSpeed(rand.nextInt(230) + 50);
            car4.setSpeed(rand.nextInt(230) + 50);

            // в переменную средней скорости, положим текущее значение
            midSpeedCar1 += car1.getSpeed();
            midSpeedCar2 += car2.getSpeed();
            midSpeedCar3 += car3.getSpeed();
            midSpeedCar4 += car4.getSpeed();

            // определеим время потраченное на отрез пути
            double timeDis1 = quarterDis / car1.getSpeed();
            double timeDis2 = quarterDis / car2.getSpeed();
            double timeDis3 = quarterDis / car3.getSpeed();
            double timeDis4 = quarterDis / car4.getSpeed();

            // добив значения времени, затраченное на этот участок пути, для подсчета общего времени
            fTimeDis1 += timeDis1;
            fTimeDis2 += timeDis2;
            fTimeDis3 += timeDis3;
            fTimeDis4 += timeDis4;

            // пока машины едут 3 первых отрезка пути, выводим информацию по отрезку
            if (count != 3) {
                System.out.printf("\nПоказания времени после %s метров, пройденного отрезка:\n" +
                                "1. Машина на первой полосе - %.2f\n" +
                                "2. Машина на второй полосе - %.2f\n" +
                                "3. Машина на третьей полосе - %.2f\n" +
                                "4. Машина на четвертой полосе - %.2f\n",
                        quarterDis1, timeDis1, timeDis2, timeDis3, timeDis4);
            } else {
                // на последнем участке, показываем общее время и среднюю скорость машины
                // находим сребнюю скорость по каждой машине
                midSpeedCar1 /= 4;
                midSpeedCar2 /= 4;
                midSpeedCar3 /= 4;
                midSpeedCar4 /= 4;

                // подводим итоги заезда
                System.out.printf("\nИтоговое время за дистанцую в %s метров:\n" +
                                "1. Машина на первой полосе - %.2f, последний участок пройден за %.2f\n" +
                                "2. Машина на второй полосе - %.2f, последний участок пройден за %.2f\n" +
                                "3. Машина на третьей полосе - %.2f, последний участок пройден за %.2f\n" +
                                "4. Машина на четвертой полосе - %.2f, последний участок пройден за %.2f\n",
                        distance, fTimeDis1, timeDis1, fTimeDis2, timeDis2, fTimeDis3, timeDis3, fTimeDis4, timeDis4);

                // ищем победителя заезда
                if ((fTimeDis1 < fTimeDis2)&&(fTimeDis1 < fTimeDis3)&&(fTimeDis1 < fTimeDis4)) {
                    System.out.printf("Победителем заезда стал первый участник, на машине %s, " +
                            "со средней скоростью %.2f км/ч", car1.getModel(), midSpeedCar1);
                } else if ((fTimeDis2 < fTimeDis1)&&(fTimeDis2 < fTimeDis3)&&(fTimeDis2 < fTimeDis4)) {
                    System.out.printf("Победителем заезда стал второй участник, на машине %s, " +
                            "со средней скоростью %.2f км/ч", car2.getModel(), midSpeedCar2);
                } else if ((fTimeDis3 < fTimeDis1)&&(fTimeDis3 < fTimeDis2)&&(fTimeDis3 < fTimeDis4)) {
                    System.out.printf("Победителем заезда стал третий участник, на машине %s, " +
                            "со средней скоростью %.2f км/ч", car3.getModel(), midSpeedCar3);
                } else {
                    System.out.printf("Победителем заезда стал четвертый участник, " +
                            "на машине %s, со средней скоростью %.2f км/ч", car4.getModel(), midSpeedCar4);
                }
            }

            // меняем значения для корректного вывода и окончания цикла
            count++;
            quarterDis1 += quarterDis;
        }
    }
}
