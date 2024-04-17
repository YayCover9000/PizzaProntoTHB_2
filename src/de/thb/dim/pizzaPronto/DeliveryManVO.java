package de.thb.dim.pizzaPronto;

public class DeliveryManVO extends EmployeeVO{
	private String driverLicence;
	
	public DeliveryManVO() {
		this(null,null,null);
	}
	public DeliveryManVO(String personnelNo, String lastName, String firstName) {
		super(personnelNo, lastName, firstName);
		setDriverLicence(driverLicence);
	}
	@Override
	public String toString() {
		return super.toString() + "DeliveryManVO [driverLicence=" + driverLicence +"]";
	}

	public String getDriverLicence() {
		return driverLicence;
	}
	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}
	
	
}
