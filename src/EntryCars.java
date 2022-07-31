import java.util.*;

public class EntryCars {

    Random random = new Random();

    private TypeOfCar type[] = TypeOfCar.values();
    public Map<TypeOfCar, Integer> cars = new TreeMap<>();

    private int count = 0;
    private int carsCount = 0;
    private int truckCount = 0;

    private boolean hasAdd;

    public EntryCars() {
        hasAdd = false;
    }

    public EntryCars(int count) {
        hasAdd = true;
        this.count = count;
        carToSpawn();
    }

    public int carToSpawn() {
        if (!hasAdd) count = 50;
        for (int i = 0; i < count; i++) {
           TypeOfCar car = type[random.nextInt(type.length)];

           switch (car) {
               case BUS -> cars.put(car, ++carsCount);
               case TROLLEYBUS -> cars.put(car, ++truckCount);
           }
        }
        for (Map.Entry<TypeOfCar, Integer> en : cars.entrySet()) {
            TypeOfCar ke = en.getKey();
            Integer ki = en.getValue();
            System.out.println(ke + " " + ki);
        }

        return carsCount;
    }
}