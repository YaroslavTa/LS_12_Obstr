public class Bus implements Transport {
    private int ticketPrice = 40;
    private int capacity = 55;
    private int serviceCost = 50_000;

    private int passCarried;
    private int income;
    private int trip;

    public Bus() {
        passCarried += (int) ((Math.random() * capacity));
        income += passCarried * ticketPrice;
        trip += ((int) ((Math.random() * (1500 - 100) + 100)));
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
}
