package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class kayak {

	public static void main(String[] args) throws Throwable 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/");
		
		// Enter From location
		
		Thread.sleep(2000);
		WebElement fromTxt = driver.findElement(By.xpath("//input[@aria-label='Flight origin input']"));
		fromTxt.click();
		fromTxt.clear();
		fromTxt.sendKeys("delhi");
		driver.findElement(By.xpath("//span[.='New Delhi, National Capital Territory of India, India']")).click();
		
		// Enter To location
		
		Thread.sleep(2000);
		WebElement toLoc = driver.findElement(By.xpath("//input[@aria-label='Flight destination input']"));
		toLoc.click();
		toLoc.sendKeys("kolkata");
		driver.findElement(By.xpath("(//div[.='Kolkata, West Bengal, India (CCU)'])[1]")).click();
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		
		// Selecting date from calendar
		driver.findElement(By.xpath("(//div[@class='sR_k-input sR_k-mod-responsive'])[1]")).click();	
		driver.findElement(By.xpath("(//label[.='Dates']/ancestor::div[@class='KK6S-dropdownContentWrapper KK6S-flexModeTabs']//div[@class='onx_-days']//div[text()='19'])[1]")).click();
		
		
	}
}
