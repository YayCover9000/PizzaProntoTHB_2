package de.thb.dim.pizzaPronto;

import java.util.Objects;

public class EmployeeVO extends PersonVO{
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
//	public EmployeeVO() {
//		this(null,null,null);
//	}
	public EmployeeVO() {
	    super(); // Aufruf des Default-Konstruktors der Elternklasse PersonVO
	    this.personnelNo = null; // Initialisierung von personnelNo mit null
	    this.salary = 0.0f; // Initialisierung von salary mit 0.0
	    this.vacationDays = 0; // Initialisierung von vacationDays mit 0
	}

//	public EmployeeVO(String personelNo,String lasName, String firstName) {
//		super();
//		setPersonnelNo(personnelNo);
//		setSalary(salary);
//		setVacationDays(vacationDays);
//		
//	}
	public EmployeeVO(String personnelNo, String lastName, String firstName) {
	    super(lastName, firstName); // Aufruf des Konstruktors der Elternklasse PersonVO
	    setPersonnelNo(personnelNo);
	    setSalary(salary); // Hier wird der Standardwert für das Gehalt (salary) gesetzt
	    setVacationDays(vacationDays); // Hier wird der Standardwert für die Urlaubstage (vacationDays) gesetzt
	}
	
//	@Override
//	public String toString() {
//		return super.toString() + "EmployeeVO [personnelNo=" + personnelNo + ", salary=" + salary + ", vacationDays=" + vacationDays + "]";
//	}
//	@Override
//	public String toString() {
//	    return "EmployeeVO [personnelNo=" + personnelNo + ", lastName=" + lastName + ", firstName=" + firstName + ", street=" + street + ", houseNumber=" + houseNumber + ", salary=" + salary + ", vacationDays=" + vacationDays + "]";
//	}
	@Override
	public String toString() {
	    return super.toString() + ", personnelNo=" + personnelNo + ", salary=" + salary + ", vacationDays=" + vacationDays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(personnelNo);
		return result;
	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
////		if (!super.equals(obj))
////			return false;
////		if (!(obj instanceof EmployeeVO))
////			return false;
//		if (obj == null || getClass() != obj.getClass())
//	        return false;
//		EmployeeVO other = (EmployeeVO) obj;
//	    return Objects.equals(personnelNo, other.personnelNo)
//	            && super.equals(obj); // Überprüfen Sie hier, ob die Elternklasse (falls vorhanden) ebenfalls gleich ist.
//	}
//		
//		return Objects.equals(personnelNo, other.personnelNo);
//	@Override
//	public boolean equals(Object obj) {
//	    if (this == obj)
//	        return true;
//	    if (obj == null || getClass() != obj.getClass())
//	        return false;
//	    if (!super.equals(obj))
//	        return false;
//	    EmployeeVO other = (EmployeeVO) obj;
//	    return Objects.equals(personnelNo, other.personnelNo);
//	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    EmployeeVO other = (EmployeeVO) obj;
	    
	    if (!super.equals(obj))
	        return false;
	    if (!Objects.equals(personnelNo, other.personnelNo))
	        return false;
	    if (Float.compare(other.salary, salary) != 0)
	        return false;
	    if (vacationDays != other.vacationDays)
	        return false;
	    return true;
	}


	
	public String getPersonnelNo() {
		return personnelNo;
	}
	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getVacationDays() {
		return vacationDays;
	}
	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}
	
	

}
