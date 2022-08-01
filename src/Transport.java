public interface Transport extends Comparable<Transport> {

    int getMonthIncome();
    int getMonthMaintenance();
    int getMonthCarried();

    default int compareTo(Transport o) {
        return Integer.compare(getMonthIncome(), o.getMonthIncome());
    }
}
