package de.thb.dim.pizzaPronto;

public class Kitchen implements IService{
	private EmployeeVO[] employees;

	@Override
	public String startService(OrderVO order) {
		String s = String.format("\nService of ChefVO %s: No order available.", employees[0].getPersonnelNo());

		if (order == null) {
			s = String.format("\nService of ChefVO %s: No order available.", employees[0].getPersonnelNo());
		} else {
			if (order.getState().equals("confirmed")) {
				order.setState("ready");
				s = String.format("\nService of ChefVO %s: Order is ready.", employees[0].getPersonnelNo());
			} else {
				s = String.format("\nService of ChefVO %s: No order for processing available.",
						employees[0].getPersonnelNo());
			}
		}
		return s;
	}
	public Kitchen() {
		employees = new EmployeeVO[1];
		employees[0] = new ChefVO("Man5Kueche","ALbert","Einstein");
	}
	public EmployeeVO[] getEmployees() {
		return employees;
	}
	public void setEmployees(EmployeeVO[] employees) {
		this.employees = employees;
	}
	

}
