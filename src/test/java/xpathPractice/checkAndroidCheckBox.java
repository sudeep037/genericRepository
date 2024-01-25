package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkAndroidCheckBox {

	public static void main(String[] args) throws Exception{
		
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
	    
		// click on android-13.0 checkbox
		
		driver.findElement(By.xpath("//span[text()='Android 13.0']/..//input[@type='checkbox']")).click();
		
		String actualTitleAfterClicking = "Amazon.in : samsung";
		String expTitle = driver.getTitle();
		
		if(actualTitleAfterClicking.equals(expTitle))
		{
			System.out.println("Your checkbox click action is Successful");
		}
		
		driver.quit();
	}
}
