package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") private WebElement myAccountLeft;
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") private WebElement logout;
	
	
	public boolean isMyAccountDistplayed()
	{
		return myAccountLeft.isDisplayed();
	}
	public String getMyAccountText()
	{
		return myAccountLeft.getText();
	}
	public void click_Logout()
	{
		logout.click();
	}
	
	
	
	
	
}
