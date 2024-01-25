package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class proKabbadi {

	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/stats/44-96-team-total-points-statistics");
		
		Thread.sleep(5000);
		
		// Fetching Team names along with details
		
	    java.util.List<WebElement> teamDetails = driver.findElements(By.xpath("//span[text()='Team']/ancestor::div[@class='waf-body']//div[@class='table stats-table']"));
		for(WebElement teamDetail : teamDetails)
		{
			System.out.println("---------------------------");
			System.out.println(teamDetail.getText());
		}
            driver.quit();
	}
}
