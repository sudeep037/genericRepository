import org.testng.annotations.Test;

public class testDataProvider2 {

	@Test(dataProviderClass = dataProviderTest.class, dataProvider = "Organization")
	public void testDataProv(String EmpName, String Organization)
	{
		System.out.println(EmpName+" ----> "+Organization);
	}
}
