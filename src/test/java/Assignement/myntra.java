package Assignement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import POM.JACKETS;
import io.github.bonigarcia.wdm.WebDriverManager;

public class myntra {

	@Test
	public void test1() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("https://www.myntra.com");
	    Thread.sleep(2000);
		
		// mouse hover on home and living
	   
	    WebElement homeAndLiving = driver.findElement(By.xpath("//a[.='Home & Living']"));
		Actions act = new Actions(driver);
	    act.moveToElement(homeAndLiving).perform();
		
		Thread.sleep(3000);
		
		// mouse hover on home and decor
		List<WebElement> homeDecorsOptions = driver.findElements(By.xpath("//a[.='Home Décor']/../../..//li"));
		for(WebElement options:homeDecorsOptions)
		{
			String unwanted = "Cushions & Cushion Covers";
			act.moveToElement(options).perform();
			System.out.println(options.getText());
		}
		
		Thread.sleep(2000);
		
		WebElement mens = driver.findElement(By.xpath("//header//a[.='Men']"));
		act.moveToElement(mens).perform();
		
		Thread.sleep(2000);
		
		List<WebElement> jacketSelect = driver.findElements(By.xpath("//a[.='Topwear']/../../..//li"));
		for(WebElement jacket:jacketSelect)
		{
			String expJacket = "Jackets";
			Thread.sleep(1000);
			act.moveToElement(jacket).perform();
			if(expJacket.contains(jacket.getText()))
			{
				jacket.click();
			}
		}
		
		// Get the count of mens jacket
		
		//act.moveToElement(driver.findElement(By.xpath("//span[.='Recommended']"))).perform();
		//driver.findElement(By.xpath("")).click();
		
		Thread.sleep(10000);
		
		// Get the jackets count displayed
		
		JACKETS j = new JACKETS(driver);
		j.selectJackets(driver);
		
		driver.close();
	}
}
