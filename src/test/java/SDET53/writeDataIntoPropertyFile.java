package SDET53;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class writeDataIntoPropertyFile {

	public static void main(String[] args) throws Throwable{
		
		Properties p = new Properties();
		
		// storing Doctor data into property file
		
		p.setProperty("browser", "Chrome");
		p.setProperty("url", "http://rmgtestingserver/domain/Hospital_Management_System/");
		p.setProperty("username","nik@gmail.com");
		p.setProperty("password", "12345678");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\cromwellData.properties");
		p.store(fos, "write data");
		
		// fetching doctor data from property file
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\cromwellData.properties");
		p.load(fis);
		String URL = p.getProperty("url");
		String Pswd = p.getProperty("password");
		String UN = p.getProperty("username");
		
		// launch the browser 
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		Thread.sleep(3000);
		
		// Click on Doctor module link 
		
		driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(UN);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Pswd);
		
		System.out.println("Successfully ");
		
		driver.quit();
		
		
	}
}
