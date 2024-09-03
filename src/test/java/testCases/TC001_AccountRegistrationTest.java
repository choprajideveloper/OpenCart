package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups="Regression")
	public void verify_account_registration() {

		logger.info("******* Starting TC001_AccountRegistrationTest ************** ");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on MyAccount link");

			hp.clickRegister();
			logger.info("clicked on Register Link");

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			logger.info("Providing Customer Details");
			regpage.setFirstName(randomeString().toUpperCase());
			logger.info("First Name Done");
			regpage.setLastName(randomeString().toUpperCase());
			logger.info("Last Name done");
			regpage.setEmail(randomeString() + "@gmail.com");
			logger.info("Email done");
			regpage.setTelephone(randomeNumber());
			logger.info("Telephone done");

			String password = randomAlphaNumeric();

			regpage.setPassword(password);
			logger.info("clicked on Register Link");
			regpage.setConfirmPassword(password);
			logger.info("clicked on Register Link");

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Verifying Title");
			/*
			 * String confmsg = regpage.getConfirmationMsg();
			 * Assert.assertEquals(confmsg,"Your Account Has Been Created!");
			 */
		} catch (Exception e) {

			logger.error("Test Failed");
			logger.debug("Debug logs...");
			Assert.fail();
		}
	}
}