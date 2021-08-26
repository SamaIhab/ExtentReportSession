package TestRunner;

import org.junit.runner.RunWith;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/featuresFiles/AddPerfumes.feature"},
		glue={"StepDefinition", "Hooks"},
		plugin= {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		publish=true
		)


public class TestRunner {
	


	

}
//import java.util.concurrent.TimeUnit;
//plugin= {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
//publish = true
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import Pages.LandingPage;
//import Pages.Products;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Runner {
//	
//	LandingPage landingPage;
//	Products products;
//	
//	
//	WebDriver myDriver;
//	JavascriptExecutor js;
//
//	@BeforeSuite
//	public void BeforeSuite() {
//		//initialize the chrome driver
//		WebDriverManager.chromedriver().setup();
//		myDriver=new ChromeDriver();
//
//
//		//navigate to the required url & maximize the window
//		myDriver.get("https://www.o2morny.com/");
//		myDriver.manage().window().maximize();
//		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//	}
//	
//	@AfterSuite
//	public void AfterSuite() {
//		//myDriver.close();
//	}
//	
//	@Test
//	public void test1() throws InterruptedException {
//		landingPage= new LandingPage(myDriver);
//		landingPage.clickOnWomenFragrances();
//		products= new Products(myDriver);
//		products.setLocators();
//		double expectedSum= products.getAllItems(5);
//		System.out.println(expectedSum);
//		
//		
//		
//	}
//	
//
//}
