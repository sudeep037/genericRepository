package xpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingProkabbadiDetails {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/athletes");
		
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		    
              Thread.sleep(2000);
		    
		    // Scroll down till medalist list
		    
		    for(int i =1 ; i<=10; i++)
		    {
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("window.scrollBy(0,70)");
		    	Thread.sleep(1000);
		    }
		    
		    Thread.sleep(2000);
		    
		    List<WebElement> details = driver.findElements(By.xpath("//h2[text()='Medalists']/..//ul[@class='styles__Wrapper-sc-534v5q-0 lgfbxw']//div[@class='Tablestyles__CommonGrid-sc-xjyvs9-1 Tablestyles__Header-sc-xjyvs9-2 fCVkkH fCTVkH']/div[2]|//h2[text()='Medalists']/..//ul[@class='styles__Wrapper-sc-534v5q-0 lgfbxw']//div[@class='Tablestyles__CommonGrid-sc-xjyvs9-1 Tablestyles__Header-sc-xjyvs9-2 fCVkkH fCTVkH']/div[4]"));
		    
		    for(WebElement detail : details)
		    {
		    	System.out.println(detail.getText());
		    }
	}
}
