package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class OrderVO {
	private static final int MAX_DISHES = 10;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private CustomerVO customer; // = new CustomerVO(); // darf nach initialisierung nicht null sein
//	private PizzaVO[] shoppingBasket;
	private DishVO[] shoppingBasket;
	private int orderNo;
	private int index;
	private String state;
	
	
	public OrderVO(int orderNo, String state, LocalDateTime timestampStartedOrder, CustomerVO customer) {
		
		this.orderNo = orderNo;
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setCustomer(customer);
		this.setState(state);
		index = 0;
		shoppingBasket = new DishVO[MAX_DISHES];
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(orderNo);
	}
    
	public float calculatePriceDishes() {
		float total = 0.0f; // Gesamtpreis = 0 ...

		for (DishVO currentDish : shoppingBasket) { // f�r alle Gerichte im
													// Warenkorb ...
			if (currentDish != null)
				total += currentDish.getPrice(); // Gesamtpreis = Gesamtpreis
													// + Preis der aktuellen
													// Gericht ...
		}
		return total;
	}
    
	public String toString() {

		StringBuilder text = new StringBuilder(String.format(
				"OrderVO " + getOrderNo()
						+ " from %1$tm/%1$td/%1$tY %1$tH:%1$tM with delivery at  %1$tm/%1$td/%1$tY %2$tH:%2$tM\n",
				timestampStartedOrder, timestampDeliveredOrder));

		text.append("of customer: " + customer.getLastName() + " " + customer.getFirstName() + ", ID of customer: "
				+ customer.getId() + "\n");

		if (shoppingBasket != null) {
			for (int i = 0; i < index; i++) {
				if (shoppingBasket[i] != null) {
					text.append(shoppingBasket[i].toString());
					text.append("\n");
				}
			}
		}

		return text.toString();

	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderVO orderVO = (OrderVO) o;
        return orderNo == orderVO.orderNo;
    }
    public void addDish(DishVO dish) {
        if (index < MAX_DISHES) {
            shoppingBasket[index] = dish;
            index++;
        }
    }

    public void deleteDish() {
		if (index > 0) {
			shoppingBasket[index - 1] = null; // set object at position index - 1 null ...
			this.index--; // decrement index den index
		} else if (index == 0)
			shoppingBasket[0] = null;
	}

    public DishVO getDish(int index) {
		if (index < MAX_DISHES && shoppingBasket[index] != null)
			return shoppingBasket[index];
		else
			return null;
	}

    public int getNumberOfDishes() {
        return index;
    }

    public int getOrderNo() {
		return orderNo;
	}
	public LocalDateTime getTimestampStartedOrder() {
		return timestampStartedOrder;
	}
	public void setTimestampStartedOrder(LocalDateTime timestampStartedOrder) {
		this.timestampStartedOrder = timestampStartedOrder;
	}
	public LocalDateTime getTimestampDeliveredOrder() {
		return timestampDeliveredOrder;
	}
	public void setTimestampDeliveredOrder(LocalDateTime timestampDeliveredOrder) {
		this.timestampDeliveredOrder = timestampDeliveredOrder;
	}

	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	public static int getMAX_DISHES() {
		return MAX_DISHES;
	}
	public int getIndex() {
		return index;
	}

	public DishVO[] getShoppingBasket() {
		return shoppingBasket;
	}

	public void setShoppingBasket(DishVO[] shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
	
}
