import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.fge.jsonschema.main.cli.Main;

import io.github.bonigarcia.wdm.WebDriverManager;

public class authenticationPOPUP {

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	}
}
