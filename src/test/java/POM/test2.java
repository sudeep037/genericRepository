package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test2 {

	public static void main(String[] args) throws Exception
	{
		
		// launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		// maximize window
		driver.manage().window().maximize();
		
		//enter url
		driver.get("https://www.goibibo.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[@class = 'logSprite icClose']")).click();
		
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[@class='DayPicker-Body']/child::div[3]/div[@aria-label='Sun Jan 14 2024']")).click();
		
		driver.findElement(By.xpath("//span[.='Done']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//li[.='premium economy']")).click();
		
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		
        driver.findElement(By.xpath("//p[.='Click to add a return flight for better discounts']")).click();
		
        driver.findElement(By.xpath("//div[@class='DayPicker-Month'][2]/child::div[3]/descendant::div[@aria-label='Sun Feb 11 2024']")).click();
		
		driver.findElement(By.xpath("//span[.='Done']")).click();
		
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		
		// click on From location 
		
		driver.findElement(By.xpath("//p[.='Enter city or airport']")).click();
		
		// enter value in from location
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bengaluru");
		
		// click on From location 
		
		driver.findElement(By.xpath("//p[text()='Bengaluru International Airport']")).click();
		
		// enter value in To location
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Delhi");
		
		// click on To location
		
		driver.findElement(By.xpath("//p[text()='Indira Gandhi International Airport']")).click();
		
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		
		// search flight 
		
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
		
		Thread.sleep(15000);
		
		String actualTitle = "Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo";
		String expectedTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Hi most welcome to Ibibo");
			driver.quit();
		}
		
		else {
		System.out.println("Sorry...");
		driver.quit(); }
	}
}
