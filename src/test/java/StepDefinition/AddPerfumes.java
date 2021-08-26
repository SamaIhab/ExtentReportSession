package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Pages.LandingPage;
import Pages.Products;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddPerfumes {
	
	
	LandingPage landingPage;
	Products products;
	double expectedSum;
	
	
	WebDriver myDriver;
	JavascriptExecutor js;
	
	
	@Given("User is on omorny website")
	public void user_is_on_omorny_website() {
		//initialize the chrome driver
		WebDriverManager.chromedriver().setup();
		myDriver=new ChromeDriver();


		//navigate to the required url & maximize the window
		myDriver.get("https://www.o2morny.com/");
		myDriver.manage().window().maximize();
		myDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("user will choose women fragrances from fragrances menu")
	public void user_will_choose_women_fragrances_from_fragrances_menu() {
		landingPage= new LandingPage(myDriver);
		landingPage.clickOnWomenFragrances();
	}

	@When("user add all perfumes with percentage discounts in first five pages")
	public void user_add_all_perfumes_with_percentage_discounts_in_first_five_pages() throws InterruptedException {
		products= new Products(myDriver);
		products.setLocators();
		expectedSum= products.getAllItems(5);
		
	}

	@Then("make sure that the total cost")
	public void make_sure_that_the_total_cost() {
		
		Assert.assertEquals(products.getTotal(), expectedSum);
		
		
		

	}


	

}
