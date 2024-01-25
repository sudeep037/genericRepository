import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public static void main(String[] args) throws Exception{
		
	   WebDriverManager.firefoxdriver().setup();
	   WebDriver driver = new FirefoxDriver();
	   Thread.sleep(3000);
	   driver.get("https://www.fb.com");
	   Thread.sleep(3000);
	   
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   
	   // Ways to send data into text field
	   
	   // Approach 1 -> JS Executor Interface
	   js.executeScript("document.getElementById('email').value='Hemanth'");
	   
	   // Approach 2 -> Keys Enum
	   
	   WebElement emailTxt = driver.findElement(By.xpath("//input[@id='email']"));
	   emailTxt.sendKeys(Keys.CONTROL+"a"); // copying data
	   Thread.sleep(2000);
	   emailTxt.sendKeys(Keys.CONTROL+"x"); // removing data
	   
	   Thread.sleep(3000);
	   WebElement pswdTxt = driver.findElement(By.xpath("//input[@type='password']"));
	   pswdTxt.sendKeys(Keys.CONTROL+"v");  // sending data
	   
	   // Approach 3 -> By getting attributes
	   
	   String expPlaceholder = emailTxt.getAttribute("placeholder");
	   String actualPlaceholder = "Email address or phone number";
	   
	   Thread.sleep(2000);
	   
	   if(expPlaceholder.equals(actualPlaceholder))
	   {
		   emailTxt.sendKeys(Keys.CONTROL+"x");
		   Thread.sleep(2000);
		   emailTxt.sendKeys(Keys.CONTROL+"v");
	   }
	   
	   
	    
	  
	   
	}
}
