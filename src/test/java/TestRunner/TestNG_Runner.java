package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"D:\\EAI\\workspace\\testcucum\\features\\amazone.feature"},
glue= {"stepdefinition","Utilities"},
plugin = {
		"pretty",
		"html:D:\\EAI\\workspace\\testcucum\\target\\htmlReports\\report.html",
		"json:D:\\EAI\\workspace\\testcucum\\target\\cucumberReports\\json"
},
		
		monochrome = true,
		dryRun = false,
		tags="(@sanity or @reg )"
	)



public class TestNG_Runner extends AbstractTestNGCucumberTests {

}
