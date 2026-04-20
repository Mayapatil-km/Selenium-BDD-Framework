package testRunners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features="E:\\javaMaya2\\BDD_Cucumber_Jan_26\\src\\test\\java\\featureFiles",
                  glue = "stepDefinationFiles",
                  tags= "@Admin",
                  plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
                  //,dryRun = true
                  //monochrome = true
                  
                )                 
public class TestRunner extends AbstractTestNGCucumberTests // its convert cucumber frameWork in testNg its main integration 
{                                                            // cucumber and testNg
	

}


