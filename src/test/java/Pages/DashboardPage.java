package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.commons;

public class DashboardPage extends commons {

	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	By customerMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By customerbtn=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	public void click_on_customerMenu() throws InterruptedException
	{
		WaitForElemnetPresence(customerMenu);
		driver.findElement(customerMenu).click();
		Thread.sleep(1000);
	}
	
	public void click_on_customerbtn() throws InterruptedException
	{
		WaitForElemnetPresence(customerbtn);
		driver.findElement(customerbtn).click();
		Thread.sleep(1000);
	
	}
	
}
