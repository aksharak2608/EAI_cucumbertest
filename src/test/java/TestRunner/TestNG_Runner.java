package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"D:\\EAI\\workspace\\testcucum\\features"},
glue= {"stepdefinition","utilities"},
/*plugin = {
		"pretty",
		"html:D:\\EAI\\workspace\\cucumberFramework\\target\\htmlReports\\report.html",
		"json:D:\\EAI\\workspace\\cucumberFramework\\target\\cucumberReports\\json"
},*/
dryRun = false,
monochrome = true,
tags="(@nop or @sanity) and not ( @nop and @sanity)"
)

public class TestNG_Runner extends AbstractTestNGCucumberTests{

}
