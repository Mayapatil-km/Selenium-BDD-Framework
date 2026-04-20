package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinationFiles.Hooks;

public class WebUtils extends Hooks  //reusable utility class , its extends hooks class because its access the driver
{
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public void ClickElement(WebElement element) //generic click method use for all element
	{
		element.click();
	}
	
	public void enterText(WebElement element, String text) //use for put the value in text filed
	{
		element.sendKeys(text);
	}
	
	public void varifyText(WebElement element,String ExpectedText) //actual vs expected text compare
	{
		Assert.assertEquals(element.getText(), ExpectedText, "Expected Text Is -"+ExpectedText+ "but found" + element.getText());
	}
	
	public void IsElementDisplay(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element)); //wait for element is visible
	}
	
	public void IsElementClickable(WebElement element, String text)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element)); //wait for element is clickable
	}
	
	public void SelectByText(WebElement element, String text)
	{
		Select select= new Select(element); //is use for select dropDown is use only for <select> tag
		select.selectByVisibleText(text);
	}
	
	public void scrollToTheElement(WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;  //is use for scroll the page and show the element
		js.executeScript("argument[0].scrollIntoView(true);", element);
	}


}
