package de.thb.dim.pizzaPronto;

import java.util.Objects;

public class PersonVO {
	protected String lastName;
	protected String firstName;
	protected String street;
	protected int houseNumber;
	
	public PersonVO () {
		this(null,null);
	}
	public PersonVO(String lastName, String firstName) {
		this(lastName,firstName,null,0);
	}
	public PersonVO (String lastName, String firstName, String street, int houseNumber) {
		setLastName(lastName);
		setFirstName(firstName);
		setStreet(street);
		setHouseNumber(houseNumber);
		
	}
	
//	@Override
//	public String toString() {
//		if(this.lastName != null && this.firstName != null && this.street != null && houseNumber != 0) {
//			StringBuilder result = new StringBuilder();
//			result.append(lastName + ", " + firstName + " " + street + houseNumber);
//			return result.toString();
//		}
//		return null;
//	}
	@Override
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    if (this.lastName != null) {
	        result.append(lastName);
	    }
	    if (this.firstName != null) {
	        if (result.length() > 0) {
	            result.append(", ");
	        }
	        result.append(firstName);
	    }
	    if (this.street != null) {
	        if (result.length() > 0) {
	            result.append(" ");
	        }
	        result.append(street);
	    }
	    if (this.houseNumber != 0) {
	        if (result.length() > 0) {
	            result.append(" ");
	        }
	        result.append(houseNumber);
	    }
	    return result.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, houseNumber, lastName, street);
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    PersonVO other = (PersonVO) o;
	    
	    if (lastName == null) {
	        if (other.getLastName() != null) return false;
	    } else if (!lastName.equals(other.getLastName())) return false;

	    if (firstName == null) {
	        if (other.getFirstName() != null) return false;
	    } else if (!firstName.equals(other.getFirstName())) return false;

	    if (street == null) {
	        if (other.getStreet() != null) return false;
	    } else if (!street.equals(other.getStreet())) return false;

	    if (houseNumber != other.getHouseNumber()) return false;

	    return true;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(lastName != null)this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName != null)this.firstName = firstName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		if(street != null)this.street = street;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		if(houseNumber != 0)this.houseNumber = houseNumber;
	}
	
}
