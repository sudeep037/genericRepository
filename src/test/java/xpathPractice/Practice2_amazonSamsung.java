package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice2_amazonSamsung {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		// Enter Samsung into search text field
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("samsung phones");
		
		// click on search button
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		Thread.sleep(5000);
		
		// Fetching the price of samsung mobile 
		
		String samsungPrice = driver.findElement(By.xpath("//span[text()='Samsung Galaxy M13 (Midnight Blue, 4GB, 64GB Storage) | 6000mAh Battery | Upto 8GB RAM with RAM Plus']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price']")).getText();
		System.out.println("The price of Samsung phone is - "+samsungPrice);
		
		driver.close();
		
	}
}
