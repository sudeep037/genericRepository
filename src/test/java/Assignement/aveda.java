package Assignement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aveda {

	@Test
	public void test() throws InterruptedException
	{
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
    driver.get("https://www.aveda.de");
    Thread.sleep(4000);
    
    driver.findElement(By.xpath("//button[.='Akzeptieren']")).click();
    
    // Scroll down to select english language
    JavascriptExecutor js = (JavascriptExecutor)driver;
    
    for(;;)
    {
        js.executeScript("window.scrollBy(0,30)");
        WebElement langDrop = driver.findElement(By.xpath("//a[.='AVEDA ARTISTS']/ancestor::footer//div[@class='site-footer__country']"));
        langDrop.click();
	}
}
}
