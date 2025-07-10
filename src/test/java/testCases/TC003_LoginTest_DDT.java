package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviderDDT;

public class TC003_LoginTest_DDT extends BaseClass {
	
	@Test(dataProvider=("loginDt"),dataProviderClass = DataProviderDDT.class)
	public void verify_Login(String email, String pwd)
	{
		logger.info("**START loginValidData**");
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		
		logger.info("click on My Account");
		hp.clickOnLogin();
		logger.info("click on Login");
		
		LoginPage lp = new LoginPage(driver);
		lp.enter_Email(email);
		logger.info("enter email");
		lp.enter_Password(pwd);
		logger.info("enter Password");
		lp.click_Login();
		logger.info("click on Login");
		
		MyAccountPage myAcc = new MyAccountPage(driver);
		boolean expResult = false;
		try {
			expResult = myAcc.isMyAccountDistplayed();
			logger.info("verify 'My Account' text Displayed");
			
			myAcc.click_Logout();
			logger.info("click on Logout from My Account Page");
			
			Assert.assertTrue(expResult);
			
		} catch (Exception e) {
			
			logger.info("Login Fail");
			
		}
		
		
		
		
		
		logger.info("**Finish loginValidData**");
		
	}
	
}
