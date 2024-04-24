package de.thb.dim.pizzaPronto;

import java.util.Objects;

public abstract class EmployeeVO extends PersonVO{
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
	public EmployeeVO() {
		this(null, null, null);
	}

	public EmployeeVO(String personnelNo, String lastName, String firstName) {
		super(lastName, firstName);
		setPersonnelNo(personnelNo);
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append(getPersonnelNo() + " ");

		sb.append(super.toString());

		sb.append("\tSalary: " + getSalary() + "\n");
		sb.append("\tNumber of vacation days: " + getVacationDays());

		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(personnelNo);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		//Do not compare the attributes of the superclass
//		if (!super.equals(obj))
//			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVO other = (EmployeeVO) obj;
		return Objects.equals(personnelNo, other.personnelNo);
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
