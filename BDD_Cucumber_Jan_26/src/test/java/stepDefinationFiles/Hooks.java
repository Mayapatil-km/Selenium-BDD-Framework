package stepDefinationFiles;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import utilities.PropertiesReader;

public class Hooks 
{
	public static WebDriver driver;
	//String url= PropertiesReader.readPropertyData("url");
	//String browser = PropertiesReader.readPropertyData("browser");

	@Before
	public void setup()
	{
		System.out.println("---------------------------------------------------------");
		System.out.println("I will execute before each scenario");
		
		String url= PropertiesReader.readPropertyData("url");
		String browser = PropertiesReader.readPropertyData("browser");
		System.out.println(browser);
		System.out.println(url);
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
	}

	@After
	public void tearDown()
	{
		System.out.println("I will execute before each scenario");
		System.out.println("---------------------------------------------------------");
		//if(driver!=null)
		//{
		//	driver.quit();
		//}
	}

	@BeforeStep
	public void beforeStep()
	{
		System.out.println("---------------------------------------------------------");
		System.out.println("I will execute before each step");
	}
	@AfterStep
	public void afterStep(Scenario scenario)
	{
	  if(scenario.isFailed()) {
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
		    e.printStackTrace();
		}
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(screenshot, "image/png", "Screenshot after step");
		
		System.out.println("I will execute after each ste");
		System.out.println("---------------------------------------------------------");
		
	  }
	}


}

