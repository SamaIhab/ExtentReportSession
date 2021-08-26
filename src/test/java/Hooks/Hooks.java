package Hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	WebDriver myDriver;
	
	@Before
	public void BeforeFeature() {
		//initialize the chrome driver
//		WebDriverManager.chromedriver().setup();
//		myDriver=new ChromeDriver();
//
//
//		//navigate to the required url & maximize the window
//		//myDriver.get("https://www.o2morny.com/");
//		myDriver.manage().window().maximize();
//		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@After (order=0)
	public void AfterFeature() {
		//myDriver.close();
	}
	
	@After (order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName= scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath=((TakesScreenshot)myDriver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
			
		}
		
	}

}
