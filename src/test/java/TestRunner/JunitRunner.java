package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"D:\\EAI\\workspace\\testcucum\\features"},
glue= {"stepdefinition","utilities"},
plugin = {
		"pretty",
		"html:D:\\EAI\\workspace\\testcucum\\target\\htmlReports\\report.html",
		"json:D:\\EAI\\workspace\\testcucum\\target\\cucumberReports\\json"
},
monochrome = false,
dryRun = false, tags="@sanity"	
)
public class JunitRunner {

}
