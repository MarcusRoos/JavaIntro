package maro1904_DT062G_exam;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		
		
		Car newCar = new Car();

		
	    Scanner input = new Scanner(System.in);
	    boolean mainLoop = true;

	    int choice;
	    while(mainLoop){
	        System.out.println("Car menu\n");
	        System.out.print("1. Create car \n");
	        System.out.print("2. Exit\n");
	        choice = input.nextInt();

	    switch(choice){

	    case 1:
	    	Scanner regScanner = new Scanner(System.in);
	        String regnr;
	        System.out.print("Enter reg nr, 6 characters: ");
	        regnr = regScanner.nextLine();
	        if (regnr.length() > 6) {
	        	regnr = regnr.substring(0, 6);
	        	}
			newCar = CarFactory.create(regnr);
			 System.err.println(newCar);
	        break;

	    case 2: 
	        System.out.println("Exiting...");
	        System.exit(0);
	         break;
	    default :
	             System.out.println("Wrong menu option");
	             break;

	    				}
	    		}
	    input.close();
		}
}