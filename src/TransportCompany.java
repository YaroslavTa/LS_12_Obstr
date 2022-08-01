import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TransportCompany {
    private List<Transport> transport = new ArrayList<>();

    public List<Transport> getTransport() {
        return new ArrayList<>(transport);
    }

    public void addTransport(Transport transport) {
        this.transport.add(transport);
    }

    public void addAllTransports(List<Transport> transport) {
        for (Transport e : transport) {
            addTransport(e);
        }
    }

    public void removeTransport(Transport transport) {
        this.transport.remove(transport);
    }

    public List<Transport> getTotalIncome(int count) {
        Collections.sort(transport);
        Collections.reverse(transport);
        return transport.subList(0, count);
    }

    Comparator<Transport> byMaintenance = Comparator.comparing(Transport::getMonthMaintenance);

    public List<Transport> getTotalMaintenance(int count) {
        transport.sort(byMaintenance);
        Collections.reverse(transport);
        return transport.subList(0, count);
    }

    Comparator<Transport> byCarried = new Comparator<Transport>() {
        @Override
        public int compare(Transport o1, Transport o2) {
            return Integer.compare(o1.getMonthCarried(), o2.getMonthCarried());
        }
    };

    public List<Transport> getTotalCarried(int count) {
        transport.sort(byCarried);
        Collections.reverse(transport);
        return transport.subList(0, count);
    }
}

