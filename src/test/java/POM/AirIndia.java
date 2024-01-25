package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AirIndia {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.airindia.com");
		
		// Mouse hover on book and manage
		
		WebElement bookAndManage = driver.findElement(By.xpath("//a[.='Book & Manage']"));
		Actions act = new Actions(driver);
		act.moveToElement(bookAndManage).perform();
		
		// Click on 
		
		driver.findElement(By.xpath("(//a[contains(.,'Search Flights')])[1]")).click();
		
		// enter from location
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='From']"));
		
		driver.findElement(By.xpath("//ngb-highlight[text()='Indira Gandhi International Airport']")).click();
	    
		// enter To location
	    
		driver.findElement(By.xpath("//input[@id='From']")).click();
		driver.findElement(By.xpath("//ngb-highlight[text()='Netaji Subhash Chandra Bose International Airport']")).click();
		
		
	}
	
}
