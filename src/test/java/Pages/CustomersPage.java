package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.Commons;

public class CustomersPage extends Commons {

	
	public CustomersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(how= How.ID, using="SearchEmail")WebElement emailsearch;

	@FindBy(how= How.ID, using="search-customers")WebElement searchBin;
	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']") WebElement table;

	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']/tbody/tr") List<WebElement> tableRow;

	@FindBy(how=How.XPATH, using="//table[@id='customers-grid']/tbody/tr/td") List<WebElement> tableColumns;
	
	public void insert_searchEmail(String search_email)
	{

		emailsearch.click();
		emailsearch.clear();
		emailsearch.sendKeys(search_email);
		
	}
	
	public void searchbutton()
	{
		searchBin.click();
	}
	
	public int getNoRows()
	{
		return(tableRow.size());
		
	}

	public int getNoColumns()
	{
		return(tableColumns.size());
		
	}
	
	public boolean searchcustbyemail(String searchemail)
	{
		System.out.println("--------------started search by email-----------------");
		System.out.println("given email is "+searchemail);
		boolean flag= false;
		System.out.println("--------------row count-----------------"+getNoRows());
		for(int i=1;i<=getNoRows();i++)
		{
			String ActualEmail=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println("found email is "+ActualEmail);
			
			if(ActualEmail.equals(searchemail)) {
			flag=true;
			System.out.println("--------------Element found-----------------");
		}}
		
		
		
		return flag;
		
	}
}
