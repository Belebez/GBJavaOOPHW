


import java.util.ArrayList;
import java.util.Random;

public class Cars {
    private String typeCar;
    private String model;
    private int year;
    private double price;
    private double power;
    private int speed;
    private boolean startCar;
    private static ArrayList<Cars> carsList = new ArrayList<>();

    public Cars(String type, String model, int year, double price, double power) {
        this.typeCar = type;
        this.model = model;
        this.year = year;
        this.price = price;
        this.power = power;
        carsList.add(Cars.this);
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

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getPower() {
        return power;
    }

    public static ArrayList<Cars> getCarsList() {
        return carsList;
    }
}

