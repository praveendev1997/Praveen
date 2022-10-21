package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class CreateRowForSql {

	public static void main(String[] args) throws SQLException {
		//step 1:register or load the Mysql database
				Driver driverref=new Driver();
				DriverManager.registerDriver(driverref);
				
				//step 2: get connect to database
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra","root","root");
				
				//step 3:create sql statement
				Statement stat=(Statement) conn.createStatement();
				
				String querry="insert into student(first_name,last_name,address,ph_num)values('Deepak','A','india','2562')";
				
				//step 4: execute querry
				int result=stat.executeUpdate(querry);  //primitive datatype content level comparison
														// nonprimitive datatype address level comparison
				if(result==1)		// if((result==1)&&(result1==1))
				{
					System.out.println("user is created");
				}
				else
				{
					System.out.println("user is not created");
				}
				
				conn.close();
	}

}
