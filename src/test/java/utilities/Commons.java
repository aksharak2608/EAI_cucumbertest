package utilities;

import java.io.File;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Commons {
	public static Logger log= (Logger) LogManager.getLogger(Commons.class);
	public static WebDriver driver;
	public static String fp=System.getProperty("user.dir");
		public ExtentSparkReporter spark = new ExtentSparkReporter(fp+"\\reports\\spark"+System.currentTimeMillis()+".html");
		 public  ExtentReports extent = new ExtentReports();
		 public ExtentTest test;
	
public void cofigreport()
{
	extent.attachReporter(spark);
	extent.setSystemInfo("Machine","testpc1");
	extent.setSystemInfo("OS", "windows");
	extent.setSystemInfo("browser", "chrome");
	extent.setSystemInfo("user", "Akshara");
	spark.config().setDocumentTitle("final report");
	spark.config().setReportName("amazone report"+System.currentTimeMillis());
	spark.config().setTheme(Theme.DARK);
} public static WebDriver Ibrowser(String NameOfBrowser, String url) {
		if(NameOfBrowser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(NameOfBrowser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
		}
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			driver.get(url);
			return driver;
	
	}
	


public static void WaitForElemnetPresence(By by)
{
	 WebDriverWait wl= new WebDriverWait(driver,Duration.ofMillis(10000));
		wl.until(ExpectedConditions.presenceOfElementLocated(by));
		log.info("Able to find the presence of elemnt");
		
}


public static void WaitForElemnetVisibility(WebElement ele)
{
	 WebDriverWait wl= new WebDriverWait(driver,Duration.ofMillis(0));
		wl.until(ExpectedConditions.visibilityOf(ele));
		log.info("Able to find the visibility of elemnt");
}
public static void scrollToPageDown(WebDriver driver)
{
	JavascriptExecutor je= (JavascriptExecutor)driver;
	je.executeScript("window.scrollTo(1,document.body.scrollHeight)");
	log.info("Able to scrollto end of the page");
}

public static void blinkelement(WebDriver driver, WebElement ele)
{
	JavascriptExecutor je=(JavascriptExecutor)driver;
	
	for(int i=0;i<50;i++)
	{
		je.executeScript("arguments[0].style.backgroundColor='rgb(255,0,0)'", ele);
		je.executeScript("arguments[0].style.backgroundColor='rgb(0,255,0)'", ele);
		
	}
	log.info("Able to blink elemnt");
}
	public static void borderElement(WebDriver driver, WebElement ele)
	{

JavascriptExecutor je=(JavascriptExecutor)driver;
	
	je.executeScript("arguments[0].style.border='3px solid red'", ele);
	log.info("Able to add boder for the elemnt");
	}


public static void displayalert(WebDriver driver) throws InterruptedException
{

	
	JavascriptExecutor je= (JavascriptExecutor)driver;
	je.executeScript("alert('Test completed')");
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	log.info("Able to display an alert");
	
}

public static void entercapcha(WebDriver driver)
{
	By ele=By.xpath("//a[@id='nav-logo-sprites' or @id='nav-bb-logo']");
	WebDriverWait w= new WebDriverWait(driver, Duration.ofMinutes(2));
	w.until(ExpectedConditions.visibilityOfElementLocated(ele));
}
  
	public String capturescreenshot(String folder)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destpath=new File(fp+"\\screenshots\\"+folder+"screenshot_"+System.currentTimeMillis()+".jpg");
		try {
			FileHandler.copy(src, destpath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String path=destpath.getAbsolutePath();
		
		
		
		return path;
		
	}
	public void verifypageTitle(String expectedtitle)
	{
		String actitle=driver.getTitle();
		Assert.assertEquals(actitle, expectedtitle);
	}
	public void tearDown()
	{
	driver.close();
	log.info("browser closed");
	}
	}

	
	
