package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test
	public void verify_Login()
	{
		logger.info("**START loginValidData**");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		
		logger.info("click on My Account");
		hp.clickOnLogin();
		logger.info("click on Login");
		
		LoginPage lp = new LoginPage(driver);
		lp.enter_Email(pop.getProperty("email"));
		logger.info("enter username");
		lp.enter_Password(pop.getProperty("password"));
		logger.info("enter Password");
		lp.click_Login();
		logger.info("click on Login");
		
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean expResult = myAcc.isMyAccountDistplayed();
		logger.info("verify 'My Account' text Displayed");
		
		myAcc.click_Logout();
		logger.info("click on Logout from My Account Page");
		
		Assert.assertTrue(expResult);
		logger.info("**Finish loginValidData**");
		
	}
}
