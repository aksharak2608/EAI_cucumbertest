package stepdefinition;

import org.testng.Assert;

import Pages.CustomersPage;
import Pages.DashboardPage;
import Pages.Loginpage;
import Pages.DashboardPage;
import Pages.pages;
import io.cucumber.java.en.*;
import utilities.Commons;
import utilities.Hooks;

public class stepdef extends pages{
	

@Given("user launch {string} browser with {string}")
public void user_launch_browser_with(String browser, String url) {
	Ibrowser(browser, url);
    
}
@Then("user navigates to {string}")
public void user_navigates_to(String pagetitle) {
	log.info("-------------------verifying the page title--------------------");
	verifypageTitle(pagetitle);
   
}
@Then("user enters email as {string} and password as {string}")
public void user_enters_email_as_and_password_as(String username, String passcode) throws InterruptedException {
	loginPage= new Loginpage(driver);
	log.info("-------------------Enter username--------------------");
	loginPage.enteremail(username);
	
	log.info("-------------------Enter passcode--------------------");
	loginPage.enterpassword(passcode);
	
   
}
@Then("CLick on login")
public void c_lick_on_login() throws InterruptedException {
	
	log.info("-------------------click login--------------------");
	loginPage.submit();
	Thread.sleep(2000);
	
}
@Then("user lands on {string} page")
public void user_lands_on_page(String dashboard) {
	
	log.info("-------------------verifying the page title--------------------");
	verifypageTitle(dashboard);
}

@Then("user clicks on {string} menu")
public void user_clicks_on_menu(String string) throws InterruptedException {
	log.info("-------------------user clicks on menu--------------------");
	dashboardPage= new DashboardPage(driver);
	dashboardPage.click_on_customerMenu();
}
	
  
@When("user clicks on customer Button")
public void click_on_customerMenu() throws InterruptedException  {
	
	log.info("-------------------user click on page--------------------");
	dashboardPage.click_on_customerbtn();
}
	

@Then("CLick on {string} field")
public void c_lick_on_field(String string) {
	
}
@Then("insert {string} as email")
public void insert_as_email(String email) throws InterruptedException {

	log.info("-------------------insert email------------------");
	customersPage= new CustomersPage(driver);
	customersPage.insert_searchEmail(email);
//	System.out.println(email);
	Thread.sleep(2000);
	
}
@Then("Click on search button")
public void click_on_search_button() throws InterruptedException {
	log.info("-------------------search button clicked------------------");
	customersPage.searchbutton();
	Thread.sleep(2000);
}
@Then("Email should be visible as {string}")
public void email_should_be_visible(String email) {
	log.info("-------------------Verify email------------------");
   Assert.assertTrue(customersPage.searchcustbyemail(email), "email is present");
}

}


