package POM;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spiceJet {

	public static void main(String[] args) throws Exception {
		
	  WebDriverManager.firefoxdriver().setup();
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://www.spicejet.com/");
	  
	  FirefoxOptions p = new FirefoxOptions();
	  p.addArguments("--disable-notifications");
	  
	  Thread.sleep(6000);
	 
	  
	  
	  // Click on round trip
	  
	  driver.findElement(By.xpath("//div[.='round trip']")).click();
	  
	  // Enter data into From location
	  
	  WebElement fromLOC = driver.findElement(By.xpath("//div[text()='From']"));
	  fromLOC.sendKeys("Bengaluru");
	  
	  // Enter data into To location
	  
	  Thread.sleep(2000);
	  WebElement toLOC = driver.findElement(By.xpath("//div[text()='To']"));
	  toLOC.sendKeys("Delhi");
	  
	  
	  
		
	}
}
