package Listeners;

import javax.swing.text.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utilities.commons;

public class TestListeners extends commons implements ITestListener {

	
	@Override
	public void onStart(ITestContext context) {
		log.info("**************************  Configuring extent Report ************************"); 
		System.out.println("**************************  On Start ************************");
		cofigreport();		
		System.out.println("On-Start Listner");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("**************************  Finishing Report ************************"); 
		System.out.println("**************************  On Finish ************************");
		extent.flush();
		System.out.println("On Finish Listner");
	}
	
	@Override
	public void onTestStart(ITestResult result) {
//		test=reports.createTest(result.getName());
//		test.info("starting test method: "+ result.getName());
		
		
		System.out.println("on Test Start: "+ result.getName());
		
		
	  
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		this.driver= ((commons)result.getInstance()).driver;

		test=extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the method that passed is: "+result.getName(), ExtentColor.GREEN));
		
		test.addScreenCaptureFromPath(capturescreenshot("er_ss"));
		
		System.out.println("Success listner:"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the method that failed is: "+result.getName(), ExtentColor.RED));
		
		System.out.println("Failure Listener:"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the method that Skipped is: "+result.getName(), ExtentColor.ORANGE));
		
		
		System.out.println("Skipped listener:"+result.getName());
		
		
	}


	

}
