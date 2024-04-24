package de.thb.dim.pizzaPronto;

import java.text.DecimalFormat;

public class MenuVO {
	private DishVO[] dishes;// = new DishVO[10];
	private static final int NUMBER_OF_DISHES = 18;
	
	public MenuVO() {
		initMenu();
	}
	private void initMenu() {
		int i = 0;
		this.dishes = new DishVO[NUMBER_OF_DISHES];

		dishes[i++] = new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei" }, 7.00f, 1);
		dishes[i++] = new PizzaVO(30, "Popeye", new String[] { "Schinken","Spinat", "Champignon", "Ei" }, 8.90f, 2);
		dishes[i++] = new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 5.80f, 1);
		dishes[i++] = new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry" }, 7.40f, 2);

		dishes[i++] = new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 7.00f, 1);
		dishes[i++] = new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 8.90f, 2);

		dishes[i++] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 4);
		dishes[i++] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 5);
		dishes[i++] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" }, 5.60f, 6);
		dishes[i++] = new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 4);
		dishes[i++] = new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 5);
		dishes[i++] = new PastaVO(12, "Bolognese", new String[] { "Hackfleischsauce" }, 6.40f, 6);
		dishes[i++] = new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 4);
		dishes[i++] = new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 5);
		dishes[i++] = new PastaVO(13, "alla Panna", new String[] { "Schinken", "Sahne" }, 6.40f, 6);

		dishes[i++] = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);
		dishes[i++] = new DessertVO(22, "Hausgemachte Pannacotta", 2.60f);
		dishes[i++] = new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f);
	}
	
//	@Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("MENU PIZZA PRONTO\n\n");
//        for (DishVO dish : dishes) {
//            if (dish != null) {
//                sb.append(dish).append("\n");
//            }
//        }
//        return sb.toString();
//    }
	public String toString() {
		StringBuffer sb = new StringBuffer();
		DecimalFormat dFormat = new DecimalFormat(".00"); // Format the price ...

		sb.append("MENU PIZZA PRONTO\n\n");
		// Pizzas
		sb.append(
				"Prima special pizzas: \n   1 normal (Diameter approx. 26 cm) and \n   2 grande (Diameter approx. 32 cm)\n");
		int i = 0;
		do {
			if (dishes[i] != null) {
				sb.append(dishes[i].getNumber() + "\t");
				sb.append(dishes[i].getName() + "\t");
				sb.append(dishes[i].ingredientsToString());
				sb.append("\n\tPrice:\t\t\t" + dFormat.format(dishes[i].getPrice()) + " Euro");
				if (i < dishes.length && dishes[i].getNumber() == dishes[i + 1].getNumber()) {
					sb.append("\n\tPrice:\t\t\t" + dFormat.format(dishes[i + 1].getPrice()) + " Euro");
					sb.append("\n");
					i += 2;
				} else
					i++;
			}
		} while (i < dishes.length && dishes[i] instanceof PizzaVO);

		// Pasta

		sb.append("\nPrima special pastas: \n4  Spaghetti\n5  Tortellini\n6  Gnocchi\n");
		do {
			if (dishes[i] != null) {
				sb.append(" " + dishes[i].getNumber() + "\t");
				sb.append(dishes[i].getName() + "\t");

				sb.append(dishes[i].ingredientsToString());

				sb.append("\n\tPrice:\t\t\t" + dFormat.format(dishes[i].getPrice()) + " Euro");
				if (dishes[i].getNumber() == dishes[i + 1].getNumber()
						&& dishes[i].getNumber() == dishes[i + 2].getNumber()) {
					i += 3;
				} else {
				if (dishes[i].getNumber() == dishes[i + 1].getNumber()) {
					i += 2;
				}
				else i++;
				}
				sb.append("\n");
			}
		} while (i < dishes.length && dishes[i] instanceof PastaVO);

		sb.append("\nPrima desserts\n");
		do {
			if (dishes[i] != null) {
				sb.append(dishes[i].getNumber() + "\t");
				sb.append(dishes[i].getName() + "\t");

				sb.append(dishes[i].ingredientsToString());

				sb.append("\n\tPrice:\t\t\t" + dFormat.format(dishes[i].getPrice()) + " Euro");
				sb.append("\n");
				i++;
			}
		} while (i < dishes.length && dishes[i] instanceof DessertVO);

		return sb.toString();
	}
	
	public DishVO getDish(int index) {
		if (index >= 0 && index < NUMBER_OF_DISHES)
			return dishes[index];
		else
			return null;
	}

	public int getNumberOfDishes() {
		return NUMBER_OF_DISHES;
	}
	
}