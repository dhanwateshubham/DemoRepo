package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver)
	{
		super(driver); 
	}
	
	@FindBy(xpath="//input[@id='input-email']") private WebElement eMailAddress;
	@FindBy(xpath="//input[@id='input-password']") private WebElement password;
	@FindBy(xpath="//input[@value='Login']") private WebElement login;
	
	public void enter_Email(String email)
	{
		eMailAddress.sendKeys(email);
	}
	public void enter_Password(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void click_Login()
	{
		login.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
