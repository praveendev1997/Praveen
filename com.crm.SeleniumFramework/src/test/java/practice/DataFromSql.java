package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class DataFromSql {

	public static void main(String[] args) throws Throwable {
		//step 1:register or load the Mysql database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step 2: get connect to database
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
		
		//step 3:create sql statement
		Statement stat=(Statement) conn.createStatement();
		String selectQuerry="select * from student";
		
		//step 4: execute statement/querry
		ResultSet result =stat.executeQuery(selectQuerry);
		while(result.next())
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		conn.close();
	}

}
