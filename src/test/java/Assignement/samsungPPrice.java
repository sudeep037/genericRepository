package Assignement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class samsungPPrice {

	@Test
	public void test() throws InterruptedException, EncryptedDocumentException, IOException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("https://www.amazon.in");
	    Thread.sleep(2000);
	    
	    // Search iphone
	    
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone-13");
	    Thread.sleep(2000);
	    
	    // click on search button
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	    Thread.sleep(2000);
	    
	    // Fetch the iphone cost
	    
	    WebElement iphone = driver.findElement(By.xpath("//span[.='Results']/../../../../../..//div[@data-index='3']//span[@class='a-price']"));
	    Actions act = new Actions(driver);
	    act.moveToElement(iphone).perform();
	    String cost = iphone.getText();
	    
	    // write cost into excel sheet 
	    
	    FileInputStream fis = new FileInputStream("./src/main/resources/OragnizationExcelData.xlsx");
	    Workbook book = WorkbookFactory.create(fis);
	    Sheet sheet = book.getSheet("Sheet2");
	    sheet.createRow(0).createCell(0).setCellValue(cost);
	    FileOutputStream fos = new FileOutputStream("./src/main/resources/OragnizationExcelData.xlsx");
	    book.write(fos);
	    fos.close();
	    
	    System.out.println("The cost of iphone is ---> "+cost);
	    
	    driver.close();
	}
}
