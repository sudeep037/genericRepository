package xpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1_ICC {

public static void main(String[] args) throws Exception {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/test");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		
		Thread.sleep(3000);
		
		//List<WebElement> allRecords = driver.findElements(By.xpath(" //div[@class='si-table']//div[@class='si-table-body']"));
		
		List<WebElement> allRecords = driver.findElements(By.xpath("//div[@class='si-table-row' ]//div[@class='si-table-data si-team']|//div[@class='si-table-row' ]//div[@class='si-table-data si-matches']|//div[@class='si-table-row' ]//div[@class='si-table-data si-rating']"));
		for(WebElement records : allRecords)
		{
			System.out.println(" | "+records.getText()+" | ");
		}
		
		System.out.println();
		
		driver.quit();
	}
}
