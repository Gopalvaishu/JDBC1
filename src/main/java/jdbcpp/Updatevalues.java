package jdbcpp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Updatevalues {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/prepared","root","root");
		
		PreparedStatement preparedStatement=connection.prepareStatement("update college set name=? where id=?");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter college id");
		int id=sc.nextInt();
		
		System.out.println("Enter college name");
		String name=sc.next();
		
		
		
		preparedStatement.setString(1,name);
		preparedStatement.setInt(2,id);
		

        preparedStatement.execute();
		
		System.out.println("The data updated successfully");
		
	}

}
