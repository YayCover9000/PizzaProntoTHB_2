package de.thb.dim.pizzaPronto;
import java.awt.Color;
//import java.util.Objects; 
public class ChefVO extends EmployeeVO {
	private Color colorApron;
	public ChefVO() {
	        this(null, null, null);
	    }

	  public ChefVO(String personnelNo, String lastName, String firstName) {
	        super(personnelNo, lastName, firstName);
	    }
	  
	  @Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			
			sb.append("\nChef:\n" );
			
			sb.append(super.toString());
			
			if(colorApron != null)
				sb.append("\nApron " + colorApron.toString());
			
			return sb.toString();
		}

//	  @Override
//	  public boolean equals(Object o) {
//	      if (this == o) return true;
//	      if (o == null || getClass() != o.getClass()) return false;
//	      ChefVO chef = (ChefVO) o;
//	      
//	      // Check if both personnelNo are null
//	      if (getPersonnelNo() == null && chef.getPersonnelNo() == null) return true;
//	      // Check if one of the personnelNo is null
//	      if (getPersonnelNo() == null || chef.getPersonnelNo() == null) return false;
//	      return getPersonnelNo().equals(chef.getPersonnelNo());
//	  }
	  
	public void setColorApron(Color colorApron) {
		if(colorApron != null) {
			this.colorApron = colorApron;
		}
	}
	public Color getColorApron() {
		return colorApron;
	}
	
	
}
