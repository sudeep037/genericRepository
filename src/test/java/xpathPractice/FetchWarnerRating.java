package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchWarnerRating {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/batting/mens/odi");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		
		Thread.sleep(4000);
		
		//Fetching David warner rating 
		
		String name = driver.findElement(By.xpath("//span[text()='Warner']/../../../../..//div[@class='si-table-data si-rating']")).getText();
		System.out.println("The rating of David Warner is "+name);
		
		driver.quit();
	}
}
