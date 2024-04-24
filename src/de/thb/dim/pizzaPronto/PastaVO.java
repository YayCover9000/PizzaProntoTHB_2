package de.thb.dim.pizzaPronto;

import java.util.Arrays;
import java.util.Objects;

public class PastaVO extends DishVO{
	private int typeOfPasta;
	
	public PastaVO(int number, String name, String[] ingredients, float price, int pastaType) {
		super(number, name, ingredients, price);
		setTypeOfPasta(pastaType);
	}
	
	public PastaVO() {
		this(0, null, null, 0.00f, 0);

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(typeOfPasta);
		return result;
	}
	
	public boolean equals(Object o) {
		if (this == o) return true;
		if(!super.equals(o)) return false;
		if (o == null || getClass() != o.getClass()) return false;
		
		PastaVO pastaVO = (PastaVO) o;
        return typeOfPasta == pastaVO.typeOfPasta;
	}
 @Override
    public String ingredientsToString() {
        return String.join(", ", ingredients);
    }
 
 @Override
 public Object clone() {
     return new PastaVO(number, name, ingredients.clone(), price, typeOfPasta);
 }
	
//	public String toString() {
//		return super.toString() + ", typeOdPasta=" + typeOfPasta;
//	}


	@Override
	public String getNameOfDish() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pasta ");
		
		switch(typeOfPasta) {
			case 4 : 
				sb.append(getName() + " - Spaghetti");
				break;
			case 5 : 
				sb.append(getName() + " - Tortellini");
				break;
			case 6 : 
				sb.append(getName() + " - Gnocchi");
				break;
			default : 
				sb.append(getName());
				break;
		}
		
		return sb.toString();
	}

	@Override
	public int getNumberOfDish() {
		return this.typeOfPasta * 100 + this.number;
	}
	public int getTypeOfPasta() {
		return typeOfPasta;
	}
	public void setTypeOfPasta(int typeOfPasta) {
		this.typeOfPasta = typeOfPasta;
	}
	

}
