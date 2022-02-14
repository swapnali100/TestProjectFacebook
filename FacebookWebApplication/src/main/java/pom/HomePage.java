package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	
	
	
	@FindBy (xpath ="//a[@aria-label='Home']" )
	private WebElement home;
	
	@FindBy (xpath ="//a[contains(@aria-label,'Watch')]" )
	private WebElement watch;
	
	@FindBy (xpath ="//a[contains(@aria-label,'Marketplace')]" )
	private WebElement marketplace;
	
	@FindBy (xpath ="//a[contains(@aria-label,'Groups')]" )
	private WebElement groups;

	

	@FindBy (xpath ="(//div[@aria-label='Messenger'])[1]" )
	private WebElement messenger;


	@FindBy (xpath ="//a[@href='/notifications/']" )
	private WebElement notifications;

	@FindBy (xpath =" //div[@aria-label='Account']")
	private WebElement account ;

	
	
	@FindBy (xpath ="//span[text()='Log Out']" )
	private WebElement logout;
	
	
	
	public HomePage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);
	
	}
	public void clickHome()
	{
		home.click();
	}
	
	public void clickWatch() 
	{
		watch.click();
		
	}
	public void clickMarketplace()
	{
		marketplace.click();
	}
	public void clickGroups()
	{
		groups.click();
	}
	public void clickMessenger()
	{
		messenger.click();
	}
	public void clickNotifications()
	{
		notifications.click();
	}
	
	public void clickAccountButton()
	{
		account.click();
	}
	
	public void clickLogOutButton()
	{
		 
//		act.moveToElement(logout).click().build().perform();
		
		logout.click();
	}
	
	
	}