package POM;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLines {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		Thread.sleep(3000);
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		int statusCode = 0;
		for(WebElement links:allLinks)
		{
			String link = links.getAttribute("href");
			try {
				URL url = new URL(link);
				HttpsURLConnection httpConn = (HttpsURLConnection) url.openConnection();
				statusCode = httpConn.getResponseCode();
				
                if(statusCode>=400 && link!=null)
                {
                	System.err.println(link+"-->"+statusCode);
                }
			}
			catch(Exception e) {
				System.out.println(link+"-->"+statusCode);
			}
		}
		
		
	}
}
