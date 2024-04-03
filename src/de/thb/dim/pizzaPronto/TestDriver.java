package de.thb.dim.pizzaPronto;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class TestDriver {

    public static void main(String[] args) {
        // Testfälle für PizzaVO
        testPizzaVOEqualsMethod();
        testPizzaVOHashCodeMethod();

        // Testfälle für CustomerVO
        testCustomerVOEqualsMethod();
        testCustomerVOHashCodeMethod();

        // Testfälle für ChefVO und OrderVO
        testChefAndOrderVOEqualsMethod();

        // Zusätzliche Testfälle
        additionalTestCases();
    }

    // Testfälle für PizzaVO
    private static void testPizzaVOEqualsMethod() {
        System.out.println("Test der equals Methode für PizzaVO:");
        // Testdaten für Pizzen
        PizzaVO pizza1 = new PizzaVO("Margherita", new String[]{"Tomato sauce", "Mozzarella"}, 8.99f);
        PizzaVO pizza2 = new PizzaVO("Margherita", new String[]{"Tomato sauce", "Mozzarella"}, 8.99f);
        PizzaVO pizza3 = new PizzaVO("Quattro Formaggi", new String[]{"Tomato sauce", "Mozzarella", "Gorgonzola", "Parmesan", "Blue cheese"}, 10.99f);
        PizzaVO pizza4 = new PizzaVO("Funghi", new String[]{"Tomato sauce", "Mozzarella", "Mushrooms"}, 9.99f);
        PizzaVO pizza5 = new PizzaVO("Salami", new String[]{"Tomato sauce", "Mozzarella", "Salami"}, 9.99f);

        // Test der equals Methode
        System.out.println("Pizza 1 und Pizza 2 sind gleich: " + pizza1.equals(pizza2));
        System.out.println("Pizza 1 und Pizza 3 sind gleich: " + pizza1.equals(pizza3));
        System.out.println("Pizza 1 und Pizza 4 sind gleich: " + pizza1.equals(pizza4));
        System.out.println("Pizza 1 und Pizza 5 sind gleich: " + pizza1.equals(pizza5));
        System.out.println();
    }

    private static void testPizzaVOHashCodeMethod() {
        System.out.println("Test der hashCode Methode für PizzaVO:");
        // Testdaten für Pizzen
        PizzaVO pizza1 = new PizzaVO("Margherita", new String[]{"Tomato sauce", "Mozzarella"}, 8.99f);
        PizzaVO pizza2 = new PizzaVO("Margherita", new String[]{"Tomato sauce", "Mozzarella"}, 8.99f);

        // Test der hashCode Methode
        System.out.println("HashCode von Pizza 1: " + pizza1.hashCode());
        System.out.println("HashCode von Pizza 2: " + pizza2.hashCode());
        System.out.println();
    }

    // Testfälle für CustomerVO
    private static void testCustomerVOEqualsMethod() {
        System.out.println("Test der equals Methode für CustomerVO:");
        // Testdaten für Kunden
        LocalDate dob = LocalDate.of(1990, 5, 15);
        CustomerVO customer1 = new CustomerVO("Müller", "Hans", "Male", dob);
        CustomerVO customer2 = new CustomerVO("Müller", "Hans", "Male", dob);
        CustomerVO customer3 = new CustomerVO("Schmidt", "Anna", "Female", LocalDate.of(1985, 8, 20));
        CustomerVO customer4 = new CustomerVO("Schulz", "Lisa", "Female", LocalDate.of(1992, 10, 10));
        CustomerVO customer5 = new CustomerVO("Meier", "Peter", "Male", LocalDate.of(1975, 3, 25));

        // Test der equals Methode
        System.out.println("Kunde 1 und Kunde 2 sind gleich: " + customer1.equals(customer2));
        System.out.println("Kunde 1 und Kunde 3 sind gleich: " + customer1.equals(customer3));
        System.out.println("Kunde 1 und Kunde 4 sind gleich: " + customer1.equals(customer4));
        System.out.println("Kunde 1 und Kunde 5 sind gleich: " + customer1.equals(customer5));
        System.out.println();
    }

    private static void testCustomerVOHashCodeMethod() {
        System.out.println("Test der hashCode Methode für CustomerVO:");
        // Testdaten für Kunden
        LocalDate dob = LocalDate.of(1990, 5, 15);
        CustomerVO customer1 = new CustomerVO("Müller", "Hans", "Male", dob);
        CustomerVO customer2 = new CustomerVO("Müller", "Hans", "Male", dob);

        // Test der hashCode Methode
        System.out.println("HashCode von Kunde 1: " + customer1.hashCode());
        System.out.println("HashCode von Kunde 2: " + customer2.hashCode());
        System.out.println();
    }

    // Testfälle für ChefVO und OrderVO
    private static void testChefAndOrderVOEqualsMethod() {
        System.out.println("Test der equals Methode für ChefVO und OrderVO:");
        // Testdaten für Chef
        ChefVO chef1 = new ChefVO("Schmidt", "Anna", Color.WHITE);
        ChefVO chef2 = new ChefVO("Schmidt", "Anna", Color.WHITE);
        ChefVO chef3 = new ChefVO("Meyer", "Markus", Color.BLACK);
        ChefVO chef4 = new ChefVO("Schulz", "Maria", Color.BLUE);
        ChefVO chef5 = new ChefVO("Becker", "Michael", Color.RED);

        // Testdaten für Bestellung
        LocalDate dob = LocalDate.of(1990, 5, 15);
        CustomerVO customer = new CustomerVO("Müller", "Hans", "Male", dob);
        OrderVO order1 = new OrderVO(LocalDateTime.now(), customer);
        OrderVO order2 = new OrderVO(LocalDateTime.now(), customer);

        // Test der equals Methode für ChefVO
        System.out.println("Chef 1 und Chef 2 sind gleich: " + chef1.equals(chef2));
        System.out.println("Chef 1 und Chef 3 sind gleich: " + chef1.equals(chef3));
        System.out.println("Chef 1 und Chef 4 sind gleich: " + chef1.equals(chef4));
        System.out.println("Chef 1 und Chef 5 sind gleich: " + chef1.equals(chef5));

        // Test der equals Methode für OrderVO
        System.out.println("Bestellung 1 und Bestellung 2 sind gleich: " + order1.equals(order2));
        System.out.println();
    }

    // Zusätzliche Testfälle
    private static void additionalTestCases() {
        System.out.println("Zusätzliche Testfälle:");
        // Testdaten für Kunden
        LocalDate dob = LocalDate.of(

1990, 5, 15);
        CustomerVO customer = new CustomerVO("Müller", "Hans", "Male", dob);

        // Testdaten für Chef
        ChefVO chef = new ChefVO("Schmidt", "Anna", Color.WHITE);

        // Testdaten für Pizzen
        PizzaVO pizza1 = new PizzaVO("Margherita", new String[]{"Tomato sauce", "Mozzarella"}, 8.99f);
        PizzaVO pizza2 = new PizzaVO("Quattro Stagioni", new String[]{"Tomato sauce", "Mushrooms", "Artichokes", "Ham", "Olives"}, 12.99f);
        PizzaVO pizza3 = new PizzaVO("Capricciosa", new String[]{"Tomato sauce", "Mozzarella", "Mushrooms", "Ham", "Artichokes", "Olives", "Egg"}, 11.99f);

        // Testdaten für Bestellung
        OrderVO order = new OrderVO(LocalDateTime.now(), customer);
        order.addDish(pizza1);
        order.addDish(pizza2);
        order.addDish(pizza3);

        // Ausgabe der Bestellung
        System.out.println("Bestellung:");
        System.out.println(order.toString());

        // Test für equals Methode von PizzaVO
        PizzaVO pizza4 = new PizzaVO("Margherita", new String[]{"Tomato sauce", "Basil", "Mozzarella"}, 7.99f);
        System.out.println("Pizza 1 und Pizza 4 sind gleich: " + pizza1.equals(pizza4));

        // Test für equals Methode von CustomerVO
        LocalDate dob2 = LocalDate.of(1992, 8, 20);
        CustomerVO customer2 = new CustomerVO("Schulz", "Lisa", "Female", dob2);
        System.out.println("Kunde 1 und Kunde 2 sind gleich: " + customer.equals(customer2));

        // Test für equals Methode von OrderVO
        OrderVO order2 = new OrderVO(LocalDateTime.now().minusHours(1), customer);
        order2.addDish(pizza1);
        order2.addDish(pizza2);
        System.out.println("Bestellung 1 und Bestellung 2 sind gleich: " + order.equals(order2));

        // Test für hashCode Methode von PizzaVO
        System.out.println("HashCode von Pizza 1: " + pizza1.hashCode());
        System.out.println("HashCode von Pizza 4: " + pizza4.hashCode());
    }
}