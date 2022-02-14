package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	
	@FindBy (xpath = "//input[@type='text']")
	private  WebElement userName;
	
	@FindBy (xpath = "//input[@type='password']")
	private  WebElement password;
	
	@FindBy (xpath = "//button[@value='1']")
	private  WebElement login;
	
public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		
	}
	
	public void sendUserName(String user)
	{
		userName.sendKeys(user);
	}
	public void sendPassword(String pass) 
	{
		password.sendKeys(pass);
	}
	public void clickLogin()
	{
		
		login.click();
	}	
		
	
	
	}
	

