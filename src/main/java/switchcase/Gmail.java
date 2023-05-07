package switchcase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Gmail {
	
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
	Statement statement1=connection1.createStatement();
	statement1.execute("create database googleee991");
	System.out.println("Database is created");
	connection1.close();
	
	Connection connection2=DriverManager.getConnection("jdbc:mysql://localhost:3306/googleee991","root","root");	
	Statement statement2=connection2.createStatement();
	statement2.execute("create table gmailll4(phone bigint primary key,First_name varchar(20) not null,Last_name varchar(20),Username varchar(20) not null unique,Password varchar(16) not null unique)");
	System.out.println("Table is created");
	connection2.close();
	
	
	
	Connection connection3=DriverManager.getConnection("jdbc:mysql://localhost:3306/googleee991","root","root");
	boolean b=true;
	while(b) {
		System.out.println("select any one of the option below shown");
		System.out.println("1.Insert 2.update 3.Fetch or Retrieve 4.delete 5.Thanku 6.Default");
		System.out.println("Enter here");
		int a = scanner.nextInt();
		switch (a) {
		
		case 1:{
			PreparedStatement preparedStatement=connection3.prepareStatement("insert into gmailll4 values(?,?,?,?,?)");
			System.out.println("Enter user phone number");
			long phone=scanner.nextLong();
			
			System.out.println("Enter user first name");
			String first_name=scanner.next();
			
			System.out.println("Enter user last name");
			String last_name=scanner.nextLine();
			scanner.nextLine();
			
			System.out.println("Enter user Username");
			String username=scanner.next();
			
			System.out.println("Enter user Password");
			String password=scanner.next();
			
			preparedStatement.setLong(1, phone);
			preparedStatement.setString(2, first_name);
			preparedStatement.setString(3, last_name);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, password);
			preparedStatement.execute();
			
			System.out.println("The values are inserted into the table");
			break;
		}
		case 2:{
			PreparedStatement preparedStatement=connection3.prepareStatement(
					"update gmailll4 set First_name=?,Last_name=?,Username=?,Password=? where phone=?");
			System.out.println("Enter the first_name to update");
			String first_name=scanner.next();
			
			System.out.println("Enter the last_name to update");
			String last_name=scanner.next();
			scanner.nextLine();
			
			System.out.println("Enter the username to update");
			String username=scanner.next();
			
			System.out.println("Enter the password to update");
			String password=scanner.next();
			
			System.out.println("Enter the primarykeyas your phone number");
			long phone=scanner.nextLong();
			
			preparedStatement.setString(1, first_name);
			preparedStatement.setString(2, last_name);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4 ,password);
			preparedStatement.setLong(5, phone);
			preparedStatement.executeUpdate();
			
			System.out.println("The values are updated successfully");
			break;
			}
		
		case 3:{
			
			PreparedStatement preparedStatement=connection3.prepareStatement("select * from gmailll4 where phone=?");
			
			System.out.println("Enter the phone number to fetch or retrieve the details of the user");
			long phone=scanner.nextLong();
			preparedStatement.setLong(1, phone);
			
			ResultSet resultset=preparedStatement.executeQuery();
			resultset.next();
			System.out.println("phone:" +resultset.getLong(1)+" "+"first_name:" +resultset.getString(2)+ " "+"last_name:"+resultset
			.getString(3)+ " "+"username:" +resultset.getString(4)+" "+ "password:" +resultset.getString(5));
			break;
			}
		
		case 4:{
			
			PreparedStatement preparedStatement=connection3.prepareStatement("delete from gmailll4 where phone=?");
			
			System.out.println("Enter the primarykey as phone to delete the values of row");
			long phone=scanner.nextLong();
			preparedStatement.setLong(1, phone);
			
			preparedStatement.execute();
			
			System.out.println("The values of respective primary key row is deleted");
			break;
		}
		case 5:
		{
			System.out.println("Successfully did CRUD Operations Thank you");
			//b=false;
			break;
		}
		case 6:
			default:
				System.out.println("Invalid choice select the proper options");
		}
	}
		connection3.close();
		
		
		
		
	}
		
		
}
	
	


