public class EqualsCars {

    public void equalsCar(Cars car1, Cars car2) {
        if (car1.getTypeCar().equalsIgnoreCase(car2.getTypeCar())) {
            System.out.print("Их можно сравнить по параметрам, они одного типа.\n");

            if (car1.getYear() > car2.getYear()) {
                System.out.printf("У %s год выпуска %d, т.е она новее %s с годом выпуска %d\n",
                        car1.getModel(), car1.getYear(), car2.getModel(), car2.getYear());
            } else {
                System.out.printf("У %s год выпуска %d, т.е она новее %s с годом выпуска %d\n",
                        car2.getModel(), car2.getYear(), car1.getModel(), car1.getYear());
            }
            if (car1.getPrice() < car2.getPrice()) {
                System.out.print(car1.getModel() + " стоит меньше " + car2.getModel() + " на " +
                        (car2.getPrice() - car1.getPrice()) + " euro" + "\n");
            } else {
                System.out.print(car2.getModel() + " стоит меньше " + car1.getModel() + " на " +
                        (car1.getPrice() - car2.getPrice()) + " euro" + "\n");
            }
            if (car1.getPower() > car2.getPower()) {
                System.out.print("Двигатель " + car1.getModel() + " мощнее двигателя " + car2.getModel() + " " +
                        car1.getPower() + "l против" + car2.getPower() + "l" + "\n");
            } else {
                System.out.print("Двигатель " + car2.getPower() + " мощнее двигателя " + car1.getModel() + " " +
                        car2.getPower() + "l против " + car1.getPower() + "l" + "\n");
            }

        } else if ((car1.getTypeCar().equalsIgnoreCase("Спортивная"))&(car2.getTypeCar().equalsIgnoreCase("Легковая"))) {
            System.out.println("Неравный бой..хоть они примерно одного класса.\n");
        } else if ((car1.getTypeCar().equalsIgnoreCase("Спортивная"))&(car2.getTypeCar().equalsIgnoreCase("Внедорожник"))) {
            System.out.println("Одна хороша на треке, другая на бездорожье\nИх лучше не сравнивать.\n");
        } else {
            System.out.println("Это разные вида машины...  их нельзя сравнить.\n");
        }
    }
}
