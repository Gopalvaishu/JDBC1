package jdbcpp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insertthevaluesintothetable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/prepared","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into college values(?,?,?,?)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the college id");
		int id=sc.nextInt();
		
		
		System.out.println("Enter the college name");
		String name=sc.next();
	
		System.out.println("Enter the college address");
		String address=sc.next();
		
		System.out.println("Enter the college phone");
		Long phone=sc.nextLong();
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, address);
		preparedStatement.setLong(4,phone);
		
		preparedStatement.execute();
		
		
	System.out.println(" The data entered is inserted successfullyyy");
		
		
	}
}
