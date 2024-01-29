package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JACKETS {

	@FindBy(xpath="By.xpath(\"//img[@class='img-responsive']")
	private List<WebElement> allJackets;
	
	public JACKETS(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAllJackets() {
		return allJackets;
	}
	
	public void selectJackets(WebDriver driver) throws InterruptedException
	{
		List<WebElement> Jackets = getAllJackets();
		Actions act = new Actions(driver);
		int count = 0;
		for(WebElement jacket:Jackets)
		{
			act.moveToElement(jacket).perform();
			Thread.sleep(1000);
			count++;
		}
		System.out.println("Total Jackets count ---> "+count);
	}
}
