import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart1 {

	
	
	public static void main(String[] args) throws Exception{
		
		WebDriverManager.firefoxdriver().setup();
	    WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com");
		
		driver.findElement(By.xpath("//img[@alt='I like it']")).click();
		
	    WebElement electronics = driver.findElement(By.xpath("//img[@alt='Electronics']"));
	    Actions act = new Actions(driver);
	    act.moveToElement(electronics).click().perform();
	    
	    Thread.sleep(5000);
	    
	    List<WebElement> dropDown1 = driver.findElements(By.xpath("(//object)[1]"));
	    
	    for(WebElement option : dropDown1)
	    {
	    	System.out.println(option);
	    }
	    
	    driver.close();
	    
	}
	
}
