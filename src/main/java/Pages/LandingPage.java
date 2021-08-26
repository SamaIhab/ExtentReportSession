package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExtentReportSession.ExtentReportSession.ExcelReader;




public class LandingPage {
	By fragrances, womenFragrances;
	WebDriver driver;
	ExcelReader excel;


	public LandingPage(WebDriver d) {
		driver=d;
		excel = new ExcelReader();
		excel.openFile();
		setLocators();

	}

	public void setLocators() {
		String locator= excel.readExcelCell(0, 1);
		fragrances=By.xpath(locator);

		locator=excel.readExcelCell(1, 1);
		womenFragrances= By.xpath(locator);


	}


	public void hoverOnFragrances() {
		Actions actions = new Actions(driver);
		WebElement fragrancesMenu=driver.findElement(fragrances);
		actions.moveToElement(fragrancesMenu).perform();
	}
	
	public void clickOnWomenFragrances() {
		hoverOnFragrances();
		driver.findElement(womenFragrances).click();
		//WebDriverWait wait = new WebDriverWait(driver,3);
		//wait.until(ExpectedConditions.presenceOfElementLocated(addToCompare1));//(addToCompare1));//(addToCompare1));
		//driver.findElement(addToCompare1).click();
	}
	

	


}

