public class TrolleyBus implements Transport {
    private int ticketPrice = 50;
    private int capacity = 65;
    private int serviceCost = 90_000;
    private int passCarried;
    private int income;
    private int trip;

    private static int count;
    private final int count1;

    public TrolleyBus() {
        passCarried += (int) ((Math.random() * capacity));
        income += passCarried * ticketPrice;
        trip += ((int) ((Math.random() * (5000 - 100) + 100)));
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
        return "\n" + "Троллейбус под номером - " + count1 + "\n" +
                " Стоимость ремонта составит = " + (getMonthMaintenance() != 0 ? serviceCost : "0") +
                " Пассажиров проехало за рейс = " + passCarried +
                " Доход = " + income +
                " Пройденный путь = " + trip;
    }
}
