package de.thb.dim.pizzaPronto;

import java.util.Arrays;
import java.util.Objects;

public class PizzaVO {
	private String name;
	private String[] ingredients;
	private float price;
	public PizzaVO() {
		this(null,null,0.0f);
	}
	public PizzaVO(String name, String[] ingredients, float price) {
		setName(name);
		setIngredients(ingredients);
		setPrice(price);
	}
//@Override
//	public boolean equals(Object o) {
//		//Referenz check
//		PizzaVO pizza;
//		if(this == o) return true;
//		if(o == null) return false;
//		if(this.getClass() != o.getClass()) return false;
//		pizza = (PizzaVO) o;
//		
//		if(this.name == null) {
//			if(pizza.getName() != null) return false;
//			
//		}
//		
//		else if(!(Arrays.equals(ingredients,pizza.ingredients))) return false;
//		
//		if(this.price != pizza.getPrice()) return false;
//		return true;
//	}
	
	// Geht gut aber ist schwer zu lesen
	@Override
	public boolean equals(Object o) {
	    // Referenzüberprüfung
	    if (this == o) return true;
	    if (o == null || this.getClass() != o.getClass()) return false;

	    // Überprüfung der Attribute
	    PizzaVO other = (PizzaVO) o;
	    if (!Arrays.equals(ingredients, other.ingredients)) return false;
//	    if (Float.compare(other.price, price) != 0) return false;
	    if(this.price != other.getPrice()) return false;
	    if (name == null) {
//	    	System.out.println("1" + other.name == null);
	        return other.name == null;
	    } else {
//	    	System.out.println("2" + name.equals(other.name));
	        return name.equals(other.name);
	    }
	}


	// Geht am besten aber ist nicht voll ausgeschrieben
//@Override
//public boolean equals(Object o) {
//    // Referenzüberprüfung
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    // Überprüfung der Attribute
//    PizzaVO other = (PizzaVO) o;
//    return Objects.equals(name, other.name) &&
//           Arrays.equals(ingredients, other.ingredients) &&
//           Float.compare(other.price, price) == 0;
//}

	public int hashCode() {
		return Objects.hash(name, ingredients, price);
	}
	
	public PizzaVO clone() {
		return new PizzaVO(name,ingredients,price);
	}
	@Override
		
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    result.append("Pizza: ").append(name).append(" price: ").append(price);
	    
	    if (ingredients != null) {
	        result.append(" ingredients: [");
	        for (int i = 0; i < ingredients.length; i++) {
	            if (i > 0) {
	                result.append(", ");
	            }
	            if (ingredients[i] != null) {
	                result.append(ingredients[i]);
	            } else {
	                result.append("null");
	            }
	        }
	        result.append("]");
	    } else {
	        result.append(" ingredients: null");
	    }
	    
	    return result.toString();
	}



	
	public void setName(String name) {
		if(name != null) {
			this.name = name;
		}
	}public String getName() {
		return name;
	}
	public void setIngredients(String [] ingredients) {
		if(ingredients != null) {
			this.ingredients = ingredients;
		}
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setPrice(float price) {
		if(price != 0.0f && price > 0.0f) {
			this.price = price;
		}
	}
	public float getPrice() {
		return price;
	}
}
