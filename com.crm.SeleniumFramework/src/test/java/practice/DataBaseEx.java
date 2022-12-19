package practice;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class DataBaseEx {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name");
		String name=sc.nextLine();
		Driver driref=new Driver();
		DriverManager.registerDriver(driref);
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		Statement stat=(Statement) conn.createStatement();
		String querry="INSERT INTO employee(ename) values('"+name+"')";
		try
		{
		stat.executeUpdate(querry);
		System.out.println(name+" added successfully ");
		}
		catch(SQLException e)
		{
			System.out.println(name+" is already present in the database");
		}
		conn.close();
	}

}
