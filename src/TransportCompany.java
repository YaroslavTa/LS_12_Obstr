import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TransportCompany {
    private List<TransportDepot> transportDepot = new ArrayList<>();

    public List<TransportDepot> getTransport() {
        return new ArrayList<>(transportDepot);
    }

    public void addTransport(TransportDepot transport) {
        this.transportDepot.add(transport);
    }

    public void addAllTransports(List<TransportDepot> transport) {
        for (TransportDepot e : transport) {
            addTransport(e);
        }
    }

    public void removeTransport(TransportDepot transport) {
        this.transportDepot.remove(transport);
    }

    public List<TransportDepot> getTotalIncome(int count) {
        Collections.sort(transportDepot);
        Collections.reverse(transportDepot);
        return transportDepot.subList(0, count);
    }

    public List<TransportDepot> getTotalMaintenance(int count) {
        Collections.sort(transportDepot);
        return transportDepot.subList(0, count);
    }

    public List<TransportDepot> getTotalCarried(int count) {
        Collections.sort(transportDepot);
        Collections.reverse(transportDepot);
        return transportDepot.subList(0, count);
    }
}

