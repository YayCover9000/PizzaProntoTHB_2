package de.thb.dim.pizzaPronto;

import java.util.Arrays;
import java.util.Objects;

public class PizzaVO extends DishVO{
	
	private int size;
	
	public PizzaVO() {
		this(0,null,null,0.0f,1);
	}
	public PizzaVO(int number, String name, String[] ingredients, float price, int size) {
		super(number, name, ingredients,price);
		setSize(size);

	}
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(size);
	return result;
}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaVO other = (PizzaVO) obj;
		return size == other.size;
	}
	@Override
	public String getNameOfDish() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pizza ");
		
		if (size == 1) sb.append(getName() + " - Normal");
		else sb.append(getName() + " - Grande");
		
		return sb.toString();
	}
	@Override
	public int getNumberOfDish() {
		return this.number * 10 + size;
	}
}
