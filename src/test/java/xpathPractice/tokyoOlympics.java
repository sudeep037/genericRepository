package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tokyoOlympics {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020");
		
		driver.findElement(By.xpath("//button[text()='Yes, I am happy']")).click();
		
		String actualAthleteButton = "All Athletes";
		WebElement expAthleteButton = driver.findElement(By.xpath("//a[text()='All Athletes']"));
		
		    for(; ;)
		    {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0,50)");
		        Thread.sleep(2000);
		        
		        if(actualAthleteButton.equals(expAthleteButton.getText()))
		        {
		        	System.out.println("Your expected and actual athelete button is matched");
		        	expAthleteButton.click();  //click on athelete button
		        	break;
		        }	    	
		    }
		    
		    Thread.sleep(2000);
		    
		    // Scroll down till medalist list
		    
		    for(int i =1 ; i<=10; i++)
		    {
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("window.scrollBy(0,70)");
		    	Thread.sleep(1000);
		    }
		    
		    // Fetch the name of the gold medalist
		    
		    WebElement atheleteMedal = driver.findElement(By.xpath("//h3[text()='emma mckeon']/ancestor::li[@class='styles__AthleteRow-sc-1e0xx7r-0 styles__AthleteRowGrid-sc-534v5q-2 WHUp ftzWoO']//span[@class='Medalstyles__Medal-sc-1tu6huk-1 gHnuPI']"));
		    System.out.println("Your located medal is correct and no of medals is -> "+atheleteMedal.getText());	
		    
		    driver.quit();
	}
}
