public interface TransportDepot extends Comparable<TransportDepot> {

    int getMonthIncome();
    int getMonthMaintenance();
    int getMonthCarried();

    default int compareTo(TransportDepot o) {
        return Integer.compare(getMonthIncome(), o.getMonthIncome());
    }
}
