package Assignement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class television {

	@Test
	public void test() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("https://www.flipkart.com/");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//div[@class='_3sdu8W emupdz']//span[.='Appliances']")).click();
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    for(int i = 1; i<=10; i++)
	    {
	       js.executeScript("window.scrollBy(0,50)");
	    }
	    
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//a[.='VIEW ALL'])[1]")).click();
	    
	    Thread.sleep(5000);
	    
	    List<WebElement> tvPrices = driver.findElements(By.xpath("//div[.='Televisions']/../..//div[@class='_5_K_qG']//div[@class='ZOGard']"));
	    for(WebElement price:tvPrices)
	    {
	    	Actions act = new Actions(driver);
	    	act.moveToElement(price).perform();
	    	System.out.println(price.getText());
	    }
	    
	}
}
