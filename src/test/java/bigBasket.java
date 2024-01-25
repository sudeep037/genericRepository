import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bigBasket {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com");
		Actions act = new Actions(driver);
		
		// click on drop
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']")).click();
		
		// Mouse hover on suggestions
		List<WebElement> sugges1 = driver.findElements(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']/following-sibling::div[@id='headlessui-menu-items-:R9bab6:']//ul[1]//li"));
		for(WebElement option1:sugges1)
		{
			act.moveToElement(option1).perform();
			System.out.println(option1.getText());
			Thread.sleep(1000);
			List<WebElement> sugges2 = driver.findElements(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']/following-sibling::div[@id='headlessui-menu-items-:R9bab6:']//ul[2]//li"));
			for(WebElement option2:sugges2)
			{
				act.moveToElement(option2).perform();
				Thread.sleep(1000);
				List<WebElement> sugges3 = driver.findElements(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']/following-sibling::div[@id='headlessui-menu-items-:R9bab6:']//ul[3]//li"));
				
				for(WebElement option3:sugges3)
				{
					act.moveToElement(option3).perform();
					Thread.sleep(1000);
					System.out.println(option3.getText());
					Thread.sleep(1000);
				}
				System.out.println(option2.getText());
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
		}
		
	}
}
