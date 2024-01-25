import java.io.FileInputStream;

import org.junit.Test;
import org.testng.annotations.DataProvider;

public class dataProviderTest {

	@DataProvider(name="Organization")
	public Object[][] data()
	{
		Object[][] arr= new Object[4][2];
		arr[0][0]="EmpName";
		arr[0][1]="Organization";
		
		arr[1][0]="Ashutosh";
		arr[1][1]="Capegemini";
		
		arr[2][0]="Narendra";
		arr[2][1]="Webkul";
		
		arr[3][0]="Nikhita";
		arr[3][1]="Apple";
		
		return arr;
	}
	
	@org.testng.annotations.Test(dataProvider = "Organization")
	public void testDataProvider(String EmpName, String Organization)
	{
		System.out.println(EmpName+" ----> "+Organization);
	}
	
	
}
