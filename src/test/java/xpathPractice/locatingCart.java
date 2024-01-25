package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class locatingCart {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		
		Thread.sleep(2000);
		
		//Locating a cart 
		WebElement locatedCart = driver.findElement(By.xpath("//div[@class='_2msBFL']//div[3]/div[@class='_38VF5e'] "));
		System.out.println("Text of the cart is - "+locatedCart.getText());
		System.out.println("Position of the cart is - "+locatedCart.getLocation());
		
		driver.quit();
	}
}
