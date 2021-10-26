package maro1904_DT062G_exam;
import java.util.Random;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class CarFactory {
	private final static String[] carBrands ={"Alfa Romeo",	"Audi",	"BMW", 	"Chevrolet",
			"Citroen", "Fiat", "Ford", "Honda", "Mazda", "Mercedes-Benz",
			"Mitsubishi", "Opel", "Peugeot", "Renault", "Saab", "Skoda",
			"Subaru", "Toyota", "Volkswagen", "Volvo"};
		
		private final static String[][] carModels = {
			{"MiTo", "Giulietta", "4C", "Giulia"},
			{"A1", "A3", "A5", "A6", "A7", "A8", "TT", "R8", "Q3"},
			{"316i", "328i xDrive", "330d", "523i", "550i", "535d", "730Li", "750i/Li xDrive", "xDrive20i", "Z4 GTE"},
			{"Camaro", "Corvette", "Orlando", "Niva", "Prisma", "Impala", "Express"},
			{"C1", "C3 Picasso", "Berlingo", "C4", "C5"},
			{"Doblo", "Punto", "Bravo", "Linea"},
			{"Mondeo", "Fiesta", "Focus", "Ka", "Sierra", "Granada"},
			{"Accord", "Civic", "Brio", "Crider"},
			{"Carol", "Scrum", "RX-8", "CX-7", "Bongo", "Axela", "Premacy"},
			{"ML 350", "ML 63 AMG", "S500", "E350", "E250 CDI", "SL500", "R230"},
			{"Adventure", "L200", "Lancer", "Strada", "Fuzion", "Dignity"},
			{"Astra", "Corsa", "Agila", "Tigra", "GT"},
			{"107", "207", "308", "408", "Partner", "807"},
			{"Captur", "Clio", "Laguna", "Scala", "Twingo", "Pulse"},
			{"9-3", "9-5"},
			{"Citigo", "Fabia", "Rapid", "Octavia", "Yeti"},
			{"BRZ", "Exiga", "Forester", "Impreza", "R1", "Stella"},
			{"Avanza", "Comfort", "Corolla", "Etios", "Vensa" , "Verso"},
			{"Beetle", "Fox", "Polo", "Golf", "Passat", "Sharan"},
			{"V40", "S60", "XC90", "V70", "S80", "XC70", "V50"}
		};
		
		private final static int[] years = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 206, 2017, 2018, 2019, 2020, 2021};
		
		public static Car create(String regnr) {
			String MD5 = md5(regnr.toUpperCase());
		    int md5decimal=Integer.parseInt(MD5);  
			int brandidx, modelidx, yearidx = -1;
			brandidx = (md5decimal % carBrands.length);
			modelidx = (md5decimal % carModels[brandidx].length);
			yearidx = (md5decimal % years.length);
			
			System.out.println("Creating...\n");

			Car newCar = new Car(regnr, carBrands[brandidx], carModels[brandidx][modelidx], years[yearidx]);
			return newCar;
		}

		private static String md5(String s) {
			String hashtext = "";
			MessageDigest digest;
			BigInteger integer;
			int dec = -1;
			byte[] digestMessage;
	        try { 
	        	  
	        	digest = MessageDigest.getInstance("MD5"); 
	        	digestMessage = digest.digest(s.getBytes()); 
	            integer = new BigInteger(1, digestMessage); 
	            hashtext = integer.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	        }
	        catch (NoSuchAlgorithmException e) { 
	            throw new RuntimeException(e); 
	        }    
		
	        if (hashtext.length() > 6) {
	        	hashtext = hashtext.substring(0, 6);
	        	}
	        hashtext = hashtext.toUpperCase();
	        dec = hexToDec(hashtext);
			return String.valueOf(dec);
		}
		
		private static int hexToDec(String hex) {
			String hexDigits = "0123456789ABCDEF";
            int decimal = 0;
            for (int i = 0; i<hex.length(); i++) {
                char c = hex.charAt(i);
                int p = hexDigits.indexOf(c);
                decimal = 16*decimal + p;
            }
			return decimal;
		}


}