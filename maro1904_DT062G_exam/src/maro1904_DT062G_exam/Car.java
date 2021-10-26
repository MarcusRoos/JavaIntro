package maro1904_DT062G_exam;

public class Car {
	
	  private String regnr;  
	  private String brand; 
	  private String model; 
	  private int year; 
	  
	  public Car() {
		  regnr = "";
		  brand = "";
		  model = "";
		  year = 0;
	  }

	    public Car(String areg, String abrand, String amodel, int ayear) {
			  regnr = areg;
			  brand = abrand;
			  model = amodel;
			  year = ayear;
	    }
	    
	    public String getReg() {
	        return regnr;
	    }

	    public String getBrand() {
	        return brand;
	    }	    
	    
	    public String getModel() {
	        return model;
	    }
	    
	    public int getYear() {
	        return year;
	    }
	    
	    public void setReg(String aReg) {
	        regnr = aReg;
	    }

	    public void setBrand(String aBrand) {
	        brand = aBrand;
	    }
	    
	    public void setModel(String aModel) {
	        model = aModel;
	    }
	    
	    public void setYear(int aYear) {
	        year = aYear;
	    }
	    
	    
	    public String toString(){ 
	    	  return "Regnr = "+ regnr + ", Brand = " + brand + ", Model = " + model + ", Year = " + year + ")" ;
	    } 

}