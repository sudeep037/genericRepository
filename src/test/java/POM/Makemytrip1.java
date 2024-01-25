package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com");
		
		// entering from location
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
		
		// entering from location
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//p[text()='Indira Gandhi International Airport']")).click();
		
		// selecting depart date 

		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'January')]/ancestor::div[@class='DayPicker-Month']//p[text()='24']")).click();
		
		// selecting return date 
		
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'February')]/ancestor::div[@class='DayPicker-Month']//p[text()='14']")).click();
		
		// Choose class
		
		driver.findElement(By.xpath("//span[text()='Travellers & Class']")).click();
		driver.findElement(By.xpath("//li[text()='Premium Economy']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		
		// Click on search button
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		// Click on OKAY got it!!
		
		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		
		driver.quit();
	}
}
