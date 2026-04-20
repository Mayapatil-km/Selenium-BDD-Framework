package pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.WebUtils;

public class AdminPage 
{
	WebDriver driver;
	WebUtils utils=new WebUtils();

    public AdminPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='Admin']")
     WebElement Admin;
    
    @FindBy(xpath="//label[text()='Username']/../following-sibling::div/input")
    WebElement username;
    
    @FindBy(xpath="//h6[text()='Admin']")
    WebElement DropDownAdmin;
    
    @FindBy(xpath="//div[@role='listbox']//*[contains(text(),'Admin')]")////div[@role='listbox']//*[contains(text(),'Admin')]  //span[text()='Admin']
    WebElement AdminTital;
    
    @FindBy(xpath="//label[text()='User Role']/../following-sibling::div//div[contains(text(),'Select')]")
    WebElement UserRole;

    public void enterUserDataInAdminTab(String ExpectedText) 
    {
    	utils.varifyText(AdminTital, ExpectedText);
    	//Assert.assertEquals(AdminTital.getText(),ExpectedText);
        Admin.click();
        username.sendKeys("Shiv");
        UserRole.click();
        DropDownAdmin.click();
    }

}
