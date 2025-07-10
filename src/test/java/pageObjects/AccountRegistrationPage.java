package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{	
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")  private WebElement firstName;
	@FindBy(xpath="//input[@id='input-lastname']")  private WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']")  private WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']")  private WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']")  private WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']")  private WebElement passwordConfirm;
	@FindBy(xpath="//input[@name='agree']")  private WebElement agreeCheckbox;
	@FindBy(xpath="//input[@value='Continue']")  private WebElement continueButton1;
	@FindBy(xpath="//div[@id='content']/h1")  private WebElement confirmationMsg;
	@FindBy(xpath="//a[normalize-space()='Continue']") private WebElement continueButton2;

	public void enter_FirstName(String Firstname)
	{
		firstName.sendKeys(Firstname);
	}
	public void enter_LastName(String Lastname)
	{
		lastName.sendKeys(Lastname);
	}
	public void enter_Email(String Email)
	{
		email.sendKeys(Email);
	}
	public void enter_Telephone(String Telephone)
	{
		telephone.sendKeys(Telephone);
	}
	public void enter_Password(String Password)
	{
		password.sendKeys(Password);
	}
	public void enter_PasswordConfirm(String Password)
	{
		passwordConfirm.sendKeys(Password);
	}
	
	public void click_AgreeCheckBox()
	{
		agreeCheckbox.click();
	}
	public void click_ContinueButton_1()
	{
		continueButton1.click();
	}
	
	public String get_AccountCreationConfirmationMsg()
	{
		String value;
		try {
			value = confirmationMsg.getText();
		}
		catch(Exception e)
		{
			value="";
		}
		return value;
	}
	
	public void click_ContinueButton_2()
	{
		continueButton2.click();
	}
	

	
	
	
}
