package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class clearTrip {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("https://www.cleartrip.com");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='px-1   flex flex-middle nmx-1 pb-1']")).click();
		driver.findElement(By.xpath("//span[text()='One way']")).click();
		driver.findElement(By.xpath("//span[text()='Round trip']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Where from?']")).sendKeys("bangalore");
		driver.findElement(By.xpath("//div[text()='BLR']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys("Mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, IN - Chatrapati Shivaji Airport (BOM)']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[text()='January 2024']/parent::div[@class='DayPicker-Caption']/following-sibling::div[@class='DayPicker-Body']/descendant::div[@aria-label='Thu Jan 18 2024']")).click();
	}
}
