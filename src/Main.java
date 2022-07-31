import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TransportCompany company = new TransportCompany();
        TransportDepot bus112 = new Bus();
        TransportDepot bus93 = new Bus();
        TransportDepot trolle53 = new TrolleyBus();
        TransportDepot trolle276 = new TrolleyBus();

        company.addTransport(bus112);
        company.addTransport(trolle53);
        company.addTransport(bus93);
        company.addTransport(trolle276);

        for (int i = 0; i < 200; i++) {
            company.addTransport(new Bus());
        }

        List<TransportDepot> transport = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            transport.add(new Bus());
            if (i % 10 != 0) transport.add(new TrolleyBus());
        }
        company.addAllTransports(transport);

        List<TransportDepot> dep = company.getTransport();
        System.out.println("Количество машин: " + dep.size());

        System.out.println("\t");

        for (int i = 0; i < 391; i++) {
            company.removeTransport(dep.get(i));
        }
        System.out.println("Количество машин после удаления: " + company.getTransport().size());
        System.out.println("\t");


        List<TransportDepot> getTotalIncome = company.getTotalIncome(3);
        for (TransportDepot e:
             getTotalIncome) {
            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
                    " " + e.getMonthIncome());
        }
        System.out.println("\t");

        List<TransportDepot> getTotalMaintenance = company.getTotalMaintenance(3);
        for (TransportDepot e : getTotalMaintenance) {
            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
                    " " + e.getMonthMaintenance());
        }

        System.out.println("\t");

        List<TransportDepot> getTotalCarried = company.getTotalCarried(3);
        for (TransportDepot e : getTotalCarried) {
            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
                    " " + e.getMonthCarried());
        }
    }
}
