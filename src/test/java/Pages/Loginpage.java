package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.commons;

public class Loginpage extends commons {

	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='email']")WebElement emailfield;

	@FindBy(id="Password")WebElement passwordfield;

	@FindBy(xpath="//button[text()='Log in']")WebElement login;
	
	public void enteremail(String email) throws InterruptedException
	{
		WaitForElemnetVisibility(emailfield);
		emailfield.click();
		emailfield.clear();
		emailfield.sendKeys(email);
		Thread.sleep(3000);
	}
	public void enterpassword(String pass) throws InterruptedException
	{
		WaitForElemnetVisibility(passwordfield);
		passwordfield.click();
		passwordfield.clear();
		passwordfield.sendKeys(pass);
		Thread.sleep(3000);
	}
	
	public void submit()
	{
		login.click();
	}
}
