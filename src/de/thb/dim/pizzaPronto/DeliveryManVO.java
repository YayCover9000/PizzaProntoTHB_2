package de.thb.dim.pizzaPronto;

public class DeliveryManVO extends EmployeeVO{
	private String driverLicence;
	
	public DeliveryManVO() {
		this(null,null,null);
	}
	public DeliveryManVO(String personnelNo, String lastName, String firstName) {
		super(personnelNo, lastName,firstName);
		vacationDays = 25;
		salary = 2100;
		driverLicence = "XYZ123";
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("\nDelivery Man:\n" );
		
		sb.append(super.toString());
		sb.append("\n Driver lecende: " + driverLicence);
		
		return sb.toString();
		
	}

	public String getDriverLicence() {
		return driverLicence;
	}
	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
	
	
}
