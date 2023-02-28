import java.util.Random;

public class PassengerTrain extends Railway{
    private int capacityTrain;
    private int numWagons;


    public PassengerTrain() {
        setTypeOfTransport("Наземный");
        setTypeGround("Железнодорожный");
        setTypeTrain("Пассажирский");
        getCapacityTrain();
        getNumWagons();
    }

    @Override
    public String toString() {
        return "Транспорт\n" +
                "Тип транспорта = " + getTypeOfTransport() + "\n" +
                "Тип наземного транспорта = " + getTypeGround()+ "\n" +
                "Тип поезда = " + getTypeTrain() + "\n" +
                "Количество мест = " + capacityTrain + " человек" + "\n" +
                "Количество вагонов = " + numWagons + "\n";
    }

    public int getCapacityTrain() {
        setCapacityTrain();
        return capacityTrain;
    }

    public int getNumWagons() {
        setNumWagons();
        return numWagons;
    }

    public void setCapacityTrain() {
        Random random = new Random();
        int[] capacity= new int[]{100, 200, 300, 400, 600, 800, 1000};
        this.capacityTrain = capacity[random.nextInt(capacity.length)];
    }

    public void setNumWagons() {
        Random random = new Random();
        int[] wagon = new int[]{10, 13, 15, 8, 18, 20, 22};
        this.numWagons = wagon[random.nextInt(wagon.length)];
    }
}
