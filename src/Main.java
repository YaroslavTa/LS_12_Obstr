import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Supplier<Transport> stringSupplier = TrolleyBus::new;
        System.out.println(stringSupplier.get());

        Function<String, String> ff = String::toLowerCase;
        System.out.println(ff.apply("AGAGAGAG"));

        BinaryOperator<String> stg_44 = new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s.toUpperCase() + " " + s2.toLowerCase();
            }
        };
        System.out.println(stg_44.apply("Калашников", "Венигредов"));

        BinaryOperator<String> binaryOperator = (s, s2) -> s.toLowerCase() + " " + s2.toUpperCase();

        System.out.println(binaryOperator.apply("КНИГАГРАД","кознакрат"));
        System.out.println(binaryOperator.apply("КНИГАГРАД","кознакрат"));
        System.out.println(binaryOperator.apply("КНИГАГРАД","кознакрат"));

        BiFunction<Integer, Integer, String> biFunction = (i, q) -> {
            String lol = "Харек";
            if (i + q == 5){
                lol = "Точно так!";
            } else if (i+q != 5) {
                lol = "нифига";
            }
          return lol;
        };

        System.out.println(biFunction.apply(4,1));
        System.out.println(biFunction.apply(4,2));
        System.out.println(biFunction.apply(4,-1));

        IntSupplier supplier = () -> (int) (Math.random() * (((150 - 50) + 1) + 50));
        System.out.println(supplier.getAsInt());


        UnaryOperator<String> uo = s -> s.toUpperCase();
        System.out.println(uo.apply("javaK12"));

        Supplier<Integer> integerSupplier = () -> (int) (Math.random() * (((150 - 50) + 1) + 50));
        System.out.println(integerSupplier.get());

        Function<Integer, String> function2 = shot -> {
            String resalt = "Ноль";
            if (shot > 0) {
                resalt = "Положил";
            } else if (shot < 0) {
                resalt = "Отрицал";
            }
            return resalt;
        };
        System.out.println(function2.apply(500));
        System.out.println(function2.apply(-500));
        System.out.println(function2.apply(0));

        Function<Double, Long> function = s -> Math.round(s);
        System.out.println(function.apply(5.7));

        Consumer<Transport> bus = (Transport bu) -> System.out.println("Автобус" + bu);
        Consumer<Transport> troll = (Transport tro) -> System.out.println("Тролли" + tro);

        for (int i = 1; i != 0; i--) {
            bus.accept(new Bus());
            troll.accept(new TrolleyBus());
        }

        Predicate<String> predicate = s -> s.startsWith("A");
        Predicate<String> predicate2 = s -> s.endsWith("f");
        Predicate<String> predicate3 = predicate.or(predicate2);
        System.out.println(predicate3.test("Agaf"));


        IngoFaiter ingoFaiter = System.out::println;
        ingoFaiter.fight("ingoFaiter");

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


        List<Transport> getTotalIncome = company.getTotalIncome(3);

        Consumer<Transport> consumer1 =
                Transport -> System.out.println(Transport + " " + Transport.getMonthIncome());
        getTotalIncome.forEach(consumer1);

//        for (Transport e:
//             getTotalIncome) {
//            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
//                    " " + e.getMonthIncome());
//        }
        System.out.println("\t");

        List<Transport> getTotalMaintenance = company.getTotalMaintenance(3);

        Consumer<Transport> consumer2 = Transport -> System.out.println(Transport + " " + Transport.getMonthMaintenance());

        getTotalMaintenance.forEach(consumer2);
//        for (Transport e : getTotalMaintenance) {
//            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
//                    " " + e.getMonthMaintenance());
//        }

        System.out.println("\t");

        List<Transport> getTotalCarried = company.getTotalCarried(3);
//        getTotalCarried.forEach(
//                (e) -> System.out.println(e.getClass().getName() + " " + e.getMonthCarried())
//        );
        Consumer<Transport> consumer3 = Transport -> System.out.println(Transport + " " + Transport.getMonthCarried());
        getTotalCarried.forEach(consumer3);

//        getTotalCarried.forEach(consumer1.andThen(consumer2).andThen(consumer3));

//        for (Transport e : getTotalCarried) {
//            System.out.println((e.getClass().getName().equalsIgnoreCase("Bus") ? TypeOfCar.BUS : TypeOfCar.TROLLEYBUS) +
//                    " " + e.getMonthCarried());
//        }
    }
}
