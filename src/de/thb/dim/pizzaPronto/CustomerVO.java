package de.thb.dim.pizzaPronto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class CustomerVO extends PersonVO{
private static int nextId = 0;
private String gender;
private LocalDate dateOfBirth;
private int id = nextId;	
private OrderVO order;


	public CustomerVO() {
		this(null, null, null, 0, null,null);
	}
	public CustomerVO(String lastName, String firstName, LocalDate dateOfBirth) {
		this(lastName,firstName,null,dateOfBirth);
	}
	public CustomerVO(String lastName, String firstName, String street, int houseNumber, String gender,LocalDate dateOfBirth) {
		super(lastName,firstName,street,houseNumber);
		setGender(gender);
		setDateOfBirth(dateOfBirth);
		nextId += 1;
	}
	public CustomerVO(String lastName, String firstName,String gender,LocalDate dateOfBirth) {
		setLastName(lastName);
		setFirstName(firstName);
		setGender(gender);
		setDateOfBirth(dateOfBirth);
		nextId += 1;
	}
	
	public short calculateAge() {
	    if(dateOfBirth != null) {
	        LocalDate today = LocalDate.now();
	        long yearsDifference = ChronoUnit.YEARS.between(dateOfBirth, today);
	        if (yearsDifference == 18) {
	            // Überprüfen, ob das Geburtsdatum 18 Jahre minus 1 Tag zurückliegt
	            LocalDate dobPlus18YearsMinus1Day = dateOfBirth.plusYears(18).minusDays(1);
	            if (today.isBefore(dobPlus18YearsMinus1Day)) {
	                // Das Geburtsdatum liegt 18 Jahre minus 1 Tag zurück
	                return 17;
	            }
	        }
	        if (yearsDifference >= 18) {
	            return (short) yearsDifference;
	        } else {
	            return -1;
	        }
	    }
	    return -1;
	}




	
	private String dobToString() {
		if(dateOfBirth != null) {
			return dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
		}
		return null;
		
	}
	public String toString() {
		if(gender != null && dateOfBirth != null) {
			StringBuilder result = new StringBuilder();
			result.append(gender + id + dobToString() + calculateAge());
			return super.toString() + result.toString();
		}
		return super.toString();
	}
	public int hashCode() {
		return Objects.hash(lastName,firstName,gender,dateOfBirth);
	}	
	public boolean equals(Object o) {
		CustomerVO customer;
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		customer = (CustomerVO) o;
		
		//Referenzvariable Check
		if(this.lastName == null) {
			if(customer.getLastName() != null) return false;
		}else if(this.firstName == null) {
			if(customer.getFirstName() != null) return false;
		}else if(this.dateOfBirth == null) {
			if(customer.getDateOfBirth() != null) return false;
		}
		
		else if(!this.lastName.equals(customer.getLastName())) return false;
		else if(!this.firstName.equals(customer.getFirstName())) return false;
		else if(!this.dateOfBirth.equals(customer.getDateOfBirth())) return false;
		return true;
		
	}
	public boolean hasOrder() {
		if(order != null) return true;
		else return false;
	}
	
	public OrderVO getOrder() {
		return order;
	}
	public void setOrder(OrderVO order) {
		this.order = order;
	}
	public void setGender(String gender) {
		if(gender != null) {
			this.gender = gender;
		}
	}
	public String getGender() {
		return gender;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		if(dateOfBirth != null) {
			LocalDate today = LocalDate.now();
			int compareValue = today.compareTo(dateOfBirth);
			if(compareValue >= 18) {
				this.dateOfBirth = dateOfBirth;
			}
		}
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	//nur Getter
	public static int getNextId() {
		return nextId;
	}
	public int getId() {
		return id;
	}
}
