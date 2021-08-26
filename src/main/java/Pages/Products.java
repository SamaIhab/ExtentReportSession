package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExtentReportSession.ExtentReportSession.ExcelReader;



public class Products {
	By perfume, addToCartButton, discountBox, nextButton, closeCart, priceAfterDiscount, totalPrice;
	List<WebElement> allProducts, allDiscountedProducts, allDiscountBoxes;
	WebDriver driver;
	ExcelReader excel;


	public Products(WebDriver d) {
		driver=d;
		excel = new ExcelReader();
		excel.openFile();
		setLocators();

	}

	public void setLocators() {
		
		String locator= excel.readExcelCell(2, 1);
		perfume= By.cssSelector(locator);



		locator=excel.readExcelCell(3, 1);
		addToCartButton= By.cssSelector(locator);

		locator=excel.readExcelCell(4, 1);
		discountBox= By.cssSelector(locator);

		locator=excel.readExcelCell(6, 1);
		closeCart= By.cssSelector(locator);


		locator=excel.readExcelCell(5, 1);
		nextButton= By.cssSelector(locator);

		locator=excel.readExcelCell(7, 1);
		priceAfterDiscount= By.cssSelector(locator);
		
		locator=excel.readExcelCell(8, 1);
		totalPrice= By.cssSelector(locator);
		
		



	}

	public double addToCartTheDiscountedProducts() {
		//setLocators();

		allProducts= driver.findElements(perfume);
		double pageSum=0; double priceDouble=0;
		String priceString;
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
	
		
		for(WebElement product: allProducts) {
			try {

//				
				if(product.findElement(discountBox).getText().contains("%")) {
					Actions actions = new Actions(driver);
					actions.moveToElement(product).perform();
					
					//get the price
					WebElement priceWebElement= product.findElement(priceAfterDiscount);
					priceString= priceWebElement.getText();
					
					priceString=priceString.replaceAll("[^\\d.]","");
					//priceString=priceString.replace(" EGP","" );
					//priceString=priceString.substring(0, priceString.length() - 3);
					priceDouble=Double.parseDouble(priceString);
					//pageSum += priceDouble;

					//add to cart
					WebElement buttonn= product.findElement(addToCartButton);
					wait.until(ExpectedConditions.elementToBeClickable(buttonn));
					actions.moveToElement(buttonn).click().perform();

					pageSum += priceDouble;
					//close the  cart
					wait.until(ExpectedConditions.elementToBeClickable(closeCart));
					driver.findElement(closeCart).click();

					

				}


			} catch(Exception e) {

				//System.out.println("Element not found");
				//e.printStackTrace();

			}


		}
		return pageSum; 


	}

	public double getAllItems(int numberOfPages) throws InterruptedException {

		double totalSum=0;

		for(int i=0; i<numberOfPages;i++) {

			totalSum+=addToCartTheDiscountedProducts();
			//wait till the elements in next page are loaded

			clickNext();
			Thread.sleep(8000);
			//setLocators();
//			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			
		}

		return totalSum;
	}

	public void clickNext() {
		driver.findElement(nextButton).click();
	}
	
	public double getTotal() {
		
		//get the price
		
		String totalPriceElement=driver.findElement(totalPrice).getText();
		
		totalPriceElement=totalPriceElement.replaceAll("[^\\d.]","");
		return Double.parseDouble(totalPriceElement);
		
	}


}
