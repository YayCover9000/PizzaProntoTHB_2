package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class OrderVO {
	private static final int MAX_DISHES = 10;
	private static int nextOrderNo = 0;
	private LocalDateTime timestampStartedOrder;
	private LocalDateTime timestampDeliveredOrder;
	private CustomerVO customer; // = new CustomerVO(); // darf nach initialisierung nicht null sein
	private PizzaVO[] shoppingBasket;
	private int orderNo;
	private int index;
	
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
        this();
        this.timestampStartedOrder = timestampStartedOrder;
        this.customer = customer;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("OrderVO ").append(orderNo).append(" from ");
        result.append(timestampStartedOrder);
        result.append(" with delivery at ").append(timestampDeliveredOrder);
        result.append(" of customer: ").append(customer.getFirstName() + " " + customer.getLastName());
        result.append(", Id of customer: ").append(customer.getId());
        result.append(" Ingredients [");
        if (shoppingBasket != null) {
            for (PizzaVO pizza : shoppingBasket) {
                if (pizza != null) {
                    result.append(pizza.toString()).append(" ");
                }
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderVO orderVO = (OrderVO) o;
        return orderNo == orderVO.orderNo;
    }
    public void addDish(PizzaVO dish) {
        if (index < MAX_DISHES) {
            shoppingBasket[index] = dish;
            index++;
        }
    }

    public void deleteDish() {
        if (index > 0) {
            shoppingBasket[index - 1] = null;
            index--;
        }
    }

    public PizzaVO getDish(int index) {
        if (index >= 0 && index < MAX_DISHES) {
            return shoppingBasket[index];
        }
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
	public PizzaVO[] getShoppingBasket() {
		return shoppingBasket;
	}
	public void setShoppingBasket(PizzaVO[] shoppingBasket) {
		this.shoppingBasket = shoppingBasket;
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
	
}
