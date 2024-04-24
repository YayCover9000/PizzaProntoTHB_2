package de.thb.dim.pizzaPronto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;

public abstract class DishVO {
	protected int number;
	protected String name;
	protected String[] ingredients;
	protected float price;
	
	public DishVO(int number, String name, String[] ingredients,float price) {
//		this(number,name,ingredients,price);
		setNumber(number);
		setName(name);
		setPrice(price);
		setIngredients(ingredients);
	}
	public DishVO(int number, String name, float price) {
		this(number,name,null,price);
	}
	public DishVO() {
		this(0, null, null, 0.0f);
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DishVO other = (DishVO) obj;
		return Arrays.equals(ingredients, other.ingredients) && Objects.equals(name, other.name)
				&& number == other.number && Float.floatToIntBits(price) == Float.floatToIntBits(other.price);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(ingredients);
		result = prime * result + Objects.hash(name, number, price);
		return result;
	}
	public String toString() {
		DecimalFormat dFormat = new DecimalFormat(".00"); // Formatierung der
															// Preisangabe ...
		StringBuffer sb = new StringBuffer(); // R�ckgabewert ...

		sb.append(getNumberOfDish() + " - ");
		sb.append(getNameOfDish() + "\t");

		sb.append(ingredientsToString());

		sb.append("\n\tPrice:\t\t\t" + dFormat.format(getPrice()) + " Euro");
		sb.append("\n");

		return sb.toString();
	}
	
	public String ingredientsToString() {
		StringBuffer sb = new StringBuffer();

		if (getIngredients() != null) { // Wenn Zutaten Array nicht
			// null ...
			for (String currentIngredient : getIngredients()) { // F�r jede
				// Zutat ...
				sb.append(currentIngredient + ", "); // aktuelle Zutat und Komma an
				// R�ckgabestring anh�ngen ...
			}
			sb = new StringBuffer(sb.substring(0, sb.length() - 2)); // Komma am Ende entfernen ...
		}
		return sb.toString();
	}
	
	public abstract String getNameOfDish();
	public abstract int getNumberOfDish();
	
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = (price > 0f) ? price : 0f;
	}
	
	
	
}
