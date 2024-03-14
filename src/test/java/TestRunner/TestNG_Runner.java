package TestRunner;


import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"D:\\EAI\\workspace\\testcucum\\features\\test.feature"},
		glue= {"stepdefinition","Utilities"},//folder names what the feature files are dependent on
		plugin = {
				"pretty",
				"html:D:\\EAI\\workspace\\testcucum\\target\\htmlReports\\report.html",
				"json:D:\\EAI\\workspace\\testcucum\\target\\cucumberReports\\json"
		},
		monochrome = false,
		dryRun = false, 
		tags="(@sanity or @reg) and  not(@sanity and @reg)"	
		)




public class TestNG_Runner extends AbstractTestNGCucumberTests {

}
