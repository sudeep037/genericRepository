package SDET53;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class updateQuery {

	public static void main(String[] args) throws Throwable {
		
		// step1 : Register Driver
		
		        try {
				Driver driver = new com.mysql.cj.jdbc.Driver();
				DriverManager.registerDriver(driver);
				
				// Step2 : Get connection for database
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root", "root");
				
				// Step3 : Create statement
				
				java.sql.Statement state = conn.createStatement();
				String query = "insert into rmg values('Hemanth TG', 'Web_Technology', 2),('SKR', 'Manual', 6),('Narsimha','Live_Project', 1)";
				
				int result = state.executeUpdate(query);
				
				if(result>1)
				{
					System.out.println("Data added succesfully");
				}
				else {
					System.err.println("--Data not added--");
				}
		        }
				catch(Exception e) {
					e.printStackTrace();
				}
				
	}
}
