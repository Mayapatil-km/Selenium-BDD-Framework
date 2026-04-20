package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.WebUtils;
public class LoginPage 
{
	WebDriver driver;
	WebUtils utils=new WebUtils();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(tagName="button")
	WebElement Loginbtn;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	WebElement errorMassage;
	
	public void login(String user, String pass)
	{
		utils.enterText(username, user);
		utils.enterText(password, pass);
		utils.ClickElement(Loginbtn);
	//	username.sendKeys(user);
	//	password.sendKeys(pass);
	//	Loginbtn.click();
	}
	public void varifyErrorMessage(String ExpectedErrorMessage) 
	{
		utils.varifyText(errorMassage, ExpectedErrorMessage);
		//Assert.assertEquals(errorMassage.getText(),ExpectedErrorMessage);
	}	

}
