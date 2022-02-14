package package1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.HomePage;
import pom.LoginPage;
import utils.Utility;

public class ToVerifyLoginPage extends Browser
{
	private WebDriver driver;
	private  LoginPage loginPage;
	private  HomePage homepage;
	private int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser") 
	
	public void launchBrowser(String browser) 
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browser.equalsIgnoreCase("chrome"))	
		{
		driver = launchChromeBrowser();
		}
		if(browser.equalsIgnoreCase("firefox"))	
		{
		driver = launchFirefoxBrowser();	
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS );  
		
	}
		
	

	@BeforeClass
	public void createPomObjects()
	{
		loginPage = new LoginPage(driver);
		 homepage = new HomePage(driver);
	}
	
	@BeforeMethod
	public void openLoginPage()
	{
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void verifyLoginButton() throws EncryptedDocumentException, IOException
	{   testID =101;
		String username =Utility.getDataFromExcelSheet("Sheet1", 1, 0);
		loginPage.sendUserName(username);
		String password = Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		loginPage.sendPassword(password);
		loginPage.clickLogin();
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException
	{
		 if(ITestResult.FAILURE==result.getStatus()) 
		 {
			 
			Utility.getScreenShot(driver, testID);
		 }
		 homepage.clickAccountButton();
		 homepage.clickLogOutButton();
		
	}
	
	@AfterClass
	public void clearPomObjects()
	{
		loginPage = null;
		homepage = null;
		
	}
	@AfterTest
	public void afterClass()
	{
		driver.quit();
		driver = null;
		System.gc();
	}
	
	
	
}
