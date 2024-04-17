package de.thb.dim.pizzaPronto;
import java.awt.Color;
//import java.util.Objects; 
public class ChefVO extends EmployeeVO {
//	private String lastName;
//	private String firstName;
	private Color colorApron;
	
//	public ChefVO() {
//		this(null, null, null);
//		
//	}
	  public ChefVO() {
	        this(null, null, null);
	        this.colorApron = null;
	    }
//	public ChefVO(String lastName, String firstName, Color colorApron) {
//		setLastName(lastName);
//		setFirstName(firstName);
//		setColorApron(colorApron);
//	}
//	public ChefVO(String personnelNo, String lastName, String firstName) {
//		super(personnelNo,lastName,firstName);
//		setColorApron(colorApron);
//	}
//	public ChefVO(String personnelNo, String lastName, String firstName) {
//	    super(personnelNo, lastName, firstName);
//	    this.colorApron = null; // Initialisiere colorApron mit null
//	}
	  public ChefVO(String personnelNo, String lastName, String firstName) {
	        super(personnelNo, lastName, firstName);
	        this.colorApron = null;
	    }

	
//	public String toString() {
////		if(this.lastName != null && this.firstName != null && this.colorApron != null) {
//		if(colorApron != null) {
//			StringBuilder result = new StringBuilder();
////			result.append(lastName + ", " + firstName + " " + colorApron);
//			result.append("Chef: ");
//			return result.toString();
//		}
//		return super.toString();
////		return null;
//	}
//	@Override
//	public String toString() {
//	    StringBuilder result = new StringBuilder(super.toString());
//	    if (getColorApron() != null) {
//	        result.append(", ").append(getColorApron());
//	    }
//	    return result.toString();
//	}
	


//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder(super.toString());
//        if (colorApron != null) {
//            result.append(", Apron color: ").append(colorApron);
//        }
//        return result.toString();
//    }
	  
	  @Override
	  public String toString() {
	      StringBuilder result = new StringBuilder(super.toString());
	      result.append(", Chef");
	      if (colorApron != null) {
	          result.append(", Apron color: ").append(colorApron);
	      }
	      return result.toString();
	  }





	
//	public int hashCode() {
//		return Objects.hash(lastName, firstName, colorApron);
//	}
//	@Override
//	public boolean equals(Object o) {
//		ChefVO chef;
//		if(this == o) return true;
//		if(o == null) return false;
//		if(this.getClass() != o.getClass()) return false;
//		chef = (ChefVO) o;
//		
//		//Referenzvariable Check
//		if(this.lastName == null) {
//			if(chef.getLastName() != null) return false;
//		}else if(!this.lastName.equals(chef.getLastName())) return false; //wenn chef.getLAstName identeisch zu this.lastName gibt es true zurueck, dann wird das true zu false und der if Fall tritt nicht ein, es wird nicht false zurueck gegeben
//
//		else if(this.firstName == null) {
//			if(chef.getLastName() != null) return false;
//		}else if(!this.firstName.equals(chef.getFirstName())) return false;
//
//		else if(this.colorApron == null) {
//			if(chef.getColorApron() != null) return false;
//		}else if(!this.colorApron.equals(chef.getColorApron())) return false;
//
//		
//		return true;
//	}
	
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ChefVO chef = (ChefVO) o;
//        return getPersonnelNo().equals(chef.getPersonnelNo());
//    }
	  @Override
	  public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      ChefVO chef = (ChefVO) o;
	      
	      // Check if both personnelNo are null
	      if (getPersonnelNo() == null && chef.getPersonnelNo() == null) return true;
	      // Check if one of the personnelNo is null
	      if (getPersonnelNo() == null || chef.getPersonnelNo() == null) return false;
	      return getPersonnelNo().equals(chef.getPersonnelNo());
	  }

	  
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
	public void setColorApron(Color colorApron) {
		if(colorApron != null) {
			this.colorApron = colorApron;
		}
	}
	public Color getColorApron() {
		return colorApron;
	}
	
	
}
