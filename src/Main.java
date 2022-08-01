import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TransportCompany company = new TransportCompany();
        Transport bus112 = new Bus();
        Transport bus93 = new Bus();
        Transport trolle53 = new TrolleyBus();
        Transport trolle276 = new TrolleyBus();

        company.addTransport(bus112);
        company.addTransport(trolle53);
        company.addTransport(bus93);
        company.addTransport(trolle276);

        for (int i = 0; i < 200; i++) {
            company.addTransport(new Bus());
        }

        List<Transport> transport = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            transport.add(new Bus());
            if (i % 10 != 0) transport.add(new TrolleyBus());
        }
        company.addAllTransports(transport);

        List<Transport> dep = company.getTransport();
        System.out.println("Количество машин: " + dep.size());

        System.out.println("\t");

        for (int i = 0; i < 150; i++) {
            company.removeTransport(dep.get(i));
        }
        System.out.println("Количество машин после удаления: " + company.getTransport().size());
        System.out.println("\t");


        List<Transport> getTotalIncome = company.getTotalIncome(10);
        for (Transport e:
             getTotalIncome) {
            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
                    " " + e.getMonthIncome());
        }
        System.out.println("\t");

        List<Transport> getTotalMaintenance = company.getTotalMaintenance(10);
        for (Transport e : getTotalMaintenance) {
            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
                    " " + e.getMonthMaintenance());
        }

        System.out.println("\t");

        List<Transport> getTotalCarried = company.getTotalCarried(10);
        for (Transport e : getTotalCarried) {
            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
                    " " + e.getMonthCarried());
        }
    }
}
