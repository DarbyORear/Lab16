package lab16;

//THIS FILE SHOULD BE COMPARABLE TO TOASTFILEUTIL (I THINK)

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesTextFile {


//	//This file should include two methods:
//	
//	//Method 1: allows you to read countrylist from file
//	
//	List<Country> list = CountriesListApplication.readFile();
//	for (Country c : list) {
//		System.out.println(c);
//	}
//
//	//Method 2: allows you to write list of countries to file
//	
//	//appending
//	Country country = new Country("19.", "Ireland");
//	ToastFileUtil.appendLine(toast);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			
			// The path to the file to use
			public static final String FILE_NAME = "countries.txt";
			
			// Modify this method as necessary to convert a line of text from the file to a new item instance
			private static Country convertLineToItem(String line) {
				// TODO Fill in this method
				
//					String[] parts = line.split("\t");
					Country country = new Country(line);
//					country.setCountryNum((parts[0]));
//					country.setCountryName((parts[0]));
					return country;
				}
			
			// Modify this method as necessary to convert an item instance to a line of text in the file
			private static String convertItemToLine(Country item) {
				// TODO Fill in this method
				return String.format("%s",item.getCountryName());
				
			}
			
			public static List<Country> readFile() {
				List<Country> items = new ArrayList<Country>();
				
				try (
					// Open/prepare the resources in the try resources block
					FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
					Scanner fileScanner = new Scanner(fileInputStream);
				) {
					// loop until the end of the file
					while (fileScanner.hasNextLine()) {
						// read each line as a string
						String line = fileScanner.nextLine();
						// then convert it to an object
						items.add( convertLineToItem(line) );
					}
					
				} catch (FileNotFoundException ex) {
					// If the file doesn't exist, there just aren't any items.
					return items;
				} catch (IOException e) {
					// If something else crazy goes wrong, print out the error.
					System.err.println("Something unexpected happended.");
					e.printStackTrace();
				}
				
				// Finally return the array of items.
				return items;                                                     //GREAT. THE ITEMS HAVE BEEN RETURNED. HOW DO WE SYSTEM.OUT.PRINT THEM??
			}																		//I think I figured out format for printing the countries, but it's not working.
			
			public static void appendLine(Country item) {
				// convert object to a string line of text to be written to the file
				String line = convertItemToLine(item);
				
				try (
					// The `true` here tells the FileOutputStream to append to the file rather than overwriting it
					FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
					PrintWriter fileWriter = new PrintWriter(fileOutputStream);
				) {
					// write to the file
					fileWriter.println(line);
					
				} catch (IOException e) {
					// If something else crazy goes wrong, print out the error.
					System.err.println("Something unexpected happended.");
					e.printStackTrace();
				}
			}
			
			public static void writeFile(List<Country> items) {
				try (
					// The `false` here tells the FileOutputStream to overwrite the file, rather than append to it
					FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
					PrintWriter fileWriter = new PrintWriter(fileOutputStream);
				) {
					// write to the file
					for (Country item : items) {
						// each item must be converted to a string of text to write to the file
						String line = convertItemToLine(item);
						fileWriter.println(line);
					}
					
				} catch (IOException e) {
					// If something else crazy goes wrong, print out the error.
					System.err.println("Something unexpected happended.");
					e.printStackTrace();
				}
			}
			
			public static void createDirectory(String pathName) {
				Path path = Paths.get(pathName);
				if (Files.notExists(path)) {
					try {
						Files.createDirectories(path);
						System.out.println("Directory created at " + path.toAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			public static void createBlankFile(String pathName) {
				Path path = Paths.get(pathName);
				if (Files.notExists(path)) {
					try {
						Files.createFile(path);
						System.out.println("File created at " + path.toAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}





//TODO:
//-save text file to computer
//-