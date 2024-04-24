package de.thb.dim.pizzaPronto;

public class DessertVO extends DishVO{
	
	public DessertVO(int number, String name, float price) {
		super(number, name, price);	}
	
	public DessertVO() {
		this(0, null, 0.0f);
	}
	
  

	@Override
	public String getNameOfDish() {
		return name;
	}

	@Override
	public int getNumberOfDish() {
		return number;
	}

}
