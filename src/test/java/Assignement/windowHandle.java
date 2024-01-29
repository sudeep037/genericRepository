package Assignement;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandle {

	public class Assignment_1 {
		@Test
		public void Window() 
		{
			WebDriverManager.firefoxdriver().setup();
			WebDriver Driver=new FirefoxDriver();
		String id=null;
		for(int i=1;i<11;i++) 
		{
			
			 Driver.switchTo().newWindow(org.openqa.selenium.WindowType.WINDOW);
	 ;
			if(i==7) 
	       {
	    	 id= Driver.getWindowHandle();
	    	
	    	 Driver.get("https://www.google.com"); 
	       }
		}
		Set<String> windsID = Driver.getWindowHandles();
		for(String s:windsID) 
		{
				
			if(s.equals(id)) 
			{
				Driver.switchTo().window(s);
				 Driver.quit();
				 System.out.println(" 7th window is closed");
			}	
			
		} 
		 
		Driver.quit();
		
		}	
	}

}
