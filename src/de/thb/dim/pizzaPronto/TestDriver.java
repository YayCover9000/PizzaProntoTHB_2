package de.thb.dim.pizzaPronto;

import java.time.LocalDateTime;
import java.util.Arrays;

public class TestDriver {
    public static void main(String[] args) {
        testDishes();
        testMenu();
        testOrderProcessing();
    }

    private static void testDishes() {
        System.out.println("Testing Dishes...");

        // Pizza Test
        PizzaVO pizza = new PizzaVO(30, "Popeye", new String[]{"Schinken", "Spinat", "Champignon", "Ei"}, 7.00f, 1);
        System.out.println("Pizza: " + pizza.toString());

        // Pasta Test
        PastaVO pasta = new PastaVO(11, "Napoli", new String[]{"Tomatensauce"}, 5.60f, 4);
        System.out.println("Pasta: " + pasta.toString());

        // Dessert Test
        DessertVO dessert = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);
        System.out.println("Dessert: " + dessert.toString());

        System.out.println("\n");
    }

    private static void testMenu() {
        System.out.println("Testing Menu...");
        MenuVO menu = new MenuVO();
        System.out.println(menu.toString());
        System.out.println("\n");
    }

    private static void testOrderProcessing() {
        System.out.println("Testing Order Processing...");
        CustomerVO customer = new CustomerVO("Doe", "John", "Main Street", 101, "Male", null);
        OrderVO order = new OrderVO(1, "started", LocalDateTime.now(), customer);

        MenuVO menu = new MenuVO();
        DishVO firstDish = menu.getDish(0);
        DishVO secondDish = menu.getDish(1);

        order.addDish(firstDish);
        order.addDish(secondDish);

        System.out.println("Order Contents:");
        for (DishVO dish : order.getShoppingBasket()) {
            if (dish != null) {
                System.out.println(dish.toString());
            }
        }

        System.out.println("Total Price: " + order.calculatePriceDishes());
        System.out.println("\n");
    }
}
