package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fetchDateFromMMT {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		// Click on Depart date
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String getDate = driver.findElement(By.xpath("//div[contains(text(),'January')]/ancestor::div[@class='DayPicker-Month']//p[text()='24']")).getText();
		System.out.println("The located date is - "+getDate+" January,2024");
		
		driver.quit();
	}
}
