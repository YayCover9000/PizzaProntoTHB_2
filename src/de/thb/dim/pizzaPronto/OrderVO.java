package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class OrderVO {
	private static final int MAX_DISHES = 10;
	private static int nextOrderNo = 0;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private CustomerVO customer; // = new CustomerVO(); // darf nach initialisierung nicht null sein
//	private PizzaVO[] shoppingBasket;
	private DishVO[] shoppingBasket;
	private int orderNo;
	private int index;
	private String state;
	
	public OrderVO() {
        this.timestampStartedOrder = LocalDateTime.now();
        this.shoppingBasket = new PizzaVO[MAX_DISHES];
        this.index = 0;

        int currentYear = LocalDate.now().getYear();
        if (nextOrderNo == 0 || nextOrderNo < currentYear) {
            nextOrderNo = currentYear * 100000 + 1;
        } else {
            nextOrderNo++;
        }
        orderNo = nextOrderNo;
    }

	public OrderVO(LocalDateTime timestampStartedOrder, CustomerVO customer) {
		if (nextOrderNo == 0 || (nextOrderNo / 100000 < LocalDate.now().getYear()))
			nextOrderNo = LocalDateTime.now().getYear() * 100000;
		this.orderNo = ++nextOrderNo;
		this.setTimestampStartedOrder(timestampStartedOrder);
		this.setState("started");
		this.setCustomer(customer);
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
	public static int getNextOrderNo() {
		return nextOrderNo;
	}
	public static void setNextOrderNo(int nextOrderNo) {
		OrderVO.nextOrderNo = nextOrderNo;
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
