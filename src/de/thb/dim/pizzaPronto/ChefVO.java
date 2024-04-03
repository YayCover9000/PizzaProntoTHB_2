package de.thb.dim.pizzaPronto;
import java.awt.Color;
import java.util.Objects; 
public class ChefVO {
	private String lastName;
	private String firstName;
	private Color colorApron;
	
	public ChefVO() {
		this(null, null, null);
	}
	public ChefVO(String lastName, String firstName, Color colorApron) {
		setLastName(lastName);
		setFirstName(firstName);
		setColorApron(colorApron);
	}
	
	public String toString() {
		if(this.lastName != null && this.firstName != null && this.colorApron != null) {
			StringBuilder result = new StringBuilder();
			result.append(lastName + ", " + firstName + " " + colorApron);
			return result.toString();
		}
		return null;
	}
	
	public int hashCode() {
		return Objects.hash(lastName, firstName, colorApron);
	}
	public boolean equals(Object o) {
		ChefVO chef;
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		chef = (ChefVO) o;
		
		//Referenzvariable Check
		if(this.lastName == null) {
			if(chef.getLastName() != null) return false;
		}else if(this.firstName == null) {
			if(chef.getLastName() != null) return false;
		}else if(this.colorApron == null) {
			if(chef.getColorApron() != null) return false;
		}
		
		else if(!this.lastName.equals(chef.getLastName())) return false; //wenn chef.getLAstName identeisch zu this.lastName gibt es true zurueck, dann wird das true zu false und der if Fall tritt nicht ein, es wird nicht false zurueck gegeben
		else if(!this.firstName.equals(chef.getFirstName())) return false;
		else if(!this.colorApron.equals(chef.getColorApron())) return false;
		return true;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setColorApron(Color colorApron) {
		this.colorApron = colorApron;
	}
	public Color getColorApron() {
		return colorApron;
	}
	
	
}
