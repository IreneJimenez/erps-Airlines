package org.cuatrovientos.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 * @author Irene
 *
 */
public class Main 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	 System.out.println("Hello World!");
         String option = "";
         String name = "";
         int id = 0;
         Scanner reader = new Scanner(System.in);
         Bd myBd = new Bd();
         do {
         	option = showMenu(reader);
         	switch (option) {
        	case "1":
        		id = readId(reader);  
        		name = readName(reader);
        		Customer customer = new Customer(id, name);
        		myBd.insertCustomer(customer);
        		break;
        	case "2":
        		id = readId(reader);   
        		Bd.showOne(id);     
        		break;
        	case "3":
        		id = readId(reader);   
        		myBd.deleteCustomer(id); 
        		break;  
        	case "4":
        		id = readId(reader);  
        		name = readName(reader);
        		myBd.updateCustomer(id, name); 
        		break; 
        	case "5": 
        		myBd.showAll(); 
        		break; 
        	default:
        		myBd.close();
        		break;
         	}
         } while (!option.equals("6"));
    	
    }
    
    public static int readId(Scanner reader){
    	int id;
    	System.out.println("Please, enter the id of customer");
    	id =Integer.parseInt(reader.nextLine());
    	return id;
    }
    /**
	 * Read name of customer
	 * @param reader
	 * @return
	 */
	public static String readName(Scanner reader){
		String name;
		System.out.println("Please, enter name");
		name = reader.nextLine();
		return name;
	}

	/**
	 * Show menu
	 * @param reader
	 * @return
	 */
	private static String showMenu(Scanner reader) {
		String option;
		System.out.println("Please select option:");
		System.out.println("1. Insert a customer");
		System.out.println("2. Show one customer");
		System.out.println("3. Remove a customer");
		System.out.println("4. Update a customer");
		System.out.println("5. Show all");
		System.out.println("6. Exit");
		
		option = reader.nextLine();
		return option;
	}
}
