package stepDefinationFiles;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AdminPage;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import utilities.ExcelReader;
  
public class WebSteps 

{
	WebDriver driver= Hooks.driver;
	LoginPage lp= new LoginPage(driver);
	DashboardPage dp= new DashboardPage(driver);
	AdminPage ap= new AdminPage(driver);
	String TestCaseName;
	
	@When("user enters valid creds using {string} data")
	public void user_enters_valid_creds_using_data(String RowName) throws IOException 
	{
		TestCaseName=RowName;
		String user= ExcelReader.readExcel("User_Data", TestCaseName, "Username");
		String pass= ExcelReader.readExcel("User_Data", TestCaseName, "Password");
		
		lp.login(user, pass);
	}
	
	@Then("user varifies the dashboard page is loaded")
	public void user_varifies_the_dashboard_page_is_loaded()
	{
		dp.varifyDashboardPage("Dashboard");
	}
	
	@Then("user varifies the error massage")
	public void user_varifies_the_error_massage() throws IOException  
	{
		String text= ExcelReader.readExcel("User_Data",TestCaseName,"Verify text");
		lp.varifyErrorMessage(text);    
	}
	
	@When("user navigates to AdminPage and requaired details")
	public void user_navigates_to_admin_page_and_requaired_details() 

	
	{
		//ap.enterUserDataInAdminTab("Admin");
	}
	
	@Then("user varifies the fileds on the dashboard page")
	public void user_varifies_the_fileds_on_the_dashboard_page() {
	    //System.out.println("Fields Verified");
	}


	
}





/* @Given("user launches the url {string}")
	public void user_launches_the_url(String url) 
	{
		//driver= new ChromeDriver();
	    //driver.manage().window().maximize();
	    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get(url);	
	}
  @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() 
{
	driver.findElement(By.name("username")).sendKeys("Admin");;
	driver.findElement(By.name("password")).sendKeys("admin123");;
	driver.findElement(By.tagName("button")).click();    	
}
*/