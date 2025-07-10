package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void TC001_EnterMandatoryField()
	{
		logger.info("**START TC001_AccountRegistrationTest**");
		HomePage hm = new HomePage(driver);
		hm.clickOnMyAccount();
		hm.clickOnRegister();
		
		AccountRegistrationPage accReg = new AccountRegistrationPage(driver);
		accReg.enter_FirstName(randomName());
		accReg.enter_LastName(randomName());
		
		String email = randomEmail();
		accReg.enter_Email(email);
		accReg.enter_Telephone(randomCellPhone());
		
		String pwd = randomPassword();		
		accReg.enter_Password(pwd);
		accReg.enter_PasswordConfirm(pwd);
		accReg.click_AgreeCheckBox();
		accReg.click_ContinueButton_1();
		
//		System.out.println(email+"\t"+pwd);
		
		Assert.assertEquals("Your Account Has Been Created!", accReg.get_AccountCreationConfirmationMsg());
		
		accReg.click_ContinueButton_2();
		logger.info("**FINISH TC001_AccountRegistrationTest**");
		
		
	}
}
