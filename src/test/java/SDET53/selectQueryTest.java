package SDET53;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class selectQueryTest {

	public static void main(String[] args) throws Throwable{
		
		// step1 : Register Driver
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		// Step2 : Get connection for database
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root", "root");
		
		// Step3 : Create statement
		
		java.sql.Statement state = conn.createStatement();
		String query = "select * from rmg";
		
		// Step4 : Execute Query
		
		ResultSet result = state.executeQuery(query);
	
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		conn.close();
	}
}
