package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.WebUtils;

public class DashboardPage 
{
		WebDriver driver;
		WebUtils utils=new WebUtils();
		
		public DashboardPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//h6[text()='Dashboard']")
		WebElement DashboardText;

		public void varifyDashboardPage(String ExpectedText)
		{
			utils.varifyText(DashboardText, ExpectedText);
			//Assert.assertEquals(DashboardText.getText(),ExpectedText);
		}

}
