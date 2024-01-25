import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class practice1 {

	@BeforeSuite
	public void suite()
	{
		System.out.println("Before suite");
	}
	
	@BeforeClass
	public void clas()
	{
		System.out.println("Before class execute");
	}
	
	@BeforeClass
	public void clas2()
	{
		System.out.println("Before class execute 2nd time");
	}
	
	@BeforeClass
	public void clas3()
	{
		System.out.println("Before class execures 3rd time");
	}
	
	@BeforeMethod
	public void method1()
	{
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void mtd1()
	{
		System.out.println("After method executes");
	}
	
	@AfterClass
	public void afterClas()
	{
		System.out.println("After class executes");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test 1 executes");
	}
	
	@Test
	public void test2()
	{
		System.out.println("test 2 executes");
	}
	
	@AfterSuite
	public void aftSuite()
	{
		System.out.println("After suites executes");
	}
	
}
