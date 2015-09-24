/**
 * 
 */
package org.cuatrovientos.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Irene
 *
 */
public class Bd extends Main{
	
	private static Statement statement = null;
	private Connection connection;

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Bd() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection =
				DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement statement = connection.createStatement();
		
		String sql = "create table customers (id integer, name varchar(30))";
		//statement.executeUpdate(sql);
	    
	}
	
	/**
	 * Insert a customer in to the database
	 * @param statement
	 * @throws SQLException
	 */
	public void insertCustomer(Customer customer) throws SQLException {
		String insertSql = "insert into customer values("+customer.getIdCard()+",'"+customer.getName()+"')";
		statement.executeUpdate(insertSql);		
	}
	
	/**
	 * Show a customer by Id
	 * @param id
	 * @param statement 
	 * @throws SQLException
	 */
	public static String  showOne(int id) throws SQLException{
		String select = "select * from customer where id= values('+id+')";
		ResultSet resultSet = statement.executeQuery(select);
		System.out.print("ID: " + resultSet.getInt("id"));
		System.out.println(" Name: " + resultSet.getString("name"));
		
	   return resultSet.toString();
	}
	/**
	 * Update a customer
	 * @param statement
	 * @throws SQLException
	 */
	public void updateCustomer(int id, String name) throws SQLException {
		String updateSql = "update customer set name='"+name+"' where id='"+id+"'";
		statement.executeUpdate(updateSql);
		ResultSet resultSet = statement.executeQuery(updateSql);
		System.out.print("ID: " + resultSet.getInt("id"));
		System.out.println(" Name: " + resultSet.getString("name"));
		
	}
	
	/**
	 * Delete a customer from the database
	 * @param statement
	 * @throws SQLException
	 */
	public void deleteCustomer(int id) throws SQLException {
		String deleteSql = "delete from customer where id="+id+"";
		statement.executeUpdate(deleteSql);
	}

	public void showAll() throws SQLException{
		String select = "select * from customer";
		ResultSet resultSet = statement.executeQuery(select);
		System.out.print("ID: " + resultSet.getInt("id"));
		System.out.println(" Name: " + resultSet.getString("name"));
		
	}

	public void close() throws SQLException {
	     connection.close();
		
	}

	
	
}