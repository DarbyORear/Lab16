package lab16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesListApplication {
	
	public static void main(String[] args) {
		
		int userInput=0;
		String userCont = "";		
		
		System.out.print("Hello! ");
		//Display menu with three options:
		do {
		
		//ADD VALIDATOR: Validator.getInt();
			
		System.out.println("What would you like to do? Please choose one: \n 1. View countries \n 2. Add a new country \n 3. Exit the program \n");
		Scanner scnr = new Scanner(System.in);
		userInput = scnr.nextInt();
			if(userInput == 1) {
				//method 1 (display list of countries)
				System.out.println("You chose option 1. Here is the list of countries:");
//				System.out.println(CountriesTextFile.readFile());    //FIXME: THIS JUST PRINTS AN EMPTY ARRAYLIST. 
				
				//reading
				List<Country> items = CountriesTextFile.readFile();
				for (Country c : items) {
					System.out.println(c);
				}
				
				System.out.println("Would you like to choose another option?");
				userCont= scnr.next();
				
			} else if (userInput == 2) {
				//method 2 
				System.out.println("You chose option 2. What country/countries would you like to add to the list?");
				String userAdd= scnr.next();

				
				//appending
				Country country = new Country(userAdd);
				CountriesTextFile.appendLine(country);
				
//				
				System.out.println("Would you like to choose another option?");
			} else {
				break;
			}
		} while (userCont.equalsIgnoreCase("yes") || userCont.equalsIgnoreCase("y"));
		
	System.out.println("Goodbye!");
	

	}
}
