package dbVerification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataVerification {

	public static void main(String[] args) throws Throwable{
		
		
		Random ran = new Random();
		int no = ran.nextInt(100);
		String proj_name = "cromwellHMS_Project"+no;
		Connection conn = null;
		
		try {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		
		
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
	    // Click on project link
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		//Click on create button 
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		//enter project details
		driver.findElement(By.name("projectName")).sendKeys(proj_name);
		driver.findElement(By.name("createdBy")).sendKeys("Mageswari_HR");
		WebElement status =  driver.findElement(By.xpath("(//select[@name='status'])[1]"));
		
		Select s = new Select(status);
		s.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		
		conn =  DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		
		Statement stmt = conn.createStatement();
		String query = "select * from project where lower(project_name)='"+proj_name+"';";
		
		ResultSet result = stmt.executeQuery(query);
		boolean status1 = false;
		
		while(result.next())
		{
			String actual = result.getString(4);
			
			if(proj_name.equalsIgnoreCase(actual))
			{
				status1 = true;
				break;
			}
		}
		if(status1==true)
		{
			System.out.println("--Project create succesfully--");
		}
		else {
			System.out.println("--Not Created--");
		}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
	}	
}


