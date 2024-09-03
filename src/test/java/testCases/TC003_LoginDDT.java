package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")
	public void verify_loginDDT(String email, String pwd, String exp) {

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// login

			LoginPage lp = new LoginPage(driver);
			lp.setEmailId(email);
			lp.setPassword(pwd);
			lp.clickLoginButton();

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountExist();

			// Data is valid - login success - test pass
			// data is valid - login failed - test fail

			// data is invalid - login success - test failed
			// data is invalid - login failed - test pass

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("******* Finished TC-003_LoginDDT ********");

	}
}
