package jdbcpp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Fetchallthevalues {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/prepared","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("select * from college where id in(?,?)");
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter id to fetch");
		int id1=sc.nextInt();
		System.out.println("Enter next id to fetch");
		int id2=sc.nextInt();
		
		preparedStatement.setInt(1, id1);
		preparedStatement.setInt(2, id2);
		
		ResultSet resultset=preparedStatement.executeQuery();
		while(resultset.next()) {
		System.out.println("id:"+resultset.getInt(1)+" "+"name:"+resultset.getString(2)+" "+"address:"+resultset.getString(3)+" "+"phone:"+resultset.getLong(4));
	}
	
	}
}
