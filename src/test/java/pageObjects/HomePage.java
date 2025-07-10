package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")  private WebElement myAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") private WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']") private WebElement login;
	
	public void clickOnMyAccount()
	{
		myAccount.click();
	}
	public void clickOnRegister()
	{
		register.click();
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	
	
}
