import java.util.Random;

public class Bus extends Automobile{
    private int capacityBus;


    public Bus() {
        setTypeOfTransport("Наземный");
        setTypeGround("Автомобиль");
        setTypeAutomobile("Автобус");
        getCapacityBus();
    }

    @Override
    public String toString() {
        return "Транспорт\n" +
                "Тип транспорта = " + getTypeOfTransport() + "\n" +
                "Тип наземного транспорта = " + getTypeGround() + "\n" +
                "Тип автомобиля = " + getTypeAutomobile() + "\n" +
                "Вместительность = " + capacityBus + " человек" + "\n";
    }

    public int getCapacityBus() {
        setCapacityBus();
        return capacityBus;
    }

    public void setCapacityBus() {
        Random random = new Random();
        int[] capacity = new int[]{30, 40, 50, 60, 80, 100};
        this.capacityBus = capacity[random.nextInt(capacity.length)];
    }
}
