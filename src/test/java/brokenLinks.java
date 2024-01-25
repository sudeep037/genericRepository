import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		
		// locating links
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(WebElement att :allLinks)
		{
			String link = att.getAttribute("href");
			try {
				URL url = new URL(link);
				HttpURLConnection connection=(HttpURLConnection)url.openConnection();
				  int resonceCode=connection.getResponseCode();
				  if(resonceCode>400) {
					  System.out.println(link+" : "+resonceCode);
				  }
			} catch (Exception e1) {
//				e1.printStackTrace();
				continue;
				
			}
		}
		
		driver.quit();
	}
}
