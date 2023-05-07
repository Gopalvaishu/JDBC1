package jdbcpp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Imageinsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/prepared","root","root");
		PreparedStatement preparedStatement=connection.prepareStatement("insert into college values (9,'sapthagiri','Maralurudinne',9676543321,?)");
		FileInputStream fileInputStream=new FileInputStream("E:\\image3.jpg");
		preparedStatement.setBinaryStream(1, fileInputStream);
		preparedStatement.execute();
		System.out.println("data/image inserted successfully");
	}

}
