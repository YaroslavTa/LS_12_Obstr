public class Bus implements Transport {
    private int ticketPrice = 40;
    private int capacity = 65;
    private int serviceCost = 50_000;

    private int passCarried;
    private int income;
    private int trip;

    private static int count;
    private final int count1;

    public Bus() {
        passCarried += (int) ((Math.random() * capacity));
        income += passCarried * ticketPrice;
        trip += ((int) ((Math.random() * (1500 - 100) + 100)));
        count++;
        count1 = count;
    }

    @Override
    public int getMonthIncome() {
        return income;
    }

    @Override
    public int getMonthMaintenance() {
        if (trip >= 1000) {
            return serviceCost;
        }
        return 0;
    }

    @Override
    public int getMonthCarried() {
        return passCarried;
    }

    @Override
    public String toString() {
        return "\n" + "Автобус под номером - " + count1 + "\n" +
                " Стоимость ремонта составит = " + (getMonthMaintenance() != 0 ? serviceCost : "0") +
                " Пассажиров проехало за рейс = " + passCarried +
                " Доход = " + income +
                " Пройденный путь = " + trip;
    }
}
